class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int limit = nums.length / 3;
        for (int i = 0; i < nums.length; i++) {
            if (frequency.getOrDefault(nums[i], 0) > limit) {
                continue;
            }
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
            if (frequency.get(nums[i]) > limit) {
                result.add(nums[i]);
            }
        }
        return result;
    }
}