// traversal of 1d array

// public class arr1 {
//     public static void main(String[] args) {
//         int arr[] = new int[5];
//         for(int i=0;i<5;i++){
//             arr[i]=i+1;
//         }
//         for(int i=0;i<5;i++){
//             System.out.println(arr[i]);
//         }
//     }
    
// }
// traversal of 1d array using for each loop
// public class arr1 {
//     public static void main(String[] args) {
//         int arr[] = new int[5];
//         for(int i=0;i<5;i++){   
//             arr[i]=i+1;
//         }
//         for(int i:arr){
//             System.out.println(i);
//         }
//     }   
// }

public class arr1{
    public static void main(String[] args) {
        int arr[]=new int[5];
        for(int i=0;i<5;i++){
            arr[i]=i+1;
        }
        for(int i:arr){
            System.out.println(i);
        }
    }
}

