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
import java.util.List;

@WebServlet("/WordFilterServlet")
public class WordFilterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Check isLogged first
        if (isLogged(req, resp) == false)
            return;
        Data data = DataFactory.getInstance();
        Page<WordFilter> wordFilterPage = data.getwordFilterPage();
        String cmdType = req.getParameter("cmdType");
        // Check
        if (cmdType.equals("init")) {//传回一个json直接输出
            doLoadInitWordFilter(data, req, resp);
        } else if (cmdType.equals("add")){
            doAddWordFilter(data, req, resp);
        } else if (cmdType.equals("upd")){
            doUpdWordFilter(data, req, resp);
        } else if (cmdType.equals("del")){
            doDelWordFilter(data, req, resp);
        }else if (cmdType.equals("ShowOnPage")){
            doShowOnPage(wordFilterPage,data, req, resp);
        }else if(cmdType.equals("nextPage")) {
            doNextPage(wordFilterPage, data, req, resp);
        }else if(cmdType.equals("prePage")){
            doPrePage(wordFilterPage, data, req, resp);
        }
    }

    public void doLoadInitWordFilter(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // send data to client
        sendToClient(data, req, resp);
    }

    public void doAddWordFilter(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id       = req.getParameter("id");
        String value    = req.getParameter("value");
        // Not Exist: Add new
        if (data.getWordFilter(id) == null)
            data.addWordFilter(id, value);
        // send data to client
        sendToClient(data, req, resp);
    }

    public void doUpdWordFilter(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id       = req.getParameter("id");
        String value    = req.getParameter("value");
        // Update the Follow
        data.updWordFilter(id, value);
        // Send data to client
        sendToClient(data, req, resp);
    }

    public void doDelWordFilter(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id = req.getParameter("id");
        // Delete the _Post
        data.delWordFilter(id);
        // send data to client
        sendToClient(data, req, resp);
    }

    public void sendToClient(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String respJson = new Gson().toJson(data.getWordFilterList());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);
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
    public void doShowOnPage(Page<WordFilter> pageWordFilter, Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int pageNo = pageWordFilter.getPageNo();
        System.out.println("doShowOnPage pageNo: "+pageNo);
        int pageSize = pageWordFilter.getPageSize();
        System.out.println("doShowOnPage pageNo: "+pageSize);
        Page<WordFilter> wordFilterPage = data.filterWordsPage(pageNo, pageSize);
        List<WordFilter> wordFilterList = wordFilterPage.getItems();
        System.out.println(wordFilterList);
        String respJson = new Gson().toJson(wordFilterList);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().write(respJson);//resp里面的都是返回到action里面的，这里是把json的字符串返回到ajax的action里
        System.out.println("sent");
    }

    public void doNextPage(Page<WordFilter> pageWordFilter, Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int pageNo = pageWordFilter.getPageNo() + 4;
        System.out.println("进入doNextPage后的 pageNo: " + pageNo);
        int pageSize = pageWordFilter.getPageSize() + 4;
        System.out.println("进入doNextPage后的 pageSize:" + pageNo);
        pageWordFilter.setPageNo(pageNo);
        pageWordFilter.setPageSize(pageSize);
        doShowOnPage(pageWordFilter, data, req, resp);
    }
    public void doPrePage(Page<WordFilter> pageWordFilter, Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int pageNo = pageWordFilter.getPageNo()-4;
        System.out.println("进入doNextPage后的 pageNo: "+pageNo);
        int pageSize = pageWordFilter.getPageSize()-4;
        System.out.println("进入doNextPage后的 pageSize:"+pageNo);
        pageWordFilter.setPageNo(pageNo);
        pageWordFilter.setPageSize(pageSize);
        doShowOnPage(pageWordFilter, data, req, resp);
    }
}
