import java.util.Scanner;
import java.util.Arrays;

public class removeDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[j]!=arr[i]){
                i++;
                arr[i]=arr[j];
            }
        }
        // System.out.println(i+1);

        for(int x=0;x<=i;x++){
            System.out.print(arr[x]+" ");
        }

        sc.close();
    }
}