package jp.co.ws.training.example;

import java.util.ArrayList;
import java.util.List;

/**
 * if文を使う例
 * for文を使う例
 */
public class TrainingBasic1_10 {

	public static void main(String[] args) {
		ex06();
	}

	/**
	 * IF文を使う(数値比較、論理演算）
	 */
	private static void ex01(){
		System.out.println("ex1 START --------");

		//数値の比較(値を変えて実行してみる。前回と同じ実行はCTRL+F11）
		//
		int a = 0;
		int b = 1;

		System.out.println("a:"+ a);
		System.out.println("b:"+ b);

		System.out.println("ex1-1 数値の比較 if-else  START --------");
		if(a > b){
			//条件が真：trueだったら実行される処理
			System.out.println("a > b");
		}else{
			//条件が偽：falseだったら実行される処理
			System.out.println("a =< b");
		}

		System.out.println();
		System.out.println("ex1-2 数値の比較 if-else if-else START --------");
		//else if で条件を連続して記述できる
		if(a > b){
			//条件が真：trueだったら実行される処理
			System.out.println("a > b");
		}else if (a == b){
			//条件が偽：falseだったら実行される処理
			System.out.println("a = b");
		}else{
			//条件が偽：falseだったら実行される処理
			System.out.println("a > b");
		}

		System.out.println();
		System.out.println("ex1-3 階層をもったIF文 START --------");
		if(a > b){
			if(a >= 10){
				System.out.println("aはbより大きくでかつ10以上です。");
			}else{
				System.out.println("aはbより大きくでかつ10未満です。");
			}
		}else if (a == b) {
			System.out.println("aはb同じです。");
		}else{
			System.out.println("aはb以下です。");
		}

		System.out.println("ex1-3 if文内で論理演算（&&を使う。&&の左右の条件がどちらも真の場合true、一つでも偽の場合、falseになる。） START --------");
		if(a > b && a >= 10){
			System.out.println("aはbより大きくでかつ10以上です。");
		}else if(a > b && a < 10){
			System.out.println("aはbより大きくでかつ10未満です。");
		}else if (a == b) {
			System.out.println("aはb同じです。");
		}else{
			System.out.println("aはb以下です。");
		}

		System.out.println("");
		System.out.println("ex1-4 if文内で論理演算（||を使う。||の左右の条件がどちらかが真の場合true、どちらも偽の場合、falseになる。） START --------");
		int c = 20;
		if(a > c || c < 0){
			System.out.println("aの値 " + a + " は許容範囲外です。許容範囲：0以上"+ c + "以下");
		}else{
			System.out.println("aの値 " + a + " は許容範囲です。許容範囲：0以上"+ c + "以下");
		}

		System.out.println("");
		System.out.println("ex1-5 !=の使い方 ） START --------");

		if(a != b){
			System.out.println("aとbは違います。");
		}else{
			System.out.println("aとbは同じです。");
		}


		System.out.println("ex1 END --------");

	}

	/**
	 * IF文を使う(文字列比較）
	 * 文字列の比較はStringクラスのequalsを使います。==での比較は正しい結果が取得できない場合があるので使わないように。
	 */
	private static void ex02(){

		System.out.println("ex2 START --------");
		String strSta1 = "新宿";
		String strSta2 = "渋谷";
		String strSta3 = "渋";
		strSta3 = strSta3 + "谷";
		System.out.println("strSta1:" + strSta1);
		System.out.println("strSta2:" + strSta2);
		System.out.println("strSta3:" + strSta3);

		System.out.println("");
		System.out.println("ex2-1 文字列の間違った比較 START --------");
		if(strSta1 == strSta2 || strSta2 == strSta3 || strSta1 == strSta3){
			System.out.println("文字が重複しています。");
		}else{
			System.out.println("文字がすべて違います。");
		}
		System.out.println("");
		System.out.println("ex2-2 文字列の正しい比較 START --------");
		if(strSta1.equals(strSta2) || strSta2.equals(strSta3) || strSta1.equals(strSta3)){
			System.out.println("文字が重複しています。");
		}else{
			System.out.println("文字がすべて違います。");
		}

	}

