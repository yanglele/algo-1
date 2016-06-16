package Tests;

import java.util.Scanner;
import java.util.TreeSet;
/*��������ѧУ����һЩͬѧһ����һ���ʾ���飬Ϊ��ʵ��Ŀ͹��ԣ������ü����������N��1��1000֮������������N��100�������������ظ������֣�ֻ����һ������������ͬ����ȥ������ͬ������Ӧ�Ų�ͬ��ѧ����ѧ�š�Ȼ���ٰ���Щ����С�������򣬰����źõ�˳��ȥ��ͬѧ�����顣����Э��������ɡ�ȥ�ء��롰���򡱵Ĺ�����


Input Param 
    n               ����������ĸ���     
inputArray      n�����������ɵ����� 
    
Return Value
    OutputArray    ����������������


ע������������֤�����������ȷ�ԣ�������������֤��*/

public class RadomAndSort {
	// �Լ���low����
	public void MydelAndSort() {

		int n;
		int[] data;
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			// read data
			n = s.nextInt();
			data = new int[n];
			for (int i = 0; i < n; i++) {
				data[i] = s.nextInt();
			}

			// Bubble Sort
			int i, j, temp;
			for (i = 0; i < n; i++) {
				for (j = 0; j < n - i - 1; j++) {
					if (data[j] > data[j + 1]) {
						temp = data[j];
						data[j] = data[j + 1];
						data[j + 1] = temp;
					}
				}
			}

			// print data
			int record = data[0];
			System.out.println(record);
			for (int num : data) {
				if (num != record) {
					System.out.println(num);
					record = num;
				}
			}
		}

	}

	// �� TreeSet ���
	public void TreeSetDelAndSort() {
		int n;
		TreeSet<Integer> set;
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			// read data
			n = s.nextInt();
			set = new TreeSet<Integer>();
			for (int i = 0; i < n; i++) {
				set.add(s.nextInt());
			}
			for (int i : set) {
				System.out.println(i);
			}
		}

	}

}
