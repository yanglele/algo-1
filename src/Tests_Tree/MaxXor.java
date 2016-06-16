package Tests_Tree;

import java.util.Random;
import java.util.Scanner;

import Utils.U;

/** ������ֵ**/
/**
 * ��һ������Ϊn���������У�����Ҫ���ȡ������е�һ��ǰ׺��һ����׺(ǰ׺�ͺ�׺�����ཻ)��ʹ��ǰ׺�ͺ�׺�����ֵ���
 * 
 * ǰ׺�ͺ�׺�����ֵΪǰ׺�����е����ͺ�׺�����е��������Ľ�������磬ĳ�����е�ǰ׺Ϊ1�� 2�� 4 ����׺Ϊ8�� 16����ô���ǵ����ֵΪ31.
 * 
 * ǰ׺�ͺ�׺����Ϊ�գ�Ϊ��ʱ���ǵ�ֵΪ0�� Input �ж���������ݣ��봦���ļ�������
 * 
 * ����ÿ��������ݣ���һ�а���һ������n(1<=n<=100 000)��
 * 
 * ������һ����n���ÿո����������a1, a2, a3, ..., an (0 <= ai <= 1000 000 000 000)��
 **/
// not�� �������ݽϴ� ��Ҫʹ�� long ������
public class MaxXor {
	public static TrieNode root;
	public static int N;
	public static long[] data;
	public static Scanner s;

	public static void main(String[] args) {

		MaxXor mx = new MaxXor();
		U.p("Please Enter");

		s = new Scanner(System.in);
		while (s.hasNext()) {
			mx.readData();

			mx.calculateMax();
		}
		s.close();
	}

	public void calculateMax() {
		long time_start = System.currentTimeMillis();
		root = new TrieNode();
		long headXOR = 0, tailXOR = 0, maxXOR;
		for (long num : data) {
			tailXOR ^= num;
		}
		maxXOR = headXOR ^ tailXOR;
		insertNode(headXOR);
		for (int i = 0; i < N; i++) {
			headXOR ^= data[i];
			tailXOR ^= data[i];
			insertNode(headXOR);
			maxXOR = Math.max(maxXOR, getMaxXOR(tailXOR));
		}
		System.out.print("maxXOR is : ");
		System.out.println(maxXOR);
		System.out.print("using time:" + (System.currentTimeMillis() - time_start));
	}

	public void readData() {

		N = s.nextInt();
		data = new long[N];
		for (int i = 0; i < N; i++) {
			data[i] = s.nextLong();
		}
	}

	public void insertNode(long _word) {
		if (searchTrieNode(_word))
			return;
		byte[] num = longToByte(_word);
		TrieNode cur = root;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0) {
				if (cur.zero == null) {
					cur.zero = new TrieNode();
				}
				cur = cur.zero;
			}
			if (num[i] == 1) {
				if (cur.one == null) {
					cur.one = new TrieNode();
				}
				cur = cur.one;
			}
		}
	}

	public boolean searchTrieNode(long _word) {
		byte[] num = longToByte(_word);
		TrieNode cur = root;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0) {
				if (cur.zero == null) {
					return false;
				} else
					cur = cur.zero;
			}
			if (num[i] == 1) {
				if (cur.one == null) {
					return false;
				} else
					cur = cur.one;
			}
		}
		return true;
	}

	// search the trie tree and find max xor for input num
	public long getMaxXOR(long _word) {
		byte[] num = longToByte(_word);
		TrieNode cur = root;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0) {
				if (cur.one != null) {
					cur = cur.one;
					num[i] = 1;
				} else {
					cur = cur.zero;
					num[i] = 0;
				} // note that you changed num[i] before, so must use else here!
			} else if (num[i] == 1) {
				if (cur.zero != null) {
					cur = cur.zero;
					num[i] = 1;
				} else {
					cur = cur.one;
					num[i] = 0;
				}
			}
		}
		return byteToLong(num);
	}

	// long to byte[]
	// note every num should end with L, or it will be converted into int!!!
	public static byte[] longToByte(long lnum) {
		long temp = lnum;
		byte[] b = new byte[41];
		for (int i = b.length - 1; i >= 0; i--) {
			b[i] = new Long(temp & 0x01L).byteValue();// �����λ���������λ
			temp = temp >> 1; // ������1λ
		}
		return b;
	}

	// byte����ת��long
	public static long byteToLong(byte[] b) {
		long s = 0L;
		for (int i = b.length - 1; i >= 0; i--) {
			s |= (((b[i] & 0x01L) << (b.length - 1 - i)));
		}
		return s;
	}

	// create test case ,use it like this: createNum(100, 1000000000000L);
	public static void createNum(int n, long range) {
		// N = n;
		// data = new long[N];
		Random r = new Random();
		U.p(n);
		for (int i = 0; i < n; i++) {
			System.out.println("" + Math.abs(r.nextLong() % range));
			// data[i] = Math.abs(r.nextLong() % range);
		}
		// U.p(data);
	}

}

class TrieNode {
	TrieNode zero;
	TrieNode one;
}
