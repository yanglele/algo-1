import java.util.List;

import Utils.U;

public class Main {
	static List<Integer> list;

	public static void main(String[] args) {
		int[] d = new int[] { 3, 30, 34, 5, 9 };
		U.p(d);
		qs(d, 0, d.length - 1);
		U.p(d);
		return;
		// new IntsToMaxValue();
		// System.out.println(Integer.toString(303));
		// String arr = "222222 22222222 2222222222 22222222222222222";
		// String arr1 = null;
		// System.out.println(LongestCommonSubstring.longestCommonSubSequence(arr,
		// arr1));
		// GetAllSubSequence.getAllSubSequence(arr);
		// list = new ArrayList<>();
		// TreeNode t1 = new TreeNode(1);
		// TreeNode t2 = new TreeNode(2);
		// TreeNode t3 = new TreeNode(3);
		// TreeNode t4 = new TreeNode(4);
		// TreeNode t5 = new TreeNode(5);
		// TreeNode t6 = new TreeNode(6);
		// t1.left = t2;
		// t1.right = t3;
		// t2.left = t4;
		// t2.right = t5;
		// t3.right = t6;

		// System.out.println(001 & 0000);
		// System.out.println(Math.pow(a, b));
		// System.out.println(Integer.toBinaryString(4));
		// System.out.println(31 & 7);
		// U.p(Character.digit(2, 1));

		// List<String> list = new ArrayList<>();
		//
		// int[][] a = new int[2][];
		// a[0] = new int[3];
		// System.out.println(a[0][0]);
	}

	public static void qs(int[] data, int l, int r) {
		if (l >= r)
			return;
		int i = l, j = r, tmp = data[l], t;
		while (i < j) {
			while (data[j] >= tmp && i < j) // 等于不能丢！
				j--;
			while (data[i] <= tmp && i < j)// 等于不能丢！
				i++;
			if (i < j) {
				t = data[i];
				data[i] = data[j];
				data[j] = t;
			}
		}
		data[l] = data[i];
		data[i] = tmp;
		U.p(data);
		qs(data, l, i - 1);
		qs(data, i + 1, r);
	}

}
