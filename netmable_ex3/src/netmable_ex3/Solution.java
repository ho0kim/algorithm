package netmable_ex3;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a= {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		System.out.println(Arrays.toString(solution(3,a)));
	}
	
	public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int worngIdx=0;
        int worngPlayer=0;
        int worngOrder=0;
        //check worng index
        for(int i=1;i<words.length;i++) {
        	//check last char first char matching
        	if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
        		worngIdx=i+1;
        	}
        	//check before words
        	for(int k=0;k<i;k++) {
        		if(words[k]==words[i]) {
        			worngIdx=i+1;
        		}
        	}
        }
        
        if(worngIdx!=0) {
        	if((worngIdx%n)==0) {
        		worngPlayer=n;
        		worngOrder=worngIdx/n;
        	}
        	else {
        		worngPlayer=worngIdx%n;
        		worngOrder=(worngIdx/n)+1;
        	}
        }
        answer[0]=worngPlayer;
        answer[1]=worngOrder;

        return answer;
    }

}
