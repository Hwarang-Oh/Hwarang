const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim();

let array = new Array(26).fill(-1);
const a_loc = 'a'.charCodeAt(0);

for (let index = 0; index < target.length; index++) {
  if (array[target.charCodeAt(index) - a_loc] === -1)
    array[target.charCodeAt(index) - a_loc] = index;
}

console.log(array.join(' '));
