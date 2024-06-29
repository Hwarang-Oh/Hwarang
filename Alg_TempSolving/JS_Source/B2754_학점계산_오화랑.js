const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('');
if (input[0] == 'A') {
  if (input[1] == '-') console.log('3.7');
  else if (input[1] == '0') console.log('4.0');
  else console.log('4.3');
} else if (input[0] == 'B') {
  if (input[1] == '-') console.log('2.7');
  else if (input[1] == '0') console.log('3.0');
  else console.log('3.3');
} else if (input[0] == 'C') {
  if (input[1] == '-') console.log('1.7');
  else if (input[1] == '0') console.log('2.0');
  else console.log('2.3');
} else if (input[0] == 'D') {
  if (input[1] == '-') console.log('0.7');
  else if (input[1] == '0') console.log('1.0');
  else console.log('1.3');
} else console.log('0.0');
