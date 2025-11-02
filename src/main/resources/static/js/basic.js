//스크롤되면 nav 밑에 밑줄 생김
window.addEventListener('scroll', function () {
  const nav = document.querySelector('.header');
  if (window.scrollY > 0) {
    nav.classList.add('scrolled');
  } else {
    nav.classList.remove('scrolled');
  }
});

//홈으로 이동
// const backBtn = document.getElementById('backHome');
// backBtn.addEventListener('click', () => {
//   window.location.href = '/';
// });

//조건 검색
document.addEventListener('DOMContentLoaded', function() {
  const searchBtn = document.getElementById('searchBtn');
  const userNameInput = document.getElementById('userName');
  const userPhoneInput = document.getElementById('userPhone');
  const listContainer = document.querySelector('.referral__list');

  if (searchBtn) {
    searchBtn.addEventListener('click', function () {
      const userName = userNameInput.value;
      const userPhone = userPhoneInput.value;
      console.log("main 페이지 - 조건 검색 동작");

      fetch(`/api/v1/referrals?userName=${encodeURIComponent(
          userName)}&userPhone=${encodeURIComponent(userPhone)}`)
      .then(res => res.json())
      .then(data => {
        // resultCode 체크
        if (data.resultCode !== "SUCCESS") {
          alert('main 페이지 - 조건 검색 실패');
          return;
        }

        const referrals = data.result;
        // console.log(referrals);

        // 기존 리스트 초기화
        listContainer.innerHTML = '';

        // 리스트 없으면 안내
        if (!referrals || referrals.length === 0) {
          listContainer.innerHTML = '<li>조회된 결과가 없습니다.</li>';
          return;
        }

        // 리스트 생성
        referrals.forEach(referral => {
          const li = document.createElement('li');
          li.className = 'referral__content';
          li.id = `referral-${referral.referralId}`;

          li.innerHTML = `
                                <a href="/referrals/${referral.referralId}">
                                    <div class="referral__row">
                                        <div class="referral__row__left">
                                            <strong>${referral.hospitalName}</strong>
                                            <div class="referral__equipment">
                                                ${referral.equipmentList.map(
              equip => `<span>${equip}</span>`).join('')}
                                            </div>
                                        </div>
                                        <div class="referral__row__right">
                                            <span class="referral__tag">${referral.hospitalAddress}</span>
                                            <span class="referral__tag">${referral.elapsedTime}</span>
                                        </div>
                                    </div>
                                </a>
                            `;

          listContainer.appendChild(li);
        });
      })
      .catch(err => {
        console.error(err);
        alert('main 페이지 - 조건 검색 API 호출 실패');
      });
    });
  }
});

//슬라이드 처리
let lastId = (() => {
  const list = document.getElementById('referralList');
  const items = list.querySelectorAll('li');
  if (items.length === 0) return 0; // 데이터 없으면 0
  const lastItemId = parseInt(items[items.length - 1].dataset.id, 10);
  return isNaN(lastItemId) ? 0 : lastItemId; // NaN이면 0으로 처리
})();

let isLoading = false;
let hasMore = true;

async function loadReferrals() {
  if (isLoading || !hasMore) return;
  isLoading = true;

  try {
    const response = await fetch(`/api/v1/referrals?lastId=${lastId}&limit=10`);
    const data = await response.json();

    if (data.resultCode === 'SUCCESS' && data.result.length > 0) {
      renderReferrals(data.result);
      lastId = data.result[data.result.length - 1].referralId;
    } else {
      hasMore = false; // 더 이상 데이터 없음
    }
  } catch (error) {
    console.error('Error loading referrals:', error);
  } finally {
    isLoading = false;
  }
}

function renderReferrals(referrals) {
  const list = document.getElementById('referralList');
  referrals.forEach(ref => {
    const li = document.createElement('li');
    li.classList.add('referral__content');
    li.dataset.id = ref.referralId;
    li.innerHTML = `
      <a href="/referrals/${ref.referralId}">
        <div class="referral__row">
          <div class="referral__row__left">
            <strong>${ref.hospitalName}</strong>
            <div class="referral__equipment">
              ${ref.equipmentList.map(e => `<span>${e}</span>`).join('')}
            </div>
          </div>
          <div class="referral__row__right">
            <span class="referral__tag">${ref.hospitalAddress}</span>
            <span class="referral__tag">${ref.elapsedTime}</span>
          </div>
        </div>
      </a>
    `;
    list.appendChild(li);
  });
}

// 스크롤 감지
window.addEventListener('scroll', () => {
  const scrollTop = window.scrollY || document.documentElement.scrollTop;
  const scrollHeight = document.documentElement.scrollHeight;
  const clientHeight = window.innerHeight;

  if (scrollTop + clientHeight >= scrollHeight - 200) {
    loadReferrals();
  }
});