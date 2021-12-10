package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * This class tests all sorting algorithms.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // otherwise, some methods have to be static
public class SortingTest {
    private final Random random = new Random();
    private int[] mixedUnsorted;    // unsorted array of negative and positive random integers
    private int[] mixedSorted;
    private int[] positiveUnsorted; // unsorted array of positive random integers
    private int[] positiveSorted;

    /**
     * Generates a positive and mixed array of sorted integers.
     */
    @BeforeEach
    public void setup() {
        mixedUnsorted = createMixedArray(-1000, 1000, 100);
        mixedSorted = Arrays.copyOf(mixedUnsorted, mixedUnsorted.length);
        Arrays.sort(mixedSorted);

        positiveUnsorted = createPositiveArray(1, 1000, 100);
        positiveSorted = Arrays.copyOf(positiveUnsorted, positiveUnsorted.length);
        Arrays.sort(positiveSorted);
    }

    /**
     * A helper function to generate an array of random positive and negative integers.
     *
     * @param lowerBound the lower bound of integers (negative)
     * @param upperBound the upper bound of integers (positive)
     * @param length     the length of the wanted array
     * @return the generated array
     */
    public int[] createMixedArray(final int lowerBound, final int upperBound, final int length) {
        final int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                array[i] = random.nextInt(upperBound);
            } else {
                array[i] = -random.nextInt(Math.abs(lowerBound));
            }
        }
        return array;
    }

    /**
     * A helper function to generate an array of random positive integers.
     *
     * @param lowerBound the lower bound of integers (positive)
     * @param upperBound the upper bound of integers (positive)
     * @param length     the length of the wanted array
     * @return the generated array
     */
    public int[] createPositiveArray(final int lowerBound, final int upperBound, final int length) {
        assert lowerBound < upperBound;
        final int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = lowerBound + random.nextInt(upperBound - lowerBound);
        }
        return array;
    }

    /* ********************************************************
    THE FOLLOWING METHODS TEST DIFFERENT SORTING ALGORITHMS.
     * ********************************************************/

    @Test
    public void insertionSortTest() {
        final InsertionSort sorter = new InsertionSort();
        Assertions.assertArrayEquals(positiveSorted, sorter.sort(positiveUnsorted));
        Assertions.assertArrayEquals(mixedSorted, sorter.sort(mixedUnsorted));
    }

    @Test
    public void selectionSortTest() {
        final SelectionSort sorter = new SelectionSort();
        Assertions.assertArrayEquals(positiveSorted, sorter.sort(positiveUnsorted));
        Assertions.assertArrayEquals(mixedSorted, sorter.sort(mixedUnsorted));
    }

    @Test
    public void quickSortTest() {
        final QuickSort sorter = new QuickSort();
        Assertions.assertArrayEquals(positiveSorted, sorter.sort(positiveUnsorted));
        Assertions.assertArrayEquals(mixedSorted, sorter.sort(mixedUnsorted));
    }

    @Test
    public void optimizedQuickSortTest() {
        final OptimizedQuickSort sorter = new OptimizedQuickSort();
        Assertions.assertArrayEquals(positiveSorted, sorter.sort(positiveUnsorted));
        Assertions.assertArrayEquals(mixedSorted, sorter.sort(mixedUnsorted));
    }
}