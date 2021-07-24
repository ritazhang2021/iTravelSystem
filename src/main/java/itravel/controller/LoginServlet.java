package itravel.controller;

import com.google.gson.Gson;
import itravel.model.Data;
import itravel.model.DataFactory;
import itravel.model.LogLogin;
import itravel.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
// System.out.println("");

@WebServlet({"/loginServlet", "/", "/login"})
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // doPost(req, resp);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Data data = DataFactory.getInstance();
        // Process login
        doLogin(data, req, resp);
   }

    public void doLogin(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Get Data from parameter
        String userName = req.getParameter("txtUserName");
        String password = req.getParameter("txtPassword");
        System.out.println(userName + " ----- " + password);
        // Check userName, Password
        User item = data.login(userName, password);
        if (item == null) {
            System.out.println("login ...Fail count....!!!");
            // Add logLogin
            data.addLogLogin(userName, 0, "notes"); // login fail
            // Check for deactive user
            if (data.needDeactiveUser(userName) == true) {
                data.deActiveUser(userName);
                data.deActiveUserByEmail(userName);
                resp.sendRedirect("pageErrorDeactiveUser.jsp");
                sendToClient("Error 3 times in 10 min...deActive Account", req, resp);
            } else {
                // try to login
                System.out.println("login....FAIL!!!!");
                resp.sendRedirect("pageErrorLoginFail.jsp");
                // sendToClient("If fail 3 times will be deActive account...!", req, resp);
            }
        } else {
            System.out.println("login ...OOOOOKKKKK count....!!!");
            String userId   = item.getId();
            String userType = item.getUserType();
            // Add logLogin
            data.addLogLogin(userName, 1, "notes"); // login OK
            if (userType.equals("admin")) {
                System.out.println("admin.... login....SUCCESS ..... !!!!");
                updateLoginSession(req, userId, userType, true);
                // Redirect to Admin page
                resp.sendRedirect("admin.jsp");
            } else if (userType.equals("user")) {
                System.out.println("user.... login....SUCCESS ..... !!!!");
                updateLoginSession(req, userId, userType, true);
                // Redirect to User page
                // resp.sendRedirect("userTravelInfo.jsp?userId=" + userId);
                resp.sendRedirect("userTravelInfo.jsp");
            }
        }
    }

    public void updateLoginSession(HttpServletRequest req, String userId, String userType, Boolean isLogged) {
        HttpSession session = req.getSession();
        session.setAttribute("userId", userId);
        session.setAttribute("userType", userType);
        session.setAttribute("isLogged", isLogged);
        // Log tracking
        System.out.println("Updated session: " + userId + ", " + userType + ", " + isLogged);
    }

    public void sendToClient(String result, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // resp.setContentType("text/plain");
        resp.getWriter().write(result);
    }
}

