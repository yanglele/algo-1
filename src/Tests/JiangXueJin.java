package Tests;

import java.util.Scanner;

import Utils.U;

public class JiangXueJin {
	int n;
	long r;
	long avg;
	long[] a;
	long[] b;

	public JiangXueJin() {
		long rest;
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			n = s.nextInt();
			r = s.nextLong();
			avg = s.nextLong();
			rest = avg * n;
			a = new long[n];
			b = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = s.nextLong();
				b[i] = s.nextLong();
				rest -= a[i];
			}
			quickSortTwo(b, 0, a.length - 1, a);
			U.p(rest);
			U.p(a);
			U.p(b);
			long t = minT(r, rest, a, b);
			System.out.println(t);
		}
	}

	public long minT(long r, long rest, long[] a, long[] b) {
		int i = 0;
		long totalT = 0;
		while (rest > 0) {
			if (rest <= (r - a[i])) {
				totalT += b[i] * rest;
				break;
			} else {
				totalT += (b[i] * (r - a[i]));
				U.p(totalT);
				rest -= (r - a[i]);
			}
			i++;
		}
		return totalT;

	}

	public void quickSortTwo(long[] b, int left, int right, long a[]) {
		if (left >= right)
			return;
		long temp = b[left];
		int i = left;
		int j = right;
		while (i != j) {
			while (b[j] >= temp && i < j)
				j--;
			while (b[i] <= temp && i < j)
				i++;
			if (i < j) {
				swap(a, i, j);
				swap(b, i, j);
			}
		}
		swap(a, left, i);
		swap(b, left, i);

		quickSortTwo(b, left, i - 1, a);
		quickSortTwo(b, i + 1, right, a);
	}

	public void swap(long[] a, int i, int j) {
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
