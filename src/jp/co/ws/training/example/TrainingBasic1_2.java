package jp.co.ws.training.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jp.co.ws.training.common.DateUtil;

public class TrainingBasic1_2 {

	public static final float PI = 3.14159F;

	public static void main(String[] args) {

		test7();
	}

	/**
	 * 日付操作サンプル（Calenderクラス）
	 *  x日のn日後を求めるとかの操作はCalenderクラスを使う
	 */
	private static void test7(){
		System.out.println("日付操作サンプル（Calenderクラス） START----------");

		String[] arrayWeek = {"日","月","火","水","木","金","土"};


		//現在時刻を取得
		Calendar calNow = Calendar.getInstance();
	    System.out.println(calNow);

	    int year = calNow.get(Calendar.YEAR);
	    int month = calNow.get(Calendar.MONTH) + 1; //月は＋１しなければならないので注意
	    int day = calNow.get(Calendar.DATE);
	    int hour = calNow.get(Calendar.HOUR_OF_DAY);
	    int minute = calNow.get(Calendar.MINUTE);
	    int second = calNow.get(Calendar.SECOND);

	    int dayOfYear = calNow.get(Calendar.DAY_OF_YEAR);

	    StringBuilder sbDateinfo = new StringBuilder();
	    sbDateinfo.append(year).append("/").append(month).append("/").append(day);
	    sbDateinfo.append(" ");
	    sbDateinfo.append(hour).append(":").append(minute).append(":").append(second);

	    System.out.println("現在時刻："+sbDateinfo.toString());

	    int week = calNow.get(Calendar.DAY_OF_WEEK) - 1; //日～土は1～7が対応しているので、配列のインデックスに合わせて-1
	    System.out.println(arrayWeek[week]+"曜日");

	    //2ヵ月後の日付を求める
	    int addMonth = 2;
	    Calendar calAddMonth = (Calendar)calNow.clone();
	    calAddMonth.add(Calendar.MONTH, addMonth);

	    System.out.println(addMonth + "ヵ月後：" + DateUtil.getDateString(calAddMonth));


	    //60日後の日付を求める
	    int addDate = 60;
	    Calendar calAddDate = (Calendar)calNow.clone();
	    calAddDate.add(Calendar.DATE, addDate);

	    System.out.println(addDate + "日後：" + DateUtil.getDateString(calAddDate));

	    //今年の何日目
	    System.out.println(addDate + "今年の何日目：" + dayOfYear );


		System.out.println("日付操作サンプル（Calenderクラス） END----------");
	}


	/**
	 * 日付操作サンプル（Dateクラス）
	 * 現在日付を扱うのであればDateクラスを使う
	 */
	private static void test6(){

		System.out.println("日付操作サンプル START----------");

		//現在の日付を取得する処理にはDateクラスを使う
		//現在日付を取得
		Date dateStart = new Date();

		//日付を文字列で出力してみる。 Sat Jun 17 23:14:08 JST 2017
		System.out.println("日付を文字列で出力");
		System.out.println(dateStart.toString());
		System.out.println();

		System.out.println("日付のフォーマットを指定して出力");
		DateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //※変数を宣言するクラスと、Newする時のクラスが違います。
		String strDate = dateTimeFormat.format(dateStart);
		System.out.println(strDate);

		//現在の日付から時間だけを取得
		System.out.println("現在の日付から時間だけを取得");
		String nowHour = strDate.substring(11, 13);
		System.out.println(nowHour);

		//1000ミリ秒待機
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//処理完了時刻を取得
		Date dateEnd = new Date();
		String strEndDate = dateTimeFormat.format(dateEnd);
		System.out.println(strEndDate);

		//処理にかかかった時間を計測
		long diff = dateEnd.getTime() - dateStart.getTime();
		System.out.println("経過時間（ms）：" + diff);

		System.out.println("日付操作サンプル END  ----------");
	}


	/**
	 * 文字列操作のサンプル
	 */
	private static void test5(){

		//文字列はダブルクォーテーションで囲む
		String text = "Yahoo! JAPAN";
		System.out.println("文字列：" + text);
		//文字列に空文字が入ることはよくある。
		String zeroByteText = "";

		//文字列の長さ
		System.out.println("文字列の長さ-----------------");
		int len = text.length();
		System.out.println("長さ：" + len);
		System.out.println("長さ：" + zeroByteText.length());

		//分割
		System.out.println("分割-----------------");
		String[] arrayText = text.split(" "); //分割した文字列が配列に格納される。配列の最初の引数は0

		//繰り返し文
		for(int i=0; i <arrayText.length ; i++){
			System.out.println(i + ":" + arrayText[i]);
		}

		//リプレース
		String replacedText = text.replaceAll("Yahoo!", "");
		System.out.println("replaced:" + replacedText);

		//正規表現を使ってみる
		String regexText = text.replaceAll("[a-z]*| ", "");
		System.out.println("regex:" + regexText);

		//切り出し
		String subText = text.substring(0,4);
		System.out.println("subText:" + subText);

		//改行
		System.out.println("改行について");
		//文字列の連結にはStringBuilderを使う。+で文字列を連結するより早く処理できる。
		StringBuilder sbNewLineText = new StringBuilder();
		for(int i=0 ;i<20;i++){
			sbNewLineText.append(String.valueOf(i));
			//最後の文字でなければ","を追加する。
			if(i != 19){
				sbNewLineText.append(",");
			}
			//iが５で割れたら改行も追加
			if(i != 0 && i%5 == 0){
				//sb.append(System.lineSeparator()); //改行コードはシステムによって異なる。OSに合わせる必要があれば、System.lineSeparatorを使う
				sbNewLineText.append("\n");   //明示的にLFにする場合
				//sb.append("\r\n"); //明示的にCRLFにする場合
			}
		}
		System.out.println(sbNewLineText.toString());

	}




	public static void runGetDistance() {

		double x1 = 0.0;
		double y1 = 0.0;
		double x2 = 1.0;
		double y2 = 1.0;

		double distance = getDistance(x1,y1,x2,y2);
		System.out.println(distance);
	}


	/**
	 * 2点間の距離を求める
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public static double getDistance(double x1 , double y1 , double x2, double y2){

		double dist =  Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));

		return dist;

	}


	/**
	 * キャストの確認
	 */
	private static void test4(){

		//float → int
		int intPi = (int)PI;
		System.out.println(intPi);

		//float →String
		String strPI = String.valueOf(PI);
		System.out.println("文字列に変換：" + strPI);

	}


	private static void test3(float r){

		System.out.println("round:" + 2F * PI * r);
		System.out.println("area:" + PI * r * r);

	}

	private static void test2(){

		//long を使う場合は、固定値を代入するときは数値の最後にLをつける。
		long longVal1 = 10L;
		long longVal2 = 20L;

		System.out.println(longVal1 * longVal2);

		//小数点を扱う場合はfloatを使い、固定値を代入するときは数値の末尾にFをつける。
		float floatVal1 = 10.0009F;
		float floatVal2 = 20.1112F;

		System.out.println(floatVal1 * floatVal2);

	}

	private static void test1(){

		int i;
		i=2147483647;
		System.out.println(i);

		i=i+1;
		System.out.println(i);

	}
	



}
