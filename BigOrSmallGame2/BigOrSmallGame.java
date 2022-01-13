package bigorsmallgame2;

// BigOrSmallGame: 各回のゲームを管理するクラス1

// mainメソッドを配置して、各クラスのメソッドを呼び出す
public class BigOrSmallGame {

	public static void main(String[] args) {

		System.out.println("Big or Small をプレイします。");

		// TODO 自動生成されたメソッド・スタブ
		while (BigOrSmall.num > 0) {
			// 残りのプレイ回数
			System.out.println("残りのプレイ回数は" + BigOrSmall.num + "です");
			// 現在のスコア
			System.out.println("スコア: " + BigOrSmall.score);
			// ランダムに生成された整数を表示する(現在の数値)
			RandomNumberGenerator.randomNum1();

			// 次の値について入力を求める
			System.out.println("次の数値は Big or Small?(Big: 0 Small: 1)");
			System.out.println("0または1で入力してください:");
			Player.input();

			if (Player.bool == true) {
				// ランダムに生成された整数を表示する(次の数値)
				RandomNumberGenerator.randomNum2();

				// あなたの答え
				System.out.println("あなたの答えは" + Player.str1 + "です");

				// はずれ、もしくは当たりと表示する、残りのプレイ回数と、スコアを更新する
				BigOrSmall.play();

				// 残りのプレイ回数が0になるまでは、BigOrSmallクラスのPlayメソッドを繰り返す

			} else if (Player.bool == false) {
				System.out.println("正しい値を入力してください");
				Player.bool = true;
			}

		}
	}
}