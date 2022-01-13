package bigorsmallgame1;

import java.util.Random;
import java.util.Scanner;

public class BigOrSmallGame1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int[] a = { 2, 3, 4, 5, 6, 7, 8 };
		int[] g = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		// ゲーム続行:s=1 ゲーム終了:s=0
		int s = 1;

		// 3回まで動作を繰り返す
		for (int b = 0; b <= 2 && s == 1; b++) {

			// コンピューターが配列aからランダムに数字を選択し表示させる
			Random random = new Random();
			int randomValue = random.nextInt(7);

			// 配列aの中からランダムな数字を表示
			System.out.println("出た数字" + a[randomValue]);

			// 1回目と比べて2回目の数字が大きいかユーザーに選択してもらう
			System.out.println("あなたの選択は？ (0: Small 1: Big):");

			Scanner scanner = new Scanner(System.in);
			int p = scanner.nextInt();

			if (p != 0 && p != 1) {
				System.out.println("入力エラー");
				break;
			} else {

				// コンピューターが配列aからランダムに数字を選択し表示させる
				Random random2 = new Random();
				int randomValue2 = random2.nextInt(8);

				// 配列aの中からランダムな数字を表示
				System.out.println("あなたの数字" + g[randomValue2]);

				// １回目の数字と２回目の数字を比較して、Win,Lose,Drawの３つのパターンを表示させる

				if (a[randomValue] == g[randomValue2]) {
					System.out.println("Drawです");
					b = b - 1;
					// １回目より大きい
				} else if (a[randomValue] <= g[randomValue2]) {
					if (p == 1) {
						System.out.println("Win!");
					} else {
						System.out.println("Lose..");
					}
					// １回目より小さい
				} else if (a[randomValue] >= g[randomValue2]) {
					if (p == 0) {
						System.out.println("WIn!");
					} else {
						System.out.println("Lose..");
					}
				}

				if (b <= 1) {
					// ゲームを続行するか終了するか選択してもらう
					System.out.println("もう一度プレイしますか？(0:No 1:Yes):");
					Scanner scanner2 = new Scanner(System.in);
					s = scanner2.nextInt();
				}
				if (s != 0 && s != 1) {
					System.out.println("入力エラー");
					break;
				}

				if (s == 0 || b >= 2) {
					System.out.println("プレイを終了します");
					break;
				}
			}
		}
	}
}