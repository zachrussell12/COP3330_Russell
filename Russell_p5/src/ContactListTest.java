import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {

    @Test
    void addingItemsIncreasesSize(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("John", "Doe", "813-231-1564", "johnd@gmail.com");
        list.add(newItem);
        assertEquals(1, list.size());
    }

    @Test
    void editingItemsFailsWithAllBlankValues(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("John", "Doe", "813-231-1564", "johnd@gmail.com");
        list.add(newItem);
        assertThrows(IllegalArgumentException.class, ()-> list.set(new ContactItem("", "", "", ""), 0));
    }

    @Test
    void editingItemsFailsWithInvalidIndex(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("John", "Doe", "813-231-1564", "johnd@gmail.com");
        list.add(newItem);
        ContactItem editItem = new ContactItem("John", "Dip", "813-231-1564", "johnd@gmail.com");
        assertThrows(IndexOutOfBoundsException.class, ()-> list.set(editItem, 4));
    }

    @Test
    void editingSucceedsWithBlankFirstName(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("John", "Doe", "813-231-1564", "johnd@gmail.com");
        list.add(newItem);
        ContactItem editItem = new ContactItem("", "Dip", "813-231-1564", "johnd@gmail.com");
        list.set(editItem, 0);
        assertEquals("", list.get(0).getFirstName());
    }

    @Test
    void editingSucceedsWithBlankLastName(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("John", "Doe", "813-231-1564", "johnd@gmail.com");
        list.add(newItem);
        ContactItem editItem = new ContactItem("John", "", "813-231-1564", "johnd@gmail.com");
        list.set(editItem, 0);
        assertEquals("", list.get(0).getLastName());
    }

    @Test
    void editingSucceedsWithBlankPhone(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("John", "Doe", "813-231-1564", "johnd@gmail.com");
        list.add(newItem);
        ContactItem editItem = new ContactItem("John", "Dip", "", "johnd@gmail.com");
        list.set(editItem, 0);
        assertEquals("", list.get(0).getPhoneNumber());
    }

    @Test
    void editingSucceedsWithNonBlankValues(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("John", "Doe", "813-231-1564", "johnd@gmail.com");
        list.add(newItem);
        ContactItem editItem = new ContactItem("John", "Dip", "823-123-8321", "johnd@gmail.com");
        list.set(editItem, 0);
        assertEquals("Name: John Dip\n" + "Phone: 823-123-8321\n" + "Email: johnd@gmail.com", list.get(0).toString());
    }

    @Test
    void newListIsEmpty(){
        ContactList list = new ContactList();
        assertEquals(0,list.size());
    }

    @Test
    void removingItemsDecreasesSize(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("John", "Doe", "813-231-1564", "johnd@gmail.com");
        list.add(newItem);
        ContactItem editItem = new ContactItem("John", "Dip", "823-123-8321", "johnd@gmail.com");
        list.add(editItem);
        list.remove(1);
        assertEquals(1, list.size());
    }

    @Test
    void removingItemsFailsWithInvalidIndex(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("John", "Doe", "813-231-1564", "johnd@gmail.com");
        list.add(newItem);
        ContactItem editItem = new ContactItem("John", "Dip", "823-123-8321", "johnd@gmail.com");
        list.add(editItem);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.remove(4));
    }

    @Test
    void savedContactListCanBeLoaded(){
        ContactList list = new ContactList();
        list.loadFile("testContactList.txt");
        assertEquals("0) Name: John Doe\n" + "Phone: 213-456-1908\n" + "Email: johnd@gmail.com\n" + "1) Name: Davey Doe\n" + "Phone: 312-678-1098\n" + "Email: daveyd@gmail.com\n", list.view());
    }

    @Test
    void viewFunctionTest(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("John", "Doe", "813-231-1564", "johnd@gmail.com");
        ContactItem newItem2 = new ContactItem("John", "Dip", "813-231-1322", "johndip@gmail.com");
        list.add(newItem);
        list.add(newItem2);
        assertEquals("0) Name: John Doe\n" + "Phone: 813-231-1564\n" + "Email: johnd@gmail.com\n" + "1) Name: John Dip\n" + "Phone: 813-231-1322\n" + "Email: johndip@gmail.com\n", list.view());
    }

    @Test
    void viewPrintsNoItemsinListWhenEmptyList(){
        ContactList list = new ContactList();
        assertEquals("No contacts have been added yet.", list.view());
    }
}
