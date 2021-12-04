package algorithms.sorting;

import java.util.List;


/**
 * The type Sorting algorithm.
 */
public abstract class SortingAlgorithm {
    private final List<Integer> nums;   // the list we are looking at

    /**
     * Instantiates a new Sorting algorithm.
     *
     * @param nums the nums
     */
    public SortingAlgorithm(final List<Integer> nums) {
        this.nums = nums;
    }

    /**
     * Prints the specified list.
     */
    public void printList() {
        System.out.print("[");
        for (int i = 0; i < nums.size() - 1; i++) {
            System.out.print(nums.get(i) + ", ");
        }
        System.out.println(nums.get(nums.size() - 1) + "]");
    }

    /**
     * Sorts the numbers in the list in ascending order.
     */
    public abstract void sort();

    /**
     * Returns the list.
     *
     * @return the list
     */
    public List<Integer> getList() {
        return nums;
    }
}