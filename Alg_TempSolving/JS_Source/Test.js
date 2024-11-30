/**
 * IMP : get Input in JS : readFileSync() ( 1 )
 */
const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n')
  .map(Number);

/**
 * IMP : get Input in JS : readline() ( 2 )
 */
const readline = require('readline');
const br = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

/**
 * IMP : JavaScript reduce() 함수
 * * JavaScript의 reduce() 함수는 배열의 각 요소에 대해 콜백 함수를 실행하여, 배열을 하나의 값으로 줄이는 역할
 */

const numbers = [1, 2, 3, 4, 5];
const sum = numbers.reduce((accumulator, currentValue) => {
  return accumulator + currentValue;
}, 0);
console.log(sum); // 출력: 15

let n = 0;
let lineCount = -1;
br.on('line', (line) => {
  if (lineCount === -1) {
    lineCount = parseInt(line);
    n = lineCount;
    return;
  }
  line.split(' ').forEach((value) => {});

  lineCount--;
  if (lineCount === 0) br.close();
}).on('close', () => {
  console.log(pq.peek());
  process.exit();
});

/**
 * IMP : 입력 다루는 방식
 */
let [N, M] = input[0].split(' ').map(Number); // N, M 값 받기
let targetArray = input.slice(1).map((line) => line.trim().split('').map(Number)); // 다음 줄에 나오는 target Array 받기 ( shift, slice 모두 가능 )
let map = Array.from({ length: M }, () => Array(N).fill(0));
let visited = Array.from({ length: M }, () => Array(N).fill(-1)); // 2차원 배열 쉽게 선언하기
const move = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
]; // move Array 만들기

/**
 * IMP : Class 선언하기
 */
class Pair {
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }
}

/**
 * IMP : PQ 간단하게 구현
 */
class PriorityQueue {
  constructor() {
    this.items = [];
  }
  offer(value) {
    this.items.push(value);
    this.items.sort((a, b) => a - b);
  }
  poll() {
    return this.items.shift();
  }
  peek() {
    return this.items[0];
  }
  isEmpty() {
    return this.items.length === 0;
  }
  size() {
    return this.items.length;
  }
}
