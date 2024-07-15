const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .split('\n');
let N = parseInt(input[0]);
const result = new Array();
for (let i = 1; i <= N; i++) {
  let len = input[i].trim().length;
  if (len < 6 || len > 9) result.push('no');
  else result.push('yes');
}
console.log(result.join('\n'));
