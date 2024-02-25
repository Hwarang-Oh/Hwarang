
public class A0208_CBT_Test {

	public static void main(String[] args) {
		A0208_CBT<Character> tree = new A0208_CBT<>(10);
		for (int i = 0 ; i < 10 ; i++) {
			tree.add((char)(65 + i));
		}
//		tree.bfs();
//		System.out.println("==================================");
//		tree.bfs2();
//		System.out.println("==================================");
//		tree.bfs3();
		tree.dfsByPreorder();
		tree.dfsByInorder();
		tree.dfsByPostorder();
	}
}

// 현재 출력에는 Level에 대한 정보가 존재하지 않는다.
//어떻게 하면 너비를 구분해서 출력을 해낼 수 있을까??
// 방문 여부를 확인하지 않았다 In Tree
// 한 정점에서 다른 정점으로 오는 경우가 유일함
// Acyclic => 방문관리르 할 필요가 없다.