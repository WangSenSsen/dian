package fqd.com.fanqingdian20181220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetWork {
    public static String getJson(String urlstring){
        try {
            URL url = new URL(urlstring);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            //获取返回请求吗
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader reader=new BufferedReader(streamReader);
                //拼接字符串
                String str1="";
                String str2="";
                while ((str1=reader.readLine())!=null){
                    str2+=str1;
                }
                return str2;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
