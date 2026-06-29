public class secondmax {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        int max=Integer.MIN_VALUE;
        int secondmax=Integer.MIN_VALUE;
        for(int i:arr){
            if(i>max){
                secondmax=max;
                max=i;
            }
            else if(i>secondmax && i!=max){// this condition is used to check if the current element is greater than secondmax and not equal to max, because if it is equal to max then it cannot be secondmax. when we use this condition then it will not work for the case when the array contains all the same elements because in that case secondmax will remain Integer.MIN_VALUE and it will not be updated. so we need to remove this condition and just check if the current element is greater than secondmax then update secondmax with that element.
                secondmax=i;
            }
        }
        System.out.println(secondmax);
    }
}