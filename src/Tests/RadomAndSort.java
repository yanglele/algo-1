package Tests;

import java.util.Scanner;
import java.util.TreeSet;
/*明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤100），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。


Input Param 
    n               输入随机数的个数     
inputArray      n个随机整数组成的数组 
    
Return Value
    OutputArray    输出处理后的随机整数


注：测试用例保证输入参数的正确性，答题者无需验证。*/

public class RadomAndSort {
	// 自己的low程序
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

	// 用 TreeSet 解决
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
