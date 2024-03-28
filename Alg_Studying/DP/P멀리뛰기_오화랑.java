class Solution {
    public int solution(int n) {
        int[] answerList = new int[n + 2];
        answerList[1] = 1;
        answerList[2] = 2;
        if (n >= 3) {
            for (int i = 3 ; i <= n ; i++) {
                answerList[i] = (answerList[i - 1] + answerList[i - 2]) % 1234567;
            }

        }
        int answer = answerList[n];
        return answer;
    }
}