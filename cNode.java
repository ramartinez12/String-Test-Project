package lab3;
//this file represent a Node that will be used to store each character in a lString object
import java.util.*;
public class cNode{	
	public char item;
	public cNode next;
	
	public cNode(char c, cNode n){
		item = c;
		next = n;
	}
}
