const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split(' ');

let [N, W, H, L] = target;
let possSpace = Math.floor(W / L) * Math.floor(H / L);
console.log(Math.min(N, possSpace));
