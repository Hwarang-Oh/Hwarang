// ES5
const user1 = {
  id: 'ssafy',
  name: '오화랑',
  age: 26,
  classNum: 11,
  info: function () {
    return this.name + '(' + this.id + ')님 나이 ' + this.age;
  },
};

let id1 = user.id;
let name1 = user.name;
let age1 = user.age;
console.log(name + ' ' + id + ' ' + age);

const user2 = {
  userId: userId,
  name: name,
  age: age,
};

// ES6 -> 구조 분해 할당 : Destructuring Assignment
let { id: userId, name, age, classNum } = user;
console.log(name + ' ' + userId + ' ' + age + ' ' + classNum);

// ES6 -> Concise Method
const user3 = {
  id: 'ssafy',
  name: '오화랑',
  age: 26,
  classNum: 11,
  info() {
    // Concise Method
    return this.name + '(' + this.id + ')님 나이 ' + this.age;
  },
};

// ES6 -> Property ShortHand
const user4 = {
  // Property Shorthand
  userId,
  name,
  age,
};
