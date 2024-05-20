const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

const numCnt = parseInt(target[0]);
let total = 0;
for (let index = 0; index < numCnt; index++) {
  total += parseInt(target[1].charAt(index));
}
console.log(total);
