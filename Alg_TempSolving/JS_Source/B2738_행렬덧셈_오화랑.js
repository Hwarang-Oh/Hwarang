const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

let size = input[0].split(' ').map(Number);
const N = size[0];
const M = size[1];

for (let i = 1; i <= N; i++) {
  let first = input[i].split(' ').map(Number);
  let second = input[N + i].split(' ').map(Number);
  let row = [];
  for (let j = 0; j < M; j++) {
    row[j] = first[j] + second[j];
  }
  console.log(row.join(' '));
}
