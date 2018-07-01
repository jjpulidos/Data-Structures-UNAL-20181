import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class MaxHeapTest {

    @Test
    public void buildHeap() {
        int[] array = new int[11];
        for (int i = 1; i < array.length; i++) {
            array[i] = i;
        }

        new MaxHeap().buildHeap(array);

        int[] expected = {0, 10, 9, 7, 8, 5, 6, 3, 1, 4, 2};
        Assert.assertArrayEquals(expected, array);
    }

    @Test
    public void insert() {
        MaxHeap heap = new MaxHeap();
        for (int i = 1; i <= 15; i++) {
            heap.insert(i);
        }

        int[] expected = {0, 15, 10, 14, 7, 9, 11, 13, 1, 4, 3, 8, 2, 6, 5, 12};
        Assert.assertArrayEquals(expected, heap.getArray());
    }

    @Test
    public void extractMax() {
        MaxHeap heap = new MaxHeap();
        for (int i = 1; i <= 1000; i++) {
            heap.insert(i);
        }

        for (int i = 1000; i >= 1; i--) {
            Assert.assertEquals(i, heap.extractMax());
        }
    }

    @Test
    public void heapSort() {
        int[] array = new int[1001];
        int[] expected = new int[1001];
        for (int i = 1; i < array.length; i++) {
            array[i] = i;
            expected[i] = i;
        }

        shuffleArray(array);
        new MaxHeap().sort(array);

        Assert.assertArrayEquals(expected, array);
    }

    public static void shuffleArray(int[] a) {
        Random random = new Random();
        random.nextInt();
        for (int i = 1; i < a.length; i++) {
            int change = i + random.nextInt(a.length - i);
            int helper = a[i];
            a[i] = a[change];
            a[change] = helper;
        }
    }

}
