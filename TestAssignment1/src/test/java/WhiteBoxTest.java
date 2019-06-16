import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JUnitPlatform.class)
public class WhiteBoxTest {
    private PeterSestoft p = new PeterSestoft();

    @Test
    void testWithNumbers() {
        MinMaxPair mmp = p.minMax(new String[]{"1","2","-4", "100","50","40"});
        assertThat(-4, equalTo(mmp.getMin()));
        assertThat(100, equalTo(mmp.getMax()));

    }

    @Test
    void testWithWrongInputs() {
        final MinMaxPair[] mmp = {null};
        assertThrows(NumberFormatException.class, () -> {
            mmp[0] = p.minMax(new String[]{"1","2","-4", "100","@","40"});
        });
        assertThrows(NumberFormatException.class, () -> {
            mmp[1] = p.minMax(new String[]{"a whole string!"});
        });
    }
}