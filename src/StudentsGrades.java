import java.util.Scanner;

public class StudentsGrades {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of subjects:");
        int numSub= sc.nextInt();
        int[] marks = new int[numSub];
        for(int i=0;i<numSub;i++){
            System.out.println("Enter marks obtained in "+(i+1) +" Subjects out of 100:");
            marks[i ]=sc.nextInt();
        }
        double totalMarks=0;
        for(int i=1;i<numSub;i++){
            totalMarks += marks[i];
        }
        double  avgPercent =totalMarks /numSub;
        char grade;
        if(avgPercent>=95) {
            grade = 'A';
        }else if(avgPercent>=75){
            grade='B';
        }else if(avgPercent>=65){
            grade ='C';
        }else if(avgPercent>=35){
            grade='D';
        }else{
            grade='f';
        }
        System.out.println("Total marks:"+ totalMarks);
        System.out.println("Average percentage:"+ avgPercent+"%");
        System.out.println("Grade:"+grade);

    }
}
