const input = require('fs')
  .readFileSync(process.platform === 'linux' ? 'dev/stdin' : './input.txt')
  .toString()
  .split('\n');
const numCount = input[0];
const numArray = input[1].split(' ').map(Number);

let minNum = 1000000;
let maxNum = -1000000;
const getMinMax = (number) => {
  if (number > maxNum) maxNum = number;
  if (number < minNum) minNum = number;
};

numArray.forEach((eachNum) => getMinMax(eachNum));
console.log(minNum, maxNum);
