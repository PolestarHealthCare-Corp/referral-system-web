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

//무한 스크롤
let lastId = 0;          // 마지막으로 로드한 referral의 ID
let isLoading = false;   // 중복 요청 방지 플래그
let hasMore = true;      // 더 불러올 데이터가 있는지 여부

console.log("스크롤 이벤트");
console.log(lastId);
async function loadReferrals() {
  if (isLoading || !hasMore) return;
  isLoading = true;

  console.log("스크롤 이벤트2");
  try {
    const response = await fetch(`/api/v1/referrals?lastId=${lastId}&limit=10`);
    const data = await response.json();

    if (data.resultCode === 'SUCCESS' && data.result.length > 0) {
      renderReferrals(data.result);
      lastId = data.result[data.result.length - 1].referralId; // 마지막 ID 갱신
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

// 스크롤 이벤트 감지
window.addEventListener('scroll', () => {
  const scrollTop = window.scrollY || document.documentElement.scrollTop;
  const scrollHeight = document.documentElement.scrollHeight;
  const clientHeight = window.innerHeight;

  // 거의 맨 아래일 때
  if (scrollTop + clientHeight >= scrollHeight - 200) {
    loadReferrals();
  }
});

// 초기 로드
// document.addEventListener('DOMContentLoaded', () => {
//   loadReferrals();
// });