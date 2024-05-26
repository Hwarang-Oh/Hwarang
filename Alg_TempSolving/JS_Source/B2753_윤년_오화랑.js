const target = Number(
  fs
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
    .toString()
    .trim()
);

let number = 0;

// Leap year check
if ((target % 4 === 0 && target % 100 !== 0) || target % 400 === 0) {
  number = 1;
}

console.log(number);
