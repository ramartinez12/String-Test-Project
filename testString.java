package lab3;
import java.util.*;
/*
 * Course: Data Structure CS2302
 * Author: Roman Martinez
 * Objective: to implement strings using reference-based list of characters, and to complete different methods that are to be used on the objects
 * Instrutor: Olac Fuentes
 * T.A: Saiful Abu
 * Date Last Modified: October 5, 2015
 * Purpose: The purpose of the program is to practice the implementations of different methods using reference-based list of characters, and each method will do different operations3 
 */

public class testString {
	
	public static void main(String[] args) {
		//variables being tested 
		Scanner i = new Scanner(System.in);
	      lString S = new lString("CS2302");
	      lString U = new lString("");
	      lString I = new lString("Iron Man");
	      lString F = new lString("Flash");
	      lString G = new lString("llo");
	      lString B = new lString("hello");
	      //the tests being made 
	      S.println();
	      lString T = S.copy();  
	      U.println();
	      T.println();
	      System.out.println("The length is "+S.length());
	      System.out.println("Please enter the index of the character you want");
	      int Index=i.nextInt();
	      System.out.println("The character at index "+ Index + " is " + S.charAt(Index));
	      S.setCharAt(4,'c');
	      System.out.println("Update");
	      S.println();
	      System.out.println("Index of e is ");
	      System.out.println(S.indexOf('e'));
	      S.replace('C','0');
	      System.out.println("Update");
	      S.println();
	      System.out.println("Comparing");
	      System.out.println(I.compareTo(G));
	      F.append(G);
	      lString reverse = S.reverse();
	      System.out.println("reverse");
	      reverse.println();
	      if(I.substring(1, 10)!=null){
	    	  lString A = I.substring(1, 10);
	    	  A.println();
	    	  }
	      if(B.palindrome()==true){
	    	  System.out.print("The word ");
	    	  B.println();
	    	  System.out.println("is a palindrome");
	      } else{ 
	    	  B.println();
	    	  System.out.println("is not a palindrome");
	      }
	      if(B.startsWith(G)){
	    	  System.out.println("true");
	      } else {
	    	  System.out.println("false");
	      }
	      if(B.endsWith(G)){
	    	  System.out.println("true");
	      } else {
	    	  System.out.println("false");
	      }
	      if(B.regionMatches(2,G,0,3)!=true){
	    	  System.out.println("The region does not match");
	      } else {
	    	  System.out.println("The region do match");
	      }
	      System.out.println(B.indexOf(G));
	      if(B.isSubstring(G)!=true){
	    	  System.out.println("It is a substring");
	      } else {
	    	  System.out.println("It is not a substring");
	      }
	      System.out.println("The object of type lString will become a String ");
	      System.out.println(S.toString());
	  }

	}
