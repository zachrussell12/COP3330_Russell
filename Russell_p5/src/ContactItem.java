public class ContactItem {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public ContactItem(String inputFirstName, String inputLastName, String inputPhoneNumber, String inputAddress) throws IllegalArgumentException {

        boolean contactChecker = nameChecker(inputFirstName, inputLastName, inputPhoneNumber, inputAddress);

        if(!contactChecker){
            System.out.println("Contact must contain at least one of the fields prompted.");
            throw new IllegalArgumentException();
        }

        this.firstName = inputFirstName;
        this.lastName = inputLastName;
        this.phoneNumber = inputPhoneNumber;
        this.emailAddress = inputAddress;
    }

    public boolean nameChecker(String one, String two, String three, String four){
        if(one.length() < 1 && two.length() < 1 && three.length() < 1 && four.length() < 1){
            return false;
        }
        else{
            return true;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if(this.phoneNumber.equals("") && this.lastName.equals("") && this.emailAddress.equals("")){
            System.out.println("This would mean all your fields will be blank.\nThat is not allowed. Nothing changed.");
            throw new IllegalArgumentException();
        }else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(this.firstName.equals("") && this.phoneNumber.equals("") && this.emailAddress.equals("")){
            System.out.println("This would mean all your fields will be blank.\nThat is not allowed. Nothing changed.");
            throw new IllegalArgumentException();
        }else {
            this.lastName = lastName;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        if(this.firstName.equals("") && this.lastName.equals("") && this.emailAddress.equals("")){
            System.out.println("This would mean all your fields will be blank.\nThat is not allowed. Nothing changed.");
            throw new IllegalArgumentException();
        }else {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getEmailAddress() throws IllegalArgumentException{return emailAddress;}

    public void setEmailAddress(String emailAddress) {
        if(this.firstName.equals("") && this.lastName.equals("") && this.phoneNumber.equals("")){
            System.out.println("This would mean all your fields will be blank.\nThat is not allowed. Nothing changed.");
            throw new IllegalArgumentException();
        }else {
            this.emailAddress = emailAddress;
        }
    }

    public String toStringFile(){return firstName + "\n" + lastName + "\n" + phoneNumber + "\n" + emailAddress;}

    @Override
    public String toString(){return "Name: " + firstName + " " + lastName + "\n" + "Phone: " + phoneNumber + "\n" + "Email: " + emailAddress;}
}
