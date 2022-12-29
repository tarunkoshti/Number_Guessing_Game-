import java.util.Scanner;

public class ngg {
     Scanner sc = new Scanner(System.in);
     int score =0;
     int randomno;
     int round =0;
     int highScore =0;
     int copyhighScore =0;
     int losecount =0;

    // start method definition
    public  void start()
        {
//          number of trials
            int n = 5;

//          Create a random number
            randomno = (int) (Math.random()*100+1);

          System.out.println(randomno);

            System.out.println("\nRound "+ (round+1)+ " start...");
            System.out.println("you have 5 tries to guess the number.");

            int tryCount =0;
            while (n > 0) {
                 tryCount++;
                System.out.println("Enter your guessing number:");
                int userno = sc.nextInt();
                if (userno < 0 || userno > 100) {
                    System.out.println("Invalid Input");
                }  else if (userno == randomno) {
                    System.out.println("Your Guessing number is correct.");
                    System.out.println("You Win!");
                    // if trycount is 1 then your score will 50  .....
                    // if trycount is 5 then your score will 10  .....
                    score = score+(n*10);
                    highScore = score;
                    System.out.println("\nTry:"+tryCount+"\nScore:"+ score);
                    break;
                } else if (userno+1==randomno || userno-1==randomno){
                    System.out.println("Your guessing is too close");
                    if (n-1!=0)
                        System.out.println(n-1  + " tries left.");
                } else if (userno > randomno) {
                    System.out.println("Your Guessing number is too high.");
                    if (n-1!=0)
                    System.out.println(n-1 + " tries left.");
                } else if (userno < randomno) {
                    System.out.println("Your Guessing is too low");
                    if (n-1!=0)
                    System.out.println(n-1  + " tries left.");
                }
                n--;
            }

            // if trials end new game begin
            if (n == 0) {
                System.out.println("Guessing limit exceeded.");
                System.out.println("You Lose!!\n");
                round =0;
                if (losecount==0) {
                    copyhighScore = score;
                }
                score=0;
                losecount++;
                System.out.println("\nWould you like to play again:\n 1.Yes\n 2.No");
                int c = sc.nextInt();
                if (c==1)
                    choice();
                else
                    System.exit(0);
            }

            if (n!=0)
            {
            round++;
            }
        }

//  choice method definition
    public  void choice(){

        int choice;
        do
        {
            System.out.println("Choose an option");
            System.out.println("1.Start Game");
            System.out.println("2.Score Board");
            System.out.println("3.Quit");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> start();
                case 2 -> scoreBoard();
                case 3 -> {
                    System.out.println("Thank you for playing the game");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid Input");
                    System.out.println("Please choose right option");
                }
            }
        }
        while (choice!=1);

    }
//  nextRound method definition
    public  void nextRound(){

        int choice1;
        do{
            System.out.println("Choose an option");
            System.out.println("1.Next Round");
            System.out.println("2.Score Board");
            System.out.println("3.Quit");

            choice1 = sc.nextInt();
            switch (choice1) {
                case 1 -> start();
                case 2 -> scoreBoard();
                case 3 -> {
                    System.out.println("Thank you for playing the game");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid Input");
                    System.out.println("Please choose right option");
                }
            }
        }
        while (choice1 == 1 || choice1 == 2 || choice1 >3);

    }

    // ScoreBoard method definition
    public  void scoreBoard()
    {
        if (copyhighScore>highScore)
            System.out.println("High Score:"+copyhighScore);
        else
        {
            copyhighScore = highScore;
            System.out.println("High Score:"+copyhighScore);
        }
    }

    public static void main(String[] args) {

        // random number between 1 to 100
        System.out.println("...............WELCOME TO THE NUMBER GUESSING GAME...............");
        // choice method call
        ngg n = new ngg();
        n.choice();
        // nextRound method call
        n.nextRound();
    }
}
