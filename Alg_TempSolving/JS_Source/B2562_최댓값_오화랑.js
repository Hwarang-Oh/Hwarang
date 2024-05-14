const numList = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n')
  .map(Number);

let currentMax = Number.MIN_VALUE;
let currentMaxIdx = 0;
numList.forEach((num, index) => {
  if (num > currentMax) {
    currentMax = num;
    currentMaxIdx = index + 1;
  }
});
console.log(currentMax + '\n' + currentMaxIdx);

// 1. 회의실 시간을 끝나는 시간을 기준으로 정렬한다.
// 2. 끝나는 시간보다 시작하는 시간이 같거나 뒤에 있다면, 채택한다.
// 3. 이어간다.
// 4. => Memo + Greedy 성격이 담겨있는 DP문제 이에대한 생각을 처음 보았을 때, 할 수 있을까?

/*
11
1 4 V
3 5
0 6
5 7 V
3 8
5 9
6 10
8 11 V
8 12
2 13
12 14 V
*/
