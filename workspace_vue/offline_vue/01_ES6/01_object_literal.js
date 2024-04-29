// Before ES6

let fullName = '카리나';
/*
let person = {
  fullName: fullName,
  getFullName: function () {
    return this.fullName;
  },
};

console.log(person.fullName);
console.log(person.getFullName());
*/

// ES6 - shorthand Property , concise Method
let person = {
  // property명과 property의 초기값이 똑같을 때
  fullName,
  getFullName() {
    // smth like 익명객체
    return this.fullName;
  },
};
console.log(fullName);
console.log(person.getFullName());
