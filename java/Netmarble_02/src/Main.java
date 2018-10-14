import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"one","one", "two", "one"};
		solution(words);
	}

    public static long[] solution(String[] words) {
    	Hashtable<String, Integer> hash = new Hashtable<>();
    	
    	long[] answer = {};
    	answer = new long[words.length];
    	
    	for(int i =0; i<words.length;i++) {
    		if(hash.containsKey(words[i])== true) {
    			
    			hash.put(words[i], hash.get(words[i]));
    			answer[i] = hash.get(words[i]);
    		}else {
    			hash.put(words[i], i);
    			answer[i] = i;
    		}
    	}
     
    	for(int i = 0; i<words.length;i++) {
    		System.out.println(answer[i]+1);
    	}
        return answer;
    }
}
