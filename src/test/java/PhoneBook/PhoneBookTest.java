package PhoneBook;
import com.phonebook.PhoneBookEntriesImply;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.Optional;

//import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;


public class PhoneBookTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookEntriesImply phoneBook_Test = new PhoneBookEntriesImply();

    @Test
    public void findPhoneNumberByName() {
        Optional<String> phoneNumber = phoneBook_Test.findPhoneNumberByName("Lakshay");


       assertThat(phoneNumber.get()).isEqualTo("9780878889");
    }
    @Test
    public void findPhoneNumberByName_NotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBook_Test.findPhoneNumberByName("Vishal");
        phoneNumber.get();
    }
    @Test
    public void findNameByPhoneNumber(){
        Optional<String> name=phoneBook_Test.findNameByPhoneNumber("9888098880");
        assertThat(name.get()).isEqualTo("Ankit");
    }
    @Test
    public void findNameByPhoneNumber_NotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBook_Test.findNameByPhoneNumber("1234500000");
        phoneNumber.get();
    }
}
