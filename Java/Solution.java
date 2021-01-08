import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.lang.model.util.ElementScanner6;

public class Solution {
   public static void main(String[] args)
    {   Player players[] = new Player[4];
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<4;i++ )
        {
            int id=sc.nextInt();
            sc.nextLine();
            String sk=sc.nextLine();
            String le=sc.nextLine();
            int poi=sc.nextInt();
            players[i]=new Player(id, sk, le, poi);
        }
        sc.nextLine();
        String skill = sc.nextLine();
        String level = sc.nextLine();
        int points =findPointsForGivenSkill(players, skill);
        
        Player player1=getPlayerBasedOnLevel(players, skill, level);
        if(points<0)
        {System.out.println("The given Skill is not available"); }
        else
        {System.out.println(points); }
        if(player1==null)
        {System.out.println("No player is available with specified level, skill and eligibility points."); }
        else
        {System.out.println(player1.playerid); }
    }

    public static int findPointsForGivenSkill(Player[] players, String skill)
      {
          //method logic
          int sum=0;
          
            for(int k = 0; k < players.length; k++) {
            if(skill.equalsIgnoreCase(players[k].skill))
            {sum+=players[k].points;}
            }
          return sum;
      }

    public static Player getPlayerBasedOnLevel(Player[] players, String skill, String level)
      {
          //method logic
          Player player1=null;
          for(int k = 0; k < players.length; k++) {
            if(skill.equalsIgnoreCase(players[k].skill) && level.equalsIgnoreCase(players[k].level) && players[k].points>=20)
            { player1=players[k];}
            }
            return player1;
      }
}

class Player
{
    int playerid;
    String skill;
    String level;
    int points;
    Player(int id, String sk, String le,int poi)
    {playerid=id;
    skill=sk;
    level=le;
    points=poi;
    }

    //code to build Player class
}
