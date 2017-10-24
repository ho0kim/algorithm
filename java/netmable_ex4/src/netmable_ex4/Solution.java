package netmable_ex4;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,5};
		System.out.println(solution(5,a));
		

	}
	
	public static int solution(int l, int[] v) {
        int answer = 0;
        int maxlen=0;
        int temp=0;
        int cnt=0;
        
        for(int i=v.length; i>0; i--) {
        	for (int j=0; j<i-1; j++) { 
        		cnt++;
        		if(v[j] > v[j+1]) {
        			temp = v[j]; v[j] = v[j+1]; v[j+1] = temp; 
        			}
        		}
        	}
        for(int i=1; i<v.length;i++) {
        	if(v[i]-v[i-1]>maxlen)
        		maxlen=v[i]-v[i-1];
        }
        maxlen+=1;
        answer=maxlen/2;
        if(v[0]>answer) 
        	answer=v[0];
        if(l-v[v.length-1]>answer) 
        	answer=l-v[v.length-1];

        return answer;
    }

}
