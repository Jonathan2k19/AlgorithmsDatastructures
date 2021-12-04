package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class tests all sorting algorithms.
 */
public class SortingTest {
    private final int[] numbers = new int[1000];       // the unsorted array we have to sort
    private int[] reference = new int[1000];           // used to check if numbers is sorted
    // correctly
    private final Random random = new Random();

    /**
     * Generates a list of 1000 positive integers (bounded by 100) for sorting.
     */
    private void generatePositiveIntegers() {
        for (int i = 0; i < 1000; i++) {
            numbers[i] = random.nextInt(100);
        }
    }

    /**
     * Generates a list of 1000 negative integers (bounded by -100) for sorting.
     */
    private void generateNegativeIntegers() {
        for (int i = 0; i < 1000; i++) {
            numbers[i] = -random.nextInt(100);
        }
    }

    /**
     * Generates a list of 1000 negative and positive integers (bounded by +-100) for sorting.
     */
    private void generateMixedIntegers() {
        final Random randomSign = new Random(); // used to determine the sign of the generated int
        for (int i = 0; i < 1000; i++) {
            if (randomSign.nextInt(50) % 2 == 0) {
                numbers[i] = random.nextInt(100);      // generate positive number
            } else {
                numbers[i] = -random.nextInt(100);     // generate negative number
            }
        }
    }

    /**
     * Sorts the reference array.
     */
    private void generateReference() {
        reference = numbers.clone();
        Arrays.sort(reference);
    }

    /**
     * TEST IF THE SORTING ALGORITHMS WORK CORRECTLY.
     * <p>FOR <Code>RadixSort</Code> ONLY POSITIVE INTEGERS CAN BE USED.</p>
     * <p>FOR ALL OTHER ALGORITHMS: TEST POSITIVE, NEGATIVE, MIXED NUMBERS.</p>
     */
    @Test
    public void testSelectionSort() {
        generatePositiveIntegers();
        generateReference();
        final SelectionSort selectionSorter = new SelectionSort(numbers);
        Assertions.assertArrayEquals(reference, numbers);

        generateNegativeIntegers();
        generateReference();
        selectionSorter.sort(numbers);
        Assertions.assertArrayEquals(reference, numbers);

        generateMixedIntegers();
        generateReference();
        selectionSorter.sort(numbers);
        Assertions.assertArrayEquals(reference, numbers);
    }
}