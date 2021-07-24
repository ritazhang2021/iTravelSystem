package itravel.controller;

import com.google.gson.Gson;
import itravel.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/_PostMnServlet")
public class _PostMnServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Check isLogged first
        if (isLogged(req, resp) == false)
            return;
        Data data = DataFactory.getInstance();
        String cmdType = req.getParameter("cmdType");
        // Check
        if (cmdType.equals("init")) {
            doLoadInit_Posts(data, req, resp);
        } else if (cmdType.equals("add")){
            doAdd_Post(data, req, resp);
        } else if (cmdType.equals("upd")){
            doUpd_Post(data, req, resp);
        } else if (cmdType.equals("del")){
            doDel_Post(data, req, resp);
        }
    }

    public void doLoadInit_Posts(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // send data to client
        sendToClient(data, req, resp);
    }

    public void doAdd_Post(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id       = req.getParameter("id");
        String userId   = "userId"; //
        String image    = req.getParameter("image");
        String title    = req.getParameter("title");
        String content  = req.getParameter("content");
        String category = req.getParameter("category");
        String tags     = req.getParameter("tags");
        String time     = req.getParameter("time");
        String location     = req.getParameter("location");

        // Not Exist: Add new _Post
        if (data.getPost(id) == null)
            data.addPost(id, userId, image, title, content, category, tags, time, location);

        //add for filter
        String healthy = (String)req.getAttribute("content");
        if(healthy.equals("false")){
            Post post = data.getPost(id);
            post.setStatus(false);
        }else{
            Post post = data.getPost(id);
            post.setStatus(true);
        }
// send data to client
        sendToClient(data, req, resp);
    }

    public void doUpd_Post(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id = req.getParameter("id");
        String userId   = "userId"; //
        String image = req.getParameter("image");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String category = req.getParameter("category");
        String tags = req.getParameter("tags");
        String time = req.getParameter("time");
        String location = req.getParameter("location");
        // Update the _Post
        data.updPost(id, userId, image, title, content, category, tags, time, location);
        // Send data to client
        sendToClient(data, req, resp);
    }

    public void doDel_Post(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id = req.getParameter("id");
        // Delete the _Post
        data.delPost(id);
        // send data to client
        sendToClient(data, req, resp);
    }

    public void sendToClient(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get userId from Session
        HttpSession session = req.getSession();
        String userId = (String)session.getAttribute("userId");

        String respJson = new Gson().toJson(data.getPostsByUserId(userId));
        // String respJson = new Gson().toJson(data.get_PostList());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);
    }

    public Boolean isLogged(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        // Write to log for debug
        String strType = (String)session.getAttribute("userType");
        String strId = (String)session.getAttribute("userId");
        Boolean logged = (Boolean) session.getAttribute("isLogged");
        System.out.println("Before Updated session: " + strId + ", " + strType + ", " + logged);
        // isLogged == invalid
        if (logged == null || logged == false)
        {
            System.out.println("Need to login......! ");
            // Send Redirect to Login Page
            resp.sendRedirect("login.jsp");
            return false;
        }
        // isLogged
        return true;
    }
}
