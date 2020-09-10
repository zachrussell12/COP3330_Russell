public class Decrypter {
    public static String decrypt(String code){
        int ddigitOne, ddigitTwo, ddigitThree, ddigitFour;


        ddigitOne = Character.getNumericValue(code.charAt(0));
        ddigitTwo = Character.getNumericValue(code.charAt(1));
        ddigitThree = Character.getNumericValue(code.charAt(2));
        ddigitFour = Character.getNumericValue(code.charAt(3));

        ddigitOne = modChecker(ddigitOne);
        ddigitTwo = modChecker(ddigitTwo);
        ddigitThree = modChecker(ddigitThree);
        ddigitFour = modChecker(ddigitFour);

        String newCode = dSwap(ddigitOne,ddigitTwo,ddigitThree,ddigitFour);

        System.out.printf("\nDecrypted Code: %s\n\n", newCode);

        return newCode;
    }

    public static int modChecker(int check){
        if(check == 7 || check == 8 || check == 9){
            check = check - 7;
        }
        else if(check == 0){
            check = 10 - 7;
        }
        else if(check == 1)
        {
            check = 11 - 7;
        }
        else if(check == 2)
        {
            check = 12 - 7;
        }
        else if(check == 3)
        {
            check = 13 - 7;
        }
        else if(check == 4)
        {
            check = 14 - 7;
        }
        else if(check == 5)
        {
            check = 15 - 7;
        }
        else if(check == 6)
        {
            check = 16 - 7;
        }

        return check;
    }

    public static String dSwap(int one, int two, int three, int four){
        int temp, temp2;

        temp = one;
        one = three;
        three = temp;
        temp2 = two;
        two = four;
        four = temp2;

        return String.valueOf(one) + String.valueOf(two) + String.valueOf(three) + String.valueOf(four);
    }
}
