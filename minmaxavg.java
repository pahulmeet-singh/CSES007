public class minmaxavg {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i:arr){
            if(i<min){
                min=i;
            }
            if(i>max){
                max=i;
            }
            sum+=i;
        }
        System.out.println("min: "+min);
        System.out.println("max: "+max);    
        System.out.println("avg: "+sum/arr.length);
    }
}
//this logic is wrong because i have initialized min and max with 0 and if the array contains only positive numbers then min will always be 0 and if the array contains only negative numbers then max will always be 0. so we need to initialize min with Integer.MAX_VALUE and max with Integer.MIN_VALUE.
//the use of Integer.MAX_VALUE and Integer.MIN_VALUE is to ensure that any number in the array will be less than or equal to Integer.MAX_VALUE and greater than or equal to Integer.MIN_VALUE, so that we can correctly update min and max values.
//how does it work? when we initialize min with Integer.MAX_VALUE, it means that any number in the array will be less than or equal to Integer.MAX_VALUE, so when we compare each number in the array with min, if we find a number that is less than min, we update min with that number. similarly, when we initialize max with Integer.MIN_VALUE, it means that any number in the array will be greater than or equal to Integer.MIN_VALUE, so when we compare each number in the array with max, if we find a number that is greater than max, we update max with that number. this way we can correctly find the minimum and maximum values in the array.