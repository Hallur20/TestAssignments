public class PeterSestoft {

    public MinMaxPair minMax(String[] numbers) {
        int mi, ma;
        MinMaxPair pairs;
        if (numbers.length == 0)                               /* 1 */ System.out.println("No numbers");
        else {
            mi = ma = Integer.parseInt(numbers[0]);
            for (int i = 1; i < numbers.length; i++)           /* 2 */ {
                int obs = Integer.parseInt(numbers[i]);
                if (obs > ma) ma = obs;                     /* 3 */
                else if (obs < mi) mi = obs;              /* 4 */
            }
            System.out.println("Minimum = " + mi + "; maximum = " + ma);
            pairs = new MinMaxPair(mi, ma);
            return pairs;
        } return null;
    }
}
