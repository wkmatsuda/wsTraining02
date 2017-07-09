package jp.co.ws.training.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ファイル操作のサンプル
 * C:\Users\GATEWAY\git\wsTraining02\data\input\01HOKKAI.CSV
 *
 * C:\Users\GATEWAY\git\wsTraining02\data\input\01HOKKAI_YYYYMMDD.CSV
 *
 */
public class TrainingBasic1_14 {

	public static void main(String[] args) {

		TrainingBasic1_14 tb = new TrainingBasic1_14(",", "SJIS", "UTF-8");
		tb.run();

	}

	String SEP_WORD;
	String IN_FILE_ENCODE;
	String OUT_FILE_ENCODE;

	/**
	 * コンストラクタ
	 */
	TrainingBasic1_14(String _sepWord, String _inFileEncode, String _outFileEncode){

		SEP_WORD = _sepWord;
		IN_FILE_ENCODE = _inFileEncode;
		OUT_FILE_ENCODE = _outFileEncode;

	}

	/**
	 * 実行メソッド
	 */
	public void run(){

		//変換元のファイル名 ディレクトリの区切り文字をJavaの文字列で扱うときは\\なので注意してください。
		String sourceFileName = "C:\\Users\\GATEWAY\\git\\wsTraining02\\data\\input\\01HOKKAI.CSV";

		//変換後のファイル名
		Date now = new Date();
		DateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMddHHmmss"); //※変数を宣言するクラスと、Newする時のクラスが違います。
		String timeStampString = dateTimeFormat.format(now);
		String destFileName = "C:\\Users\\GATEWAY\\git\\wsTraining02\\data\\output\\01HOKKAI" + timeStampString +  ".CSV";

		//変換実行
		convertFile(sourceFileName , destFileName);


	}

	/**
	 *
	 * ファイルひらき内容を変更して出力する。
	 */
	public void convertFile(String sourceFile ,String destFile){

		BufferedReader br = null;
		PrintWriter pw = null;

		//変換元のファイルをオープン
		try{


			File inFile = new File(sourceFile);
			File outFile = new File(destFile);

			if (checkBeforeReadfile(inFile)){
				br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile) , IN_FILE_ENCODE));
				String str;
				String[] col;
				pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outFile) ,OUT_FILE_ENCODE));

				while((str = br.readLine()) != null){
					//カラムに分割
					col = str.split(",");
					for(int i=0;i<col.length ; i++){
						//文字列置換メソッド呼び出し
						col[i] = convertCol(col[i]);

					}
					//結合処理呼び出し
					String rec  = mergeCol(col, SEP_WORD);

					//ファイルを書き込み
					pw.println(rec.toString());
					//コンソールへの出力
					//System.out.println(rec);
				}

			}else{
				System.out.println("FileNotFound:" + sourceFile);
			}
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(pw != null){
				pw.close();
			}
		}
	}

	/**
	 * 文字の配列を１行にまとめる
	 * @param col
	 * @return
	 */
	private String mergeCol(String[] cols , String sepWord) {

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<cols.length ; i++){
			sb.append(cols[i]);
			if(i != cols.length){
				sb.append(sepWord);
			}
		}
		return sb.toString();
	}

	/**
	 * カラムを置換する処理
	 * @param string
	 * @return
	 */
	protected String convertCol(String str) {

		String ret = str.replaceAll("\"", "");

		return ret;
	}

	/**
	 * ファイルの存在チェック
	 * @param file
	 * @return
	 */
	private static boolean checkBeforeReadfile(File file){
		if (file.exists()){
			if (file.isFile() && file.canRead()){
				return true;
			}
		}
		return false;
	}

	/**
	 *
	 * @param soruce 変換前
	 * @param dest 返還後
	 */
	public void convRecord(String soruce , String dest){


	}




}
