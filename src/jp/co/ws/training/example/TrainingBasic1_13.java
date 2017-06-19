package jp.co.ws.training.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/**
 * 配列・コレクション
 * @author wsKmatsuda
 */
public class TrainingBasic1_13 {

	public static void main(String[] args) {

		//動作確認するメソッドを指定
		int trNo = 2;
		//switch文を使用
		//switchは多くのIF文を記述しなければならない場合に便利
		//caseごとのbreakを忘れないこと。意図的にbreakを書かない事もできる
		switch (trNo){
			case 0:
				ex00();
				break;
			case 1:
				ex01();
				break;
			case 2:
				ex02();
				break;
			case 9:
			case 10:
				//CASE9と10が同じ処理の場合、case9の直後のbreakは書かない。
				break;
			default:
				//上記のいずれの条件にも当てはまらない場合の処理

				break;
		}
	}

	/**
	 * HashMapを使う練習
	 * ・連想配列とも言う
	 * ・並び順が保証されていない。
	 * ・コード＋コード名などのようなデータ構造を保持するのに使う。
	 * ・画面でよく使うコンボボックスのデータを保持する場合にも使う。
	 * ・メモリー上に固定値を保持しておいて、プログラム上で使う場合などにも便利。
	 * ・既出のデータかどうかを確認できるので、重複チェックに利用できる。
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
		//キーがすでに登録されているかを確認できる
		if(hm.containsKey("01")){
			System.out.println("キー:01は既に登録されています。");
		}else{
			System.out.println("キー:01は未登録です。");
		}
		if(!hm.containsKey("04")){
			System.out.println("キー:04が未登録なので追加");
			hm.put("04","関西");
		}
		for (int i = 0; i < keys.size(); i++) {
		    String key = keys.toArray(new String[0])[i];
		    System.out.println(key + " => " + hm.get(key));
		}
		System.out.println("------------------同一キーを登録すると上書きされる。");
		hm.put("04","四国");
		for (int i = 0; i < keys.size(); i++) {
		    String key = keys.toArray(new String[0])[i];
		    System.out.println(key + " => " + hm.get(key));
		}

	}

	/**
	 * LinkedHashMapを使う練習
	 * LinkedHashMapは並び順が保証されている。
	 */
	private static void ex01(){

		LinkedHashMap<String,String> lhm = new LinkedHashMap<String,String>();
		lhm.put("01","北海道");
		lhm.put("02","東北");
		lhm.put("03","関東");
		Set<String> keys = lhm.keySet();
		for (int i = 0; i < keys.size(); i++) {
		    String key = keys.toArray(new String[0])[i];
		    System.out.println(key + " => " + lhm.get(key));
		}

	}

	/**
	 * LinkedHashMapを使う練習 その２
	 * removeEldestEntryにより、指定した数以上の値が登録されると最初に登録した値は削除される
	 * キャッシュの機能を実装するのに便利
	 */
	private static void ex02(){

		//※Interfaceについて
		//MapはインターフェースでLinkedHashMapはMapを実装しているクラス。
		//実際にクラスを実行するのはInterfaceで定義したメソッドを使うことによって、
		//実装したクラスに依存せずに機能を使用することが出来る。
		//
		//例えば、LinkedHashMapを以下のようにHashMapに置き換えても、
		//以降の処理の実装を変更する必要がない。
		//Map<String,String> lm5 = new HashMap<String,String>(5);

		Map<String,String> lm5 = new LinkedHashMap<String,String>(5);
		lm5.put("01","北海道");
		lm5.put("02","東北");
		lm5.put("03","関東");
		lm5.put("04","関西");
		lm5.put("05","四国");
		//ハッシュマップの中身を確認
		Set<String> keys = lm5.keySet();
		for (int i = 0; i < keys.size(); i++) {
		    String key = keys.toArray(new String[0])[i];
		    System.out.println(key + " => " + lm5.get(key));
		}
		System.out.println("5個以上追加---------");

		//TODO 思ってた動きと違うので後で再確認、修正する。
		lm5.put("06","九州");
	    for ( Map.Entry<String, String> e : lm5.entrySet() ) {
	        System.out.println( e.getKey() + ":" + e.getValue() );
	    }

	}
	/**
	 * クラスの中に定義したクラス。
	 * LinkedHashMapを継承して、リストの数の上限を5にしたクラスを新たに定義している。
	 * LinkedHashMapを継承することにより、その機能をカスタマイズして使えるクラスLinkedHashMap5を定義する。
	 *
	 * ※Javaの場合、継承（extends）で指定できるクラスは１つだけ。
	 *   Interfaceは複数指定できる。
	 */
	class LinkedHashMap5<K,V> extends LinkedHashMap<K,V> {

		private static final long serialVersionUID = 1L;

		/**
		 * 親クラスのremoveEldestEntryというメソッドを
		 * オーバーライド（上書きのイメージ）して、
		 * サイズが5以上の場合にtrueを返すようにする。
		 * サイズが5以上の場合は、最初に追加した要素が削除される。
		 * 左の△で、親クラスのメソッドを確認できる。
		 * 親クラスは常にfalseを返しているので継承しないで使ったLinkedHashMapは
		 * 無制限に値を追加できる。
		 * オーバーライドする場合は、親クラスと同じメソッド名、戻り値、引数を指定する必要がある。
		 */
		@Override
	    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
	        return size() > 5;
	    }
	}



}
