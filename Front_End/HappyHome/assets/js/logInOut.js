//MARK: - Property
class User {
  constructor(id, pw, name, addr, phone) {
    this.id = id;
    this.pw = pw;
    this.name = name;
    this.addr = addr;
    this.phone = phone;
  }
  validate() {}
}

// init DB (ssafy, 1234) 계정 생성
if (localStorage.getItem("Users") == null) {
  localStorage.setItem(
    "Users",
    JSON.stringify([new User("ssafy", "1234", "ssafy", "multicampus", "02")])
  );
}


//MARK: - Lifecycle
window.onload = function () {
  document.querySelectorAll(".accordion-collapse.collapse.show").forEach((element) => {
    element.classList.remove("show");
  });
  let trylogIn = document.querySelector("#trylogIn");
  trylogIn.addEventListener("click", logInValidation);
  let trylogOut = document.querySelector("#trylogOut");
  trylogOut.addEventListener("click", logOut);
  let tryJoin = document.querySelector("#tryJoin");
  tryJoin.addEventListener("click", joinValidation);
};

//MARK: - Method
function logOut() {
  console.log("hi");
  document.querySelector("#loggedFalse").classList.remove("d-none");
  document.querySelector("#loggedTrue1").classList.add("d-none");
  document.querySelector("#loggedTrue2").classList.add("d-none");
}
function joinValidation() {
  let id = document.querySelector("#joinID").value;
  let pw = document.querySelector("#joinPWD").value;
  let name = document.querySelector("#joinName").value;
  let addr = document.querySelector("#joinAddress").value;
  let phone = document.querySelector("#joinPhone").value;
  let values = [id, pw, name, addr, phone];
  if (-1 != [id, pw, name, addr, phone].indexOf("")) {
    alert("입력을 확인해주세요.");
    return;
  }
  if (checkID(id)) {
    alert("중복된 아이디입니다.");
    return;
  }
  
  alert("회원가입 성공!");
  let user = new User(id, pw, name, addr, phone);
  let users = JSON.parse(localStorage.getItem("Users"));
  users.push(user);
  localStorage.setItem("Users", JSON.stringify(users));
  values.forEach((value) => {
    value = "";
  });
  
  document.querySelector("#loggedFalse").classList.add("d-none");
  document.querySelector("#loggedTrue1").classList.remove("d-none");
  document.querySelector("#loggedTrue2").classList.remove("d-none");
  document.querySelector("#makeAccountModal .btn-close").click();
}
function checkCredentials(id, pw) {
  let users = JSON.parse(localStorage.getItem("Users"));
  for (let user of users) {
    console.log(user.id === id + " " + id + " " + user.id);
    if (user.id === id && user.pw === pw) {
      return true;
    }
  }
  return false;
}
function checkID(id) {
  let users = JSON.parse(localStorage.getItem("Users"));
  for (let user of users) {
    console.log(user.id === id);
    if (user.id === id) {
      return true;
    }
  }
  return false;
}

function logInValidation() {
  let inputID = document.querySelector("#inputID");
  let inputPWD = document.querySelector("#inputPassword");
  if (inputID.value == "") alert("아이디를 입력해주세요.");
  if (inputPWD.value == "") alert("비밀번호를 입력해주세요.");

  if (checkCredentials(inputID.value, inputPWD.value)) {
    alert("로그인 성공!");
    inputID.value = "";
    inputPWD.value = "";
    document.querySelector("#loggedFalse").classList.add("d-none");
    document.querySelector("#loggedTrue1").classList.remove("d-none");
    document.querySelector("#loggedTrue2").classList.remove("d-none");
    document.querySelector("#logInModal .btn-close").click();
  } else {
    if (!checkID(inputID.value)){
      alert("등록된 ID가 없습니다.");
    } else {
      alert("비밀번호를 다시 확인해주세요.");
    }
  }
}