import java.util.*;
public class Bracket_Sequence {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		
		Stack<Character> st=new Stack<>();
		
		char[] c=str.toCharArray();
		int len=c.length;
		int count=0;
		char temp='\0';
		int k=0;
		int i=0;
		while(k<len)
		{
			temp=c[0];
		for(i=0;i<len-1;i++)
		{
			c[i]=c[i+1];
		}
		c[i]=temp;
		
		for(i=0;i<len;i++)
		{
			if(c[0]==')')
			{
				break;
			}
			else if(c[i]=='(')
			{
				st.push(')');
				
			}
			else if(c[i]==')')
			{
				if(st.peek()=='(')
				{
					st.pop();
				}
				else
				{
					break;
				}
			}
			
		}
		//System.out.println("Count = = "+count);
		for(i=0;i<len;i++)
		{
			System.out.print(c[i]+" ");
		}
		System.out.println();
		if(i==len && st.isEmpty())
		{
			count++;
		}
		
		k++;
		st.removeAllElements();
		}
		
		System.out.println("Count = = "+count);
	}

}
