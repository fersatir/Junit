package com.app;

public class C01StringModifier {
	
	//method'un amacı: verilen string ifadede ilk 2 karaktere bakacak 
	//ve bu iki karakter içinde A harfi olanları hiçlik yapacak
	
	public String deleteAIfItIsinFirstTwoPosition(String str) {
		
		if(str.length()<=2) {
			return str.replaceAll("A","");
		}
		
		String firstTwoChars= str.substring(0,2);
		String afterFirstTwoChars=str.substring(2);
		
		return firstTwoChars.replaceAll("A","")+ afterFirstTwoChars;
	}

}
