package com.wg.daonile.model.guest.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Looper;

import com.wg.common.util.cookie.PersistentCookieStore;
import com.wg.common.util.security.Base64Utils;
import com.wg.common.util.security.RSAUtils;
import com.wg.daonile.R;
import com.wg.daonile.app.DaoNiLeApp;
import com.wg.daonile.grim.constant.AppConstant;
import com.wg.daonile.grim.utils.LogUtil;
import com.wg.daonile.model.guest.IGuestInteractor;
import com.wg.daonile.model.guest.IGuestRequestCallback;

/**
 * 
 * @author JUNLONG CHAN
 * @date 2015-4-15
 * @version 1.0
 * 
 */
public class GuestInteractor implements IGuestInteractor {
	private String mToken;
	private PersistentCookieStore mPersistentCookieStore;
	private DefaultHttpClient mHttpClient;

	@Override
	public void getPublicKeyListener(final IGuestRequestCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					mPersistentCookieStore = DaoNiLeApp.getPersistentCookie();
					mHttpClient = new DefaultHttpClient();
					ClientConnectionManager mgr = mHttpClient.getConnectionManager();
					HttpParams params = mHttpClient.getParams();
					mHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(params, mgr.getSchemeRegistry()), params);
					String serverURL = AppConstant.GET_PUBLICKEY;
					HttpGet httpRequest = new HttpGet(serverURL);// 建立http get联机
					HttpResponse httpResponse = mHttpClient.execute(httpRequest);// 发出http请求
					if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						CookieStore mCookieStore = mHttpClient.getCookieStore();
						List<Cookie> cookies = mCookieStore.getCookies();
						for (int i = 0; i < cookies.size(); i++) {
							// 这里是读取Cookie['PHPSESSID']的值存在静态变量中，保证每次都是同一个值
							if ("token".equals(cookies.get(i).getName())) {
								mToken = cookies.get(i).getValue();
							}
						}
						String result = EntityUtils.toString(httpResponse.getEntity());// 获取相应的字符串
						JSONObject o = new JSONObject(result);
						String publicKey = o.getString("publicKey");
						// 明文
						String ming = "admin";
						RSAPublicKey pubKey = (RSAPublicKey) RSAUtils.loadPublicKey(publicKey);
						// 加密后的密文
						byte[] encryptByte = RSAUtils.encryptData(ming.getBytes(), pubKey);
						// 为了方便观察吧加密后的数据用base64加密转一下，要不然看起来是乱码,所以解密是也是要用Base64先转换
						String pwd = Base64Utils.encode(encryptByte);
						Looper.prepare();
						callback.getPublicKeySuccess(pwd);
						Looper.loop();
					}
				} catch (ConnectException e) {
					Looper.prepare();
					callback.getPublicKeyError(DaoNiLeApp.getAppInstance().getResources().getString(R.string.tt_connect_error));
					Looper.loop();
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (InvalidKeySpecException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	private String mPublicKey;
	private String mAccount;

	@Override
	public void onServerLoginListener(String key, final IGuestRequestCallback callback) {
		mPublicKey = key;
		mAccount = "admin";
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					String uriAPI = AppConstant.GUEST_LOGIN; // 声明网址字符串
					HttpPost httpRequest = new HttpPost(uriAPI); // 建立HTTP
					List<NameValuePair> params = new ArrayList<NameValuePair>(); // Post运作传送变量必须用NameValuePair[]数组储存
					params.add(new BasicNameValuePair("username", mAccount));
					params.add(new BasicNameValuePair("password", mPublicKey));
					httpRequest.addHeader("token", mToken);
					httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8)); // 发出http请求
					HttpResponse httpResponse = mHttpClient.execute(httpRequest); // 取得http响应
					if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						CookieStore mCookieStore = mHttpClient.getCookieStore();
						List<Cookie> cookies = mCookieStore.getCookies();
						for (int i = 0; i < cookies.size(); i++) {
							mPersistentCookieStore.addCookie(cookies.get(i));
						}
						String strResult = EntityUtils.toString(httpResponse.getEntity());
						LogUtil.i(strResult);
						Looper.prepare();
						callback.loginServerSuccess("");
						Looper.loop();
					}
				} catch (ConnectException ex) {
					Looper.prepare();
					callback.loginServerSuccess(DaoNiLeApp.getAppInstance().getResources().getString(R.string.tt_connect_error));
					Looper.loop();
					ex.printStackTrace();
				} catch (UnsupportedEncodingException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}).start();
	}
}
