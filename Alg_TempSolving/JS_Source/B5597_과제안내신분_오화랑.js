const input = require('fs')
  .readFileSync(process.platform === 'linux' ? 'dev/stdin' : './input.txt')
  .toString()
  .split('\n')
  .map(Number);

let check = new Array(31);
for (let index = 0; index < input.length; index++) {
  check[input[index]] = 1;
}

for (let i = 1; i < check.length; i++) {
  if (!check[i]) console.log(i);
}
