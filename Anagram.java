import java.util.Arrays;
import java.util.Scanner;
public class Anagram
{
 public static void main(String args[])
{
  Scanner s=new Scanner(System.in);
  String s1="";
  String s2=""; 
  System.out.println("Enter the Strings ");
 s1=s.nextLine();
 s2=s.nextLine();
  int len1=s1.length();
  int len2=s2.length();
 int flag=0;

if(len1==len2)
{

char[] s1_arr=s1.toLowerCase().toCharArray();
char[] s2_arr=s2.toLowerCase().toCharArray();

Arrays.sort(s1_arr);
Arrays.sort(s2_arr);


if(Arrays.equals(s1_arr,s2_arr))
{
 flag=1;
}
}
else
 flag=0;


if(flag==0)
System.out.println("Not Anagram");
else
System.out.println(" Anagram");


System.out.println("Understood");
System.out.println("Understood");
System.out.println("Understood");
System.out.println("Understood");
}
}