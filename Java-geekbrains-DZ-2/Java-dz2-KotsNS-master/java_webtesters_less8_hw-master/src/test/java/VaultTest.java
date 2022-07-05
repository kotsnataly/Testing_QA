import controller.Vault;
import model.PersonalUserAccount;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class VaultTest {

    Vault vault = new Vault();

    PersonalUserAccount personalUserAccount1 = new PersonalUserAccount();
    PersonalUserAccount personalUserAccount2 = new PersonalUserAccount();
    PersonalUserAccount personalUserAccount3 = new PersonalUserAccount();
    PersonalUserAccount personalUserAccount4 = new PersonalUserAccount();

    User user1 = new User(1L, "Nata", personalUserAccount1);
    User user2 = new User(2L, "Erika", personalUserAccount2);
    User user3 = new User(3L, "Arina", personalUserAccount3);
    User user4 = new User(4L, "Vova", personalUserAccount4);

    VaultTest() throws IOException {
        personalUserAccount1.setTotalSum(250_000);
        personalUserAccount2.setTotalSum(250_000);
        personalUserAccount3.setTotalSum(250_000);
        personalUserAccount4.setTotalSum(250_000);
    }

    @Test
    void testTransaction1() throws IOException {
        Assertions.assertFalse(vault.makeTransaction(user1, user2, 1_500_000));
    }

    @Test
    void testTransaction2() throws IOException {
        Assertions.assertFalse(vault.makeTransaction(user2, user3, 500_000));
    }

    @Test
    void testTransaction3() throws IOException {
        Assertions.assertTrue(vault.makeTransaction(user1, user2, 100_000));
    }

    @Test
    void testHistoryList() throws IOException {
        vault.makeTransaction(user1, user2, 1_500_000);
        vault.makeTransaction(user1, user2, 1_500_000);
        vault.makeTransaction(user1, user2, 1_500_000);
        Assertions.assertTrue(3 == vault.getTransactionList().size());
    }

    @Test
    void printHistory() throws IOException {
        vault.makeTransaction(user1, user2, 1_500_000);
        vault.makeTransaction(user1, user2, 100_000);
        vault.makeTransaction(user1, user2, 750_000);
        Assertions.assertNotNull(vault.printHistory());
    }


}