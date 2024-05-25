import java.util.*;

class Topmost {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        List<Integer> bucket[] = new ArrayList[nums.length + 1];

        for (int num : nums)
            cnt.merge(num, 1, Integer::sum);


        for (Integer key : cnt.keySet()) {
            Integer freq = cnt.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int val : bucket[i]) {
                    res[index++] = val;
                    if (index == k) return res;
                }
            }
        }
        return res;
    }
}