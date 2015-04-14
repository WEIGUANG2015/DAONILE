package com.wg.daonile.grim.utils;

import java.io.InputStream;
import java.util.Properties;

import com.wg.daonile.app.DaoNiLeApp;

import android.content.res.AssetManager;

public class ConfigFile {
	 private static Properties prop = null;  
	    static {   
	        try {   
	            prop = new Properties();
	            AssetManager am = DaoNiLeApp.getAppInstance().getAssets();
	            InputStream is = am.open("config.properties");
	            prop.load(is);    
	         
	        }catch (Exception e) {   
	            e.printStackTrace();
	        }   
	    }
	    
	    public static boolean isDebug(){
	        return Boolean.valueOf(prop.get("is_debug").toString()).booleanValue();
	    }
	    
	    public static boolean isCrashhandlerOpen(){
	        return Boolean.valueOf(prop.get("is_crashhandler_open").toString()).booleanValue();
	    }
	}
