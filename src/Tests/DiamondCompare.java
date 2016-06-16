package Tests;

import java.util.ArrayList;

// һ����ʯ�ѱ�ţ�С�������ȡ�����Ƚϣ��Ƚ���ɺ��¼ ��class Cmp {int heavy; int light;}��Ȼ��Żض��С������������ȡ���������Ϊ��g1 g2���ܷ�ͨ����֪��¼�ж����أ�
// g1 �� ����1�� g2 �ط���-1�� �޷��Ƚ� ����0��
public class DiamondCompare {
	ArrayList<Cmp> list;
	int g1;
	int g2;
	boolean FLAG = false;

	public DiamondCompare() {
		// ��¼ list �ĳ�ʼ��
		list = new ArrayList<>();
		list.add(new Cmp(10, 3));
		list.add(new Cmp(10, 9));
		list.add(new Cmp(9, 8));
		list.add(new Cmp(9, 2));
		list.add(new Cmp(2, 1));
		list.add(new Cmp(2, 0));
		list.add(new Cmp(8, 5));
		list.add(new Cmp(7, 6));
		list.add(new Cmp(8, 4));
		list.add(new Cmp(4, 5));
		list.add(new Cmp(5, 11));

		g1 = 10;
		g2 = 5;

		// ������
		if (dfs(g1, g2)) {
			System.out.println(1);
			FLAG = false;
		} else if (dfs(g2, g1)) {
			System.out.println(-1);
			FLAG = false;
		} else
			System.out.println(0);
	}

	// �˴�����DFS������������ɺ� ��FLAG Ϊtrue
	public boolean dfs(int step, int target) {
		if (!FLAG) {
			for (Cmp each : list) {
				if (each.h == step && each.l == target)
					FLAG = true;
			}
			for (Cmp each : list) {
				if (step == each.h) {
					dfs(each.l, target);
				}

			}

		}
		return FLAG;
	}

}

class Cmp {
	int h;
	int l;

	public Cmp(int hh, int ll) {
		h = hh;
		l = ll;
	}
}
