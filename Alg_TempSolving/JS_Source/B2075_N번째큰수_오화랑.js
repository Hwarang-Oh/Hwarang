/**
 * * N * N 표에는 수가 N^2개 적혀 있음
 * * 모든 수는 자신의 한 칸 위에 있는 수보다 크다.
 * * 해당 경우의 2차원 배열에서 N번째 큰 수를 찾는 프로그램을 작성하시오.
 * IMP : 첫째 줄에 N이 주어진다. (1 <= N <= 1500)
 * IMP : 표에 적힌 수는 -10억 <= 수 <= 10억
 *
 * * 순서가 일부 결정된 2차원 Array 문제
 * * 각 Column은 순서대로 정렬이 되어 있지만, 중간에 다른 수가 들어갈 수 있음.
 * * 가장 먼저 생각나는 방식은 Priority Queue에 넣어서 하나씩 빼는 방식이 유효해 보임.
 * * 최대 연산은 1500 * 1500 = 2,250,000 Read
 * * 출력으로 PQ 연산을 1500번 수행할 것으로 예상됨.
 */

/**
 * Queue Implementation
 */
class Queue {
  constructor() {
    this.items = [];
  }
  offer(item) {
    this.items.push(item);
  }
  poll() {
    if (this.isEmpty())
    return this.items.shift();
  }
  peek() {
    if ()
  }
}

const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim();

console.log(target);
