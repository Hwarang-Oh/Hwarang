let isLog = false;
window.onload = function () {
    currlogOut();
    let logIn = document.querySelector("header .log");
    logIn.addEventListener("click", openLogin("아이디 입력", 1, "ssafy", false));
}

function openLogin(text, stage, correct, isValid) {
    let inputID = prompt(text, "가장이쁜여자는 호시노아이")
    if (stage == 2) {
        if (inputID == "1234") isValid = true;

        if (isValid == true) {
            alert("로그인 성공!!");
            isLog = true;
            return;
        }
        else {
            alert("비밀번호가 틀렸습니다.")
            return;
        }
    }
    if (inputID == correct) {
        stage++;
        openLogin("비밀번호 입력", stage, "1234", false);
    }
    else {
        alert("해당 아이디는 존재하지 않습니다.")
    }
}




function currlogOut() {
    let notLogged = document.querySelectorAll("header .notLog");
    for (const eachMenu of notLogged) {
        eachMenu.style.display = "none";
    }
}
function currlogIn() {
    let logged = document.querySelectorAll("header .Log");
    let notLogged = document.querySelectorAll("header .notLog");
    for (const eachMenu of logged) {
        eachMenu.style.display = "none";
    }
    for (const eachMenu of notLogged) {
        eachMenu.style.display = "block";
    }
}
















