// ... : spread operator -> 전개 연산자
// 1. 함수 호출시 인자값에 사용 // 구조 분해 할당 -> 받아내는 쪽에서, 분해하고 할당
// xxx(...args) // args : 배열, 문자열
// clone 객체를 만들어내는 느낌
// 2. 배열 리터럴 표기에서 사용 가능
// [...arr, 10, 20] -> 새 배열을 만들어 내는데, 기존에 있는 배열의 내용을 가지고 초기값으로 활용해서 new Array(5)
// 3. 객체 리터럴 표기에서 사용
//    {...obj, key:value}

// -> 객체가 가지고 있는 속성이, 다른 객체를 물고 있다면 그것까지는 복사되지 않음.
// 결론 : 배열이나 객체를 ...연산자와 함께 사용하여 새로운 Object, Array를 생성할 때 주로 사용함.

function print(a, b) {
  // Array가 온다는 것을 알고 있다면, Destruction Assign을 할 수 있음.
  console.log(a, b);
}
let arr = [10, 20];
print(...arr); // smth like print(10, 20)
// print(arr[0], arr[1])

let p1 = {
  fullName: '카리나',
  age: 25,
};

let p2 = {
  fullName: '카리나',
  addr: 'SM',
};
let clonePerson = { ...p1 };
let mergePerson = { ...p1, ...p2 }; // 속성이 겹칠 때는, 나중에 있는 속성으로 덮어버린다!
console.log(clonePerson);
console.log(mergePerson);

function changeAge(person) {
  person.age++;
  console.log(p1 == person); // False
}
changeAge(clonePerson);
console.log(p1);
console.log(clonePerson);
// 둘의 나이가 다르다.

changeAge({ ...p1, gender: 'F' }); // 객체 리터럴. mergePerson을 펼쳐, 새로운 객체를 만드는 느낌 -> 기존의 p1과 다르다는 False
console.log(p1); // 나이도 맞지 않다.

// Result : 원본이 아닌, 사본을 보내서 안정성을 확하고자 하는 느낌
