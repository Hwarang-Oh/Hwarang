const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .split('\n');
const N = parseInt(input[0]);
let result = [];
let count = 1;
while (count <= N) {
  let temp = input[count].trim();
  result.push(temp[0] + temp[temp.length - 1]);
  count++;
}
console.log(result.join('\n'));
