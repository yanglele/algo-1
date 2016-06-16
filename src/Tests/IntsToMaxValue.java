package Tests;

import Utils.U;

public class IntsToMaxValue {
	public IntsToMaxValue() {
		U.p(intsToMin(new int[] { 3, 30, 34, 5, 9 }));

	}

	public String intsToMin(int[] data) {
		StringBuilder sb = new StringBuilder();
		qs(data, 0, data.length - 1);
		U.p(data);
		for (int d : data) {
			sb.append(d);
		}
		return sb.toString();
	}

	public boolean isSmaller(int[] data, int a, int b) {
		U.p(Integer.valueOf((Integer.toString(a) + Integer.toString(b))));
		U.p(Integer.valueOf((Integer.toString(b) + Integer.toString(a))));
		U.p(data);
		return Integer.valueOf((Integer.toString(a) + Integer.toString(b))) <= Integer
				.valueOf((Integer.toString(b) + Integer.toString(a)));
	}

	public void qs(int[] data, int l, int r) {
		if (l >= r)
			return;
		int i = l, j = r, tmp = data[l], t;
		while (i < j) {
			while (i < j && isSmaller(data, tmp, data[j]))
				j--;
			while (i < j && isSmaller(data, data[i], tmp))
				i++;
			if (i < j) {
				t = data[i];
				data[i] = data[j];
				data[j] = t;
				U.p(data);
			}
		}
		data[l] = data[i];
		data[i] = tmp;
		qs(data, l, i - 1);
		qs(data, i + 1, r);
	}

}
