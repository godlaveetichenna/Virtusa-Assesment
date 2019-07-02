package com.chenna.merchant;

import java.util.ArrayList;


public class Application {

	
	public static void main(String[] args) {
		
		Utility.println("Welcome to GalaxyMerchant ! please provide input below and a blank new line to finish input");
		
		
		Paragraph paragraph = new Paragraph();
		
		ArrayList<String> output=paragraph.read();
		
		for(int i=0;i<output.size();i++)
		{
			Utility.println(output.get(i));
		}
		
		
	}

}
