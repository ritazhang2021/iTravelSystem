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
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet("/UserMnServlet")
public class UserMnServlet extends HttpServlet {
    private class JData<T> {
        int total;
        List<T> list;
        public JData(int total, List<T> list){
            this.total = total;
            this.list = list;
        }
    }

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
            doLoadInitUser(data, req, resp);
        } else if (cmdType.equals("add")){
            doAddUser(data, req, resp);
        } else if (cmdType.equals("upd")){
            doUpdUser(data, req, resp);
        } else if (cmdType.equals("del")){
            doDelUser(data, req, resp);
        }
    }

    public void doLoadInitUser(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // send data to client
        sendToClient(data, req, resp);
    }

    public void doAddUser(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get Data from parameter
        String id       = request.getParameter("id");
//        String name    = req.getParameter("fname");
//        String author   = req.getParameter("author");
//        String subject  = req.getParameter("subject");
//        String isbn     = req.getParameter("isbn");
        String gender = request.getParameter("gender");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String zip = request.getParameter("zip");
        String fname = request.getParameter("fname");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        // Not Exist: Add new user
        if (data.getUser(id) == null)
            data.getUser(id);
        // send data to client
        sendToClient(data, request, response);
    }

    public void doUpdUser(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get Data from parameter
        String id = request.getParameter("id");
//        String title = req.getParameter("title");
//        String author = req.getParameter("author");
//        String subject = req.getParameter("subject");
//        String isbn = req.getParameter("isbn");
        String gender = request.getParameter("gender");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String zip = request.getParameter("zip");
        String fname = request.getParameter("fname");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        // Update the book
        data.updUser(id, "user", fname, gender, state, city, street, zip, parseInt(year), email, pwd);
        // Send data to client
        sendToClient(data, request, response);
    }

    public void doDelUser(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id = req.getParameter("id");
        // Delete the book
        data.delUser(id);
        // send data to client
        sendToClient(data, req, resp);
    }

    public void sendToClient(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String respJson = new Gson().toJson(data.getUserList());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);

/*
        int pageno = Integer.parseInt(req.getParameter("pageno"));
        int pageSize = 9;
        List<Book> list = data.getBookList();
        List<Book> lst = list.stream()
                .skip((pageno - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
        BookMnServlet.JData jdata = new BookMnServlet.JData(list.size(), lst);
        String respJson = new Gson().toJson(jdata);
        resp.getWriter().write(respJson);
*/
    }

    public Boolean isLogged(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        // Write to log for debug
        String strType = (String)session.getAttribute("userType");
        String strId = (String)session.getAttribute("userID");
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
