function myFunc(name = '김싸피', age = 24) {
  // argument 내장변수를 통해 들어온 인자에 대한 처리를 통해, 유효성 검사 기능이 가능하다.
  console.log(name, age);
}

myFunc();
myFunc('김재환');
myFunc('김재환', 27);
