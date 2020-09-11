package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_2383 {
	private static List<int[]> s;
	private static List<int[]> p;
	private static int[] toStair;
	private static int answer;

	static void C(int start, int cnt, int max) {
		if (cnt == max) {
			run();
			return;
		}
		for (int i = start; i < p.size(); ++i) {
			p.get(i)[2] = 1;
			C(i + 1, cnt + 1,max);
			p.get(i)[2] = 0;
		}
	}

	private static void run() {
		for (int i = 0; i < p.size(); ++i) { // 각각의 사람들의 내려가려는 계단까지의거리를 저장
			toStair[i] = Math.abs(p.get(i)[0] - s.get(p.get(i)[2])[0]) + Math.abs(p.get(i)[1] - s.get(p.get(i)[2])[1]);
		}

		int count = 0; // 나간 사람 수
		int minute = 0;
		while (count != p.size()) {
			++minute;
			for(int i = 0; i<p.size(); ++i) {
				if (toStair[i] == 0 && p.get(i)[3] < s.get(p.get(i)[2])[2]) { // 계단에서 내려가고 있는 사람이면
					if (p.get(i)[3] == 0) { // 계단을 다 내려 갔으면
						--s.get(p.get(i)[2])[3];
						toStair[i] = -1;
						++count;
					}
				}
			}
			
			for (int i = 0; i < p.size(); ++i) { // 사람들 한칸씩 움직여줌
				if (toStair[i] == -1)
					continue; // 다 내려간애면 넘겨줌
				if (toStair[i] == 0) { // 계단입구 또는 내려가고 있으면
					if (p.get(i)[3] < s.get(p.get(i)[2])[2]) { // 계단에서 내려가고 있는 사람이면
						--p.get(i)[3];
					} else { // 계단 입구에서 대기중인 사람이면
						if (s.get(p.get(i)[2])[3] < 3) { // 계단에 있는 사람이 3명보다 적으면
							++s.get(p.get(i)[2])[3];
							--p.get(i)[3];
						}
					}
				} else { // 계단으로 가는 중이면
					--toStair[i];
					if (toStair[i] == 0) { // 방금 계단에 도착했으면
						p.get(i)[3] = s.get(p.get(i)[2])[2]; // 계단입구에서 대기 또는 내려가는 중으로 바뀜
					}
				}
			}
		}
		answer = Math.min(answer, minute);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			int N = Integer.parseInt(br.readLine());
			s = new ArrayList<>();
			p = new ArrayList<>();
			answer  = Integer.MAX_VALUE;

			for (int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					int num = Integer.parseInt(st.nextToken());
					if (num == 1)
						p.add(new int[] { i, j, 0, 0 }); // x,y, 계단 번호, 계단을 다 내려가기까지 남은 시간(-1 이면 다 내려감)
					if (num > 1)
						s.add(new int[] { i, j, num, 0 }); // x,y, 내려가는데 걸리는 시간, 내려가고 있는 사람 수
				}
			}

			toStair = new int[p.size()];

			for (int i = 0; i <= 10; ++i) {
				C(0,0, i);
			}

			System.out.println("#" + test_case + " " + answer);

		}
	}

}
