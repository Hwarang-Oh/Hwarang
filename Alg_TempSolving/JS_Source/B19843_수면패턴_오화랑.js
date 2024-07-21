const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

let dayMap = new Map([
  ['Mon', 1],
  ['Tue', 2],
  ['Wed', 3],
  ['Thu', 4],
  ['Fri', 5],
]);
let [targetTime, sleepCnt] = target[0].split(' ').map(Number);
let sleepTime = 0;
for (let cnt = 1; cnt <= sleepCnt; cnt++) {
  let [D1, H1, D2, H2] = target[cnt].split(' ');
  let startDay = dayMap.get(D1);
  let startTime = parseInt(H1);
  let endDay = dayMap.get(D2);
  let endTime = parseInt(H2);

  if (startDay == endDay) {
    targetTime -= endTime - startTime;
  } else if (startDay < endDay) {
    targetTime -= 24 - startTime + endTime + (endDay - startDay - 1) * 24;
  }
}
if (targetTime < 0) console.log(0);
else if (targetTime > 48) console.log(-1);
else console.log(targetTime);