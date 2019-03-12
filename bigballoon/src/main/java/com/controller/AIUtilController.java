package com.controller;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.support.GenericTypeAwareAutowireCandidateResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.speech.AipSpeech;


import net.sf.json.JSONArray;
import sun.misc.BASE64Decoder;



@Controller
@RequestMapping("/ai")
public class AIUtilController {
	
	private static Logger log = Logger.getLogger(LoginController.class);
	
	//语音识别
	public static final String YUYIN_APP_ID = "15351219";
    public static final String YUYIN_API_KEY = "oM3sy4VW7dMiqo7E6bwN7pwR";
    public static final String YUYIN_SECRET_KEY = "eW1nvKjXLTSf4svioIEr9qG072z4CBvX";
	AipSpeech speech_client = new AipSpeech(YUYIN_APP_ID, YUYIN_API_KEY, YUYIN_SECRET_KEY);
	
	//图片识别
	public static final String TUPIAN_APP_ID = "15588156";
    public static final String TUPIAN_API_KEY = "u4QrGDjT89O8dSmhdGhQCo53";
    public static final String TUPIAN_SECRET_KEY = "wseoiTwSl80hQGmv4DZqphC7tFu6ECyL";
    AipImageClassify  pic_client = new AipImageClassify(TUPIAN_APP_ID, TUPIAN_API_KEY, TUPIAN_SECRET_KEY);
    
    //人体识别
    public static final String RENTI_APP_ID = "15720857";
    public static final String RENTI_API_KEY = "oKtwHMCB3poUTVTkPlA4U22M";
    public static final String RENTI_SECRET_KEY = "14PFTEOznWKLziW9WojwILcPDN0xlwMr";
    AipBodyAnalysis body_client = new AipBodyAnalysis(RENTI_APP_ID, RENTI_API_KEY, RENTI_SECRET_KEY);

    //文字识别
    public static final String WENZI_APP_ID = "15728614";
    public static final String WENZI_API_KEY = "k9R4fNhh9WudGEVQ1U93jf9d";
    public static final String WENZI_SECRET_KEY = "WHPWZzG7rKzCnkBBv2jNRmXdEUK2EI2k";
    AipOcr ocr_client = new AipOcr(WENZI_APP_ID,WENZI_API_KEY,WENZI_SECRET_KEY);
    
    //变量
    public static List<String> dishMenu = new ArrayList<String>();
    public static List<String> imgUrl = new ArrayList<String>();
   
    
	/**
	 * 语音识别
	 * @param request
	 * @return 
	 * @throws Exception 
	 */
    @ResponseBody
	@RequestMapping("/speechRecognition")
	public void speechRecognition(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("---------进入speechRecognition函数---------");
		
//		response.setContentType("text/html;charset=utf-8");          
//	    response.setHeader("Access-Control-Allow-Origin", "*");  
//	    response.setHeader("Access-Control-Allow-Methods", "GET,POST"); 
	        
		MultipartFile  file = ((MultipartHttpServletRequest) request).getFile("speechFile");
		byte[] pcmBytes = mp3Convertpcm(file.getInputStream());
	
		JSONObject res = speech_client.asr(pcmBytes, "pcm", 16000, null);
		String result = res.getJSONArray("result").get(0).toString().split(",")[0];
		Writer out = response.getWriter(); 
		out.write(result);
		out.flush();   
	}

	private byte[] mp3Convertpcm(InputStream mp3Stream) throws Exception {
		AudioInputStream mp3audioStream = AudioSystem.getAudioInputStream(mp3Stream);
		AudioInputStream pcmaudioStream = AudioSystem.getAudioInputStream(AudioFormat.Encoding.PCM_SIGNED,mp3audioStream);
		byte[] pcmBytes = IOUtils.toByteArray(pcmaudioStream);
		pcmaudioStream.close();
	    mp3audioStream.close();
		return pcmBytes;
	}
	
