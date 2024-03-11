window.onload = function () {
    let addB = document.querySelector(".addButton");
    addB.addEventListener("click", function () {
        let eachInput = document.getElementById("addTarget");
        let listIndex = 1;
        const addBox = document.createElement("div");
        addBox.id = "list" + listIndex;

        const addInput = document.createElement("input");
        addInput.type = "text";
        addInput.value = eachInput.value;

        const addButton = document.createElement("input");
        addButton.type = "button";
        addButton.value = "삭제";
        addButton.addEventListener("click", function () {
            let delComp = document.querySelector(`#list${listIndex}`);
            document.querySelector(".answerList").removeChild(addBox);
            listIndex++;
        });
        addBox.appendChild(addInput);
        addBox.appendChild(addButton);

        document.querySelector(".answerList").appendChild(addBox);
        eachInput.value = "";
    })
}