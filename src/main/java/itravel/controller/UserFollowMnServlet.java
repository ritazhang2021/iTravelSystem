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

@WebServlet("/UserFollowMnServlet")
public class UserFollowMnServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Data data = DataFactory.getInstance();
        String cmdType = req.getParameter("cmdType");
        // Check
        if (cmdType.equals("init")) {
            doLoadInitFollow(data, req, resp);
        } else if (cmdType.equals("add")){
            doAddFollow(data, req, resp);
        } else if (cmdType.equals("upd")){
            doUpdFollow(data, req, resp);
        } else if (cmdType.equals("del")){
            doDelFollow(data, req, resp);
        }
    }

    public void doLoadInitFollow(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // send data to client
        sendToClient(data, req, resp);
    }

    public void doAddFollow(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id           = req.getParameter("id");
        String travellerId  = req.getParameter("travellerId");
        String userId       = getCurrentId(req, resp); //
        // Not Exist: Add new
        if (data.getFollow(id) == null)
            data.addFollow(id, travellerId, userId);
        // send data to client
        sendToClient(data, req, resp);
    }

    public void doUpdFollow(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id           = req.getParameter("id");
        String travellerId  = req.getParameter("travellerId");
        String userId       = getCurrentId(req, resp);
        // Update the Follow
        data.updFollow(id, travellerId, userId);
        // Send data to client
        sendToClient(data, req, resp);
    }

    public void doDelFollow(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id = req.getParameter("id");
        // Delete the
        data.delFollow(id);
        // send data to client
        sendToClient(data, req, resp);
    }

    public void sendToClient(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String respJson = new Gson().toJson(data.getFollowList());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);
    }

    public String getCurrentId (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Write to log for debug
        return (String)req.getSession().getAttribute("userId");
    }
}
