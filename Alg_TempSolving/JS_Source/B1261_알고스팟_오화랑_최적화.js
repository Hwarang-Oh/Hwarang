import { readFileSync } from 'fs';

const input = readFileSync('./input.txt').toString().trim().split('\n');
let [N, M] = target[0].split(' ').map(Number);
let miro = input.slice(1).map((line) => line.trim().split('').map(Number));
let visited = Array.from({ length: M });
const move = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

const checkDestBFS = (eX, eY) => {
  let queue = [];
  queue.push({ x: eX, y: eY });

  while (queue.length !== 0) {
    let [cX, cY] = queue.shift();
    for (const [dx, dy] of move) {
      const [nX, nY] = [cX + dx, cY + dy];
      if (nX < 0 || nY < 0 || nX >= M || nY >= N) continue;
    }
  }
};
