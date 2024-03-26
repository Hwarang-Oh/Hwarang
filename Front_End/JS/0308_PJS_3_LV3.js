window.onload = function () {
    window.open("./0308_PHTML_3_LV3_poll.html", "투표 생성", "width=400, height=400");
    currlogOut();
    let logIn = document.querySelector("header #getLogIn");
    logIn.addEventListener("click", goLogIn);

    let logOut = document.querySelector("header #getLogOut");
    logOut.addEventListener("click", currlogOut);

    let allSideCont = document.querySelector("aside .sideBar");
    allSideCont.addEventListener("click", allSide.allSideControl);

    let eachSideCont = document.querySelectorAll("aside .locationBox");
    for (const each of eachSideCont) {
        each.addEventListener("click", function () {
            let eachComp = each.childNodes[1];
            console.log(eachComp);
            if (eachComp.style.display == "none") eachComp.style.display = "block";
            else eachComp.style.display = "none";
        });
    }
    
    let adminMakePoll = document.querySelector("header #adminFunc");
    adminMakePoll.addEventListener("click", function () {
        window.open("./0308_PHTML_3_LV3_poll.html", "투표 생성", "width=400, height=400");
    });
}


// LogIn
function goLogIn() {
    openLogIn("아이디 입력", 1, "ssafy", false);
}


function openLogIn(text, stage, correct, isValid) {
    let input = prompt(text, "Hosino AI");
    if (stage == 2) {
        if (input == "1234") isValid = true;

        if (isValid == true) {
            alert("로그인 성공!!"); 
            currlogIn();
            return;
        }
        else {
            alert("비밀번호가 틀렸습니다.")
            return;
        }
    }
    if (input == correct) {
        stage++;
        openLogIn("비밀번호 입력", stage, "1234", false);
    }
    else {
        alert("해당 아이디는 존재하지 않습니다.");
    }
}

function currlogOut() {
    let logged = document.querySelectorAll(".log");
    let notLogged = document.querySelectorAll(".notLog");
    for (const eachMenu of notLogged) {
        eachMenu.style.display = "none";
    }
    for (const eachMenu of logged) {
        eachMenu.style.display = "block";
    }

}

function currlogIn() {
    let logged = document.querySelectorAll(".log");
    let notLogged = document.querySelectorAll(".notLog");
    for (const eachMenu of logged) {
        eachMenu.style.display = "none";
    }
    for (const eachMenu of notLogged) {
        eachMenu.style.display = "block";
    }
}

// SideBar
allSide = {
    isOpen: false,
    allSideControl() {
        if (!this.isOpen) {
            let locComp = document.querySelectorAll("aside .locComponent");
            let name = document.querySelector("aside .sideBar");
            name.childNodes[0].innerText = "전국 매장 접기";

            this.isOpen = true;
            for (const eachComp of locComp) {
                eachComp.style.display = "block";
            }
        }
        else {
            let locComp = document.querySelectorAll("aside .locComponent");
            let name = document.querySelector("aside .sideBar");
            name.childNodes[0].innerText = "전국 매장 펼치기";
            this.isOpen = false;
            for (const eachComp of locComp) {
                eachComp.style.display = "none";
            }
        }
    },
}














