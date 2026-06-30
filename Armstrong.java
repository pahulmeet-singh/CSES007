public class Armstrong {
    public static void main(String[] args) {
        int number = 153; // Example number
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }

    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        int digits = String.valueOf(num).length();

        while (num > 0) {
            int digit = num % 10; // get the last digit
            sum += Math.pow(digit, digits); // add the digit raised to the power of the number of digits
            num /= 10;
        }

        return sum == originalNum;
    }
}
// 2,90,62,026
// https://docs.google.com/document/d/1zMBAQkaVJjgdSJ-AjlNM_IVmokbgHDzwXHZDKCKJQKM
//i am a day scholar. if i wish to commute to the uni on my bicycle. can i park it in the 34 block parking. or do i need to file for a rfid sticker/pass for a bicycle as well? what are the charges for that