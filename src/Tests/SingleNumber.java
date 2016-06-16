package Tests;

public class SingleNumber {

	// XOR ��������ر��
	public int findLost(int[] num) {
		int single = 0;
		for (int i : num) {
			single ^= i;
		}
		return single;
	}

	// ����������ȥ��
	public int singleNumber(int num[]) {
		if (num.length == 1)
			return num[0]; // �������������Ϊ1

		quickSort(num, 0, num.length - 1);

		return findSingle(num);

	}

	public int findSingle(int num[]) {
		int single = 0;
		for (int i = 0; i <= num.length - 3; i += 2) {
			if (num[i] != num[i + 1]) {
				single = num[i];
				break;
			}
			if (i == num.length - 3)
				single = num[num.length - 1];
		}
		return single;
	}

	public void quickSort(int[] num, int left, int right) {
		if (left >= right)
			return;
		int temp = num[left];
		int i = left, j = right;
		while (i != j) {
			while (num[j] >= temp && j > i)
				j--;
			while (num[i] <= temp && j > i)
				i++;
			if (j > i) {
				int t = num[i];
				num[i] = num[j];
				num[j] = t;
			}
		}
		num[left] = num[i];
		num[i] = temp;
		quickSort(num, left, i - 1);
		quickSort(num, i + 1, right);
	}

}
