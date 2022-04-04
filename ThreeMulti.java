public class ThreeMulti {
    // doesn't need constructor right?
    public void test(double[] array, int amountOfRows) {
        int i;
        for (i = 0; i < amountOfRows; i++) {
            array[i] *= 3;
        }
    }
}
