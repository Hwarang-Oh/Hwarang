import java.io.*;
import java.util.*;

public class B1043_거짓말_오화랑_최적화필요 {
    static class Party {
        int cnt;
        ArrayList<Integer> partyMem;

        public Party(int cnt) {
            this.cnt = cnt;
            this.partyMem = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        HashMap<Boolean, HashSet<Integer>> knowStoryMap = new HashMap<>();
        ArrayList<Party> partyList = new ArrayList<>(P);
        knowStoryMap.put(true, new HashSet<>(N));

        st = new StringTokenizer(input.readLine());
        int knowStory = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowStory; i++)
            knowStoryMap.get(true).add(Integer.parseInt(st.nextToken()));

        int cnt;
        boolean isKnow;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(input.readLine());
            cnt = Integer.parseInt(st.nextToken());
            Party party = new Party(cnt);
            isKnow = false;

            int each1;
            for (int j = 0; j < cnt; j++) {
                each1 = Integer.parseInt(st.nextToken());
                if (knowStoryMap.get(true).contains(each1))
                    isKnow = true;
                party.partyMem.add(each1);
            }

            if (isKnow) {
                for (int each2 : party.partyMem)
                    knowStoryMap.get(true).add(each2);
            }
            partyList.add(party);
        }
        boolean canLie;
        int len = 0;
        while (len < knowStoryMap.get(true).size()) {
            len = knowStoryMap.get(true).size();
            for (Party eachParty : partyList) {
                canLie = true;
                for (int each : eachParty.partyMem) {
                    if (knowStoryMap.get(true).contains(each)) {
                        canLie = false;
                        break;
                    }
                }
                if (!canLie) {
                    for (int each : eachParty.partyMem)
                        knowStoryMap.get(true).add(each);
                }
            }
        }

        // System.out.println(knowStoryMap.get(true));

        int lieCnt = 0;
        for (Party eachParty : partyList) {
            canLie = true;
            for (int each : eachParty.partyMem) {
                if (knowStoryMap.get(true).contains(each)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie)
                lieCnt++;
        }
        System.out.println(lieCnt);
    }
}
// 솔직히 최적화가 매우 필요한 상태
// 너무 비효율적인 풀이 같다..