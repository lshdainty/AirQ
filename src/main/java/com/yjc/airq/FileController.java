package com.yjc.airq;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.yjc.airq.service.UploadService;

import lombok.AllArgsConstructor;

/**
 * 파일을 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class FileController {

	
    UploadService uploadService;

	/**
     * 이미지 업로드
     * @param request
     * @param response
     * @param upload
     */
    @RequestMapping(value = "imageUpload", method = RequestMethod.POST)
    public void communityImageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) {
 
    	String uuid=UUID.randomUUID().toString().replace("-", "");
    	JsonObject json = new JsonObject();
    	JsonObject uploadVO=new JsonObject();
        OutputStream out = null;
        PrintWriter printWriter = null;
        
        
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
 
        try{
        	// 파일이름 받기
            String fileName = upload.getOriginalFilename();
            
            //파일 읽기
            byte[] bytes = upload.getBytes();
            // 업로드 경로 설정
            String uploadPath = request.getServletContext().getRealPath("/resources/uploadFile/images");
            // 파일 경로 생성
            File uploadFile = new File(uploadPath);
            
            
            if(!uploadFile.exists())
            	uploadFile.mkdirs();
            
            uploadPath=uploadPath+"/"+fileName;
            // 파일업로드
            out = new FileOutputStream(new File(uploadPath));
            out.write(bytes);
            
            
            
            printWriter = response.getWriter();
            String fileUrl = "resources/uploadFile/images/"+fileName;
            
            json.addProperty("uploaded",1);
            json.addProperty("fileName",fileName);
            json.addProperty("url",fileUrl);
            
            printWriter.println(json);
            
    		/* 업로드 코드 생성 시작 */
//    		Date today = new Date();
//    		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
//    		String day = date.format(today);
//    		Timestamp upload_date = new Timestamp(System.currentTimeMillis());
//    		int random=(int)(Math.random()*10000);
//    		String upload_code="ul"+day+random;
    		/* 업로드 코드 생성 완료 */
            
            
        }catch(IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
    }

}
