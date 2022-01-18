package utils;

import java.util.Random;

/**
 * Some utils for testing with arrays:
 * <ul>
 *    <li><Code>createMixedArray()</Code></li>
 *    <li><Code>createPositiveArray()</Code></li>
 * </ul>
 */
public class ArrayUtils {
    private static final Random random = new Random();


    /**
     * A utility method to generate an array of random positive and negative integers.
     *
     * @param lowerBound the lower bound of integers (negative)
     * @param upperBound the upper bound of integers (positive)
     * @param length     the length of the wanted array
     * @return the generated array
     */
    public static int[] createMixedArray(final int lowerBound, final int upperBound,
                                         final int length) {
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
     * A utility method to generate an array of random positive integers.
     *
     * @param lowerBound the lower bound of integers (positive)
     * @param upperBound the upper bound of integers (positive)
     * @param length     the length of the wanted array
     * @return the generated array
     */
    public static int[] createPositiveArray(final int lowerBound, final int upperBound,
                                            final int length) {
        assert lowerBound < upperBound;
        final int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = lowerBound + random.nextInt(upperBound - lowerBound);
        }
        return array;
    }

    /**
     * A utility method to print an array of integers.
     */
    public static void printArray(final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }
}
