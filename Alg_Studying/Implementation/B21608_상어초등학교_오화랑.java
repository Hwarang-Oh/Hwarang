import java.io.*;
import java.util.*;

public class B21608_상어초등학교_오화랑 {
	static int size;
	static int studentNum;
	static int[] studentIndex, likeList[], classRoom[], roomInfo[];

	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(input.readLine());
		studentNum = size * size;
		roomInfo = new int[studentNum][7]; // 좌석 정보 : n번 자리 {상,좌,하,우, 들어가있는 숫자, x, y} -> {x,y, 들어가있는 숫자, 상, 좌, 하, 우}
		studentIndex = new int[studentNum + 1];
		likeList = new int[studentNum][4];
		
		// -1,0 / 0,-1, / 1,0 / 0,1 (상, 좌, 하, 우)
		int index = 0;
		for (int i = 0 ; i < size ; i++) {
			for (int j = 0 ; j < size ; j++) {
				roomInfo[index][0] = i; roomInfo[index][1] = j;
				if (i - 1 < 0) roomInfo[index][3] = -1;
				if (j - 1 < 0) roomInfo[index][4] = -1;
				if (i + 1 >= size) roomInfo[index][5] = -1;
				if (j + 1 >= size) roomInfo[index][6] = -1;
				index++;
			}
		}
		
		int student;
		for (int i = 0 ; i < studentNum ; i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			student = Integer.parseInt(st.nextToken());
			studentIndex[student] = i;
			likeList[i][0] = Integer.parseInt(st.nextToken());
			likeList[i][1] = Integer.parseInt(st.nextToken());
			likeList[i][2] = Integer.parseInt(st.nextToken());
			likeList[i][3] = Integer.parseInt(st.nextToken());
			makeSeat(student, likeList[i]);
		}
		
		int totalPoint = 0; int tempCount; int stIndex;
		for (int i = 0 ; i < roomInfo.length ; i++) {
			tempCount = 0;
			stIndex = studentIndex[roomInfo[i][2]];
			for (int j = 0 ; j < 4 ; j++) {
				if (roomInfo[i][j+3] == likeList[stIndex][0]) tempCount++;
				if (roomInfo[i][j+3] == likeList[stIndex][1]) tempCount++;
				if (roomInfo[i][j+3] == likeList[stIndex][2]) tempCount++;
				if (roomInfo[i][j+3] == likeList[stIndex][3]) tempCount++;
			}
			switch (tempCount) {
				case 4: totalPoint += 900;
				case 3: totalPoint += 90;
				case 2: totalPoint += 9;
				case 1: totalPoint += 1;
				case 0: totalPoint += 0;
			}
		}
		System.out.println(totalPoint);
	}
	// 각 자리에 정보를 붙이고, 그에 맞게 자리에 앉히는 것은 어떨까? => 계속 갱신해주기! 
	public static void makeSeat(int eachStud, int[] like) {
		Queue<int []> tempSeat = new ArrayDeque<>();
		
		// 1. 조건에 따라, 해당 학생이 들어갈 빈칸을 선택
		for (int i = 0 ; i < roomInfo.length ; i++) {
			if (roomInfo[i][2] != 0) continue;
			
			int[] temp = {i,0,0}; // 좌석번호, 주변선호도, 빈칸정보
			for (int j = 0 ; j < 4 ; j++) { // 좌석의 정보를 갱신한다.
				if (roomInfo[i][j+3] == like[0]) temp[1]++; // 위쪽에 선호 학생?
				if (roomInfo[i][j+3] == like[1]) temp[1]++; // 왼쪽에 선호 학생?
				if (roomInfo[i][j+3] == like[2]) temp[1]++; // 아래쪽에 선호 학생?
				if (roomInfo[i][j+3] == like[3]) temp[1]++; // 오른쪽에 선호 학생?
				if (roomInfo[i][j+3] == 0) temp[2]++; // 빈칸은 몇개 있나?
			}
			
			if (tempSeat.isEmpty()) // Queue에 없다면, 좌석의 정보를 넣어준다.
				tempSeat.offer(temp);
			
			if (tempSeat.peek()[1] < temp[1]) { // 1-1.해당 좌석에 선호 학생이 많다면, 채택
				tempSeat.poll(); tempSeat.offer(temp);
			}
			else if (tempSeat.peek()[1] == temp[1]) { // 1-2. 선호 학생이 같지만, 빈칸이 주변에 더 많았다면, 채택
				if (tempSeat.peek()[2] < temp[2]) { 
					tempSeat.poll(); tempSeat.offer(temp);
				}
			}// 1-3. 왜 행번호 -> 열번호는 체크 X? => 좌석 정보의 순서가 이미 행 번호와 열 번호의 최소 정보를 담고 있음.
		}
		
		// 2. 들어간 칸에 따라 주변의 영향을 수정해줘야 함. 
		int[] seat = tempSeat.poll(); // 들어갈 칸에 대한 정보 꺼내기
		int seatX = roomInfo[seat[0]][0]; // 들어갈 칸의 x좌표
		int seatY = roomInfo[seat[0]][1]; // 들어갈 칸의  y좌표
		roomInfo[seat[0]][2] = eachStud; // 교실 정보 Array에 또 학생 정보를 넣고
		
		for (int i = 0 ; i < roomInfo.length ; i++) { // -1,0 / 0,-1, / 1,0 / 0,1 (상, 좌, 하, 우)
			if (seatX - 1 == roomInfo[i][0] && seatY == roomInfo[i][1]) roomInfo[i][5] = eachStud; // 현재 위치의 위쪽 입장에서는 '하'
			if (seatX == roomInfo[i][0] && seatY - 1 == roomInfo[i][1]) roomInfo[i][6] = eachStud; // 현재 위치의 왼쪽 입장에서는 '우'
			if (seatX + 1 == roomInfo[i][0] && seatY == roomInfo[i][1]) roomInfo[i][3] = eachStud; // 현재 위치의 아래쪽 입장에서는 '상'
			if (seatX == roomInfo[i][0] && seatY + 1 == roomInfo[i][1]) roomInfo[i][4] = eachStud; // 현재 위치의 오른쪽 입장에서는 '좌'
		}
	}
}
