https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

#code

  class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int total = numbers[l] + numbers[r];

            if (total == target) {
                return new int[]{l + 1, r + 1};
            } else if (total > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1, -1};         
    }
}
