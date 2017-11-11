package lab3;
/*
 * this file represent each method that needs to be created, and each method represent a different operation that is to be made in the reference-based 
 * list of characters
 */
/*
 * Course: Data Structure CS2302
 * Author: Roman Martinez
 * Objective: to implement strings using reference-based list of characters, and to complete different methods that are to be used on the objects
 * Instrutor: Olac Fuentes
 * T.A: Saiful Abu
 * Date Last Modified: October 5, 2015
 * Purpose: The purpose of the program is to practice the implementations of different methods using reference-based list of characters, and each method will do different operations3 
 */
public class lString{
	//the variable represents the head of the set of Nodes created when seperating the String into Nodes of characters 
	private cNode  head;
	//the lString constructor method will input the String then it will be seperated to Nodes and give the variable head the reference to the nodes of characers
	public lString(String S){
		head =null;
		for (int i= S.length()-1;i>=0;i--)
			head = new cNode(S.charAt(i),head);             
	}
	//this method will set the input Node as the head of the list 
	public lString(cNode t){
		head = t;
	}
	//this method will print the list of characters in the order that is stored in the reference variable
	public void print(){
		for (cNode t=head;t!=null;t=t.next)
			System.out.print(t.item);
	}
	//this method will just print a space between the print method and the next print statement
	public void println(){
		print();
		System.out.println();
	}
	//this method will input a node and then it will create a new node and copy the next node in the list and return the node created 
	public static cNode copy(cNode x){
		if (x==null) 
			return null;
		return new cNode(x.item,copy(x.next));
	}
	//this method will return the lString after copying the lString into a new lString
	public lString copy(){
		cNode t = copy(head); 
		return new lString(t);      
	}
	//this method will return the size of the string created in the type lString
	public int length(){
		//this sets the variable x to the reference variable head so head will not be affected
		cNode x=head;
		return length(x);
	}
	//this method will calculate the length of the String using a recursive method
	public int length(cNode x){
		if(x==null)
			return 0; 
		x=x.next;
		return 1+length(x);
	}
	//this method will return the character at the desired index in the String of the object of type lString
	public char charAt(int Index){
		int length=length();
		int index=Index;
		//if the index is greater than the length of the String then it couldn't be found
		if(index>length){
			System.out.println("The index given is greater than the line of string");
			return '1';
		}
		cNode x=head;
		while(x!=null && index-1!=0){
			x=x.next;
			index--;
		}
		return x.item;
	}
	//this method sets a certain character inputed by the users at the position desired by the user
	public void setCharAt(int Index, char c){
		int length=length();
		int index=Index;
		//if the index is greater than the length then the character cannot be substituted
		if(index>length){
			System.out.println("The index given is greater than the line of string");
		} else { 
			cNode x=head;
			while(x!=null && index-1!=0){
				x=x.next;
				index--;
			}
			x.item=c;
		}
	}
	//this method will return the index or position of the character that the user is looking for 
	public int indexOf(char ch){
		cNode x=head;
		int index = 1;
		int length=length();
		while(x!=null && index+1!=length){
			if(x.item==ch){
				return index;
			} else {
				x=x.next;
				index++;  
			}
		}
		//if not found it returns -1
		return -1;
	}
	//this method compares 2 strings to see if they are identical, or if they are in alphabetical order 
	public int compareTo(lString L){
		if(length()!=L.length()){
			if(length()>L.length()){
				for(int i=1;i<=L.length();i++){
					if(L.charAt(i)>charAt(i)){
						return -1;
					} else {
						return 1;
					}
				}
			} else {
				for(int i=1;i<=length();i++){
					if(L.charAt(i)<charAt(i)){
						return 1;
					} else {
						return -1;
					}
				}
			}
		} 
		return 0;
	}
	//this method will unite 2 different strings into 1
	public void append(lString L){
		for(int i=1;i<=length();i++){
			System.out.print(charAt(i));
		}
		for(int i=1;i<=L.length();i++){
			System.out.print(L.charAt(i));
		}
		System.out.println( );	
	}
	//this method will replace any specific character in a String with another specific character
	public void replace(char ch1, char ch2){
		cNode x=head;
		int length=length(head);
		while(x!=null && length!=0){
			if(x.item==ch1){
				x.item=ch2;
			}
			x=x.next;
		}
		System.out.println("The character you are looking for is not in the String");
	}
	//this method will create and return a lString type variable with the content of a substring determined by the parameters of the method
	public lString substring(int startindex, int endindex){
		String temp="";
		int stringLength=endindex-startindex;
		if(stringLength<=length()){
			while(startindex<=endindex){
				temp+=charAt(startindex);
				startindex++;
			}
			lString subString=new lString(temp);
			return subString;
		} else {
			System.out.println("The substring cannot be created");
			return null;
		}
	}
	//this method will return the String in reverse 
	public lString reverse(){
		String temp="";
		for(int i=length();i>0;i--){
			temp+=charAt(i);
		}
		lString reverse=new lString(temp);
		return reverse;
	}
	//this method will return true if the String is actually a palindrome 
	public boolean palindrome(){
		lString reverse=reverse();
		for(int i=1;i<length();i++){
			reverse.charAt(i);
			if(reverse.charAt(i)!=charAt(i)){
				return false;
			}
		}
		return true;
	}
	//this method will determine if the String starts with the L lString characters
	public boolean startsWith(lString L){
		for(int i=1;i<L.length();i++){
			if(charAt(i)!=L.charAt(i)){
				return false;
			}
		}
		return true;
	}
	//this method will determine if the string ends with the L lString characters
	public boolean endsWith(lString L){
		L=L.reverse();
		lString reverse=reverse();
		for(int i=1;i<L.length();i++){
			if(reverse.charAt(i)!=L.charAt(i)){
				return false;
			}
		}
		return true;
	}
	//this method will determine if the L lString actually exist in the area specified in the String object 
	public boolean regionMatches(int ind, lString L, int lStringIndex, int len){
		if(ind<0||lStringIndex<0){
			return false;
		} else if((ind+len)>length()||(lStringIndex+len)>L.length()){
			return false;
		} else {
			for(int i=1;i<len;i++){
				if(charAt(ind+i)!=L.charAt(lStringIndex+i)){
					return false;
				}
			}
		}
		return true;
	}
	//this method returns true if the L lString is a substring of the lString object
	public boolean isSubstring(lString L){
		if(L.length()>length()){
			return false;
		} else {
			for(int i=1;i<L.length();i++){
				for(int j=1;j<length();j++){
					if(charAt(i)==L.charAt(j)){
						return true;
					}
				}
			}
			return false;
		}
	}
	//this returns the starting index where the L lString is in the original lString object
	public int indexOf(lString L){
		int index=L.length();
		for(int i=length();i>0;i--){
			if(charAt(i)==L.charAt(index)){
				if(index==1){
					return index;
				}
			}
			index--;
		}
		return -1;
	}
	//this method will return a string of the characters in the lString type object 
	public String toString(){
		cNode x=head;
		String temp="";
		while(x!=null){
			temp+=x.item;
			x=x.next;
		}
		return temp;
	}

	/* 

	  public  void print(){}    // Prints the contents of the string (provided)

	  public  int length(){}    // Returns the length of the string

	  public  char charAt(int index){} // Returns character at positio index

	  public  void setCharAt(int index, char c){}   // Sets character in positio index to c

	  public  int indexOf(char ch){}   // Returns the index of the first occurrence of character ch

	  public  int compareTo(lString L){}   // Compares lString to L, returns -1 if it comes before L in alphabetical order, 0 if they are equal, 1 otherwise

	  public  void  append(lString L){}    

	  public  void replace(char ch1, char ch2){}  //Replace all ocurrences of ch1 by ch2 in the string

	  public  lString substring(int startindex, int endindex){}   //Builds and returns a substring in the range specified

	  public  lString copy(){}  //

	  public  lString reverse(){}

	  public  boolean palindrome(){}

	  public  boolean startsWith(lString L){}

	  public  boolean endsWith(lString L) {}

	  public  boolean regionMatches(int ind, lString L, int lStringIndex, int len)  {}

	  public  boolean isSubstring(lString L) {}

	  public  int indexOf(lString L){}   

	  public  String toString(){} // Returns a regular string with the same contants as the lString 

	 */

}
