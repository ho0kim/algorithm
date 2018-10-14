
public class Main {

	public static void main(String[] args) {
		String a = "ababc";
		String b = "";
		solution(a, b);
		
	}
	
    public static int solution(String s1, String s2) {
        int answer = 0;
        
        int s1Len = s1.length();
        int s2Len = s2.length();
        int minLen = 0;
        if(s1Len > s2Len) {
        	minLen = s2Len;
        }else {
        	minLen = s1Len;
        }
        
        String subStr = "";
        for(int i=0;i< minLen+1;i++) {
        	String s1sub = s1.substring(s1.length() - i, s1.length());
        	String s2sub = s2.substring(0, i);
        	
        	if(s1sub.equals(s2sub)) {
        		subStr = s2sub;
        	}
        }
        
        answer = s1.length() + s2.length() - subStr.length();
        System.out.println(answer);
        return answer;
    }

}
