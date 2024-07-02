import java.io.*;
import java.util.*;

/**
 * B13302_리조트_오화랑
 * https://www.acmicpc.net/problem/13302
 */
public class B13302_리조트_오화랑 {
    static class Solution {
        int N, M;
        boolean[] cantGo;
        int[] minCost;
        int[][] remainDay;
        int[][] cost;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            this.N = Integer.parseInt(st.nextToken());
            this.M = Integer.parseInt(st.nextToken());
            this.remainDay = new int[this.N + 1][5];
            this.cost = new int[this.N + 1][5];
            this.cantGo = new boolean[this.N + 1];
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < this.M; i++) {
                this.cantGo[Integer.parseInt(st.nextToken())] = true;
            }
            for (int i = 1; i <= this.N; i++) {
                Arrays.fill(this.cost[i], 1_000_000);
            }
            getMinCost();

            for (int i = 0; i <= this.N; i++) {
                System.out.println("Day : " + i);
                System.out.println(Arrays.toString(this.cost[i]));
                System.out.println(Arrays.toString(this.remainDay[i]));
            }
        }

        void getMinCost() {
            for (int day = 1; day <= this.N; day++) {
                getEachMin(day);
            }
        }

        void getEachMin(int day) {
            int[][] payment = { { 10000, 0 }, { 25000, 2 }, { 37000, 4 } };
            int eachCost, eachRemainDay;

            // 만약 오늘 리조트를 이용할 수 없는 날이라면? -> 전날의 정보에서 RemainDay를 빼주면 된다.
            if (cantGo[day]) {
                for (int coupon = 4; coupon >= 0; coupon--) {
                    eachCost = this.cost[day - 1][coupon];
                    eachRemainDay = this.remainDay[day - 1][coupon];

                    this.cost[day][coupon] = eachCost;
                    this.remainDay[day][coupon] = eachRemainDay - 1 <= 0 ? 0 : eachRemainDay - 1;
                }
                return;
            }

            for (int coupon = 4; coupon >= 0; coupon--) {
                eachCost = this.cost[day - 1][coupon];
                eachRemainDay = this.remainDay[day - 1][coupon];
                if (coupon > 0 && eachCost == 0)
                    continue;

                // 해당 쿠폰 개수가 남은 경우에, RemainDay가 0보다 크다면
                if (eachRemainDay > 0) {
                    // 하루가 그냥 지났을 때, 남은 액수가 저장된 정보에 비해 작다면, 갱신
                    if (this.cost[day][coupon] > eachCost) {
                        this.cost[day][coupon] = eachCost;
                        this.remainDay[day][coupon] = eachRemainDay - 1;
                    } else if (this.cost[day][coupon] == eachCost) {
                        this.remainDay[day][coupon] = Math.max(eachRemainDay - 1, this.remainDay[day][coupon]);
                    }
                }
                // 해당 쿠폰 개수가 남은 경우에, RemainDay가 0보다 작다면 => 무엇인가 조치를 취해서 리조트를 즐겨야 함
                else {
                    // 쿠폰을 쓸 수 있다면, 쿠폰을 사용한다.
                    int nextCoupon;
                    if (coupon >= 3) {
                        nextCoupon = coupon - 3;
                        if (this.cost[day][nextCoupon] > eachCost) {
                            this.cost[day][nextCoupon] = eachCost;
                            this.remainDay[day][nextCoupon] = 0;
                        } else if (this.cost[day][nextCoupon] == eachCost) {
                            this.remainDay[day][nextCoupon] = Math.max(0, this.remainDay[day][nextCoupon]);
                        }
                    }
                    // 쿠폰을 쓸 수 없다면, 이용권을 구매해야 한다.
                    else {
                        for (int p = 0; p < 3; p++) {
                            nextCoupon = coupon + p;
                            if (this.cost[day][nextCoupon] > eachCost + payment[p][0]) {
                                this.cost[day][nextCoupon] = eachCost + payment[p][0];
                                this.remainDay[day][nextCoupon] = eachRemainDay + payment[p][1];
                            } else if (this.cost[day][nextCoupon] == eachCost + payment[p][0]) {
                                this.remainDay[day][nextCoupon] = Math.max(eachRemainDay + payment[p][1],
                                        this.remainDay[day][nextCoupon]);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}