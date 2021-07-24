package itravel.controller;

import com.google.gson.Gson;
import itravel.model.*;

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

@WebServlet("/UserPostServlet")
public class UserPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //check isLogged - no need to check because client already check
        // if(isLogged(request, response)== false)
        //    return;
        System.out.println("do post request");
        Data data = DataFactory.getInstance();
        String cmdType = request.getParameter("cmdType");
        //String userID = request.getParameter("userID");
        System.out.println(cmdType+"command type");
        //System.out.println(userID+"USer ID get");
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
        else if(cmdType.equals("loadNotify")){
            doLoadNotify(data, request, response);
        }
        else if(cmdType.equals("loadNotifyDetail")){
            doLoadNotifyDetail(data, request, response);
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

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("step1");

        Data data = DataFactory.getInstance();
//一个user like 一个post
        String postId = req.getParameter("postId");
        boolean shouldLike = Boolean.parseBoolean(req.getParameter("should_like"));

        //判断这个user以前有不有like过，like过就不执行，没like过，再执行
        //1.根据post id,找出这个post，再找出这个user
        //2.根据user查出post
        //3.如果user对这个post like过，不执行，没like过，再执行
        /* List<Post> posts = data.getPostList();
        Post post = data.getPost(postId);
        String userId = post.getUserId();
        User user = data.getUser(userId);
        System.out.println("step1");
       // List<Post> userPostList = user.getPosts();
        /*
        for(Post userPost : userPostList){
            if(postId.equals(userPost.getId())){
                if(!userPost.isLikeStatus()){
                    post.setLikeStatus(true);
                    System.out.println("step2 "+post.isLikeStatus());

                    post.setCountLike(1);//post中如果有userLikedList会好很多
                }
            }
        }
        *

        System.out.println("step3");
        post.setCountLike(1);
        int count = post.getCountLike();


*/
        String jsonString = new Gson().toJson(5);
        resp.setContentType("application/json");
        resp.getWriter().write(jsonString);
    }

    private void doLoadInitPost(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // List <Post> postList = data.getPostList();
        sendToClient(data, request, response);
    }

    public void doAddPost(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Get data from parameter
        //String id = request.getParameter("id");

        String userId = request.getParameter("userId");
        System.out.println(userId);
//        String image = request.getParameter("image");
//        System.out.println(image);
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
        String notification = request.getParameter("notification");
        Boolean bNotification = Boolean.parseBoolean(request.getParameter("notification"));
        //if post not exist, add new Post
        int id = 0;
        System.out.println(data.getPostList());
        System.out.println(data.findPostsByUserId(userId).size());

        System.out.println("test - done");
        // id = data.getPostList().size() +1;
        id = data.getMaxPostId() +1;
        System.out.println("test - done............. dddddd" + id);

        String strID 	= String.valueOf(id);

        data.addPost(strID, userId, "image", title, content, category, tags, LocalDate.now().toString(), location);
        // Update Notification in DB
        Post postInDb = data.getPost(strID);
        postInDb.setNotification(bNotification);

        Post post = new Post(strID, userId, "image", title, content, category, tags, time, location);
        post.setNotification(Boolean.getBoolean(notification));

        updatePostSession(request, post, true);
        /// Noti
        System.out.println(notification);
        //check if notification is enabled

        if (bNotification){
            // sendNotify2Follower
            data.sendNotify2Follower(strID, userId);
        }

        //       }
        System.out.println(id);

        checkHealthy(post, request, response);
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
        System.out.println(id);
        //Delete post
        data.delPost(id);
        //send to client;
        sendToClient(data, request, response);
    }

    public void doLoadNotify(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("in side doLoadNotifydoLoadNotifydoLoadNotifydoLoadNotify");
        // sendToClient
        String userId = getCurrentId(request, response);
        String respJson = new Gson().toJson(data.getNotifybyUser(userId));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(respJson);
    }

    public void doLoadNotifyDetail(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("in side doLoadNotifydoLoadNotifydoLoadNotifydoLoadNotify");
        // sendToClient
        String userId = getCurrentId(request, response);
        List listNotify = data.getNotifybyUser(userId);

        List list = data.getPostByNotify(listNotify);
        String respJson = new Gson().toJson(list);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(respJson);
    }

    public void sendToClient(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String respJson = new Gson().toJson(data.getPostsReverse());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(respJson);
    }
    public void sendToClientFollowerList(String userId, Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String respJson = new Gson().toJson(data.getFollowList().get(3));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(respJson);
    }

    public  Boolean isLogged(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        //write log
        String strType = (String) session.getAttribute("useType");
        String strId = (String) session.getAttribute("useID");
        Boolean logged = (Boolean) session.getAttribute("isLogged");
        System.out.println("Before update session: " + strId + ", " + strType + ", " + logged);
        if(logged == null || logged == false){
            System.out.println("User need login...!");
            //send redirect to login page
            response.sendRedirect("login.jsp");
            return  false;
        }
        return true;
    }
    public void updatePostSession(HttpServletRequest req, Post post , Boolean isLogged) {
        HttpSession session = req.getSession();

        session.setAttribute("post", post);

        System.out.println("Updated session: " + post.getId() + ", " + post.getTags() + ", " +post.getCategory()
                + ", "+ post.getTitle()+", "+ post.getContent()+", "+ post.getId()+", "+ post.getUserId()
                +", "+ post.getImage()+ ", "+post.getTime()+", "+isLogged);
    }

    public void getUserPostList(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        List<Post> posts = new ArrayList<>();
        for (int i =0; i<data.getPostList().size(); i++){
            if(data.getPostList().contains(user.getId())){
                posts.add(data.getPost(user.getId()));
            }
        }
        String respJson = new Gson().toJson(posts);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(respJson);
    }
    public void getPostList(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {

        List <Post> postList = data.getPostList();

        String respJson = new Gson().toJson(postList);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(respJson);


    }

    public void checkHealthy(Post post, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String s = (String)request.getSession().getAttribute("content");
        if(s.equals("false")){
            post.setStatus(false);
        }else if(s.equals("true")){
            post.setStatus(true);
        }
        request.getSession().removeAttribute("content");
    }
    public void getFollowerList(String userId, Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("follower");
        System.out.println(userId);
        List<Follow> followList = data.findFollowersByUserId(userId);
        System.out.println(followList);
        for (Follow f: followList){
            System.out.println(f.getTravellerId());
        }
        String respJson = new Gson().toJson(followList.get(2));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(respJson);
        // sendToClient(data, request, response);


    }

    public String getCurrentId (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return (String)req.getSession().getAttribute("userId");
    }
}
