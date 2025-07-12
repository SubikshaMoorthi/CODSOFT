import java.util.*;

public class Grade_Calc 
{
    public static int[] inputMarks(int n)
    {
        int[] marks=new int[n];
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<n;i++)
        {
            while (true) 
            { 
                System.out.print("Enter mark"+(i+1)+":");
                int mark = sc.nextInt();
                if(mark>=0 && mark<=100)
                {
                    marks[i]=mark;
                    break;
                }
                else
                {
                    System.out.println("Invalid Mark");
                }
            }
        }
        return marks;
    }

    public static String result(int[] marks)
    {
        for(int m:marks)
        {
            if(m<50)
            {
                return "FAIL";
            }
        }
        return "PASS";
    }
    
    public static int totalMarks(int[] marks)
    {
        int sum=0;
        for(int mark : marks)
        {
            sum+=mark;
        }
        return sum;
    }
    
    public static double calcAverage(int sum,int n)
    {
        return sum/n;
    }

    public static String grade(double avg)
    {
        if(avg>=95) return "O";
        else if(avg>=90) return "A+";
        else if(avg>=80) return "A";
        else if(avg>=70) return "B";
        else if(avg>=60) return "C";
        else if(avg>=50) return "D";
        else return "F";
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("---Students Grade Calculator---");
        System.out.print("Enter no of subjects:");
        int n= sc.nextInt();

        int marks[]=inputMarks(n);

        System.out.println("\n---Subject-wise Result---");
        for(int i=0;i<n;i++)
        {
            if(marks[i]>=50)
            {
                System.out.println("Subject "+(i+1)+": PASS ("+marks[i]+")");
            }
            else
            {
                System.out.println("Subject "+(i+1)+": FAIL ("+marks[i]+")");
            }
        }

        int total=totalMarks(marks);
        double avg=calcAverage(total,n);
        String res=result(marks);

        System.out.println("\n_______FINAL RESULT_______");
        System.out.println("Total Marks: "+total);
        System.out.printf("Total Percentage: %.2f\n",avg);
        System.out.println("Result: "+res);

        if(res.equals("PASS"))
        {
            String grade=grade(avg);
            System.out.println("Grade: "+grade);
        }
    }
}
