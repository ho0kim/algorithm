package netmable_ex1;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,4,3,3};
		System.out.println(solution(a));

	}
	
	
	public static int solution(int[] s) {
        int answer = 0;
        int[] cnt=new int[4];
        for(int i=0;i<s.length;i++) {
        	switch(s[i]) {
        	case 1: cnt[0]+=1;break;
        	case 2: cnt[1]+=1;break;
        	case 3: cnt[2]+=1;break;
        	default: cnt[3]+=1;break;
        	}
        }

        answer+=cnt[3];
        if(cnt[2]>cnt[0]) {
        	answer+=cnt[2];
        	cnt[0]=0;
        }else {
        	answer+=cnt[2];
        	cnt[0]=cnt[0]-cnt[2];
        }
        answer=answer+cnt[1]/2;
        cnt[1]=cnt[1]%2;
        if(cnt[1]!=0) {
        	if(cnt[0]>=2) {
        		answer+=1;
        		cnt[0]-=2;
        	}else{
        		answer+=1;
        		cnt[0]=0;
        	}
        }else {
        	if(cnt[0]>0) {
        		answer=answer+cnt[0]/4+1;
        	}
        }
        
        return answer;
    }

}
