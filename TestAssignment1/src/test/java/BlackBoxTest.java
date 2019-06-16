
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.time.LocalTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(JUnitPlatform.class)
public class BlackBoxTest {
    TrainFunctions trainFunctions = new TrainFunctions();

    @Test
    public void BeforeNineThirty(){
        LocalTime t = LocalTime.of(9,20);
        assertThat("pay full fare", equalTo(trainFunctions.takeTrain(t)));
    }
    @Test
    public void AfterFourPm(){
        LocalTime t = LocalTime.of(16,05);
        assertThat("pay full fare", equalTo(trainFunctions.takeTrain(t)));
    }
    @Test
    public void exactlySevenThirty(){
        LocalTime t = LocalTime.of(19,30);
        assertThat("pay full fare", equalTo(trainFunctions.takeTrain(t)));
    }
    @Test
    public void nineThirtyAm(){
        LocalTime t = LocalTime.of(9,30);
        assertThat("saver ticket available", equalTo(trainFunctions.takeTrain(t)));
    }
    @Test
    public void fourPm(){
        LocalTime t = LocalTime.of(16,00);
        assertThat("saver ticket available", equalTo(trainFunctions.takeTrain(t)));
    }
    @Test
    public void afterSevenThirtyPm(){
        LocalTime t = LocalTime.of(19,45);
        assertThat("saver ticket available", equalTo(trainFunctions.takeTrain(t)));
    }


    /*
    does test case design help identify any weakness in the scenario description? comment on that

    * gives us the steps which we execute in a system, the input data values which we enter in the system along with the
    *  expected results when we execute a particular test case. Test cases bring together the whole testing process.
    *

    when it comes to the scenario description, then yes, without them there would be no ensurance of that i would have remembered every
    term that a train ticket has during rush/non rush hours.

    */
}
