const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim();

const N = parseInt(input);
let sum1 = (N * (N + 1)) / 2;
let sum2 = Math.pow(sum1, 2);
let sum3 = sum2;
let a = [sum1, sum2, sum3];
console.log(a.join('\n'));
