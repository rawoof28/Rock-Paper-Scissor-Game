
import java.util.Scanner;
import java.util.Random;

public class Game_RockPaperScissor {
    static String[] rps = {"Rock","Paper","Scissor"};
    static int score1,score2;
    static int  input(Scanner sc,String player)
    {
        while(true)
        {
            System.out.println("1.Rock");
            System.out.println("2.Paper");
            System.out.println("3.Scissor");
            System.out.println("Enter the number by "+player+" :(1,2,3) ");
            int x = sc.nextInt();
            if(x>=1 && x<=3)
            {
                return x;
            }
            System.out.println("Enter the correct option. ");
        }
    }
    static void RPS(String pl1,String pl2,int p1,int p2)
    {
        System.out.println(pl1+" Entered "+rps[p1-1]);
        System.out.println(pl2+" Entered "+rps[p2-1]);
                    
        switch(p1)
        {
            case 1:
                if(p2 == 1)
                {
                    System.out.println("Tie");
                    score1++;
                    score2++;
                }
                else if(p2 == 2)
                {
                    System.out.println(pl1+" Win!");
                    score1++;
                }
                else
                {
                    System.out.println(pl2+" Win!");
                    score2++;
                }
                break;
            
            case 2:
                if(p2 == 1)
                {
                    System.out.println(pl1+" Win!");
                    score1++;
                }
                else if(p2 == 2)
                {
                    System.out.println("Tie");
                    score1++;
                    score2++;
                }
                else
                {
                    System.out.println(pl2+" Win!");
                    score2++;
                }
                break;
            case 3:
                if(p2 == 1)
                {
                    System.out.println(pl1+" Win!");
                    score2++;
                }
                else if(p2 == 2)
                {
                    System.out.println(pl1+" Win!");
                    score1++;
                }
                else
                {
                    System.out.println("Tie");
                    score1++;
                    score2++;
                }
                break;        
        }
    }
    static void OnePlayer(Random rand,Scanner sc)
    {
        System.out.println("\n --- --- --- --- --- --- --- --- --- ---- ---\n");
        System.out.println("One Player Game Starts ");
        System.out.println("Enter How many rounds :");
        int rounds = sc.nextInt();

        score1 = 0;
        score2 = 0;
        int r=0;

        while(r<rounds){
            int moniter =  rand.nextInt(3)+1;
            int player1 = input(sc,"Player1");
            RPS("Monitor","Player1",moniter,player1);
            r++;
        }
        System.out.println("Monitor : Player1 scores = "+score1+" : "+score2);
    }
    static void TwoPlayer(Scanner sc)
    {
        System.out.println("\n --- --- --- --- --- --- --- --- --- ---- ---\n");
        System.out.println("Two Players Game Starts ");
        System.out.println("Enter How many rounds :");
        int rounds = sc.nextInt();

        score1 = 0;
        score2 = 0;
        int r=0;

        while(r<rounds){
            int player1 = input(sc,"Player1");
            int player2 = input(sc,"Player2");
            RPS("Player1","Player2",player1,player2);
            r++;
        }
        System.out.println("Player1 : Player2 scores = "+score1+" : "+score2);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean stop = true;
        do
        {
            System.out.println("The Game Starts :");
            System.out.println("1. One Palyer");
            System.out.println("2. Two Players");
            System.out.println("3. Exit");

            System.out.print("Enter the option (1,2,3) :");
            int option = sc.nextInt();
            switch(option)
            {
                case 1:
                    OnePlayer(rand,sc);
                    break;
                case 2:
                    TwoPlayer(sc);
                    break;
                case 3:
                    stop = false;
                    break;
                default :
                    System.out.println("Enter the valid Number.");
                    break;
            }
        }while(stop);
        sc.close();
    }
}
