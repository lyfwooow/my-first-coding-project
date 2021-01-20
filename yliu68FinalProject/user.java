/* user.java
 Yufei Liu
 Irene 
 yliu68
 Your section 3*/
import java.util.Scanner;
import java.io.*;
public class user//new class of playing process
{
  public static boolean arrest = false;//declare boolean variable
  public static boolean escape= false;//declare boolean variable
  public static int steppolice=0;
  public static int stepuser=0;
  public static int money = 100;

  public static void process( )throws IOException
  {
    int countuser=0;
    int countpolice=22;
    int record[] = new int[10000];
    int count=0;
    String userlocation[][] = new String[20][20];//a 2-d array
    
    while(!arrest&&money!=0&&!escape)//(BOOL)use the boolean variable
    {
      method steps = new method();//call random dice
      String enter = " ";//interactive input and output
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter random characters to throw the dice.");
      enter = scan.nextLine();
     
      stepuser=steps.random1();//(RANDOM)use random method to get number for user
      steppolice=steps.random2();//(RANDOM)use random method to get number for police
      countuser=countuser+stepuser;//steps for user
      countpolice=countpolice+steppolice;//steps for police
      drawmap start = new drawmap();//call drawmap method
     
      if(countuser>43)//recycle if don't get the endpoint
      {
        countuser=countuser-44;
      }
      if(countuser<20)
      {
        if(countuser==9)//get a fly pass
        {
          start.worldMap(userlocation);
          userlocation[13][14]="|+_+ |";
          System.out.println("\n\nYeah!You get a F-L-Y pass.");
          //randomuser.draw(userlocation);
          countuser=27;
        }
        else if(countuser==18)//robbed by a robber
        {
          start.worldMap(userlocation);
          userlocation[1][countuser]="|$_$ |";
          //randomuser.draw(userlocation);
          money=money-50;//这里可能有一个boolean 如果money小于0 游戏结束
          System.out.println("\n\nOH!No!You meet a R-O-B-B-E-R and are robbed $50!");
          System.out.println("You only have $"+money+" remain.");
          if(money==0)
            arrest=true;
        }
        else//normal steps
        {
          start.worldMap(userlocation);
          userlocation[1][countuser]="|+_+ |";
          //randomuser.draw(userlocation);
        }
      }
      
      else if(countuser==20)//normal step
      {
        start.worldMap(userlocation);
        userlocation[6][19]="|+_+ |";
        //randomuser.draw(userlocation);
      }
      else if(countuser==21)//normal step
      {
        start.worldMap(userlocation);
        userlocation[10][19]="|+_+ |";
        //randomuser.draw(userlocation);
      }
      else if(countuser>21&&countuser<=41)
      {
          if(countuser==27)//get fly pass
          {
            start.worldMap(userlocation);
            userlocation[1][9]="|+_+ |";
            System.out.println("Yeah!You get a F-L-Y pass.");
            //randomuser.draw(userlocation);
            countuser=9;
          }
          else if(countuser==38)//meet a trap and lose the game
          {
            start.worldMap(userlocation);
            userlocation[13][3]="|>_< |";
            System.out.println("\n\nAH!There is a T-R-A-P!You are arrested by the police.\n\n     You L-O-S-E the game.");
            //steps.draw(userlocation);
            arrest=true;
          }
          else//normal step
          {
            start.worldMap(userlocation);
            userlocation[13][41-countuser]="|+_+ |";
            //randomuser.draw(userlocation);
          }
      }
      else if(countuser==42)//normal step
      {
        start.worldMap(userlocation);
        userlocation[9][0]="|+_+ |";
        //randomuser.draw(userlocation);
      }
      else if(countuser==43)//the user gets the endpoint, win the game
      {
        start.worldMap(userlocation);
        userlocation[5][0]="|^o^ |";
        //steps.draw(userlocation);
        System.out.println("\n\nCongratulation!You are OUT of the ARRESTING by the police.\nYou W-I-N the game^o^");
        escape=true;
      }
      
      //这里开始是police
      
       if(countpolice>43)
      {
        countpolice=countpolice-44;
      }
       
      if(countpolice>=22&&countpolice<=41)//normal police step
      {
        userlocation[13][41-countpolice]="|:-P |";
        steps.draw(userlocation);
      }
      else if(countpolice==42)//normal step
      {
        userlocation[9][0]="|:-P |";
        steps.draw(userlocation);
      }
      else if(countpolice==43)
      {
        userlocation[5][0]="|:-P |";
        steps.draw(userlocation);
      } 
      else if(countpolice<20)
      {
        if(countpolice==18)//police stunned by a robber
        {
          userlocation[1][countpolice]="|:-P |";
          steps.draw(userlocation);//police应该在下一次跌骰子的时候steppolice＝0
          userlocation[1][countpolice]="|    |";
          countpolice=countpolice-steppolice;
          System.out.println("\nOH!Yes!Police meets the robber and is stunned by the robber!He is moved to the place he was last time.\n");
          userlocation[1][countpolice]="|:-P |";
          steps.draw(userlocation);
        }
      else //normal steps
        {
          userlocation[1][countpolice]="|:-P |";
          steps.draw(userlocation);
        }
      }
      
      else if(countpolice==20)//normal step
      {
        userlocation[6][19]="|:-P |";
        steps.draw(userlocation);
      }
      else if(countpolice==21)//normal step
      {
        userlocation[10][19]="|:-P |";
        steps.draw(userlocation);
      }
      
      record[count]=stepuser;
      count++;
      
      chased(countpolice, countuser);//parameter
      }
    
    if(arrest)
    {
      System.out.println(" You L-O-S-E the game because police arrested you.\n");
    }
    else if(money==0)
    {
      System.out.println(" You D-I-E of a murder that robber robs all of your money and kills you!\n");
    }
    else if(escape)
    {
      System.out.println(" Congratulation~Congratuation~You escape the arresting from police! You are a successful thief! ");
    }
    
      bubblesort(record,count);//(SORT)call the method of sort
      File Get6 = new File("Get6.txt");//a text output file
      PrintWriter writer = new PrintWriter(Get6);
      for(int i=0;i<count;i++)
      {
        writer.print(record[i]);
        writer.print(" ");
      }
      writer.close();
      int number6 = search(record,6);//(SEARCH)call the method of search
      number6 = count-number6;
      System.out.println("\nYou totally threw the dice "+count+" times.");
      if(number6==count+1)
        System.out.println("\nYou did never throw number 6.\n");
      else 
        System.out.println("\nYou threw "+number6+" times of number 6\n");
    }
  
  
  public static void chased(int countpolice1,int countuser1)//method to determine if police chase the user or user encounter the police
  {
    if (countpolice1 == countuser1)
      arrest = true;
  }
  
  public static void bubblesort(int[] list,int length)//sort method
  {
    int startIndex; 
    int i;  
    for (startIndex = 0;startIndex<=length-2; startIndex++)
    {
      for (i=length-2; i>=startIndex; i--)
        if (list[i]>list[i+1]) 
      {
        int temp;
        temp = list[i];
        list[i]=list[i+1];
        list[i+1]=temp;
      } 
     }
   } 
  
  public static int search( int[] theArray, int target) //search method
  {
    for (int loc=0;loc<theArray.length;loc++)
    {
    if (theArray[loc]==target)
    {
      return loc;
    }
    }
    return -1;    
  }
  
}
    