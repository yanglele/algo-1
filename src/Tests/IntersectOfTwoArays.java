package Tests;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectOfTwoArays {

	public IntersectOfTwoArays() {
		// TODO Auto-generated constructor stub
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0)
			return new int[0];

		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			} else {
				map.put(nums1[i], 1);
			}
		}
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				ans.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		int[] ansdata = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			ansdata[i] = ans.get(i);
		}
		return ansdata;

	}

}
