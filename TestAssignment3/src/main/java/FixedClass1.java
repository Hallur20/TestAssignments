
public class FixedClass1 {

    private final int divider = 4;
    private final int arrSize = 4;

    /** {@inheritDoc} */
    public void doDuplicate() {
        int[] arrayA = new int[arrSize];
        int[] arrayB = new int[arrSize];

        int sumA = 0;

        for (int i = 0; i < divider; i++) {
            sumA += arrayA[i];
        }

        int averageA = sumA / divider;

        int sumB = 0;

        for (int i = 0; i < divider; i++) {
            sumB += arrayB[i];
        }

        int averageB = sumB / divider;
    }
}
