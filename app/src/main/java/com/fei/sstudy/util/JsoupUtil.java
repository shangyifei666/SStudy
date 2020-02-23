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

    public Student getStudent(String url){
        this.url = url;
        Student student = Student.getInstance();
        Document document = getDocument();
        Log.d("doc", String.valueOf(document));
        /**
         * todo 假如cookie过期的处理 处理
         */
        String name = document.select("div[id=col_xm]").first().text();
        String college = document.select("div[id=col_jg_id]").first().text();
        student.setName(name);
        student.setCollege(college);
        Log.d("name",name);
        Log.d("college",college);

        return student;
    }

    private Document getDocument(){
        try {
            Connection.Response  response= null;
                response = Jsoup.connect(url)
                        .cookies(getCookie())
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
