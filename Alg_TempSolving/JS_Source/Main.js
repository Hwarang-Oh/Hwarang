const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim();

let [x, y] = input.split(' ').map(Number);
console.log((x + y) * (x - y));
