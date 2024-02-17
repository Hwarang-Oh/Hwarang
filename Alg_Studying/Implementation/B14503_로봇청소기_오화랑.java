import java.io.*;
import java.util.*;

public class B14503_로봇청소기_오화랑 {
	static int row, col, cleanCnt;
	static int[][] room;
	static int[][] dxdy = {
			{-1, 0}, {0, 1}, {1, 0}, {0, -1}
	}; // N -> E -> S -> W
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		room = new int[row][col];

		st = new StringTokenizer(input.readLine());
		int sRow = Integer.parseInt(st.nextToken());
		int sCol = Integer.parseInt(st.nextToken());
		int sDir = Integer.parseInt(st.nextToken());
		// 0 : N, 1 : E , 2 : S, 3 : W
		// 반시계 90도 -> N -> W -> S -> E -> N ...
		// 반시계 움직임 sDir - 1

		// 벽과 청소되지 않은 칸 입력
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < col ; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check(sRow, sCol, sDir);
		System.out.println(cleanCnt);
	}
	public static void check(int sRow, int sCol, int sDir) {
		// 1-1. 이동한 영역이 청소되지 않았다면 청소 -> 2
		if (room[sRow][sCol] == 0) {
			cleanCnt++;
			room[sRow][sCol] = 2;
		}
		// 1-2. 이동한 영역이 벽이라면 -> 프로그램 종료
		if (room[sRow][sCol] == 1)
			return;

		// 2. 주변 청소 가능여부 탐색
		int tempX; int tempY;
		boolean canClean = false;
		for (int[] search : dxdy) {
			tempX = sRow + search[0];
			tempY = sCol + search[1];
			if (room[tempX][tempY] == 0)
				canClean = true;
		}

		// 2-1. 주변에 청소할 공간이 있는 경우
		if (canClean) {
			for (int i = 0 ; i < 4 ; i++) {
				sDir = sDir - 1 < 0 ? sDir + 3 : sDir - 1;
				tempX = sRow + dxdy[sDir][0];
				tempY = sCol + dxdy[sDir][1];
				if (room[tempX][tempY] == 0) {
					check(tempX, tempY, sDir);
					break;
				}
			}
		}
		else { // 2-2. 주변에 청소할 공간이 없는 경우
			int backDir = (sDir - 2) < 0 ? sDir + 2 : sDir -2;
			tempX = sRow + dxdy[backDir][0];
			tempY = sCol + dxdy[backDir][1];
			check(tempX, tempY, sDir);
		}
	}
}

// 이동 Count check를 어떻게 할까? => 배열에 넣을까? => cnt변수?
// 1 전략 : 배열에 칸을 저장하고, 마지막에 세보자 => 이동 경로 표시기능 추가

//로봇 청소기 -> 청소하는 영역의 개수
//방의 각 칸 => r, c => 0, 0 ~ N - 1, M - 1
// 제약사항 : 모든 끝 칸에는 벽이 존재한다.
//1. 현재 칸이 아직 청소되지 않은 경우 => 청소
//2. 주변 4칸 모두 청소 => 후진이 가능하면 후진하고 1번으로 돌아감
//	+ 뒷 방향이 벽이라 후진하지 못한다면, 청소 종료
//3. 주변 4칸 중 청소되지 않은 빈 칸 존재 => 반 시계 90도 회전
//	=> 앞이 청소되어 있다면 결국 한 번더 90도 회전
//	=> 앞이 청소되어 있지 않다면 앞으로 전진!
//
//입력
//첫째 줄 -> N과 M ( 3 ~ 50 )
//둘째 줄 -> 로봇 좌표 + 방향 d (0 , 1 , 2 , 3) [ 북 동 남 서 ]
//셋째 줄 ~ => 좌표 ( 1 : 벽, 0 : 청소되지 않은 빈칸 )
