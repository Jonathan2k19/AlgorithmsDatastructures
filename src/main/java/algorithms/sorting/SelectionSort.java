package algorithms.sorting;

import java.util.List;


/**
 * The type Selection sort.
 */
/*
TODO
    - use generics (extending Comparable) instead of just supporting integers
    - is it a good practice to call getNums() every time or should I store nums also in subclass
 */
public class SelectionSort extends SortingAlgorithm {

    /**
     * Instantiates a new Selection sort.
     *
     * @param nums the nums
     */
    public SelectionSort(final List<Integer> nums) {
        super(nums);
    }

    /**
     * Sorts the list using selection sort.
     */
    public void sort() {
        for (int i = 0; i < getList().size() - 1; i++) {     // iterate through the list one-by-one
            int minIndex = i;
            // search for new minimum in unsorted part of the list
            for (int j = i + 1; j < getList().size(); j++) {
                if (getList().get(minIndex) > getList().get(j)) {
                    minIndex = j;
                }
            }
            // swap new minimum with current element
            int temp = getList().get(minIndex);
            getList().set(minIndex, getList().get(i));
            getList().set(i, temp);
        }
    }
}