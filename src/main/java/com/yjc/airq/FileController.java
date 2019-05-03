package com.yjc.airq;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.yjc.airq.domain.UploadVO;
import com.yjc.airq.service.UploadService;

import lombok.AllArgsConstructor;
/**
 * 파일을 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class FileController {

	
    UploadService uploadService;
    public ArrayList<UploadVO> files;
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
        OutputStream out = null;
        PrintWriter printWriter = null;
        UploadVO uploadDB = new UploadVO();
        
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        try{
        	String original_name = upload.getOriginalFilename();
            String file_name = uuid+original_name;
            String uploadPath = request.getServletContext().getRealPath("/resources/uploadFile/images");
            byte[] bytes = upload.getBytes();
            File uploadFile = new File(uploadPath);
            if(!uploadFile.exists())
            	uploadFile.mkdirs();
            
            uploadPath=uploadPath+"/"+file_name;
            // 파일업로드
            out = new FileOutputStream(new File(uploadPath));
            out.write(bytes);
            
            printWriter = response.getWriter();
            String fileUrl = "resources/uploadFile/images/"+file_name;
            
            json.addProperty("uploaded",1);
            json.addProperty("fileName",file_name);
            json.addProperty("url",fileUrl);
            
            printWriter.println(json);
            
//    		/* 업로드 코드 생성 시작 */
//    		Date today = new Date();
//    		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
//    		String day = date.format(today);
//    		Timestamp upload_date = new Timestamp(System.currentTimeMillis());
//    		String random=String.format("%04d",(int)(Math.random()*10000));
//    		String upload_code="ul"+day+random;
//    		/* 업로드 코드 생성 완료 */
//            
//    		uploadDB.setUpload_code(upload_code);
//    		uploadDB.setOriginal_name(original_name);
//    		uploadDB.setFile_name(file_name);
//            uploadDB.setUpload_date(upload_date);
//            files.add(uploadDB);
//            System.out.println(files);
            
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
    
    
    @RequestMapping(value = "fileInitialization/{data}", method = RequestMethod.GET)
    public String fileCount(@PathVariable String data, HttpServletRequest request) {
    	files.clear();
    	if(data.equals("s")) {
    		return "connect/productWrite";
    	}else {
    		return "community/postWriteForm";
    	}
    }
    
    @RequestMapping(value = "fileInsert", method = RequestMethod.GET)
    public String fileUpdate(HttpServletRequest request) {
    	Iterator<UploadVO> it = files.iterator();
    	String product_code=request.getParameter("product_code");
    	String post_code=request.getParameter("post_code");
    	System.out.println(post_code);
    	if(product_code==null)
    		product_code="";
    	if(post_code==null)
    		post_code="";
    	
    	UploadVO uploadVO;
    	while(it.hasNext()) {
    		uploadVO=it.next();
    		
    		uploadVO.setProduct_code(product_code);
    		uploadVO.setPost_code(post_code);
    		uploadService.imgUpload(uploadVO);
    		
    	}
    	
		String board_type = (String)request.getSession().getAttribute("board_type");
		String board_code = (String)request.getSession().getAttribute("board_code");
		if(board_type=="table")
			return "redirect: /tableBoardMain?board_code="+board_code+"&pagenum=1";
		else
			return "redirect: /thumbnailBoardMain?board_code="+board_code+"&pagenum=1";
    }
   
}
