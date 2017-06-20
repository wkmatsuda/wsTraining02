package jp.co.ws.training.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * クラスの中に定義したクラス。
 * LinkedHashMapを継承して、リストの数の上限を5にしたクラスを新たに定義している。
 * LinkedHashMapを継承することにより、その機能をカスタマイズして使えるクラスLinkedHashMap5を定義する。
 *
 * ※Javaの場合、継承（extends）で指定できるクラスは１つだけ。
 *   Interfaceは複数指定できる。
 */
public class LinkedHashMap5<K,V> extends LinkedHashMap<K,V>{

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