	/**
	 * 上传菜品图片
	 * @param jsonPic
	 */
	@ResponseBody
	@RequestMapping(value="uploadDish")
	public static String uploadDish(HttpServletRequest request,String jsonStr) { 
		System.out.println("进入到了uploadDish函数");
	
		JSONArray jsonArray= JSONArray.fromObject(jsonStr);
		
		for(int i=0; i<jsonArray.size(); i++) {
			net.sf.json.JSONObject jsonObj = (net.sf.json.JSONObject)jsonArray.get(i);
			String name = (String)jsonObj.get("name");
			String base64 = (String)jsonObj.get("base64");
			String imgStr =  base64.substring(base64.indexOf(",")+1);
			
			String savepath = "/Users/a/study/qqfiles/10th fwwb/上传菜品/"+name;
			
			@SuppressWarnings("restriction")
			BASE64Decoder decoder = new BASE64Decoder(); 
			try {
				byte[] b = decoder.decodeBuffer(imgStr);
//				for(int j=0;j<b.length;++j){
//					if( b[j]<0 ) {
//						b[j]+=256;
//					}
//				}
				OutputStream out = new FileOutputStream(savepath);
				out.write(b); 
				out.flush(); 
				out.close(); 
			}catch (Exception e){
				
			}
			dishMenu.add(savepath);
			imgUrl.add("/res/images/dish/"+name);
		}
		return null;
	}
	
	/**
	 * 菜品识别
	 * @param request
	 * @throws Exception 
	 */
    @ResponseBody
    @RequestMapping("/dishRecognition")
    public JSONArray dishRecognition(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	System.out.println("进入到了dishRecognition函数");
    	
    	HashMap<String, String> options = new HashMap<String, String>();
    	options.put("top_num", "1");
    	options.put("filter_threshold", "0.5");
    	
    	JSONArray ret = new JSONArray();
    	for(int i=0; i<dishMenu.size(); i++) {
    		String dishName =  dishMenu.get(i);
    		
    		JSONObject res = pic_client.dishDetect(dishName,options);
    		JSONObject jsonObj = res.getJSONArray("result").getJSONObject(0);
    	
    		net.sf.json.JSONObject temp = new net.sf.json.JSONObject();
    		
    		if( jsonObj.get("calorie").toString().equals("-1") ) {
    			temp.accumulate("name", "菜品暂时无法识别");
    			temp.accumulate("calorie","0");
    			temp.accumulate("imgUrl", imgUrl.get(i));
    			ret.add(temp);
    		}else {
    			temp.accumulate("name", jsonObj.get("name").toString());
    			temp.accumulate("calorie", jsonObj.get("calorie").toString());
    			temp.accumulate("imgUrl", imgUrl.get(i));
    			ret.add(temp);
    		}
    	}
    	return ret;
    }
  
	/**
	 * 菜品界面
	 */
    @RequestMapping("/dish/list")
    public String list(HttpServletRequest request) {
    	return "views/ai/dish";
    }
    
    /**
	 * 人流量统计
	 */
    @ResponseBody
    @RequestMapping("/bodyNum")
    public int[] bodyNum() {
    	System.out.println("进入到了bodyNum函数");
    	
    	HashMap<String, String> options = new HashMap<String, String>();
    	options.put("show", "false");
    	
    	String prefix = "/Users/a/study/qqfiles/10thfwwb/人流量图/";
    	String[] bodyPic = {prefix+"A.jpg",prefix+"B.jpg",prefix+"C.jpg",prefix+"D.jpg"};
    	int[] ret = new int[bodyPic.length];
    	for(int i=0; i<bodyPic.length; i++) { 
    		
    		JSONObject res = body_client.bodyNum(bodyPic[i], options);
    		
    		ret[i] = (Integer)res.get("person_num");
    	}
    	return ret;
    }
    
    /**
	 * 生僻字识别
     * @throws IOException 
	 */
    @ResponseBody
    @RequestMapping(value="/ocrRecognition",produces="text/html;charset=UTF-8") 
    public String ocrRecognition(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	System.out.println("进入到了ocrRecognition函数");
    	
    	MultipartFile  ocrPic = ((MultipartHttpServletRequest) request).getFile("ocrPic");
    	
    	byte[] file = ocrPic.getBytes();
    	JSONObject res = ocr_client.basicAccurateGeneral(file, new HashMap<String, String>());
    	org.json.JSONArray resArray =  res.getJSONArray("words_result");
    
    	String ocrRet = "";
    	
    	for(int i=0; i<resArray.length(); i++) {
    		JSONObject jsonOcr = res.getJSONArray("words_result").getJSONObject(i);
    		if( i == resArray.length()-1 ) {
    			ocrRet += jsonOcr.getString("words");
    		}else {
    			ocrRet += jsonOcr.getString("words") + ",";
    		}	
    	}
    	 	
    	System.out.println("识别结果: " + ocrRet);
    	
    	return ocrRet;
    }
	
}