	/**
	 * 文字列比較で発生しやすい NullPointerException
	 *
	 */
	private static void ex02_2(){

		String str1 = null;
		String str2 = "札幌	";
		try {
			 //str1がnullの場合、NullPointerExceptionが発生する。".equals"でそのインスタンスのequalsメソッドを
			//呼び出そうとしているが、そのインスタンスがNULLで参照先がないですよって意味。
			if (str1.equals(str2)) {
				System.out.println("到達しない命令1");
			}
			System.out.println("到達しない命令2");
		} catch (NullPointerException e) {
			//NullPointerExceptionが発生した場合の処理。画面系のプログラムだったら予期せぬExceptionをキャッチした場合、
			//エラー画面に遷移させたりする。
			System.out.println("exceptionの内容を表示：" + e.toString());
			//throwでキャッチしたエクセプションを呼び出し元にそのままエスカレーションすることもできる。
			throw e;
		} finally {
			//エクセプションの有無にかかわらず必ず実行する処理
			System.out.println("finallyの処理");
		}

	}


	/**
	 * IF文を使う(文字列比較・配列を使ってみる）
	 * ・配列内の同じ文字列が存在するかをチェックするメソッド
	 * ・文字列の比較はStringクラスのequalsを使います。==での比較はできないので注意すること。
	 * ・for文も覚える。ループ内の値の変化がどのようになっているかを把握する。
	 *
	 * 	i チェック対象 j 比較対象
	 * --------------------------------------------------------------------
	 *  0 新宿         0 新宿       →同一の項目なのでチェックしない
	 *  0 新宿         1 渋谷
	 *  0 新宿         2 渋谷
	 *  1 渋谷         0 新宿       →すでにチェック済みなのでチェックしない
	 *  1 渋谷         1 渋谷       →同一の項目なのでチェックしない
	 *  1 渋谷         2 渋谷
	 *  2 渋谷         0 新宿       →すでにチェック済みなのでチェックしない
	 *  2 渋谷         1 渋谷       →すでにチェック済みなのでチェックしない
	 *  2 渋谷         2 渋谷       →同一の項目なのでチェックしない
	 *
	 *
	 */
	private static void ex03(){

		System.out.println("ex3 START --------");

		String[] stationName = {"新宿","渋谷","渋谷"};

		//for文の意味
		//iの初期値は0
		//iがstationNameの配列の個数（この場合は3）未満の場合、ループを繰り返す
		//1回のループ終了後,i++を実行し加算する
		for(int i=0 ; i< stationName.length; i++){
			System.out.println("駅名" + i + "/" + stationName[i]);
		}

		//配列内に同じ文字列が存在するかをチェック
		for(int i=0 ; i< stationName.length; i++){
			//チェック対象の文字を取得
			String checkName = stationName[i];
			for(int j=0 ; j< stationName.length; j++){
				//System.out.println("i=" + i + " j=" + j);
				if(i == j){
					System.out.println("チェック対象と比較対象のインデックスが同じなのでチェックしない。index=" + i + ",j=" + j);
					//ループ内のこれ以降の処理を実行したくない場合はcontiue。
					continue;
				}
				if(i > j){
					System.out.println("チェック済みなのでチェックしない。index=" + i + ",j=" + j);
					//ループ内のこれ以降の処理を実行したくない場合はcontiue
					continue;
				}

				String compareName = stationName[j];
				if(checkName.equals(compareName)){
					System.out.println("同じ駅名が配列内に存在します。index=" + i + ",j=" + j + " 文字列=" + checkName);
				}else{
					System.out.println("異なる駅名。index=" + i + ",j=" + j + checkName + "≠" + compareName);
				}
			}
		}

		System.out.println("ex3 END --------");

	}


	/**
	 * 配列内に同じ文字列が存在する場合はtrue、しない場合はfalseを返すメソッドを作る
	 *
	 *
	 */
	private static void ex04(){

		String[] stationName1 = {"さっぽろ","しんさっぽろ","平岸","中の島","幌平橋"};
		String[] stationName2 = {"さっぽろ","中の島","平岸","中の島","幌平橋"};

		if(existsDuplicate(stationName1)){
			System.out.println("重複あり");
		}else{
			System.out.println("重複なし");
		}

		if(existsDuplicate(stationName2)){
			System.out.println("重複あり");
		}else{
			System.out.println("重複なし");
		}


	}

