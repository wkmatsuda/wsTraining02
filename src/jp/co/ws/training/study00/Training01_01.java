package jp.co.ws.training.study00;

import java.util.HashMap;
import java.util.Set;

/**
 * トレーニングクラス
 * @author wkmatsuda
 */
public class Training01_01 {

	public static void main(String[] args) {

		int trNo = 0;
		//switch文を使用
		switch (trNo){
			case 0:
				ex00();
				break;
			case 1:
				break;
		}
	}

	/**
	 * HashMapを使う練習
	 * 連想配列とも言う
	 */
	private static void ex00(){

		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("01","北海道");
		hm.put("02","東北");
		hm.put("03","関東");
		//ハッシュマップの中身を確認（※HashMapは並び順が保証されていないので注意。putした順番に出力されないこともある）
		Set<String> keys = hm.keySet();
		for (int i = 0; i < keys.size(); i++) {
		    String key = keys.toArray(new String[0])[i];
		    System.out.println(key + " => " + hm.get(key));
		}

	}

}
