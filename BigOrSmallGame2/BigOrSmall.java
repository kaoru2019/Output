package bigorsmallgame2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// BigOrSmall: 繰り返しプレイするゲーム全体を管理するクラス。残りゲーム回数や、現在のスコアなどを管理する。
public class BigOrSmall {

	// 予想が当たっているかどうかを判定し、残りのゲーム回数や、現在のスコアを更新していく
	// ユーザーの入力が不正でないか判定する
	// ユーザーの予想が当たりかはずれかを判定して、結果をBigOrSmallGameに返す
	// GAME OVERになった時点で、ログファイルを出力する

	public static int judgement;
	public static int num = 10; // ゲームの残り回数(初期値は10)
	public static int score = 0; // スコア(初期値は0)
	public static int f = 0;

	/**
	 * 書き込むテキストファイルの名前。 (環境に合わせて書き換えてください)
	 */
	private static final String OUTPUT_FILE = "C:\\Users\\user\\Desktop\\log.txt";

	public static void play() {

		int c = RandomNumberGenerator.value1;
		int d = RandomNumberGenerator.value2;
		String r = "";

		if (c > d) {
			r = "Small";
		} else if (c < d) {
			r = "Big";
		}

		// 0(高い)、1(低い)かを判定
		if (Player.answer == 0 && c != d) {
			if (c < d) {
				System.out.println(r + " 現在の数値:" + c + "次の数値:" + d);
				System.out.println("当たり!");
				num--;
				f++;
				score += 100;
			} else {
				System.out.println(r + " 現在の数値:" + c + "次の数値:" + d);
				System.out.println("はずれ!");
				num--;
				f = 0;
			}
		}
		if (Player.answer == 1 && c != d) {
			if (c > d) {
				System.out.println(r + " 現在の数値:" + c + "次の数値:" + d);
				System.out.println("当たり!");
				num--;
				f++;
				score += 100;
			} else {
				System.out.println(r + " 現在の数値:" + c + "次の数値:" + d);
				System.out.println("はずれ!");
				num--;
				f = 0;
			}
		}

		if (c == d) {
			System.out.println("Draw");
		}

		if (f > 1) {
			score += (f - 1) * 100;
		}

		if (num == 0) {
			System.out.println("GAME OVER");
			System.out.println("スコア: " + score);
			try (

					// 出力するためにファイルを開く。
					// バッファリング出力をするためのI/Oストリームを利用。
					FileWriter fw = new FileWriter(OUTPUT_FILE, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw);) {

				// 現在日時の取得
				LocalDateTime localDateTime = LocalDateTime.now();

				// 年/月/日 時:分:秒 の形式で表示
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

				// データを書き込む。
				out.printf("スコア:" + score + " " + dateTimeFormatter.format(localDateTime) + "\r\n", 1);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
