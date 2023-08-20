import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter number of processes");
        Scanner sc=new Scanner(System.in);
        int process=sc.nextInt();

        int pid[]=new int[process];
        int at[]=new int[process];
        int bt[]=new int[process];
        int wt[]=new int[process];
        int ct[]=new int[process];
        int tt[]=new int[process];
        for(int i=0;i<process;i++){
            System.out.println("Enter process arrival time for "+(i+1)+":");
            at[i]=sc.nextInt();
            System.out.println("Enter process burst time for "+(i+1)+":");
            bt[i]=sc.nextInt();
            pid[i]=i+1;
        }
        int temp;
        for(int i=0;i<process;i++){
            for(int j=i+1;j<process;j++){
                if(bt[i]>bt[j]){
                    temp=bt[i];
                    bt[i]=bt[j];
                    bt[j]=temp;
                    temp=at[i];
                    at[i]=at[j];
                    at[j]=temp;
                    temp=pid[i];
                    pid[i]=pid[j];
                    pid[j]=temp;
                }
            }
        }
        ct[0]=bt[0]-at[0];
        for(int i=1;i<process;i++){
            ct[i]=ct[i-1]+bt[i];
        }
        for(int i=0;i<process;i++){
            tt[i]=ct[i]-at[i];
            wt[i]=tt[i]-bt[i];
            if(wt[i]<0){
                wt[i]=0;
            }
        }
        System.out.println("Process.....Arrival.....Burst.....Completion.....Turn Around....Waiting");
        for(int i=0;i<process;i++){
            System.out.println(pid[i]+"....."+at[i]+"....."+bt[i]+"....."+ct[i]+"....."+tt[i]+"....."+wt[i]);
        }
        System.out.println("Gantt Chart");
        System.out.println(Arrays.toString(pid));
    }
}