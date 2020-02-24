package com.fei.sstudy.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.util.Log;

import com.fei.sstudy.entity.Student;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsoupUtil{
    private String url;
    private Context context;


    public JsoupUtil(Context context){
        this.context = context;
    }

    /**
     *
     * @param url 访问的地址
     * @return 是否请求成功（取决于cookie是否失效）
     */
    public Boolean getStudent(String url){
        Log.d("JsoupUtil","getStudent url: " + url);
        this.url = url;
        Student student = Student.getInstance();
        String name = "未登陆";
        String college = "";

        Document document = getDocument();
        Log.d("doc", String.valueOf(document));

        if (document==null){
            //cookie已过期
            return false;
        }
        Elements eName = document.select("div[id=col_xm]");
        if (eName.first()!=null){
            name = eName.first().text();
        }
        Elements eCollege = document.select("div[id=col_jg_id]");
        if (eCollege.first()!=null){
             college = eCollege.first().text();
        }
        student.setName(name);
        student.setCollege(college);
        Log.d("name",name);
        Log.d("college",college);

        return true;
    }

    private Document getDocument(){
        try {
            Connection.Response  response= null;
                response = Jsoup.connect(url)
                        .cookies(getCookie())
                        .timeout(10000)
                        .execute();
                return response.parse();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    private Map<String,String> getCookie(){
        Map<String,String> cookie= new HashMap<>();
        SharedPreferences sharedPreferences= context.getSharedPreferences("SPcookie", Context.MODE_PRIVATE);
        String jw = sharedPreferences.getString("jw","");
        String JSESSIONID = sharedPreferences.getString("JSESSIONID","");
        cookie.put("jw",jw);
        cookie.put("JSESSIONID",JSESSIONID);
        Log.d("cookei",cookie.toString());

        return cookie;
    }

}
