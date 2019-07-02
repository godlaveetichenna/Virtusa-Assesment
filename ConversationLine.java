
package com.chenna.merchant;


public class ConversationLine{

	
	public static enum Type{
		
		 ASSIGNED, 
		 
		 
		 CREDITS, 
		 
		 
		 QUESTION_HOW_MUCH, 
		 
		 
		 QUESTION_HOW_MANY, 
		 
		 
		 NOMATCH
		 
	}
	
	
	public class LineFilter
	{
		private ConversationLine.Type type;
		private String pattern;
		public LineFilter(ConversationLine.Type type,String pattern)
		{
			this.type = type;
			this.pattern = pattern;
		}
		
		public String getPattern()
		{
			return this.pattern;
					
		}
		
		public ConversationLine.Type getType()
		{
			return this.type;
		}
	}
	
	
	
	public static String patternAssigned = "^([A-Za-z]+) is ([I|V|X|L|C|D|M])$";
	public static String patternCredits = "^([A-Za-z]+)([A-Za-z\\s]*) is ([0-9]+) ([c|C]redits)$";
	public static String patternHowMuch = "^how much is (([A-Za-z\\s])+)\\?$";
	public static String patternHowMany= "^how many [c|C]redits is (([A-Za-z\\s])+)\\?$";
	private LineFilter[] linefilter;

	
	
	
	public ConversationLine()
	{
		
		this.linefilter = new LineFilter[4];
		this.linefilter[0] = new LineFilter(ConversationLine.Type.ASSIGNED, patternAssigned);
		this.linefilter[1] = new LineFilter(ConversationLine.Type.CREDITS, patternCredits);
		this.linefilter[2] = new LineFilter(ConversationLine.Type.QUESTION_HOW_MUCH, patternHowMuch);
		this.linefilter[3] = new LineFilter(ConversationLine.Type.QUESTION_HOW_MANY, patternHowMany);
		
	}
		
		
	
	
	
	public ConversationLine.Type getLineType(String line)
	{
		line = line.trim();
		ConversationLine.Type result = Type.NOMATCH;
		
		boolean matched = false;
			
		for(int i =0;i<linefilter.length && !matched ;i++)
		{
			if( line.matches(linefilter[i].getPattern()) )
			{
				matched = true;
				result = linefilter[i].getType();
			}
			
		}
		
		return result;
		
	}
	
}
