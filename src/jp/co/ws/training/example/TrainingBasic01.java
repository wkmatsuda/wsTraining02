package jp.co.ws.training.example;


/**
 * Java基礎	クラス、メッソッド、パッケージ	クラスについての概要、クラスの宣言、使い方、オブジェクト指向について
 *
 * @author K.Matsuda
 *
 */
public class TrainingBasic01 {


	/**
	 * コンストラクタ。クラスがnewされてるタイミングで実行される。
	 */
	TrainingBasic01(){
		calcResult = 0;

	}

	/**
	 * プライベート変数（※他のクラスからは見えない）
	 */
	private String text;
	/**
	 * パブリック変数（※クラスから参照できる。）
	 */
	public String strText;
	/**
	 * プロテクティッド変数（※継承したクラスから参照できる。）
	 */
	protected String pText;
	/**
	 * 数値計算用の変数
	 */
	public int calcResult;

	/**
	 * textを引数で上書きする
	 * @param val
	 */
	public void setText(String val){

		text = val;
	};

	/**
	 * TrainingBasic01が持っているtextを返すメソッド
	 * @return string
	 */
	public String getText(){

		//戻り値にテキスト
		return text;
	}


	/**
	 * textに対し引数の文字列を追加メソッド
	 * @param val
	 */
	public void addText(String val){
		text = text + val;
	};



}
