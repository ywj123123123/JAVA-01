package com.example.geek.netty.httptest;


/**
 * @标题: HttpClientDemo.java
 * @包名： com.yintech.crm.voicecall.uitl.test
 * @功能描述：TODO
 * @作者： wenjie.ye
 * @创建时间： 2021年1月21日 下午8:10:51
 * @version v1.0
 */

 

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @类描述：
 * @项目名称：voice-call-server
 * @类名称：HttpClientDemo
 * @创建人：wenjie.ye
 * @创建时间：2021年1月21日下午8:10:51
 * @修改人：wenjie.ye
 * @修改时间：2021年1月21日下午8:10:51
 * @修改备注：
 * @version v1.0
 */

public class HttpClientDemo {

	public static void main(String[] args) {
	       // 创建Httpclient对象  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        String resultString = "";  
        CloseableHttpResponse response = null;  
        try {  
            // 创建uri  
            URIBuilder builder = new URIBuilder("http://127.0.0.1:8888");  
            URI uri = builder.build();  
            // 创建http GET请求  
            HttpGet httpGet = new HttpGet(uri);  
            // 执行请求  
            response = httpclient.execute(httpGet);  
            // 判断返回状态是否为200  
            HttpEntity entity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == 200&&entity!=null) {  
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (response != null) {  
                    response.close();  
                }  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        
        System.out.println("===HttpClientDemo=="+resultString+"=====");
	}
}
