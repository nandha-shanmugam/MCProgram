/**
 * 
 */
package com.tiremgmt.tiremgmtcommon.utils;

import java.sql.Timestamp;

/**
 * @author javacloudmc275
 *
 */
public class HelperUtils {

	public static Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());
	}
}
