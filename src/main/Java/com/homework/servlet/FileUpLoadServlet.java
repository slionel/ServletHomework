package com.homework.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FileUpLoadServlet")
public class FileUpLoadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        servletFileUpload.setHeaderEncoding("UTF-8");
        servletFileUpload.setSizeMax(1024*1024*2);
        String savePath = "C:\\Users\\zsj55\\Desktop\\上传文件";
        try {
            List item = servletFileUpload.parseRequest(request);
            for(int i = 0; i < item.size(); i++){
                FileItem fileItem = (FileItem) item.get(i);
                System.out.println("文件名为="+fileItem.getName());
                if(fileItem.isFormField()){
                    System.out.println("这是一个普通文本表单字段");
                }

                else{
                    System.out.println("这是一个文件表单字段");
                }

                String fileName = System.currentTimeMillis()+fileItem.getName();
                fileItem.write(new File(savePath+File.separator+fileName));
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("index3.jsp");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
