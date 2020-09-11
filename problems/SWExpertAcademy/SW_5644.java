package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;


public class SW_5644
{
    private static int[] moveX = { 0, 0, 1, 0, -1};
	private static int[] moveY = { 0, -1, 0, 1, 0 };

	static class BC {
		int x,y,c,p;

		public BC(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<BC> BCList;

		for (int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			BCList = new ArrayList<BC>();
			int answer = 0;
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			int[] personA = new int[M]; // 사람이 이동하는 경로
			int[] personB = new int[M];

			int[] pointA = { 1, 1 }; // 사람 시작점
			int[] pointB = { 10, 10 };

			StringTokenizer stA = new StringTokenizer(br.readLine());
			StringTokenizer stB = new StringTokenizer(br.readLine());

			for (int i = 0; i < M; ++i) {
				personA[i] = Integer.parseInt(stA.nextToken());
				personB[i] = Integer.parseInt(stB.nextToken());
			}

			for (int i = 0; i < A; ++i) { // BC 리스트에 저장
				st = new StringTokenizer(br.readLine());
				BCList.add(new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			BCList.sort(new Comparator<BC>() {
				@Override
				public int compare(BC o1, BC o2) { /// 성능이 좋은 순서대로 정렬
					// TODO Auto-generated method stub
					return (o2.p - o1.p);
				}

			});
			
			for (int i = 0; i <= M; ++i) { // 한칸씩 이동하면서 검사
				ArrayList<Integer> Aidx = new ArrayList<Integer>(); /// A,B 가 각각 걸쳐져있는 모든 BC의 인덱스를 저장할 각각의 리스트
				ArrayList<Integer> Bidx = new ArrayList<Integer>();

				int maximum = 0;

				for (int j = 0; j < A; ++j) { // BC들이 저장된 리스트를 모두 돌며 범위내에 있는 BC들을 각각의 리스트에 넣어줌
					BC bc = BCList.get(j);
					
					if (Math.abs(bc.x - pointA[0]) + Math.abs(bc.y - pointA[1]) <= bc.c) {
						Aidx.add(j);
					}
					if (Math.abs(bc.x - pointB[0]) + Math.abs(bc.y - pointB[1]) <= bc.c) {
						Bidx.add(j);
					}
				}
				
				if (Aidx.size() != 0 && Bidx.size() != 0 && Aidx.get(0) == Bidx.get(0)) { // 둘다 하나라도 걸치고 인덱스가 같다면
					if (Aidx.size() == 1) { // 근데 A가 하나만 걸친다면 (A 사람은 다른거로 충전불가능하다면)
						if (Bidx.size() == 1)
							maximum = BCList.get(Aidx.get(0)).p; // B 도 같은 상황이면 나눠가짐
						else
							maximum = BCList.get(Aidx.get(0)).p + BCList.get(Bidx.get(1)).p; // 만약 같은 충전기에서 하는거보다 B가 다른거로 옮기는게 더 손해면 안옮기고 나눠먹음

					} else { // A가 걸치는게 여러개면
						if (Bidx.size() == 1)
							maximum = BCList.get(Bidx.get(0)).p + BCList.get(Aidx.get(1)).p; // 만약 같은 충전기에서 하는거보다 A가 다른거로 옮기는게 더 손해면 안옮기고 나눠먹음

						else {
							maximum = (BCList.get(Aidx.get(1)).p < BCList.get(Bidx.get(1)).p)  //둘다 옮길수 잇으면 그다음거중에 더 큰놈으로 옮김
									? BCList.get(Aidx.get(0)).p + BCList.get(Bidx.get(1)).p
									: BCList.get(Aidx.get(1)).p + BCList.get(Bidx.get(0)).p;
						}
					}
				} else {  //둘중에 하나라도 안걸치는 놈이 있으면
					maximum = ((Aidx.size() == 0)? 0 : BCList.get(Aidx.get(0)).p ) + ((Bidx.size() == 0)? 0 : BCList.get(Bidx.get(0)).p);
				}
				
				answer += maximum;

				if(i == M)
					break;
				
				pointA[0] += moveX[personA[i]];
				pointA[1] += moveY[personA[i]];

				pointB[0] += moveX[personB[i]];
				pointB[1] += moveY[personB[i]];
			}

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
