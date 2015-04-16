package com.wg.common.util.io;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 输入输出流操作工具类
 * 
 * @author JUNLONG CHAN
 * @date 2015年3月31日
 * @lastModifyDate
 * @version 1.0
 * 
 */
public class StreamTool {
	/**
	 * 读取输入流数据
	 * 
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public static byte[] readStream(InputStream is) throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		byte[] buffer = new byte[2048];
		int len = 0;
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		is.close();
		return os.toByteArray();
	}
}
