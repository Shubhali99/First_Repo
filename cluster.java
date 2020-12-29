import java.lang.*;
import java.util.*;
public class cluster
{
public static void main(String args[])
{
int[][] data=new int[6][2]; 	//for original dataset
int[][] data2=new int[6][2];	//to copy original dataset

int[][] c1_arr=new int[6][2]; 	//cluster array 1
int[][] c2_arr=new int[6][2];	//cluster array 2
float[][] c1=new float[2][2];	//array to initial take the cluster center

int dec[]=new int[6];		//decision array 1
int dec2[]=new int[6];		//decision array 2

double result1,result2;		// to store the result of euclidean distance formula
int i,j;

float x1=0.0f,x2=0,y1=0,y2=0;	//new calculated cluster points
Scanner s=new Scanner(System.in);

//Taking the input from the user
System.out.println("Enter the Array of data Points in x and y = = ");
	for( i=0;i<6;i++)
	{
	  for(j=0;j<2;j++)
	  {
	     data[i][j]=s.nextInt();
	     data2[i][j]=data[i][j];
          	   }
	}

//Taking cluster points from users
System.out.println("Enter the C1 and C2 of data Points in x and y = = ");
	/*for( i=0;i<2;i++)
	{
	  for(j=0;j<2;j++)
	  {
	      c1[i][j]=s.nextInt();
          	   }
	}*/
	c1[0][0]=s.nextInt();
	c1[0][1]=s.nextInt();
	
	c1[1][0]=s.nextInt();
	c1[1][1]=s.nextInt();


int m=0;

//Loop for calculation Begin Here 

do{
for( i=0;i<6;i++)	//for all the 6 datapoints 
	{
	 	  
	   result1=Math.sqrt(((data[i][0]-c1[0][0])*(data[i][0]-c1[0][0]))+((data[i][1]-c1[0][1])*(data[i][1]-c1[0][1])));
          	   result2=Math.sqrt(((data[i][0]-c1[1][0])*(data[i][0]-c1[1][0]))+((data[i][1]-c1[1][1])*(data[i][1]-c1[1][1])));	

	if(m%2==0)   	// for checking in future the 2 cluster are having same cluster point or not so decision will be stored in 2 
	{          		//different array acorrding to the va;ue of m
	 
	  if(result1<result2)	//check small number 
	    dec[i]=1;	//for cluster C1 value is 1
	  else
	    dec[i]=2;	//for cluster C2 value is 2
	}
              if(m%2==1)
	{
   	if(result1<result2)
	    dec2[i]=1;
	  else
	    dec2[i]=2;
	}
           }

//Now here, the data in decision array is filled now we have to separate the 
//datapoints According to there corresponding values of decision array

if(m%2==0)
{
	j=0;
	for(i=0;i<6;i++)	//again for all the datapoint so i<6
	{
 		 if(dec[i]==1)	//if value of decision array is 1
   		{
     		 c1_arr[j][0]=data2[i][0];      //data belongs to cluster 1
     		 c1_arr[j][1]=data2[i][1];
   		 j++;
   		}
  
	}

	j=0;
	for(i=0;i<6;i++)
	{
    		if(dec[i]==2)	//if value of decision array is 2
  		{
      		c2_arr[j][0]=data2[i][0];      //data belongs to cluster 2
     		 c2_arr[j][1]=data2[i][1];
    		j++;
  		}
  
	}
}
else
{
	 j=0;
	for(i=0;i<6;i++)
	{
  		if(dec2[i]==1)
  		 {
    	 	 c1_arr[j][0]=data2[i][0];
     		 c1_arr[j][1]=data2[i][1];
   		 j++;
  	 	}
  		
	}

	j=0;
	for(i=0;i<6;i++)
	{
  		  if(dec2[i]==2)
  		   {
     		     c2_arr[j][0]=data2[i][0];
       		     c2_arr[j][1]=data2[i][1];
    		      j++;
  		    }
  
	}

}
 
//here the length of both clusters is calculated 
int len=c1_arr.length;
len=len/2;
int len2=c2_arr.length;
len2=len2/2;

//Printing Cluster 1
	System.out.println("C1_ Array ");
	for(i=0;i<len;i++)
	{
   	System.out.println(c1_arr[i][0]+ " "+c1_arr[i][1]);
	}

//Printing Cluster 2
	System.out.println("C2_ Array ");
	for(i=0;i<len2;i++)
	{
  	 System.out.println(c2_arr[i][0]+ " "+c2_arr[i][1]);
	}


//Calculating new Centroid C1 
	for(i=0;i<len;i++)
	{
   	 x1 =x1+c1_arr[i][0];
	}
	x1=x1/len;

	for(i=0;i<len;i++)
	{
   	y1 =y1+c1_arr[i][1];
	}
	y1=y1/len;

//Calculating new Centroid C2 
	for(i=0;i<len2;i++)
	{
   	 x2=x2+c2_arr[i][0];
	}
	x2=x2/len2;

	for(i=0;i<len2;i++)
	{
  	 y2=y2+c2_arr[i][1];
	}
	y2=y2/len2;


//Printing new Centroid 
System.out.println("New values of cluster");
System.out.println(Math.ceil(x1)+" "+Math.ceil(y1));
System.out.println(Math.ceil(x2)+ " "+Math.ceil(y2));

//new cluster point are assigning to cluster point array C1
c1[0][0]=x1;
c1[0][1]= y1; 
c1[0][1]=x2; 
c1[1][1]= y2;

//Here in this algorithm we have to stop when the datapoints remain in the same clusters
//even after the calculation of new centroid so during the calculation 1st decision array 
//and second decision array both should be maintain and if both are having the same value
//means that now we have to stop the calculations
//and to see when which dec array should be used we are using the m variable
// if m value is even dec[] array will store the decision array
//and if m value is odd dec2[] array will store the decision result

for(i=0;i<6;i++)
{
if(dec[i]==dec2[i])
{
System.out.println(" THE BOTH CLUSTER POINT ARE SAME NOW C1 and C2  ");
break;
}
}

//
if(i==0)
break;
m++;
}while(m!=0);


}
}