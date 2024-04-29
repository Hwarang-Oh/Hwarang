// 3개가 잘 분해된 모습
let arr = [11, 12, 13];
let [a, b, c] = arr;
console.log(a, b, c);

// 앞에 2개만 할당된 모습
let [d, e] = arr;
console.log(d, e);

// g는 Array형태를 띄게 될 것이다.
let [f, ...g] = arr;
console.log(f, g);

// -> 함수의 인자를 받는 쪽에서는, 객체로 받고 구조 분해 할당을 통해서 풀어 받아내는 느낌!!
// But 일단 Array는 순서대로 받을 수 밖에 없다는 단점이 있음 ( 골라서 받아내기는 어려울 듯!! )

let p1 = {
  fullName: '카리나',
  age: 25,
  addr: 'sm',
};
// let { fullName, age } = p1;
// console.log(fullName, age);
let { fullName: fName, age: a1 } = p1;
console.log(fName, a1);
let { fullName, ...rest } = p1;
console.log(fullName, rest);

function print({ fullName, addr }) {
  // 어떤 객체가 올 것이고, 그것을 Destruction Assign해서 사용할 것이다.
  console.log(`print : ${fullName}, ${addr}`);
}
print(p1);
