/**
 * * 눈금의 간격이 1인 N X M의 모눈 종이 ( 100 이하 )
 * * 눈금에 맞추어 K 개의 직사각형의 내부를 제외한 나머지 부분이 몇개의 분리된 영역으로 나눔
 * * N 과 M의 직사각형에 직사각형 K개를 그린다면, r개의 분리된 영역으로 나누어짐
 * IMP => 각 분리된 영역의 넓이가 얼마인지 구하여 출력하는 Code 작성
 * * 가장 먼저 드는 생각은 BFS / DFS 탐색 계열이 가장 먼저 생각이 들긴 하다.
 * ! 1줄씩 반드시 처리해야 하는 느낌은 아닌 것 같으므로 -> readFileSync()로 처리 가능
 */

const target = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

let [N, M, K] = target[0].split(' ').map(Number);
const map = Array.from({ length: N }, () => Array(M).fill(0));

for (let i = 1; i <= K; i++) {
  let [r1, c1, r2, c2] = target[i].split(' ').map(Number);
  let eachRect = { r1, c1, r2, c2 };

  // Call the colorArea function within the loop
  colorArea(eachRect);
}

function colorArea({ r1, c1, r2, c2 }) {
  for (let i = r1; i <= r2; i++) {
    for (let j = c1; j <= c2; j++) {
      map[i][j] = 1; // Assuming map is already defined elsewhere
    }
  }
}
