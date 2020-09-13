package coding_Test_Contest;
public class PROGRAMMERS_Solution03 {

	public int solution(int[] a) {
		int answer = 0;
		int[] leftArr = new int[a.length];
		int[] rightArr = new int[a.length];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<a.length; ++i) {
			if(min > a[i]) {
				min = a[i];
			}
			leftArr[i] = min;
		}
		
		min = Integer.MAX_VALUE;
		for(int i = a.length -1; i>=0; --i) {
			if(min > a[i]) {
				min = a[i];
			}
			rightArr[i] = min;
		}
		for(int i = 1 ; i<a.length-1; ++i) {
			int left = leftArr[i-1];
			int right = rightArr[i+1];
			
			if(a[i] != Math.max(left, Math.max(right, a[i])))
				++answer;
		}

		return answer+2;
	}

	public static void main(String[] args) {
		int a = new PROGRAMMERS_Solution03().solution(new int[] {-16,27,65,-2,58,-92,-71,-68,-61,-33});
		System.out.println(a);
	}
}
