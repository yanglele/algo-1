package Tests;

import java.util.Scanner;

import Utils.U;

//д��һ�����򣬽���һ��ʮ�����Ƶ���ֵ�ַ������������ֵ��ʮ�����ַ�����������ͬʱ���� ��
public class ChangeDecimal {

	public ChangeDecimal() {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String str = s.next();
			str = str.substring(2, str.length());
			int dec = Integer.valueOf(str, 16);
			U.p(dec);
			U.p(Integer.toHexString(dec));

		}
		U.p(Integer.valueOf("A", 16));

	}

}
