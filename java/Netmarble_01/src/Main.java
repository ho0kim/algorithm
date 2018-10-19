import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String phrase = sc.nextLine();
		int sec = sc.nextInt();
		
		System.out.println(solution(phrase, sec));
	}

	public static String solution(String phrases, int second) {
		String answer = "";
		Queue<Character> q = new LinkedList<>();
		int strLen = phrases.length();
		for(int i =0;i<14;i++) {
			q.add('_');
		}
		for(int i =0; i<strLen;i++) {
			q.add(phrases.charAt(i));
		}
		
		for(int i = 0;i <second;i++) {
			char temp = q.poll();
			q.add(temp);
		}
		
		for(int i = 0;i<14;i++) {
			answer += q.poll();
		}
        return answer;
    }
}
