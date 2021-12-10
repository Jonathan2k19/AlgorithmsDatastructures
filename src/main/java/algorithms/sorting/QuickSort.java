package algorithms.sorting;


import java.util.Arrays;

public class QuickSort extends SortingAlgorithm {
    /**
     * Sorts the list using quick sort.
     *
     * @param nums the integer array to sort
     * @return the sorted array
     */
    @Override
    public int[] sort(final int[] nums) {
        quicksort(nums, 0, nums.length - 1, false);
        return nums;
    }

    /**
     * Recursively splits the array in two partitions.
     * For the pivot index, I choose the right most element of a partition
     *
     * @param nums      the partition array to sort
     * @param low       the first index of the partition
     * @param high      the last index of the partition
     * @param enableMoT <Code>true</Code> if <Code>medianOfThreePartition</Code> should be used
     */
    public static void quicksort(
            final int[] nums, final int low, final int high, final boolean enableMoT) {
        if (low < high) {
            int pivotIndex;
            if (enableMoT) {
                pivotIndex = medianOfThreePartition(nums, low, high);
            } else {
                pivotIndex = partition(nums, low, high);
            }
            // recursively sort both partitions
            quicksort(nums, low, pivotIndex - 1, enableMoT);
            quicksort(nums, pivotIndex + 1, high, enableMoT);
        }
    }

    /**
     * Partitions the array <Code>nums</Code> "normally" in such a way, that
     * <ul>
     *     <li> <Code> nums[low ... border] <= pivot     </Code> </li>
     *     <li> <Code> nums[border + 1 ... high] > pivot </Code> </li>
     * </ul>
     *
     * @param nums the array to partition
     * @param low  the lower index of nums
     * @param high the upper index of nums
     * @return the index of the border between both partitions (pivot index)
     */
    private static int partition(final int[] nums, final int low, final int high) {
        final int pivot = nums[high];    // the pivot element
        int border = low;               // this will be the pivot index

        // partition
        for (int i = low; i < high; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, border);
                border++;
            }
        }
        swap(nums, border, high);

        // return the pivot index
        return border;
    }

    /**
     * This method is used to optimize pivot selection (especially if the array is not randomly
     * sorted):
     * <ul>
     *     <li> If pivot is approximately the median of the array: O(n*log(n)) runtime </li>
     *     <li> If pivot is smallest or largest element: O(n^2) runtime </li>
     * </ul>
     * How to:
     * <ol>
     *     <li> Get the leftmost, center, and rightmost element of the array. </li>
     *     <li> Store median at pivot position, the other ones in ascending order. </li>
     *     <li> Then <Code>partition()</Code> the adjusted array. </li>
     * </ol>
     *
     * @param nums the array to partition
     * @param low  the lower index of nums
     * @param high the upper index of nums
     * @return the index of the border between both partitions (pivot index)
     */
    private static int medianOfThreePartition(final int[] nums, final int low, final int high) {
        // sort the three elements
        final int[] sorted = {nums[low], nums[high / 2], nums[high]};
        Arrays.sort(sorted);

        // set the sorted elements in the array
        final int temp = nums[high];
        final int median = sorted[1];
        nums[high] = median;     // store median at pivot position
        if (median == nums[low]) {
            nums[low] = temp;
        } else if (median == nums[high / 2]) {
            nums[high / 2] = temp;
        }

        /* TODO: at the moment, the elements are not sorted fully (just median is now pivot)
         *  -> this is dumb because we know that sorted[2] >= pivot, sorted[0] <= pivot
         *  -> it would be smarter to do it the same way as explained in the video (we would need to
         *  adjust partition) https://www.youtube.com/watch?v=1Vl2TB7DoAM
         */

        // partition the adjusted array
        return partition(nums, low, high);
    }

    /**
     * Swaps two elements.
     *
     * @param nums the array
     * @param idx1 the index of the first element to swap
     * @param idx2 the index of the second element to swap
     */
    private static void swap(final int[] nums, final int idx1, final int idx2) {
        final int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
