import static java.time.Duration.ofMillis;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import org.junit.jupiter.api.Test;

public class TestAccount {

    //@Disabled
    @Tag("Hallur")
    @Test
    @DisplayName("Custom test name containing spaces")
        /*question5 ????*/
    void eightDifferentAssertions() throws InterruptedException {
        Methods m = new Methods();

        Account account1 = new Account(999);
        Account account2 = new Account(1001);
        Random r = new Random();
        assertTimeout(ofMillis(5000), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(4000);
            Object resultExample = m.calculateYearlyIntereset(account1);
            assertAll("7 more assertions inside",
                    () -> assertEquals(999 * 0.05, m.calculateYearlyIntereset(account1)),//interest in balance 999 should be 5%
                    () -> assertNotEquals(-0.5, m.calculateYearlyIntereset(account2)),//interest in balance 1001 should not be minus 5%
                    () -> assertNotNull(m.calculateYearlyIntereset(account1)),//method should not return null
                    () -> assertNotSame(account1, account2), //the two accounts are not identical
                    () -> assertSame(account1, account1), //the two accounts are identical
                    () -> assertTrue(resultExample.getClass().getTypeName().equals("java.lang.Double")), //the return type is double
                    () -> assertFalse(resultExample.getClass().getTypeName().equals("java.lang.Integer")) //the return type should not be integer
            );
            boolean randBoolean = r.nextBoolean();
            assertAll("7 more assertions inside",
                    () -> assertEquals(true, randBoolean),//interest in balance 999 should be 5%
                    () -> assertNotEquals(false, randBoolean),//interest in balance 1001 should not be minus 5%
                    () -> assertNotNull(randBoolean),//method should not return null
                    () -> assertNotSame(false, randBoolean), //the two accounts are not identical
                    () -> assertSame(true, randBoolean), //the two accounts are identical
                    () -> assertTrue(randBoolean), //the return type is double
                    () -> assertFalse(!randBoolean) //the return type should not be integer
            );
        }, "test had a timeout!");

    }
}