	/**
	 * 重複の有無を返しします。
	 * @param stationName1
	 * @return true：重複あり false：重複無し
	 */
	private static boolean existsDuplicate(String[] array) {

		for(int i=0;i < array.length ; i++ ){
			String target = array[i];
			for(int j=i+1;j < array.length ; j++ ){
				String compare = array[j];
				//System.out.println(i + "," + j); //ループの処理がイメージできない場合、デバッグ用にindexの値を出力してみる。
				if(target.equals(compare)){
					//重複が１つでもあればtrueを返してメソッドを終了
					return true;
				}

			}
		}

		return false;
	}

	/**
	 * ソート
	 * 配列内の数値を並び替える
	 */
	private static void ex05(){

		int[] numArray = {10,20,5,8,35};

		System.out.println("ソート前");
		for(int i=0;i<numArray.length;i++){
			System.out.println(numArray[i]);
		}

		//ソート実行
		for(int i=0;i<numArray.length;i++){
			for(int j=i+1;j<numArray.length;j++){
				if(numArray[i]>numArray[j]){
					//値の入れ替え
					int tempNum = numArray[i];
					numArray[i] = numArray[j];
					numArray[j] = tempNum;
				}

			}
		}

		System.out.println("ソート後");
		for(int i=0;i<numArray.length;i++){
			System.out.println(numArray[i]);
		}

	}

	/**
	 * ソート
	 * java.util.Arraysのソートを使う
	 */
	private static void ex06(){

		int[] numArray = {10,20,5,8,35};

		System.out.println("ソート前");
		for(int i=0;i<numArray.length;i++){
			System.out.println(numArray[i]);
		}

		//ソート実行
		java.util.Arrays.sort(numArray);

		System.out.println("ソート後");
		for(int i=0;i<numArray.length;i++){
			System.out.println(numArray[i]);
		}

	}


	/**
	 * コレクションを使う
	 * 配列は値の個数が決まっている場合便利ですが、値の個数が決まってない場合、
	 * 初期化したインデックス以上の値を指定してArrayIndexOutOfBoundsExceptionが発生することがよくあります。
	 * 動的に格納するデータの個数を増やす場合はコレクションクラスを使う。
	 * java.util.Listのソートを使う
	 */
	private static void ex07(){

		///////////////////////////////////
		//配列の例
		//5個の配列を確保
		System.out.println("配列の例------------------");
		int numArray[] = new int[5];
		numArray[0] = 10;
		numArray[1] = 5;
		numArray[2] = 8;
		numArray[3] = 18;
		numArray[4] = 24;
		int index=0;
		try{
			for(int i=0;i < numArray.length;i++){
				System.out.println(numArray[i]);
			}
			//配列の個数をふやすことが出来ない
			numArray[5] = 20;
		}catch(Exception e){
			//配列は5個しか確保していない。[]に指定できるのは0～4なのにもかかわらず、numArray[5]と指定するとエラー
			System.out.println(e.toString());
		}

		///////////////////////////////////
		// ArrayListの例
		//ArrayListは初期化時に配列の上限を設定する必要がない。
		//ArrayListを使ってみる<>の中には格納する値の型を指定する。int,booleanなどのプリミティブ型は
		//指定できない
		//追加順の出力を保証したいのであれば
		System.out.println("ArrayListの例------------------");
		List<Integer> intList = new ArrayList<Integer>();
		//リストに値を追加
		intList.add(10);
		intList.add(5);
		intList.add(8);
		intList.add(18);
		intList.add(24);

		intList.add(20);

		for(Integer val:intList){
			System.out.println(val);
		}

		System.out.println("");
		System.out.println("ArrayListの増減の例------------------");
		//指定の行を削除もできる
		intList.remove(2);
		intList.add(70);
		//indexを指定してループもできる。Listの場合は配列のlengthと違い、size()では値の個数を取得する。
		for(int i=0; i < intList.size(); i++){
			//getで取得できるクラスは宣言時に<>で指定したクラスになる。今回はInteger
			System.out.println(intList.get(i));
		}
		//注意が必要なのはremoveやgetの引数の指定で、存在しないidexを指定するとExceptionが発生する。
		try{
			intList.remove(intList.size()+1);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		//予期せぬjava.lang.IndexOutOfBoundsExceptionが発生した場合は、配列かListのindexの指定が正しいかを疑う


	}


}
