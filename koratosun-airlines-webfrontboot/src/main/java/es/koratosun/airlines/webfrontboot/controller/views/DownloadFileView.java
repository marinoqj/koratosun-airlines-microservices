package es.koratosun.airlines.webfrontboot.controller.views;

import java.util.Map;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class DownloadFileView extends AbstractView{
	
	
    protected void renderMergedOutputModel(Map model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        byte[] bytes = (byte[]) model.get("data");
        String contentType = (String) model.get("contentType");
        response.addHeader("Content-disposition","attachment; filename="+model.get("filename"));
        response.setContentType(contentType);
        response.setContentLength(bytes.length);
        ServletOutputStream out = response.getOutputStream();
        out.write(bytes);
        out.flush();

    }


}
