// arrow function <- from 익명 함수
// 재사용성이 떨어지는 대신, 함수를 정의할 때, function 키워드를 정의하지 않고 '=>'을 통해 함수를 선언 가능.
// function(params){ code } 형태를 축약하는 형태
// callBack 함수의 문법을 간결화하기 위해 주로 많이 사용

/*
const hello = function () {
  // hello가 곧 함수 객체가 되는 형태
  console.log('hello');
};
hello();
*/

const hello = () => {
  console.log('hello');
};
hello();

const helloAgain = () => console.log('hello');
helloAgain();

const sum = (a, b) => {
  return a + b;
};
const sumAgain = (a, b) => a + b;
// 매개변수가 1개면 괄호도 생략할 수 있다.
console.log(sum(1, 2));
console.log(sumAgain(3, 4));

let arr = [1, 2, 3];
arr.forEach((e) => console.log(e));

let arr2 = arr.filter((e) => e % 2 == 0);
console.log(arr2);
