package jp.co.ws.training.common;

import java.util.Calendar;

/**
 * 日付関連の共通処理
 *
 */
public class DateUtil {

	/**
	 * yyyy/mm/dd書式の日付を返す
	 * @param cal
	 * @return
	 */
	public static String getDateString(Calendar cal) {
		StringBuilder sbDateinfo = new StringBuilder();
	    sbDateinfo.append(cal.get(Calendar.YEAR)).append("/").append(cal.get(Calendar.MONTH)+1).append("/").append(cal.get(Calendar.DATE));

		return sbDateinfo.toString();
	}


}
