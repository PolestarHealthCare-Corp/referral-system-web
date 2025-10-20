//스크롤되면 nav 밑에 밑줄 생김
window.addEventListener('scroll', function () {
  const nav = document.querySelector('.header');
  if (window.scrollY > 0) {
    nav.classList.add('scrolled');
  } else {
    nav.classList.remove('scrolled');
  }
});