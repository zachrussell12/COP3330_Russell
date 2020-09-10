public class Encrypter{

    public static String encrypt(String code){
        String nums = code;
        String newCode = "";
        int digitOne, digitTwo, digitThree, digitFour;

        digitOne = Character.getNumericValue(nums.charAt(0));
        digitTwo = Character.getNumericValue(nums.charAt(1));
        digitThree = Character.getNumericValue(nums.charAt(2));
        digitFour = Character.getNumericValue(nums.charAt(3));

        digitOne = (digitOne + 7)%10;
        digitTwo = (digitTwo + 7)%10;
        digitThree = (digitThree + 7)%10;
        digitFour = (digitFour + 7)%10;

        newCode = swap(digitOne, digitTwo, digitThree, digitFour);

        System.out.printf("Encrypted Code: %s", newCode);

        return newCode;
    }

    public static String swap(int one, int two, int three, int four){
        int temp, tempTwo;
        String numbers = "";

        temp = one;
        one = three;
        three = temp;
        tempTwo = two;
        two = four;
        four = tempTwo;

        numbers = String.valueOf(one) + String.valueOf(two) + String.valueOf(three) + String.valueOf(four);

        return numbers;
    }
}
