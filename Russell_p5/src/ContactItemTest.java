import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    @Test
    void creationFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class, ()-> new ContactItem("","","",""));
    }

    @Test
    void creationSucceedsWithBlankEmail(){
        ContactItem newItem = new ContactItem("John", "Doe", "213-234-0932", "");
        assertEquals("Name: John Doe\n" + "Phone: 213-234-0932\n" + "Email: ", newItem.toString());
    }

    @Test
    void creationSucceedsWithBlankFirstName(){
        ContactItem newItem = new ContactItem("", "Doe", "213-234-0932", "jd@gmail.com");
        assertEquals("Name:  Doe\n" + "Phone: 213-234-0932\n" + "Email: jd@gmail.com", newItem.toString());
    }

    @Test
    void creationSucceedsWithBlankLastName(){
        ContactItem newItem = new ContactItem("John", "", "213-234-0932", "jd@gmail.com");
        assertEquals("Name: John \n" + "Phone: 213-234-0932\n" + "Email: jd@gmail.com", newItem.toString());
    }

    @Test
    void creationSucceedsWithBlankPhone(){
        ContactItem newItem = new ContactItem("John", "Doe", "", "jd@gmail.com");
        assertEquals("Name: John Doe\n" + "Phone: \n" + "Email: jd@gmail.com", newItem.toString());
    }

    @Test
    void creationSucceedsWithNonBlankValues(){
        ContactItem newItem = new ContactItem("John", "Doe", "213-234-0932", "jd@gmail.com");
        assertEquals("Name: John Doe\n" + "Phone: 213-234-0932\n" + "Email: jd@gmail.com", newItem.toString());
    }

    @Test
    void editingFailsWithAllBlankValues(){
        ContactItem newItem = new ContactItem("", "", "", "jd@gmail.com");
        assertThrows(IllegalArgumentException.class, ()-> newItem.setEmailAddress(""));
    }

    @Test
    void editingSucceedsWithBlankEmail(){
        ContactItem newItem = new ContactItem("Doe", "Doe", "213-234-0932", "jd@gmail.com");
        newItem.setEmailAddress("");
        assertEquals("", newItem.getEmailAddress());
    }

    @Test
    void editingSucceedsWithBlankFirstName(){
        ContactItem newItem = new ContactItem("Doe", "Doe", "213-234-0932", "jd@gmail.com");
        newItem.setFirstName("");
        assertEquals("", newItem.getFirstName());
    }

    @Test
    void editingSucceedsWithBlankLastName(){
        ContactItem newItem = new ContactItem("Doe", "Doe", "213-234-0932", "jd@gmail.com");
        newItem.setLastName("");
        assertEquals("", newItem.getLastName());
    }

    @Test
    void editingSucceedsWithBlankPhone(){
        ContactItem newItem = new ContactItem("Doe", "Doe", "213-234-0932", "jd@gmail.com");
        newItem.setPhoneNumber("");
        assertEquals("", newItem.getPhoneNumber());
    }

    @Test
    void editingSucceedsWithNonBlankValues(){
        ContactItem newItem = new ContactItem("Doe", "Doe", "213-234-0932", "jd@gmail.com");
        newItem.setPhoneNumber("Joe");
        assertEquals("Joe", newItem.getPhoneNumber());
    }

    @Test
    void testToString(){
        ContactItem newItem = new ContactItem("Doe", "Doe", "213-234-0932", "jd@gmail.com");
        assertEquals("Name: Doe Doe\n" + "Phone: 213-234-0932\n" + "Email: jd@gmail.com", newItem.toString());
    }

    @Test
    void testToStringFile(){
        ContactItem newItem = new ContactItem("Doe", "Doe", "213-234-0932", "jd@gmail.com");
        assertEquals("Doe\n" + "Doe\n" + "213-234-0932\n" + "jd@gmail.com", newItem.toStringFile());
    }

    @Test
    void nameCheckerReturnsAppropriateFalse(){
        ContactItem newItem = new ContactItem("A", "S", "123-123-1234", "F@gmail.com");
        boolean check = newItem.nameChecker("","","","");
        assertFalse(check);
    }

    @Test
    void nameCheckerReturnsAppropriateTrue(){
        ContactItem newItem = new ContactItem("A", "S", "123-123-1244", "F@gmail.com");
        assertTrue(newItem.nameChecker("A","S","213-123-2341","F@gmail.com"));
    }

    @Test
    void nameCheckerReturnsAppropriateFalseWithBadPhoneNumberFormat(){
        ContactItem newItem = new ContactItem("A", "S", "123-123-1234", "F@gmail.com");
        assertFalse(newItem.nameChecker("A","S","812-3321-2134","F@gmail.com"));
    }

    @Test
    void nameCheckerReturnsAppropriateFalseWithBadEmail(){
        ContactItem newItem = new ContactItem("A", "S", "123-123-1234", "F@gmail.com");
        assertFalse(newItem.nameChecker("A","S","812-331-2213","Fgmail.com"));
    }

    @Test
    void nameCheckerReturnsAppropriateFalseWithLettersInPhoneNumber(){
        ContactItem newItem = new ContactItem("A", "S", "123-123-1234", "F@gmail.com");
        assertFalse(newItem.nameChecker("A","S","812-331-wq13","F@gmail.com"));
    }
}
