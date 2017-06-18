package jp.co.ws.training.example;

public class TrainingBasicRun01 {

	public static void main(String[] args) {

		//クラスはnew して使う(Eclipse操作：Ctrl+クリックでクラスの中身を確認できる）
		TrainingBasic01 tb01 = new TrainingBasic01();
		tb01.setText("step1");
		String nowText = tb01.getText();
		System.out.println(nowText);


		TrainingBasic01 tb02 = new TrainingBasic01();
		tb02.setText("step2");
		String nowText2 = tb02.getText();
		System.out.println(nowText2);

	}

}
