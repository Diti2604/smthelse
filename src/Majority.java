import java.util.*;

public class Majority {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        int threshold = nums.length / 3;
        for (int num : cntMap.keySet()) {
            if (cntMap.get(num) > threshold) {
                res.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Majority solution = new Majority();
        int[] nums1 = {3, 2, 3};
        System.out.println("Example 1 Output: " + solution.majorityElement(nums1));
        int[] nums2 = {1};
        System.out.println("Example 2 Output: " + solution.majorityElement(nums2));
        int[] nums3 = {1, 2};
        System.out.println("Example 3 Output: " + solution.majorityElement(nums3));
    }
}
