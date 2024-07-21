const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split(' ')
  .map(Number);
let result = new Array();
target.forEach((each) => result.push(100 - each));
result.push(100 - result[0] - result[1]);
result.push(result[0] * result[1]);
result.push(Math.floor(result[3] / 100));
result.push(result[3] % 100);

console.log(result.join(' '));
console.log([result[2] + result[4], result[5]].join(' '));
