/* letters.java
 Yufei Liu
 Irene 
 yliu68
 Your section 3*/
import java.util.Scanner;
import javax.swing.JOptionPane;
 import java.io.*;
public class letters//new class of  
 {
  public static void rule1()
   {
     String name;
     name = JOptionPane.showInputDialog("Please enter you name:");
     JOptionPane.showMessageDialog(null,"Hello, "+name);
     JOptionPane.showMessageDialog(null,"Welcome to OUT OF ARRESTING.");
     JOptionPane.showMessageDialog(null,"There is the map of the THISWORLD");
   }
  public static void rule2()throws IOException
   {
     System.out.println("Here is the R-U-L-E of THISWORLD!!");
     System.out.println(" ");
     File background = new File("background.txt");//(I/O) a text input file
     Scanner inputFile = new Scanner(background);
     while(inputFile.hasNext())
     {
       System.out.println(inputFile.nextLine());
     }
     System.out.println(" ");
     String begin =" ";
     Scanner scan = new Scanner(System.in);
     System.out.println("Enter random characters to begin the game.");
     begin = scan.nextLine();
  }
}
   
