package algorithms.sorting;


public class OptimizedQuickSort extends SortingAlgorithm {
    /**
     * Sorts the list using quick sort with median of three partitioning.
     *
     * @param nums the integer array to sort
     * @return the sorted array
     */
    @Override
    public int[] sort(final int[] nums) {
        QuickSort.quicksort(nums, 0, nums.length - 1, true);
        return nums;
    }
}
