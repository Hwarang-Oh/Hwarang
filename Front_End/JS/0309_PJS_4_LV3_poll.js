window.onload = function () {
  let addB = document.querySelector('.addButton');
  addB.addEventListener('click', createAnswer);

  let addPoll = document.querySelector('.makePoll');
  addPoll.addEventListener('click', makePoll);
};

var listIndex = 1;
function createAnswer() {
  let eachInput = document.getElementById('addTarget');
  const addBox = document.createElement('div');
  addBox.id = 'list' + listIndex;

  listIndex++;

  const addInput = document.createElement('input');
  addInput.type = 'text';
  addInput.className = 'inputData';
  addInput.value = eachInput.value;

  const addButton = document.createElement('input');
  addButton.type = 'button';
  addButton.value = '삭제';

  addButton.addEventListener('click', removeAnswer);

  function removeAnswer() {
    let delComp = document.querySelector(`#list${listIndex}`);
    document.querySelector('.answerList').removeChild(addBox);
  }

  addBox.appendChild(addInput);
  addBox.appendChild(addButton);
  document.querySelector('.answerList').appendChild(addBox);
  eachInput.value = '';
}

let poll = {
  answers: [],
  start_date: '',
  end_date: '',
  question: '',
};
function makePoll() {
  poll.answers = Array.from(document.querySelectorAll('.answerList .inputData')).map(
    (elem) => elem.value
  );
  poll.start_date = document.querySelector('#start input').value;
  poll.end_date = document.querySelector('#end input').value;
  poll.question = document.querySelector('.questionText').value;
  localStorage.setItem('poll', JSON.stringify(poll));
  opener.parent.reloadPoll();
  window.close();
}
