import java.util.Scanner;

public class Encrypter{
    public static void main(String [] args){

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String code = "";
        String encryptedCode = "";
        String decryptedCode = "";
        String choice = "";

        while(!choice.equals("X")) {
            System.out.println("Would you like to encrypt, decrypt, or exit? (Enter E, D, or X)");

            choice = input2.next();

            switch (choice) {
                case "E" -> {
                    System.out.println("\nEnter a string of 4 numbers: \n");
                    code = input.next();
                    encryptedCode = encrypt(code);
                    System.out.printf("\nHere is the encrypted code: %s \n\n", encryptedCode);
                }
                case "D" -> {
                    Decrypter dCode = new Decrypter();
                    System.out.println("\nEnter a string of 4 numbers: \n");
                    code = input.next();
                    decryptedCode = dCode.decrypt(code);

                    System.out.printf("\nHere is the decrypted code: %s \n\n", decryptedCode);

                }
                case "X" -> System.out.println("---------Goodbye---------");
                default -> System.out.println("\nInvalid choice please try your entry again\n");
            }

        }

    }
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
