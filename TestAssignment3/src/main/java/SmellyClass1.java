public class SmellyClass1 {
    public void doDuplicate(){
        int[] array_a = new int[4];
        int[] array_b = new int[4];

        int sum_a = 0;

        for (int i = 0; i < 4; i++)
            sum_a += array_a[i];

        int average_a = sum_a / 4;

        int sum_b = 0;

        for (int i = 0; i < 4; i++)
            sum_b += array_b[i];

        int average_b = sum_b / 4;
    }
}
