public class Methods {

    //mvn checkstyle:checkstyle TO GENERATE CHECKSTYLE REPORT
    public double calculateYearlyIntereset(Account account){

        int balance = account.getBalance();
        if (balance >= 0) {
            if (balance <= 100) {
                return balance*0.03;
            }
            if (balance > 100 && balance <= 1000) {
                return balance*0.05;
            }
            if (balance > 1000) {
                return balance*0.07;
            }
        }

        return 0.0;
    }
}