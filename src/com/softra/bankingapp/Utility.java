package com.softra.bankingapp;

public class Utility {
	public Utility() {}
	public boolean isValidDate(String date) {
		String[] pos = date.split("/");
		if((Integer.parseInt(pos[0])>31 && Integer.parseInt(pos[0])<1)
				&&(Integer.parseInt(pos[1])>12 && Integer.parseInt(pos[1])<1)
				&&Integer.parseInt(pos[2])<0)
			return true;
		else
			return false;
		
	}
	public boolean isValidName(String name) {
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		 for (int i=0; i < name.length() ; i++)
	        {
	            char ch = name.charAt(i);
	            if(specialCharactersString.contains(Character.toString(ch)))
	                return false;
	       
	        }
		 return true;
		
	}

}
