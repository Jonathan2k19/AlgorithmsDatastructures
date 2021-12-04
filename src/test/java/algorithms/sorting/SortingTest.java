package algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test sorting classes.
 */
public class SortingTest {
    private final List<Integer> numbers = new ArrayList<>();

    /**
     * Generates a list of 1000 integers for sorting.
     */
    @BeforeEach
    public void setup() {
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            numbers.add(random.nextInt(1000));
        }
        Collections.shuffle(numbers);
    }

    /**
     * Test if sorting algorithms sort the list generated in <Code>setup()</Code> correctly.
     */
    @Test
    public void testCorrectSorting() {
        final SelectionSort selectionSort = new SelectionSort(numbers);
        selectionSort.sort();
        Collections.sort(numbers);

        Assertions.assertSame(numbers, selectionSort.getList());
    }
}