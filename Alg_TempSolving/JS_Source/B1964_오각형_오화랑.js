const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim();
const stage = BigInt(target);
const MOD = BigInt(45678);

let result =
  BigInt(5) +
  BigInt(4) * (stage - BigInt(1)) +
  (BigInt(3) * stage * (stage - BigInt(1))) / BigInt(2);
result = result % MOD;
console.log(result.toString());

// 1단계 : 5 + 0
// 2단계 : 5 + 0 + (4 + 3 * 1)
// 3단계 : 5 + (4 + 3) + (4 + 3 * 2)
// 4단계 : 5 + (4 + 3*1) + (4 + 3* 2) + (4 + 3 * 3)
// N단계 : 5 + 4 * (N - 1) + Sum : 3* 1+ 3* 2 + 3 * 3 + 3*4 ... 3 * (1 ~ 4)
// 1000단계
