package jp.co.ws.training.aizuonline;


/**
 * ３つの整数を読み込み、それらを値が小さい順に並べて出力するプログラムを作成して下さい。
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_2_C
 * Sample Input
 * 3 8 1
 * Sample Output
 * 1 3 8
 *
 *
 */
//aizu online に登録するとコンパイルエラーになるのでアクセス修飾子はつけない

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Aoj_1_2_c {

    public static void main(String[] args) {

        try {
            //標準出力から1行入力する方法。プログラムが実行されると入力待ちになるので、
            //コンソールで"3 8 1" と入力しエンターを押す
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputData;
            //入力された文字列がinputDataに登録される。
            inputData = reader.readLine();
            String[] strArray = inputData.split(" ");

            //ソート用のListに格納
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<strArray.length;i++){
                list.add(Integer.valueOf(strArray[i]));
            }
            //ソート実行
            Collections.sort(list);

            //出力
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
