
import com.mycompany.testassignment4.ATM;
import com.mycompany.testassignment4.Customer;
import java.util.Arrays;
import java.util.stream.Stream;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AllTests {

    ATM atm;
    Customer bob;
    Customer david;

    @BeforeAll
    void setUpScenarios() {
        atm = new ATM();
        bob = new Customer("Bob");
        bob.setCoupon(true);
        bob.purchaseCreditcard();
        atm.deposit(500, bob.getAccount());

        david = new Customer("David");
        david.purchaseCreditcard();
    }

    @Test
    void test1() {
        assertThat(5, is(bob.getAccount().getMonthlyInterest())); //we expect 5% interest rate from 500 balance
        atm.withdraw(500, bob.getAccount()); //bob withdraws 500...
        assertThat(3, is(bob.getAccount().getMonthlyInterest())); //0 should be 3%
        assertThat(15, is(bob.getCreditCard().getDiscount())); //we expect 15 in discount from newly created account
        bob.purchaseCreditcard(); //bob buys a new credit card... he has a coupon
        assertThat(20, is(bob.getCreditCard().getDiscount())); //it is NOT 15 + 20 because the account is not new, it is 20.
        //however... if bob has loyalty card
        bob.getCreditCard().setLoyaltyCard(true);
        bob.purchaseCreditcard();
        assertThat(30, is(bob.getCreditCard().getDiscount())); //then we add 10 to 20...
    }

    @Test
    @RepeatedTest(3)
    void test2(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        if (testInfo.getDisplayName().contains("repetition 1 of 3")) {
            assertThat(30, is(bob.getCreditCard().getDiscount()));
        }
        if (testInfo.getDisplayName().contains("repetition 2 of 3")) {
            assertThat(15, is(david.getCreditCard().getDiscount()));
            david.getCreditCard().setLoyaltyCard(true);
            david.purchaseCreditcard();
        }
        if (testInfo.getDisplayName().contains("repetition 3 of 3")) {
            assertThat(10, is(david.getCreditCard().getDiscount())); //goes from 15 to 10 because david is not a new user anymore...
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {30, 10}) // six numbers
    void test3(int number) {
        if (number == 30) {
            assertThat(number, is(bob.getCreditCard().getDiscount()));
        }
        if (number == 10) {
            assertThat(number, is(david.getCreditCard().getDiscount()));
        }
    }

    //A DynamicTest is a test generated during runtime.
    //it ignores beforeEach and afterEach...
    @TestFactory
    Iterable<DynamicTest> test4() {
        return Arrays.asList(
                DynamicTest.dynamicTest("Add test",
                        () -> assertThat(1, is(1))),
                DynamicTest.dynamicTest("Multiply Test",
                        () -> assertThat(1, is(1))));
    }

    @AfterEach
    public void doAfter(TestInfo info) {
        System.out.println(info.getDisplayName());
    }

    @ParameterizedTest
    @CsvSource({"number1,30", "number2,10"})
    void test5(String input, String expected) {
        int number = Integer.parseInt(expected);
        if (number == 30) {
            assertThat(number, is(bob.getCreditCard().getDiscount()));
        }
        if (number == 10) {
            assertThat(number, is(david.getCreditCard().getDiscount()));
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1) //is located in resources folder.
    void test6(String input, String expected) {
        int number = Integer.parseInt(expected);
        if (number == 30) {
            assertThat(number, is(bob.getCreditCard().getDiscount()));
        }
        if (number == 10) {
            assertThat(number, is(david.getCreditCard().getDiscount()));
        }

    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of("Bob",30),
                Arguments.of("David",10)
        );
    }

    public int isDiscount(String customerName) {
        if (customerName.matches(bob.getName())) {
            System.out.println("are we in here");
            return bob.getCreditCard().getDiscount();
        }
        if (customerName.matches(david.getName())) {
            return david.getCreditCard().getDiscount();
        } return 0;
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void test7(String input, int expected) {
        int discount = isDiscount(input);
        System.out.println("discount is... " + discount);
        assertThat(expected, is(discount));
    }

}
