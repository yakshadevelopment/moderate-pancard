package java8.mod.pancard;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static boolean inputValidation (String pancard)
	{
		try
		{
			if(pancard.length()!=10)
				  throw new Exception();
			   pancard=pancard.toUpperCase();
			   Pattern pattern = Pattern.compile("[A-Z]", Pattern.CASE_INSENSITIVE);
			   Matcher matcher = pattern.matcher(pancard);
			   if(!matcher.find())
				   throw new Exception();
			    pattern = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
			    matcher = pattern.matcher(pancard);
			    if(!matcher.find())
					   throw new Exception();
			   pattern = Pattern.compile("[^A-Z0-9 ]", Pattern.CASE_INSENSITIVE);
			   matcher = pattern.matcher(pancard);
			   if(matcher.find())
				  throw new Exception();
			   
			   return true;
		}catch(Exception exception)
		{
			
			return false;
		}
	}
	
	public static String arrangeAlphanumerics (String pancard)
	{
		   String digit="";
		   String letter="";
		   for(int i=0;i<pancard.length();i++)
		   {
			   char ch=pancard.charAt(i);
			   if(Character.isDigit(ch))
				   digit=digit+ch;
			   else if(Character.isLetter(ch))
				   letter=letter+ch;
		   }
		   char []digitArray=digit.toCharArray();
		   char []letterArray=letter.toCharArray();
		   Arrays.sort(digitArray);
		   Arrays.sort(letterArray);
		   String output=String.valueOf(digitArray);
		   for(int i=letterArray.length-1;i>=0;i--)
			   output=output+letterArray[i];
		   return output; 
       }

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Pan Card Id.");
		String pancard=scanner.nextLine();
		if(inputValidation(pancard))
			System.out.println(arrangeAlphanumerics(pancard));
		else
			System.out.println("Invalid Pan Card Id");
		}
}
