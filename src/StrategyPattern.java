import objects.Comparator;
import objects.Number;
import java.util.Random;

class StrategyPattern {
    public static class BubbleSorter<T> {
        private Comparator<T> comparator;

        BubbleSorter(Comparator<T> comparator) {
            this.comparator = comparator;
        }

        void sort(T[] arr) {
            for (int j=0; j < arr.length - 1; j++) {
                for(int i = 0; i < arr.length - 1; i++) {
                    if (comparator.comparing(arr[i], arr[i+1]) > 0) {
                        T tmp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = tmp;
                    }
                }
            }
        }
    }
    static void test() {
        Random r = new Random();
        Number[] array = new Number[15];
        for(int i=0;i<15;i++) {
            array[i] = new Number(r.nextInt(100));
            System.out.print(array[i].value + ",");
        }
        System.out.println();
        new BubbleSorter<Number>((left, right) -> left.value - right.value).sort(array);
        for (Number number : array) {
            System.out.print(number.value+",");
        }
        System.out.println();
    }
}
