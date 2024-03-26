window.onload = function () {
  document
    .querySelectorAll('.accordion-collapse.collapse.show')
    .forEach((element) => {
      element.classList.remove('show');
    });
  let trylogIn = document.querySelector('#trylogIn');
  trylogIn.addEventListener('click', logInValidation);
  let trylogOut = document.querySelector('#trylogOut');
  trylogOut.addEventListener('click', logOut);
};

const user = {
  id: 'ssafy',
  pwd: '1234',
};

function logInValidation() {
  let inputID = document.querySelector('#inputID');
  let inputPWD = document.querySelector('#inputPassword');
  if (inputID.value == '') alert('아이디를 입력해주세요.');
  if (inputPWD.value == '') alert('비밀번호를 입력해주세요.');
  if (inputID.value == user.id && inputPWD.value == user.pwd) {
    alert('로그인 성공!');
    inputID.value = '';
    inputPWD.value = '';
    document.querySelector('#profile').src = './assets/img/profile.png';
    document.querySelector('#loggedFalse').classList.add('d-none');
    document.querySelector('#loggedTrue').classList.remove('d-none');
    document.querySelector('#logInModal .btn-close').click();
  } else {
    if (inputID.value != user.id) alert('등록된 ID가 없습니다.');
    else alert('비밀번호를 다시 확인해주세요.');
  }
}

function logOut() {
  document.querySelector('#profile').src = './assets/img/noimg.png';
  document.querySelector('#loggedFalse').classList.remove('d-none');
  document.querySelector('#loggedTrue').classList.add('d-none');
}
