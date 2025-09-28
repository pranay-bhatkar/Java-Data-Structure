package dayone.arrays;

public class LinearSearch {

    public static int linearSearch(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int key = 0;

        int index = linearSearch(nums, key);
        if (index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("key is found at index : " + index);
        }
    }
}