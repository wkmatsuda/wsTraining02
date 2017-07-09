package jp.co.ws.training.aizuonline;


/**
 *
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_3_B
 * １つの整数 x を読み込み、それをそのまま出力するプログラムを作成して下さい。
 * @author wsKmatsuda
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Aoj_1_3_b {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputData;
            StringBuilder sb = new StringBuilder();
            int i = 0;
	        while(true){
	            i++;
	            inputData = reader.readLine();
	            if("0".equals(inputData)){
	            	break;
	            }else{
	            	sb.append("Case " + i + ": " + inputData + System.getProperty("line.separator"));
	            }
            }
	        //文字列に改行を追加済みなので出力時はprintを使う
            System.out.print(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
