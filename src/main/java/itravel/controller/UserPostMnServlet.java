package itravel.controller;

import com.google.gson.Gson;
import itravel.model.Data;
import itravel.model.DataFactory;
import itravel.model.Post;
import itravel.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UserPostMnServlet")
public class UserPostMnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //check isLogged - no need to check because client already check
        // if(isLogged(request, response)== false)
        //    return;
        System.out.println("do post request");
        Data data = DataFactory.getInstance();
        String cmdType = request.getParameter("cmdType");
        String userID = request.getParameter("userID");
        System.out.println(cmdType+"command type");
        System.out.println(userID+"USer ID get");
        System.out.println("init: post ...... loaddinggggg!!!!!");
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
        // String userId = user.getId();
        // System.out.println(user.getId());

        //check
        if (cmdType.equals("init")) {
            doLoadInitPost(data, request, response);

            System.out.println("init: post ...... loaddinggggg!!!!!");
//            HttpSession session = request.getSession();
//            String userId = (String) session.getAttribute("userId");
//            System.out.println(userId);
            // send to client
//            String respJson = new Gson().toJson(data.findPostsByUserId(userID));
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write(respJson);
        }
        else if(cmdType.equals("add")){
            doAddPost(data, request, response);
        }
        else if(cmdType.equals("upd")){
            doUpdPost(data, request, response);
        }
        else if(cmdType.equals("del")){
            doDelPost(data, request, response);
        }
//        else if(cmdType.equals("getPostList")){
//            getUserPostList(data, request, response);
//        }
        else if(cmdType.equals("getPosts")){
            System.out.println("get posts ");
            // getPostList(data, request, response);
            doLoadInitPost(data, request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void doLoadInitPost(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        sendToClient(data, request, response);
    }

    public void doAddPost(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Get data from parameter
        //String id = request.getParameter("id");

        String userId = request.getParameter("userId");
        System.out.println(userId);
        String image = request.getParameter("image");
        System.out.println(image);
        String title = request.getParameter("title");
        System.out.println(title);
        String content = request.getParameter("content");
        System.out.println(content);
        String category = request.getParameter("category");
        System.out.println(category);
        String tags = request.getParameter("tags");
        System.out.println(tags);
        String time = request.getParameter("time");
        String location = request.getParameter("location");

        //if post not exist, add new Post
        int id = 0;
        System.out.println(data.getPostList());
        System.out.println(data.findPostsByUserId(userId).size());
        //if notification is tun on

//        if (data.findPostsByUserId(userId).size() == 0){
//            count = data.getPostList().size();
//            //data.addPost(String.valueOf(count), userId, image, title, content, category, tags, LocalDate.now().toString());
//            Post post = new Post(String.valueOf(count), userId, image, title, content, category, tags, LocalDate.now().toString());
//            updatePostSession(request, post, true);
//        }
//        else {
        System.out.println("test - done");
        // id = data.getPostList().size() +1;
        id = data.getMaxPostId() +1;
        System.out.println("test - done............. dddddd" + id);

        String strID 	= String.format("d", id);

        data.addPost(strID, userId, image, title, content, category, tags, LocalDate.now().toString(), location);
        Post post = new Post(strID, userId, image, title, content, category, tags, time, location);
        updatePostSession(request, post, true);

        //       }
        System.out.println(id);


        //uploadImage(request, response);
        sendToClient(data, request, response);
        return;

    }
    public void doUpdPost(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        System.out.println("test result for update");
        String userId = request.getParameter("userId");
        System.out.println(userId);
        String image = request.getParameter("image");
        System.out.println(image);
        String title = request.getParameter("title");
        System.out.println(title);
        String content = request.getParameter("content");
        System.out.println(content);
        String category = request.getParameter("category");
        System.out.println(category);
        String tags = request.getParameter("tags");
        System.out.println(tags);
        String time = request.getParameter("time");
        String location = request.getParameter("location");


        //update post
        data.updPost(id, userId, image, title, content, category, tags, time, location);
        updatePostSession(request, data.getPost(id), true);
        //send to client
        sendToClient(data, request, response);
    }
    public void doDelPost(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //get Data from parameter
        String id = request.getParameter("id");
        //Delete post
        data.delPost(id);
        //send to client;
        sendToClient(data, request, response);
    }
    public void sendToClient(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String respJson = new Gson().toJson(data.getPostsReverse());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(respJson);
    }

    public void updatePostSession(HttpServletRequest req, Post post , Boolean isLogged) {
        HttpSession session = req.getSession();
        session.setAttribute("post", post);
        System.out.println("Updated session: " + post.getId() + ", " + post.getTags() + ", " +post.getCategory()
                + ", "+ post.getTitle()+", "+ post.getContent()+", "+ post.getId()+", "+ post.getUserId()
                +", "+ post.getImage()+ ", "+post.getTime()+", "+isLogged);
    }
}

