package algorithms.sorting;

/**
 * The type Selection sort.
 */
public class SelectionSort extends SortingAlgorithm {
    /**
     * Sorts the list using selection sort.
     *
     * @param nums the integer array to sort
     * @return the sorted array
     */
    @Override
    public int[] sort(final int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {     // iterate through the list one-by-one
            int minIndex = i;
            // search for new minimum in unsorted part of the list
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            // swap new minimum with current element
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}