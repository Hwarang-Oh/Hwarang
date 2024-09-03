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
 * ! https://www.acmicpc.net/board/view/145421
 * IMP : 추가적인 최적화를 한다면, Stack 넣거나 PQ에서 가능성이 없는 친구들은 그냥 후보 Arrays에서 제거
 * IMP : PQ와 Arrays 모두에서, 굳이 추가하지 않고 넘기는 경우를 생각해보자.
 */

/**
 * * Pair Class Implementation
 */
class Pair {
  constructor(item) {
    this.from = item.from;
    this.value = item.value;
  }
}

/**
 * * Queue Implementation => N 번째 큰 수를 찾아야 하는 상황
 * * Queue보다는 Stack이 유리함 => 내장되어 있기 때문에, 부담없이 사용 가능
 */
class Queue {
  constructor() {
    this.inStack = [];
    this.outStack = [];
  }
  offer(item) {
    this.inStack.push(item);
  }
  poll() {
    if (this.outStack.length === 0) {
      while (this.inStack.length > 0) {
        this.outStack.push(this.inStack.pop());
      }
    }
    return this.outStack.pop();
  }
  peek() {
    if (this.outStack.length === 0) {
      while (this.inStack.length > 0) {
        this.outStack.push(this.inStack.pop());
      }
    }
    return this.outStack[this.outStack.length - 1];
  }
  isEmpty() {
    return this.inStack.length === 0 && this.outStack.length === 0;
  }
  size() {
    return this.inStack.length + this.outStack.length;
  }
}

/**
 * * PriorityQueue Implementation
 */
class PriorityQueue {
  constructor() {
    this.heap = [];
  }

  offer(item, priority) {
    const node = { item, priority };
    this.heap.push(node);
    this.bubbleUp();
  }

  poll() {
    const max = this.heap[0];
    const last = this.heap.pop();
    if (this.heap.length > 0) {
      this.heap[0] = last;
      this.bubbleDown();
    }
    return max.item;
  }

  bubbleUp() {
    let idx = this.heap.length - 1;
    const item = this.heap[idx];
    while (idx > 0) {
      const parentIdx = Math.floor((idx - 1) / 2);
      const parent = this.heap[parentIdx];
      if (item.priority <= parent.priority) break; // 변경된 부분
      this.heap[idx] = parent;
      idx = parentIdx;
    }
    this.heap[idx] = item;
  }

  bubbleDown() {
    let idx = 0;
    const length = this.heap.length;
    const item = this.heap[0];
    while (true) {
      let leftChildIdx = 2 * idx + 1;
      let rightChildIdx = 2 * idx + 2;

      let leftChild, rightChild;
      let swapIdx = null;
      if (leftChildIdx < length) {
        leftChild = this.heap[leftChildIdx];
        if (leftChild.priority > item.priority) {
          // 변경된 부분
          swapIdx = leftChildIdx;
        }
      }

      if (rightChildIdx < length) {
        rightChild = this.heap[rightChildIdx];
        if (
          (swapIdx === null && rightChild.priority > item.priority) ||
          (swapIdx !== null && rightChild.priority > leftChild.priority)
        ) {
          swapIdx = rightChildIdx;
        }
      }
      if (swapIdx === null) break;
      this.heap[idx] = this.heap[swapIdx];
      idx = swapIdx;
    }
    this.heap[idx] = item;
  }

  isEmpty() {
    return this.heap.length === 0;
  }

  size() {
    return this.heap.length;
  }
}

const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

let N = parseInt(target[0]);
const pq = new PriorityQueue();
const Arrays = [];
for (let i = 0; i < N; i++) {
  target[i + 1] = target[i + 1].split(' ');
  Arrays.push([]);
}

for (let i = 1; i <= N; i++) {
  for (let j = 0; j < N; j++) {
    Arrays[j].push(parseInt(target[i][j]));
    if (i === N) {
      let item = new Pair({ from: j, value: Arrays[j].pop() });
      pq.offer(item, item.value);
    }
  }
}

let temp, nextGet;
while (N-- > 0) {
  temp = pq.poll();
  nextGet = temp.from;
  if (Arrays[nextGet].length > 0) {
    let item = new Pair({ from: nextGet, value: Arrays[nextGet].pop() });
    pq.offer(item, item.value);
  }
}
console.log(temp.value);
