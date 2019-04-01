package com.yjc.airq;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

import lombok.AllArgsConstructor;

/**
 * 파일을 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class FileController {

	/**
     * 이미지 업로드
     * @param request
     * @param response
     * @param upload
     */
    @RequestMapping(value = "imageUpload", method = RequestMethod.POST)
    public void communityImageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) {
 
    	JsonObject json = new JsonObject();
        OutputStream out = null;
        PrintWriter printWriter = null;
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
 
        try{
 
            String fileName = upload.getOriginalFilename();
            byte[] bytes = upload.getBytes();
            String uploadPath = request.getServletContext().getRealPath("/img");
            File uploadFile = new File(uploadPath);
            System.out.println("UploadFile:"+uploadFile);
            
            
            if(!uploadFile.exists())
            	uploadFile.mkdirs();
            
            uploadPath=uploadPath+"/"+fileName;
            
            
            System.out.println("UploadPath:"+uploadPath);
            
            
            out = new FileOutputStream(new File(uploadPath));
            out.write(bytes);
            
            
            
            printWriter = response.getWriter();
            
            String fileUrl = request.getContextPath()+"/resources/uploadFile/images/"+fileName;
            System.out.println("ContextPath:"+request.getContextPath());
            
            json.addProperty("uploaded",1);
            json.addProperty("fileName",fileName);
            json.addProperty("url",fileUrl);
            
            
            System.out.println("JSON:"+json);
            System.out.println("FileURL:"+fileUrl);
            printWriter.println(json);
            printWriter.flush();
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
 
        return ;
    }

}
