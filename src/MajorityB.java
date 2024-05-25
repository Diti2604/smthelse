import java.util.*;

public class MajorityB {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int firstCandidate = 0, secondCandidate = 0;
        int cnt1 = 0, cnt2 = 0;

        for (int num : nums) {
            if (num == firstCandidate) {
                cnt1++;
            } else if (num == secondCandidate) {
                cnt2++;
            } else if (cnt1 == 0) {
                firstCandidate = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                secondCandidate = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == firstCandidate) {
                cnt1++;
            } else if (num == secondCandidate) {
                cnt2++;
            }
        }

        if (cnt1 > nums.length / 3) {
            res.add(firstCandidate);
        }
        if (cnt2 > nums.length / 3) {
            res.add(secondCandidate);
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
