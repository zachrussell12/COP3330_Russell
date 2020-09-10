public class Application {
    public static void main(String [] args){


        Encrypter e = new Encrypter();
        e.encrypt("1234");

        Decrypter d = new Decrypter();
        d.decrypt("0189");

        //Scanner input = new Scanner(System.in);
        //Scanner input2 = new Scanner(System.in);
        //String code = "";
        //String encryptedCode = "";
        //String decryptedCode = "";
        //String choice = "";

        /*while(!choice.equals("X")) {
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

        }*/

    }
}
