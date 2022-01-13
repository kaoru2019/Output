package bigorsmallgame2;

import java.util.Scanner;

// Player: プレイヤーの入力内容を管理するクラス
public class Player {

	public static int answer;
	public static String str1;
	public static boolean bool = true;

	public static void input() {

		try {
			// ユーザーからの入力を受け付ける
			Scanner scanner = new Scanner(System.in);
			String str3 = scanner.next();
			answer = Integer.parseInt(str3);
			if (BigOrSmall.num == 0) {
				scanner.close();
			}
		} catch (NumberFormatException e) {
			bool = false;
			System.out.println("入力が不正です");
		}

		// 0:Big、1:Smallを英語で表示できるようにする
		if (answer == 0) {
			str1 = "Big";
		} else if (answer == 1) {
			str1 = "Small";
		}
	}
}
