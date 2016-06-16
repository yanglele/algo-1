package Tests;

import Utils.U;

public class MajorityElement {

	public MajorityElement() {
		int nums[] = { 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 0, 1, 2, 0, 1, 2 };
		FindThreeMost(nums);

	}
	// ������һ������int���������������ظ�������һ���ֳ��ֵ�Ƶ�ʳ�����50%�����ҳ�������֡�

	public int majorityElement(int[] nums) {
		// Arrays.sort(nums);
		// return nums[nums.length/2];
		int majority = nums[0];
		int count = 0;

		for (int i = 0; i < nums.length; i++) {

			if (count > nums.length / 2)
				break;
			if (count == 0) {
				count++;
				majority = nums[i];
			} else if (majority == nums[i]) {
				count++;
			} else
				count--;
		}
		return majority;
	}

	// ����������û�г���Ƶ��һ��������ˣ������������������ķ�֮һ���ҵ����ǡ�
	public void FindThreeMost(int[] nums) {
		if (nums.length < 3)
			return;
		int A = nums[0], B = 0, C = 0;
		int countA = 1, countB = 0, countC = 0;
		// ��ʼ��ABC
		for (int num : nums) {
			if (countB == 0) {
				if (num != A) {
					B = num;
					countB = 1;
				}
			}
			if (countC == 0) {
				if (num != A && num != B) {
					C = num;
					countC++;
					break;
				}
			}
		}
		countA = 0;
		countB = 0;
		countC = 0;
		// Find
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == A) {
				countA++;
			} else if (nums[i] == B) {
				countB++;
			} else if (nums[i] == C) {
				countC++;
			} else {
				if (countA > 0)
					countA--;
				if (countB > 0)
					countB--;
				if (countC > 0)
					countC--;
				if (countA == 0 || countB == 0 || countC == 0) {
					if (countA == 0) {
						A = nums[i];
					} else if (countB == 0) {
						B = nums[i];
					} else if (countC == 0) {
						C = nums[i];
					}
				}
			}
		}
		U.p(A);
		U.p(B);
		U.p(C);

	}

}
