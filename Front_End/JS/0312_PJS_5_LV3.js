window.onload = function () {
  currlogOut();
  getProgramming();
  getEssay();
  let logIn = document.querySelector('header #getLogIn');
  logIn.addEventListener('click', goLogIn);

  let logOut = document.querySelector('header #getLogOut');
  logOut.addEventListener('click', currlogOut);

  let allSideCont = document.querySelector('aside .sideBar');
  allSideCont.addEventListener('click', allSide.allSideControl);

  let eachSideCont = document.querySelectorAll('aside .locationBox');
  for (const each of eachSideCont) {
    each.addEventListener('click', function () {
      let eachComp = each.childNodes[1];
      console.log(eachComp);
      if (eachComp.style.display == 'none') eachComp.style.display = 'block';
      else eachComp.style.display = 'none';
    });
  }

  let adminMakePoll = document.querySelector('header #adminFunc');
  adminMakePoll.addEventListener('click', function () {
    window.open(
      './0309_PHTML_4_LV3_poll.html',
      '투표 생성',
      'width=400, height=400'
    );
  });
  reloadPoll();
};

// LogIn
function goLogIn() {
  openLogIn('아이디 입력', 1, 'ssafy', false);
}

function openLogIn(text, stage, correct, isValid) {
  let input = prompt(text, 'Hosino AI');
  if (stage == 2) {
    if (input == '1234') isValid = true;

    if (isValid == true) {
      alert('로그인 성공!!');
      currlogIn();
      return;
    } else {
      alert('비밀번호가 틀렸습니다.');
      return;
    }
  }
  if (input == correct) {
    stage++;
    openLogIn('비밀번호 입력', stage, '1234', false);
  } else {
    alert('해당 아이디는 존재하지 않습니다.');
  }
}

function currlogOut() {
  let logged = document.querySelectorAll('.log');
  let notLogged = document.querySelectorAll('.notLog');
  for (const eachMenu of notLogged) {
    eachMenu.style.display = 'none';
  }
  for (const eachMenu of logged) {
    eachMenu.style.display = 'block';
  }
}

function currlogIn() {
  let logged = document.querySelectorAll('.log');
  let notLogged = document.querySelectorAll('.notLog');
  for (const eachMenu of logged) {
    eachMenu.style.display = 'none';
  }
  for (const eachMenu of notLogged) {
    eachMenu.style.display = 'block';
  }
}

// SideBar
allSide = {
  isOpen: false,
  allSideControl() {
    if (!this.isOpen) {
      let locComp = document.querySelectorAll('aside .locComponent');
      let name = document.querySelector('aside .sideBar');
      name.childNodes[0].innerText = '전국 매장 접기';

      this.isOpen = true;
      for (const eachComp of locComp) {
        eachComp.style.display = 'block';
      }
    } else {
      let locComp = document.querySelectorAll('aside .locComponent');
      let name = document.querySelector('aside .sideBar');
      name.childNodes[0].innerText = '전국 매장 펼치기';
      this.isOpen = false;
      for (const eachComp of locComp) {
        eachComp.style.display = 'none';
      }
    }
  },
};

function reloadPoll() {
  if (localStorage.getItem('poll') == null) {
    document.querySelector('.poll').style.display = 'none';
    return;
  }
  document.querySelector('.notPoll').style.display = 'none';
  document.querySelector('.poll').style.display = null;
  let poll = JSON.parse(localStorage.getItem('poll'));
  let pollOptions = '';
  for (let option of poll.answers) {
    pollOptions += `<li>
                        <input type="radio" name="poll" id="${option}">
                        <caption>${option}</caption>
                        </li>`;
  }
  document.querySelector('.poll').innerHTML =
    `<p style="text-align: center;">[ 당신의 선택 ]</p>
                <p style="font-weight: bold; text-indent: 5px; text-wrap: wrap;" id="poll-title">${poll.question}</p>
                <ul class="poll-options">` +
    pollOptions +
    `</ul>
                <div style="display: flex; justify-content: flex-end; padding: 0px 10px 10px 0px;">
                    <input type="submit" value="투표하기"
                        style="padding: 5px; margin: 0px 10px; background-color: blueviolet; color: aliceblue;">
                    <input type="button" value="결과보기" style="background-color: aliceblue;">
                </div>
                <div style="text-align: center; font-weight: bold; padding: 10px 0px;" id="poll-date">투표기간 : ${poll.start_date} ~ ${poll.end_date}</div>`;
}

function getProgramming() {
  fetch('./data/programming.xml')
    .then((response) => response.text())
    .then((text) => makeHosinoList(text));
}

function makeHosinoList(data) {
  let BookList = document.querySelector('.PBookList');
  let parser = new DOMParser();
  const xml = parser.parseFromString(data, 'application/xml');

  let Books = xml.querySelectorAll('book');
  Books.forEach((eachBook) => {
    let source = eachBook.querySelector('isbn').textContent;
    let title = eachBook.querySelector('title').textContent;
    let price = eachBook.querySelector('price').textContent;

    let li = document.createElement('li');
    li.classList.add('bookBox');

    let fig = document.createElement('figure');
    li.appendChild(fig);

    let img = document.createElement('img');
    img.classList.add('book');
    img.src = './img/0306_IMG/' + source + '.png';

    let figcapt = document.createElement('figcaption');
    figcapt.innerHTML = `${title}<br>(${price}원)`;

    fig.appendChild(img);
    fig.appendChild(figcapt);
    li.appendChild(fig);
    BookList.appendChild(li);
  });
}

function getEssay() {
  fetch('./data/essay.json')
    .then((response) => response.json())
    .then((obj) => makeEssayList(obj));
}

function makeEssayList(obj) {
  let essayList = document.querySelector('.EssayList');
  for (eachEssay of obj) {
    let source = eachEssay.isbn;
    let title = eachEssay.title;
    let price = eachEssay.price;

    let li = document.createElement('li');
    li.classList.add('bookBox');

    let fig = document.createElement('figure');
    li.appendChild(fig);

    let img = document.createElement('img');
    img.classList.add('book');
    img.src = './img/0306_IMG/' + source + '.png';

    let figcapt = document.createElement('figcaption');
    figcapt.innerHTML = `${title}<br>(${price}원)`;

    fig.appendChild(img);
    fig.appendChild(figcapt);
    li.appendChild(fig);
    essayList.appendChild(li);
  }
}
