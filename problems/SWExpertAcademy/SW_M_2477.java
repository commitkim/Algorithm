package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Client {
	int number;
	int time;
	int first = -1;
	int second = -1;

	public Client(int number, int time) {
		this.number = number;
		this.time = time;
	}
}

public class SW_M_2477 {
	private static int N, M, K, A, B, answer;
	private static int[] reception, repair;
	private static Client[] receptionDesk, repairDesk;
	private static List<Client> clients, result;

	private static void run() {
		int time_ = 0;
		Queue<Client> q = new LinkedList<>();
		int size = clients.size();

		while (result.size() != size) {

			int receptionDeskSize = receptionDesk.length;
			int repairDeskSize = repairDesk.length;
			for (int i = 0; i < receptionDeskSize; ++i) {
				if (receptionDesk[i] == null)
					continue;

				if (receptionDesk[i].time <= 0) {
					q.offer(receptionDesk[i]);
					receptionDesk[i] = null;
				}
			}

			Iterator<Client> iter = clients.iterator();

			while (iter.hasNext()) {
				Client c = iter.next();
				if (c.time <= 0) {
					for (int j = 0; j < receptionDeskSize; ++j) {
						if (receptionDesk[j] != null)
							continue;

						c.time = reception[j];
						c.first = j;
						receptionDesk[j] = c;
						iter.remove();
						break;
					}
				} else
					--c.time;
			}
			
			for (int i = 0; i < repairDeskSize; ++i) {
				if (repairDesk[i] == null)
					continue;
				
				if (repairDesk[i].time <= 0) {
					result.add(repairDesk[i]);
					repairDesk[i] = null;
					
				}
			}
			
			for (int j = 0; j < repairDeskSize; ++j) {
				if (repairDesk[j] != null)
					continue;
				if(q.isEmpty()) break;
				
				Client c = q.poll();
				c.time = repair[j];
				c.second = j;
				repairDesk[j] = c;
			}


			for (int i = 0; i < receptionDeskSize; ++i) {
				if (receptionDesk[i] == null)
					continue;
				--receptionDesk[i].time;
			}
			for (int i = 0; i < repairDeskSize; ++i) {
				if (repairDesk[i] == null)
					continue;
				--repairDesk[i].time;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			answer = 0;

			result = new ArrayList<Client>();
			reception = new int[N];
			receptionDesk = new Client[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				reception[i] = Integer.parseInt(st.nextToken());
				receptionDesk[i] = null;
			}

			repair = new int[M];
			repairDesk = new Client[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; ++i) {
				repair[i] = Integer.parseInt(st.nextToken());
				repairDesk[i] = null;
			}

			clients = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; ++i) {
				clients.add(new Client(i, Integer.parseInt(st.nextToken())));
			}


			run();

			for (Client client : result) {
				if (client.first == A - 1 && client.second == B - 1)
					answer += (client.number + 1);
			}

			System.out.println("#" + test_case + " " + ((answer == 0) ? -1 : answer));
		}
	}
}
