package jp.co.ws.training.aizuonline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 長方形の描画
 *
 * たてH cm よこ W cm の長方形を描くプログラムを作成して下さい。
 *
 * 1 cm × 1cm の長方形を '#'で表します。
 *
 * Input
 * 入力は複数のデータセットから構成されています。各データセットの形式は以下のとおりです：
 *
 * H W
 *
 * H, W がともに 0 のとき、入力の終わりとします。
 *
 * Output
 * 各データセットについて、H × W 個の '#' で描かれた長方形を出力して下さい。
 *
 * 各データセットの後に、１つの空行を入れて下さい。
 *
 * Constraints
 * 1 ≤ H, W ≤ 300
 *
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_5_A
 *
 * @author wsKmatsuda
 *
 */
public class Aoj_1_5_a {

	public static void main(String[] args) {
		new Aoj_1_5_a().run();
	}

	public void run(){

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputData;
        List<Square> squareList = new ArrayList<Square>();
        try {
        	//入力
	        while(true){
				inputData = reader.readLine();
	            if("0 0".equals(inputData)){
	            	break;
	            }else{
					String[] strNumber = inputData.split(" ");
					int h = Integer.parseInt(strNumber[0]);
					int w = Integer.parseInt(strNumber[1]);
					squareList.add(new Square(h,w));
	            }
	        }

	        //出力
	        for(Square square : squareList){
				outputSquare(square.h , square.w);
				System.out.println();
	        }

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 長方形を描写
	 * @param h
	 * @param w
	 */
	protected void outputSquare(int h, int w) {
		StringBuilder sbLine = new StringBuilder();
		for(int i=0;i< w ;i++){
			sbLine.append("#");
		}
		for(int i=0;i<h;i++){
			System.out.println(sbLine.toString());
		}
	}

	/**
	 * 四角形クラス
	 * h,wを保持する
	 * （※Innerクラス。クラス内でクラスを定義できる。
	 *   わかりずらくなるので一般的にはあまり使わないと思うが
	 *   AOJ的にMainクラスだけをsubmitしたほうが
	 *   よさそうだったのでInnerクラスを使いました。）
	 */
	class Square{

		public int h;
		public int w;

		Square(int _h ,int _w){
			h = _h;
			w = _w;
		}
	}

}

