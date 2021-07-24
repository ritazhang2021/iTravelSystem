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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GetCurrentUserInfoServlet")
public class GetCurrentUserInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Data data = DataFactory.getInstance();
        String cmdType = req.getParameter("cmdType");
        // Check
//        if (cmdType.equals("load")) {
//            System.out.println("Loading........ Data khoi tao thanh cong");
//            String userId = req.getParameter("userId");
//            // send data loaded to client
//            // sendToClient(data, resp);
//            String respJson = new Gson().toJson(data.getUser(userId));
//            resp.setContentType("application/json");
//            resp.setCharacterEncoding("UTF-8");
//            resp.getWriter().write(respJson);
//        }

        // Check
        if (cmdType.equals("load")) {
            System.out.println("Loading........ Data khoi tao thanh cong");
            HttpSession session = req.getSession();
            String userId = (String) session.getAttribute("userId");
            System.out.println("user id ==== " + userId);
            // send data loaded to client
            // sendToClient(data, resp);
            String respJson = new Gson().toJson(data.getUser(userId));
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(respJson);
        }
    }


/*
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //System.out.println(user.getFullName()+", "+user.getEmail()+", "+user.getBirthYear());
//        request.setAttribute("htmlTagData", "<br/> creates a new line.");
//        request.setAttribute("url", "userTravelInfo.jsp");
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("signupForm.jsp");
//        rd.forward(request, response);
        Data data = DataFactory.getInstance();
        // Process register
        displayUserInfo(data, request, response);
        getUserPostList(data, request, response);
    }
*/

    public void displayUserInfo(Data data, HttpServletRequest request, HttpServletResponse resp)throws IOException, ServletException{
        HttpSession session = request.getSession();
//        User item = data.getUser();
//        System.out.println(item);
//
//        System.out.println(session.toString());
        User user = (User) session.getAttribute("user");
        //System.out.println(user.getFullName()+", "+user.getEmail()+", "+user.getBirthYear());
        String respJson = new Gson().toJson(user);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);
    }
    public void getUserPostList(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
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
}
