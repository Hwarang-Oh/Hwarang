const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

const loop = input[0];
let temp, times, target;
for (let index = 1; index <= loop; index++) {
  temp = input[index].split(' ');
  times = temp[0];
  target = temp[1];
  let newWord = '';
  let each;
  for (let index = 0; index < target.length; index++) {
    each = target.charAt(index);
    for (let index = 0; index < times; index++) {
      newWord += each;
    }
  }
  console.log(newWord);
}
