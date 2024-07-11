const fs = require('fs');

// 데이터 생성
const fline = [1000000, 20000, 10000];
const arr = [];
const arr2 = [];

for (let index = 1; index <= 20000; index++) {
  arr.push(index);
}
for (let index = 1; index <= 5000; index++) {
  arr2.push(4);
  arr2.push(1);
  arr2.push(1);
  arr2.push(3);
  arr2.push(8);
}

// 결과 문자열 생성
const result = [fline.join(' '), arr.join(' '), arr2.join(' ')].join('\n');

// 파일에 저장
fs.writeFileSync('output.txt', result);

console.log('Data has been written to output.txt');
