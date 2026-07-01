public class secondmax {
    public static void main(String[] args) {
        int arr[]={6,6,6,6,6,6};
        int max=Integer.MIN_VALUE;
        int secondmax=Integer.MIN_VALUE;
        for(int num:arr){
            if(num>max){
                secondmax=max;
                max=num;
            }
            else if(num>secondmax && num!=max){// the real reason this line is used is to find the second max in an array. we are checking if the current element is greater than secondmax and not equal to max because if it is equal to max then it cannot be secondmax. but when we use this condition then it will not work for the case when the array contains all the same elements because in that case secondmax will remain Integer.MIN_VALUE and it will not be updated. so we need to remove this condition and just check if the current element is greater than secondmax then update secondmax with that element. 
              // this condition is used to check if the current element is greater than secondmax and not equal to max,
            //  because if it is equal to max then it cannot be secondmax. when we use this condition then it will not work for the case when the array contains all the same elements because in that case secondmax will remain Integer.MIN_VALUE and it will not be updated. so we need to remove this condition and just check if the current element is greater than secondmax then update secondmax with that element.
                secondmax=num;
            }
        }
        System.out.println(secondmax);
    }
}//single pass solution to find second max in an array.