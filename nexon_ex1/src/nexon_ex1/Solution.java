package nexon_ex1;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		String[] val= {"{[()]}","((())"};
		
		System.out.println(Arrays.toString(braces(val)));
	}
	

    /*
     * Complete the function below.
     */
    static String[] braces(String[] values) {
		
    	int len = values.length;
    	String[] result = new String[len];
    	Stack s;
    	
    	
    	for(int i =0; i<len;i++) {
    		s=new Stack(values[i].length());
    		result[i]="YES";
    		for(int k=0;k<values[i].length();k++) {
    			char element=values[i].charAt(k);
    			
    			
    			System.out.println(element);
    			System.out.println(result[i]);
    			switch(element) {
    			case '(':
    			case '{':
    			case '[': s.push(element);
    			break;
    			case ')':
    				if(s.isEmpty()||((element=s.pop())!='(')) {
    					result[i]="NO";
    				}break;
    			
    			case '}':
    				if(s.isEmpty()||((element=s.pop())!='{')) {
    					result[i]="NO";
    				}break;
    			
    			case ']':
    				if(s.isEmpty()||((element=s.pop())!='[')) {
    					result[i]="NO";
    				}break;
    		}
    	}if(s.isEmpty()!=true) {
    			result[i]="NO";
    		}
    		
    	    	
    }
		return result;
    }
    
    public static class Stack{
    	char[] stack;
    	int top;
    	public Stack(int size) {
    		stack = new char[size];
    		this.top=-1;
    	}
    	public void push(char data) {
    		stack[++top]=data;
    	}
    	public char pop() {
    		return stack[top--];
    	}
    	public boolean isEmpty() {
    		if(top==-1)
    			return true;
    		else
    			return false;
    	}
    }
}
