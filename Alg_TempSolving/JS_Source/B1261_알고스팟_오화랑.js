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
class Node {
  constructor(x, y, count) {
    this.x = x;
    this.y = y;
    this.count = count;
  }
}

class PriorityQueue {
  constructor(compare) {
    this.li = [];
    this.compare = compare;
  }

  get size() {
    return this.li.length;
  }
  isEmpty() {
    return this.li.length === 0;
  }

  p(n) {
    return Math.floor((n - 1) / 2);
  }

  l(n) {
    return n * 2 + 1;
  }

  r(n) {
    return (n + 1) * 2;
  }

  top() {
    return this.li[0];
  }

  offer(elem) {
    this.li.push(elem);
    let point = this.li.length - 1;

    while (point > 0) {
      if (this.compare(this.li[point], this.li[this.p(point)])) {
        [this.li[point], this.li[this.p(point)]] = [this.li[this.p(point)], this.li[point]];
        point = this.p(point);
      } else {
        return;
      }
    }
  }

  poll() {
    [this.li[0], this.li[this.li.length - 1]] = [this.li[this.li.length - 1], this.li[0]];
    const ret = this.li.pop();
    let point = 0;

    while (this.r(point) < this.li.length) {
      if (this.compare(this.li[this.l(point)], this.li[this.r(point)])) {
        if (this.compare(this.li[this.l(point)], this.li[point])) {
          [this.li[this.l(point)], this.li[point]] = [this.li[point], this.li[this.l(point)]];
          point = this.l(point);
          continue;
        } else {
          break;
        }
      } else {
        if (this.compare(this.li[this.r(point)], this.li[point])) {
          [this.li[this.r(point)], this.li[point]] = [this.li[point], this.li[this.r(point)]];
          point = this.r(point);
          continue;
        } else {
          break;
        }
      }
    }

    if (
      this.l(point) === this.li.length - 1 &&
      this.compare(this.li[this.l(point)], this.li[point])
    ) {
      [this.li[this.l(point)], this.li[point]] = [this.li[point], this.li[this.l(point)]];
    }

    return ret;
  }
}

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
 *
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

const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');
let [N, M] = target[0].split(' ').map(Number);
let miro = target.slice(1).map((line) => line.trim().split('').map(Number));
const move = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

const findRouteBFS = (sX, sY, info) => {
  let pq = new PriorityQueue((o1, o2) => o1.count < o2.count);
  pq.offer({ x: sX, y: sY, count: 0 });
  miro[sX][sY] = info;
  while (!pq.isEmpty()) {
    let temp = pq.poll();
    for (const eachMove of move) {
      let nX = temp.x + eachMove[0];
      let nY = temp.y + eachMove[1];
      if (nX < 0 || nY < 0 || nX >= M || nY >= N) continue;
      if (miro[nX][nY] === 0) {
        pq.offer({ x: nX, y: nY, count: temp.count });
        miro[nX][nY] = info;
      } else if (miro[nX][nY] === 1) {
        pq.offer({ x: nX, y: nY, count: temp.count + 1 });
        miro[nX][nY] = info;
      } else if (miro[nX][nY] === 3) {
        return temp.count;
      }
    }
  }
  return 0;
};

const checkDestBFS = (eX, eY, info) => {
  let queue = new Queue();
  queue.offer({ x: eX, y: eY });
  miro[eX][eY] = info;
  while (!queue.isEmpty()) {
    let temp = queue.poll();
    for (const eachMove of move) {
      let nX = temp.x + eachMove[0];
      let nY = temp.y + eachMove[1];
      if (nX < 0 || nY < 0 || nX >= M || nY >= N) continue;
      if (miro[nX][nY] === 0) {
        queue.offer({ x: nX, y: nY });
        miro[nX][nY] = info;
      }
    }
  }
};

checkDestBFS(M - 1, N - 1, 3);
console.log(findRouteBFS(0, 0, 2));
