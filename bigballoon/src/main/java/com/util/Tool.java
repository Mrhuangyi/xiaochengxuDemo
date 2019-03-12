package com.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class Tool {

	private static Logger log = Logger.getLogger(Tool.class);
	
	//获取带分时间
	public static String getyyyyMMddHHmm(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(d);
	}
	//获取带毫秒时间
	public static String getyyyyMMddHHmmss(){
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(d);
	}
	//获取带毫秒时间戳
	public static String getyyyyMMddHHmmssSSS(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(d);
	}
	//获取日期
	public static String getyyyyMMdd(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(d);
	}
	//获取日期
	public static String getyyyy_MM_dd(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}
	
	//前一天
	public static String getq_yyyy_MM_dd(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long l=System.currentTimeMillis()-1000*60*60*24;
		return sdf.format(l);
	}
	
	//前一月
	public static String getqy_yyyy_MM_dd(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long l=System.currentTimeMillis()-1000*60*60*24*30;
		return sdf.format(l);
	}
	
	//获取10000-100000的随机数
	public static int getRandom(){
		int max=100000;
        int min=10000;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
	}
	
	
	//获取ip--暂时不使用
	public static String getIps(HttpServletRequest request)
	  {
	    String ip = request.getHeader("x-forwarded-for");
	    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
	      ip = request.getHeader("Proxy-Client-IP");
	    }
	    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
	      ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
	      ip = request.getRemoteAddr();
	    }
	    if (ip.equals("127.0.0.1"))
	    {
	      log.error("获取客户ip失败：" + ip);
	      ip = getUUID();
	    }
	    return ip;
	  }
	//获取ip
	public  static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Pounded-For");
		if (ip != null) {
			return ip;
		}

		ip = request.getHeader("x-forwarded-for");

		if (ip == null) {
			ip = request.getRemoteAddr();
			if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
				InetAddress address;
				try {
					address = InetAddress.getLocalHost();
					ip = address.getHostAddress();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}

			}
			return ip;
		} else {
			StringTokenizer tokenizer = new StringTokenizer(ip, ",");
			for (int i = 0; i < tokenizer.countTokens() - 1; i++) {
				tokenizer.nextElement();
			}

			ip = tokenizer.nextToken().trim();

			if (ip.equals("")) {
				ip = null;
			}
		}

		if (ip == null) {
			ip = "0.0.0.0";
		}

		return ip;
	}
	//获取uuid
	public static String getUUID()
	  {
	    String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
	    return uuid;
	  }  
	
	 /** 
     * 对字符串md5加密(小写+字母) 
     * 
     * @param str 传入要加密的字符串 
     * @return  MD5加密后的字符串 
     */  
    public static String MD5(String str) {  
        try {  
            // 生成一个MD5加密计算摘要  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            // 计算md5函数  
            md.update(str.getBytes());  
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符  
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值  
            return new BigInteger(1, md.digest()).toString(16);  
        } catch (Exception e) {  
           e.printStackTrace();  
           return null;  
        }  
    }  
    
	public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
//            System.out.println(urlNameString);
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
	
	//百度插入文件后返回json的处理
	public static String updatebaiduresult(HttpServletRequest request,String result){
		Gson gson = new Gson();
		Map<String, String> map= gson.fromJson(result, Map.class);
		if(map!=null&&map.get("state")!=null&&"SUCCESS".equals(map.get("state"))){
			String url=map.get("url");
			url=url.replaceAll("/upload", "");
			StringBuffer requesturl = request.getRequestURL();  
			String tempContextUrl = requesturl.delete(requesturl.length() - request.getRequestURI().length(), requesturl.length()).append(request.getContextPath()).toString(); 
			url=tempContextUrl+"/file"+url;
			map.put("url", url);
			result=gson.toJson(map);
		}
		return result;
	}
	
}
