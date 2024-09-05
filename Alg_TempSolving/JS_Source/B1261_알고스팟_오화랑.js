/**
 * * 미로의 크기 N * M ( 1 <= N, M <= 100 )
 * => 빈 방 또는 벽으로 이루어져 있고, 빈 방은 자유롭게 다닐 수 있음
 * => 벽을 부수지 않으면 이동할 수 없음.
 *
 * * 상하좌우로 이동할 수 있음, 미로의 밖으로 이동은 불가
 * IMP => 무기를 통해 벽을 부술 수 있으며, 빈 방과 동일한 방으로 변함
 * IMP => 해당 무기의 Cost가 존재 => 최소한으로 사용하여 (1, 1) -> (N, M)으로 이동하기
 * IMP => 운영진의 각 Time마다 이동 위치를 기억하고, 거기서 시작해서 반복을 최대한 줄이는 Method를 사용해보자
 */

const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');
let [N, M] = target[0].split(' ').map(Number);
// target.splice(0, 1);
// console.log(target);
target.slice(1);
console.log(target);

let miro = target.slice(1).map((line) => line.split('').map(Number));
miro.forEach((line) => console.log(line));

/**
 * * let miro = Array.from({ length: M }, () => Array(N).fill(0)); => 이렇게 Java처럼 미리 선언하고 가도 됨
 * * 지금 문제와 같이 Input에서 첫번째 줄을 제외한 나머지를 활용해 N * M Array를 만들고자 할 때
 * IMP : slice(), splice(), shift() 3개를 활용할 수 있음
 * * let miro = target.slice(1).map(line => line.split('').map(Number));
 * ! slice() : 원본 배열을 변경하지 않는, 새로운 Array를 반환함.
 * * target.splice(0, 1); let miro = target.map(line => line.split('').map(Number));
 * ! splice() : 원본 배열을 직접 변경하여, 첫 번째 요소를 제거함. -> 나머지는 앞으로 이동 ( OverHead )
 * * target.shift(); let miro = target.map(line => line.split('').map(Number));
 * ! shift() : 원본 배열의 첫번째 요소 제거 => 역시 나머지는 앞으로 이동 ( OverHead )
 */
