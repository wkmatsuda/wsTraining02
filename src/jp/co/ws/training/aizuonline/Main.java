package jp.co.ws.training.aizuonline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *	http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_2_B
 *
 *	３つの整数a, b, cを読み込み、それらが a < b < cの条件を満たすならば"Yes"を、満たさないならば"No"を出力するプログラムを作成して下さい。
 *
 *	Input
 *		３つの整数が空白で区切られて与えられます。
 *
 *	Output
 *		YesまたはNoを１行に出力して下さい。
 *
 *	Constraints
 *		0 ≤ a, b, c ≤ 100
 *
 *  Sample Input 1
 *      1 3 8
 *
 */
class Main {

	public static void main(String[] args) {

		try {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        String str;
			str = reader.readLine();
	        String[] arr = str.split(" ");
	        int a = Integer.parseInt(arr[0]);
	        int b = Integer.parseInt(arr[1]);
	        int c = Integer.parseInt(arr[2]);

			Main ao1_2 = new Main();

			boolean result = ao1_2.judgeThreeNumber(a,b,c);

			if(result){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	/**
	 *
	 * @return
	 */
	private boolean judgeThreeNumber(int a, int b, int c){

		if(a < b && b < c){
			return true;

		}
		return false;
	}

}
