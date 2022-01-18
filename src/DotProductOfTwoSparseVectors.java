

import java.util.HashMap;
import java.util.Map;

public class DotProductOfTwoSparseVectors {
    public static void main(String[] args) {
        int[] nums1 = {0,1,0,0,2,0,0};
        int[] nums2 = {1,0,0,0,3,0,4};
        SparseVector v1 = new SparseVector(nums1);
        SparseVector v2 = new SparseVector(nums2);
        int ans = v1.dotProduct(v2);
        System.out.println(ans);
    }
}


class SparseVector {

    Map<Integer, Integer> map;

    SparseVector(int[] nums) {
        map = new HashMap<Integer, Integer>();
        for(int i = 0;i < nums.length; i++) {
            if(nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for(int x : vec.map.keySet()) {
            if(this.map.containsKey(x)) {
                sum += vec.map.get(x) * this.map.get(x);
            }
        }
        return  sum;
    }
}
