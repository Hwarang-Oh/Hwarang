const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');
let numbers;
target.forEach((each) => {
  numbers = each.split(' ').map(Number);
  if (numbers[0] === 0 && numbers[1] === 0) return;
  console.log(numbers[0] + numbers[1]);
});
