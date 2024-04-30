/*
기본적으로 모듈 안에 있는 것은 모두 Private이다.
현재 JS 파일은 하나의 독립적인 모듈 -> 여기서 내보내고 싶은 것을 선언할 수 있음! (export keyword)
+ 하나하나 export 찍는 것이 귀찮기도 하고, 실수 가능성 존재
=> 아예 한번에 export하고 싶은 것들만 모아서 처리도 가능하다.

export default Keyword => 모든 Module에 한개만 가능하다? -> 한개만 내보낼 것이라면.. => 한개로 정해져 있어서 다양한 변형이 가능하다 
Just export와의 차이? => 이름을 원하는 대로 바꿔서 내보낼 수 있다. 
*/

// public 성격
export function cube(x) {
  return x * x;
}

// export default function sum(a, b) {
//   return a + b;
// }

function sum(a, b) {
  return a + b;
}

function sub(a, b) {
  return a - b;
}

// private 성격
function hello(name) {
  return `hello ${name}`;
}

// export {} // -> 객체 형태는 아니다. 중괄호 이용해서 불러야 하고, 이름 다 지켜서 사용해야 한다!!

export default {
  // 이렇게 간편하게 여러개를 export default가 가능하다. 객체 형태로 나가게 된다. => Method 쓰듯이 하면 된다!!
  sum,
  sub,
};
