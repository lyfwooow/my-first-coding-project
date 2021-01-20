/* yliu68_finalproject.java
 Yufei Liu
 Irene 
 yliu68
 Your section 3*/
 import java.util.Scanner;
 import java.io.*;
 public class yliu68_finalproject
 {
   public static void main(String [ ] args)throws IOException
   {
     letters character = new letters();//call the method "letters" in the main class
     character.rule1();//use JOption box to tell user rule
     
     drawmap drawing=new drawmap();
     String [][]BWmap=new String[20][20];//(AR)my own designed array
     drawing.worldMap(BWmap);
     BWmap[1][0]="|+_+ |";
     BWmap[13][19]="|:-P |";
     method begin = new method();//(MYMETH)invoke method
     begin.draw(BWmap);//(MYMETH(O))invoke method with parameter
     
     letters printout = new letters();
     printout.rule2();
     
     int steppolice=0;
     user playgame = new user();//call method
     playgame.process();
     
     
   } 
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 