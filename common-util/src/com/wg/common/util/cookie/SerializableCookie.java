package com.wg.common.util.cookie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
/**
 * cookie读写工具类
 * 
 * @author JUNLONG CHAN
 * @date 2015年3月31日
 * @version 1.0
 * 
 */
public class SerializableCookie implements Serializable {
	
	private static final long serialVersionUID = 2149431919672990643L;
	private transient final Cookie cookie;  
    private transient BasicClientCookie clientCookie;  
  
    public SerializableCookie(Cookie cookie) {  
        this.cookie = cookie;  
    }  
  
    public Cookie getCookie() {  
        Cookie bestCookie = cookie;  
        if (clientCookie != null) {  
            bestCookie = clientCookie;  
        }  
        return bestCookie;  
    }  
  
    private void writeObject(ObjectOutputStream out) throws IOException {  
        out.writeObject(cookie.getName());  
        out.writeObject(cookie.getValue());  
        out.writeObject(cookie.getComment());  
        out.writeObject(cookie.getDomain());  
        out.writeObject(cookie.getExpiryDate());  
        out.writeObject(cookie.getPath());  
        out.writeInt(cookie.getVersion());  
        out.writeBoolean(cookie.isSecure());  
    }  
  
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {  
        String name = (String) in.readObject();  
        String value = (String) in.readObject();  
        clientCookie = new BasicClientCookie(name, value);  
        clientCookie.setComment((String) in.readObject());  
        clientCookie.setDomain((String) in.readObject());  
        clientCookie.setExpiryDate((Date) in.readObject());  
        clientCookie.setPath((String) in.readObject());  
        clientCookie.setVersion(in.readInt());  
        clientCookie.setSecure(in.readBoolean());  
    }  
}
