package main;

import java.util.ArrayList;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String out="";
		for(int i=0;i<input.length();i++) {
			out=out+input.substring(i, i+1);
			out=out+input.substring(i, i+1);
			out=out+input.substring(i, i+1);
		}
		
		
		return out;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		int start= input.toLowerCase().indexOf("bert");
		if (start==-1) {
			return "";
		}
		String cut1=input.substring(start+4);
		int end=cut1.toLowerCase().indexOf("bert");
		if (end==-1) {
			return "";
		}
		while (true) {
			
			int endd=cut1.substring(end+1).indexOf("bert");
			if (endd==-1) {
				break;
			}
			end=endd;
		
		}
		String cut2=cut1.substring(0,end);
		String out="";
		for (int i=cut2.length()-1;i>=0;i--) {
			String nextChar=cut2.substring(i, i+1);
			out = out+nextChar;
		}
		
		
		return out;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {
		int small=12;
		int med =0;
		int large=1234123;
		if(a==b|a==c||b==c) {
			return false;
		}
		if(a<b&a<c) {
			small=a;
			if(b<c) {
				med=b;
				large=c;
			}else {
				med=c;
				large=b;
			}
		}else if(b<a&b<c) {
			small=b;
			if(a<c) {
				med=a;
				large=c;
			}else {
				med=c;
				large=a;
			}
			
		}else if(c<a&c<b) {
			small=c;
			if(a<b) {
				med=a;
				large=b;
			}else {
				med=b;
				large=a;
			}
		}
		
		int dif1=small-med;
		int dif2=med-large;
		if(dif1==dif2) {
			return true;
		}
		
		
		
		
		
		
		return false;
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int n) {
		String out= input;
		while(true) {
			n=n-1;			
			int cut;
			if(out.length()%2==0) {
				cut=(out.length()/2)-1;
			}else {
				cut=(out.length()/2);
			}
			out=out.substring(0, cut)+out.substring(cut+1);
			
			if (n==0) {
				return out;
			}
			
		}
	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("wehateDev") → true
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {
		int len=input.length();
		if (len<3) {
			return false;
		}
		
		String end=input.substring(len-3);
		
		end=end.toLowerCase();
		if (end.equals("dev")) {
			return true;
		}
		
		
		
		
		return false;
	}



	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {
		char ochar='£';
		char cchar;
		int count=1;
		int largest=0;
		
		for(int i=0;i<input.length();i++) {
			cchar=input.charAt(i);
			if(cchar==ochar) {
				count++;
				if(count>largest) {
					largest=count;
				}
			
			}else {
				count=1;
			}
			ochar=cchar;
		}
		
		
		return largest;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") → 1
	//amISearch("I am in Amsterdam am I?") → 2
	//amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {
		String str=arg1.toLowerCase();
		int count=0;
		int in;
		while(true) {
			in=str.indexOf(" am ");
			if(in==-1) {
				
				if(str.indexOf("am ")==0) {
					count++;
				}
				if(str.substring(str.length()-3).equals(" am")) {
					count++;
				}
				return count;
			}
			count++;
			str=str.substring(0, in)+str.substring(in+3);
		}
		
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) → "fizz"
	//fizzBuzz(10) → "buzz"
	//fizzBuzz(15) → "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		int num=arg1;
		boolean d3=false;
		boolean d5=false;
		if(num%3==0) {
			d3=true;
		}
		if (num%5==0) {
			d5=true;
		}
		if(d3&d5) {
			return "fizzbuzz";
		}
		if(d3) {
			return"fizz";
		}
		if(d5) {
			return"buzz";
		}
		
		return null;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") → 14
	//largest("15 72 80 164") → 11
	//largest("555 72 86 45 10") → 15
	
	public int largest(String arg1) {
		String numArray= "0123456789";
		ArrayList<Integer> nums= new ArrayList<Integer>();
		ArrayList<Integer> sizes= new ArrayList<Integer>();
		char next=0;
		int newNum=0;		
		while(true) {
			if(arg1.length()==1) {
				next=arg1.charAt(0);
				newNum=(newNum*10)+numArray.indexOf(next);
				nums.add(newNum);
				break;
			}
			
			next=arg1.charAt(0);
			arg1=arg1.substring(1);
			if(next==' ') {
				nums.add(newNum);
				newNum=0;
				continue;
			}
			newNum=(newNum*10)+numArray.indexOf(next);
		}
		
		for(int i:nums) {
			int size=0;
			while(i>0) {
				size=size+i%10;
				i=i/10;
			}
			sizes.add(size);
			
		}
		
		int max=0;
		for(int i :sizes) {
			if(i>max) {
				max=i;
			}
			
		}
		
		return max;
		
	}
	
	
	
}
