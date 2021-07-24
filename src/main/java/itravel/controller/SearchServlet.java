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
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    private class JData<T> {
        int total;
        List<T> list;
        public JData(int total, List<T> list){
            this.total = total;
            this.list = list;
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kind = request.getParameter("kind");
        String name = request.getParameter("name");
        int pageno = Integer.parseInt(request.getParameter("pageno"));
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String json = "";
        int pageSize = 9;
        if(kind.equals("post")) {
            List<Post> list = searchPost(name);
            List<Post> lst = list.stream()
                    .skip((pageno - 1) * pageSize)
                    .limit(pageSize)
                    .collect(Collectors.toList());
            JData jdata = new JData(list.size(), lst);
            json = gson.toJson(jdata);
        }
        else if(kind.equals("user")) {
            List<User> list = searchUser(name);
            List<User> lst = list.stream()
                    .skip((pageno - 1) * pageSize)
                    .limit(pageSize)
                    .collect(Collectors.toList());
            JData jdata = new JData(list.size(), lst);
            json = gson.toJson(jdata);
        }
        else if(kind.equals("followedPost")) {
            // Get user Id
            String userId = getCurrentId(request, response);
            // Process search
            List<Post> list = searchFollowPost(userId, name);
            List<Post> lst = list.stream()
                    .skip((pageno - 1) * pageSize)
                    .limit(pageSize)
                    .collect(Collectors.toList());
            JData jdata = new JData(list.size(), lst);
            json = gson.toJson(jdata);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private List<Post> searchPost(String name){
        Data data = DataFactory.getInstance();
        return data.searchPost(name);
    }

    private List<User> searchUser(String name){
        Data data = DataFactory.getInstance();
        return data.searchUser(name);
    }

    private List<Post> searchFollowPost(String userId, String textSearch){
        Data data = DataFactory.getInstance();
        return data.searchFollowedPost(userId, textSearch);
    }

    public String getCurrentId (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return (String)req.getSession().getAttribute("userId");
    }

}
