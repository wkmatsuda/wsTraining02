package jp.co.ws.training.study00;

import java.util.Scanner;

public class TrainingResultCheck {

	public static void main(String[] args) {

		Scanner inputscan = new Scanner(System.in);

		int W = inputscan.nextInt();
		int H = inputscan.nextInt();
		int x = inputscan.nextInt();
		int y = inputscan.nextInt();
		int r = inputscan.nextInt();

		int Horizontal1 = x - r;
		int Horizontal2 = x + r;
		int Vertical1 = y - r;
		int Vertical2 = y + r;

		if(Horizontal1 >=0 && Horizontal2 <= W
				&& Vertical1 >=0 && Vertical2 <=H){
			//System.out.println("はい");
			System.out.println("Yes");
		}else{
			//System.out.println("いいえ");
			System.out.println("No");
		}
	}

}
