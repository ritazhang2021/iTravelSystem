package itravel.controller;

import itravel.model.Data;
import itravel.model.DataFactory;
import itravel.model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
@WebServlet("/ImageUploadServlet")
public class ImageUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ImageUploadServlet() {
        // Do Nothing
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("homePage.jsp").forward(request, response);
        //doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Data data = DataFactory.getInstance();

        System.out.println("post image");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //String imageName = request.getParameter("imageName");

        // Getting File data
        Part part = request.getPart("imageUpload");

        // Getting Application Path
        String appPath = request.getServletContext().getRealPath("/");
        System.out.println("appPath");
        System.out.println(appPath);

        System.err.println(this.getClass().getResource("/").getPath());

        // File path where all files will be stored
        String imagePath = appPath + "resources/images/";
        System.out.println(imagePath);

        // Creates the file directory if it does not exists
        File fileDir = new File(imagePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        //Get Image Name
        System.out.println("b4 get imga file name");
        String imageName = part.getSubmittedFileName();

        System.out.println(imageName);
        System.out.println("after get imga file name");
        if(validateImage(imageName)){
            try{
                part.write(imagePath + File.separator + imageName);
                out.print("<img src=\"resources/images/"+imageName+"\" >");
            }catch (Exception ex) {
                out.print("<h1>"+ex.getMessage()+"</h1>");
            }
        }else{
            out.print("<h1>Invalid Image Format</h1>");
        }
        // imagePath;
        HttpSession session = request.getSession();
        Post item = (Post) session.getAttribute("post");
        String posId = item.getId();
        String imageUrl = "resources/images/"+imageName;
        data.getPost(posId).setImage(imageUrl);
        System.out.println("--------------- 54645656565: ---------- " + imageUrl+"test done");

    }

    //Validates uploaded file is Image or not
    private boolean validateImage(String imageName){
        String fileExt = imageName.substring(imageName.length()-3);
        if("jpg".equals(fileExt) || "png".equals(fileExt) || "gif".equals(fileExt))
            return true;

        return false;
    }

}
