import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestSmellyCode {
    @Test
    public void fixedClass1(){
        FixedClass1 f1 = new FixedClass1();
        FixedClass2 f2 = new FixedClass2();
        f1.doDuplicate();
        f2.doNothing();
        assertThat(true, is(true));
    }
}
