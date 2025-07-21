import java.util.Random;
import java.util.Scanner;

public class number 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int maxT = 5, score = 0;
        boolean again = true;

        System.out.println("-----------Number Game--------- \nGuess between 1 and 100");
        System.out.println("You have " + maxT + " attempts each round.\n");

        while (again) 
        {
            int num = r.nextInt(100) + 1;
            int tryLeft = maxT;
            boolean win = false;

            while (tryLeft > 0) 
            {
                System.out.print("Guess: ");
                int g;

                if (sc.hasNextInt()) 
                {
                    g = sc.nextInt();
                } 
                else 
                {
                    System.out.println("Numbers only!");
                    sc.next(); continue;
                }

                tryLeft--;

                if (g == num) 
                {
                    System.out.println("Correct!");
                    score++;
                    win = true;
                    break;
                } 
                else if (g < num) 
                {
                    System.out.println("Too low");
                } 
                else 
                {
                    System.out.println("Too high");
                }

                System.out.println("Tries left: " + tryLeft);
            }

            if (!win) 
            {
                System.out.println("Out of tries! Number was: " + num);
            }

            System.out.print("\nPlay again? (yes/no): ");
            String ans = sc.next().toLowerCase();
            again = ans.equals("yes");
            System.out.println();
        }

        System.out.println("Total Score: " + score);
        System.out.println("Thanks for playing!");
        sc.close();
    }
}
