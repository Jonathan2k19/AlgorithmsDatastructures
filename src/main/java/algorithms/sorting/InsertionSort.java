package algorithms.sorting;

public class InsertionSort extends SortingAlgorithm {

    public InsertionSort(final int[] nums) {
        this.sort(nums);
    }

    /**
     * Sorts the specified array using insertion sort.
     *
     * @param nums the specified integer array
     */
    @Override
    public void sort(final int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            final int current = nums[j];
            while (j > 0 && nums[j - 1] > current) {
                final int temp = nums[j - 1];
                nums[j - 1] = current;
                nums[j] = temp;
                j--;
            }
        }
    }
}
