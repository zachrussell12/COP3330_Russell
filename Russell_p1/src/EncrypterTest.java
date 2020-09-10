import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncrypterTest {

    @Test
    void testEncrypt1234to0189() {
        Encrypter e = new Encrypter();
        assertEquals("0189", e.encrypt("1234"));
    }

}