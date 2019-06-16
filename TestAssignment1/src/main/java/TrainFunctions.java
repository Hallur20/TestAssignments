import java.time.LocalTime;

public class TrainFunctions {


    public String takeTrain(LocalTime time){
        if(time.isBefore(LocalTime.of(9,30)) ||
                (time.isAfter(LocalTime.of(16,0)) && time.isBefore(LocalTime.of(19,30,01)))){
            return "pay full fare";
        }
        if((time.isAfter(LocalTime.of(9,29,59)) && time.isBefore(LocalTime.of(16,00,01)))
        || time.isAfter(LocalTime.of(19,30))){
            return "saver ticket available";
        }
        return "nothing";
    }
}
