/**
 * * 눈금의 간격이 1인 N X M의 모눈 종이 ( 100 이하 )
 * * 눈금에 맞추어 K 개의 직사각형의 내부를 제외한 나머지 부분이 몇개의 분리된 영역으로 나눔
 * * N 과 M의 직사각형에 직사각형 K개를 그린다면, r개의 분리된 영역으로 나누어짐
 * IMP => 이때 직사각형은 수학적인 좌표 개념에 기반해서 그려야 한다.
 * IMP => 각 분리된 영역의 넓이가 얼마인지 구하여 출력하는 Code 작성
 * * 가장 먼저 드는 생각은 BFS / DFS 탐색 계열이 가장 먼저 생각이 들긴 하다.
 * * 현재 Code는 BFS로 처리하긴 했음 -> DFS로도 가능한 문제로 보임.
 * ! 1줄씩 반드시 처리해야 하는 느낌은 아닌 것 같으므로 -> readFileSync()로 처리 가능
 */
class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}
class Queue {
  constructor() {
    this.front = null;
    this.rear = null;
    this.length = 0;
  }
  offer(value) {
    const newNode = new Node(value);
    if (this.isEmpty()) this.front = this.rear = newNode;
    else {
      this.rear.next = newNode;
      this.rear = newNode;
    }
    this.length++;
  }
  poll() {
    if (!this.isEmpty()) {
      const value = this.front.value;
      this.front = this.front.next;
      this.length--;
      if (this.isEmpty()) this.rear = null;
      return value;
    }
    return;
  }
  peek() {
    if (!this.isEmpty()) {
      return this.front.value;
    }
    return;
  }
  isEmpty() {
    return this.length === 0;
  }
  size() {
    return this.length;
  }
}

class Heap {
  constructor() {
    this.items = [];
  }
  swap(index1, index2) {
    let temp = this.items[index1];
    this.items[index1] = this.items[index2];
    this.items[index2] = temp;
  }
  parentIndex(index) {
    return Math.floor((index - 1) / 2);
  }
  leftChildIndex(index) {
    return index * 2 + 1;
  }
  rightChildIndex(index) {
    return index * 2 + 2;
  }
  parent(index) {
    return this.items[this.parentIndex(index)];
  }
  leftChild(index) {
    return this.items[this.leftChildIndex(index)];
  }
  rightChild(index) {
    return this.items[this.rightChildIndex(index)];
  }
  peek() {
    return this.items[0];
  }
  size() {
    return this.items.length;
  }
  isEmpty() {
    return this.items.length === 0;
  }
}

class PriorityQueue extends Heap {
  bubbleUp() {
    let index = this.size() - 1;
    while (this.parent(index) !== undefined && this.parent(index) > this.items[index]) {
      this.swap(index, this.parentIndex(index));
      index = this.parentIndex(index);
    }
  }
  bubbleDown() {
    let index = 0;
    while (
      this.leftChild(index) !== undefined &&
      (this.leftChild(index) < this.items[index] || this.rightChild(index) < this.items[index])
    ) {
      let smallerIndex = this.leftChildIndex(index);
      if (this.rightChild !== undefined && this.rightChild(index) < this.items[smallerIndex]) {
        smallerIndex = this.rightChildIndex(index);
      }
      this.swap(index, smallerIndex);
      index = smallerIndex;
    }
  }
  offer(item) {
    this.items[this.size()] = item;
    this.bubbleUp();
  }
  poll() {
    let item = this.items[0];
    this.items[0] = this.items[this.size() - 1];
    this.items.pop();
    this.bubbleDown();
    return item;
  }
}

class Pair {
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }
}

const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

/**
 * IMP : 좌표로 문제가 나왔기 때문에, 그냥 R <-> C 하는게 정신건강에 좋음.
 */
let [N, M, K] = target[0].split(' ').map(Number);
let map = Array.from({ length: M }, () => Array(N).fill(0));
let isChecked = Array.from({ length: M }, () => Array(N).fill(false));
const pq = new PriorityQueue();
const search = [
  [0, -1],
  [-1, 0],
  [0, 1],
  [1, 0],
];

const colorArea = ({ r1, c1, r2, c2 }) => {
  for (let i = r1; i < r2; i++) {
    for (let j = c1; j < c2; j++) {
      map[i][j] = 1;
      isChecked[i][j] = true;
    }
  }
};

/**
 * IMP : forEach의 특색 -> continue가 되지 않는다?!
 * * => return;을 써도 그대로 다음 element로 이어갈 수 있음
 * * => 이러한 의미는 뭔가 특정 Value를 찾았을 때, 그냥 넘어가는 최적화가 안될 수도 있다는 의미임.
 * @param {*} param0
 */

const BFS = ({ sX, sY }) => {
  let count = 0;
  eachQueue = new Queue();
  isChecked[sX][sY] = true;
  eachQueue.offer(new Pair(sX, sY));
  let temp, nX, nY;
  while (!eachQueue.isEmpty()) {
    temp = eachQueue.poll();
    count++;
    search.forEach((eachSearch) => {
      nX = temp.x + eachSearch[0];
      nY = temp.y + eachSearch[1];
      if (nX < 0 || nY < 0 || nX >= M || nY >= N) return;
      if (map[nX][nY] === 0 && !isChecked[nX][nY]) {
        isChecked[nX][nY] = true;
        eachQueue.offer(new Pair(nX, nY));
      }
    });
  }
  return count;
};

for (let i = 1; i <= K; i++) {
  let [r1, c1, r2, c2] = target[i].split(' ').map(Number);
  let eachRect = { r1, c1, r2, c2 };
  colorArea(eachRect);
}

for (let i = 0; i < M; i++) {
  for (let j = 0; j < N; j++) {
    if (map[i][j] === 0 && !isChecked[i][j]) {
      let eachSize = BFS({ sX: i, sY: j });
      pq.offer(eachSize);
    }
  }
}

let size = pq.size();
let result = [];
while (!pq.isEmpty()) {
  result.push(pq.poll());
}
console.log(size);
console.log(result.join(' '));
