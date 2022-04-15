package org.example.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/3/24 23:41
 * @description：
 * @modified By：
 * @version: $
 */
public class ProjectUtils {
    private static Map<String,String>map = new HashMap<>();
    static {
        map.put("草稿","0");
        map.put("作废","-1");
        map.put("推进中","1");
        map.put("签约","2");
        map.put("核销 ","9");
        map.put("0","草稿");
        map.put("-1","作废");
        map.put("1","推进中");
        map.put("2","签约");
        map.put("9","核销");
        map.put("内贸直租","PROD_TYPE_1");
        map.put("外贸直租","PROD_TYPE_2");
        map.put("回租","PROD_TYPE_3");
        map.put("委贷","PROD_TYPE_4");
        map.put("证券类基金","PROD_TYPE_5");

    }
     public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static  String getCode(String name){
        return map.get(name);
    }
    public static String ReadAsChars(HttpServletRequest request)
    {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
