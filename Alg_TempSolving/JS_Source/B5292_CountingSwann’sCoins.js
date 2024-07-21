/*
웨더비 스완 주지사는 당신에게 국고에 있는 동전의 수를 세어보라고 명령합니다. 
그 일을 더 재미있게 하기 위해 당신은 3의 배수인 모든 숫자에 대해 "죽었다"고 말하고 
5의 배수인 모든 숫자에 대해 "사람"이라고 말하기로 결정합니다. 
3과 5의 배수인 숫자에 대해 당신은 "죽은 사람"이라고 말합니다.
*/
const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim();

let number = parseInt(target);
let result = [];
for (let i = 1; i <= number; i++) {
  if (i % 3 == 0 && i % 5 == 0) {
    result.push('DeadMan');
  } else if (i % 5 == 0) {
    result.push('Man');
  } else if (i % 3 == 0) {
    result.push('Dead');
  } else {
    result.push(i);
    continue;
  }
  console.log(result.join(' '));
  result = [];
}
if (result.length > 0) console.log(result.join(' '));
