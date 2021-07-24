package itravel.controller;

import com.google.gson.Gson;
import itravel.model.Data;
import itravel.model.DataFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/UserCommentMnServlet")
public class UserCommentMnServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Data data = DataFactory.getInstance();
        String cmdType = req.getParameter("cmdType");
        // Check
        if (cmdType.equals("init")) {
            doLoadInitComments(data, req, resp);
        } else if (cmdType.equals("add")) {
            doAddComment(data, req, resp);
        } else if (cmdType.equals("upd")) {
            doUpdComment(data, req, resp);
        } else if (cmdType.equals("del")) {
            doDelComment(data, req, resp);
        }
    }

    public void doLoadInitComments(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // send data to client
        sendToClient(data, req, resp);
    }

    public void doAddComment(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id = req.getParameter("id");
        String postId = req.getParameter("postId");
        String userId = getCurrentId(req, resp); //
        String content = req.getParameter("content");
        // Not Exist: Add new
        if (data.getComment(id) == null)
            data.addComment(id, postId, userId, content);
        // send data to client
        sendToClient(data, req, resp);
    }

    public void doUpdComment(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id = req.getParameter("id");
        String postId = req.getParameter("postId");
        String userId = getCurrentId(req, resp); //
        String content = req.getParameter("content");
        // Update the Comment
        data.updComment(id, postId, userId, content);
        // Send data to client
        sendToClient(data, req, resp);
    }

    public void doDelComment(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id = req.getParameter("id");
        // Delete the _Post
        data.delComment(id);
        // send data to client
        sendToClient(data, req, resp);
    }

    public void sendToClient(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String respJson = new Gson().toJson(data.getCommentList());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);
    }

    public String getCurrentId (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return (String)req.getSession().getAttribute("userId");
    }
}