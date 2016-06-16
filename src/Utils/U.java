package Utils;

public class U {

	public static void p(int[] num) {
		for (int i : num)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void p(char[] num) {
		for (char i : num)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void p(byte[] num) {
		for (byte i : num)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void p(Integer[] num) {
		for (Integer i : num)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void p(long[] num) {
		for (long i : num)
			System.out.println(i + " ");

	}

	public static <T> void p(T num) {
		System.out.println(num);
	}

	public static <T> void p(T... num) {
		for (T data : num) {
			System.out.print(data + " ");
		}
		System.out.println();
	}

}
