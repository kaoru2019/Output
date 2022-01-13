package bigorsmallgame2;

import java.util.Random;

// RandomNumberGenerator: 任意の範囲のランダムな整数を生成するクラス
public class RandomNumberGenerator {

	public static int value1;
	public static int value2;
	public static String str2;

	public static void randomNum1() {

		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int randomValue1;

		// コンピューターが配列aからランダムに数字を選択し表示させる
		Random random1 = new Random(System.nanoTime());

		randomValue1 = random1.nextInt(8);

		value1 = a[randomValue1];

		// 配列aの中からランダムな数字を表示
		System.out.println("現在の数値:" + value1);
	}

	public static void randomNum2() {

		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int randomValue2;

		// コンピューターが配列aからランダムに数字を選択し表示させる
		Random random2 = new Random(System.nanoTime());

		randomValue2 = random2.nextInt(8);

		value2 = b[randomValue2];

		// 配列aの中からランダムな数字を表示
		System.out.println("次の数値:" + value2);
	}
}
