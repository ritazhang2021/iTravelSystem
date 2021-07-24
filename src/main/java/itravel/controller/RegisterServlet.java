package itravel.controller;

import com.google.gson.Gson;
import itravel.model.Data;
import itravel.model.DataFactory;
import itravel.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.lang.Integer.parseInt;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Data data = DataFactory.getInstance();
        // Process register
        doRegister(data, request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
    public void doRegister(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get Data from parameter
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
        // Check userName, Password
        User item = data.getUserByEmail(email);
        System.out.println(item);
        //System.out.println(item);
        List<User> listUser = data.getUserList();
        int count = listUser.size();
        int s = 0;
        System.out.println(count+ "list size");

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        if (item!=null) {
            //response.getWriter().write("false");
            // process error register
            //System.out.println("false");
            //return;

//           sendToClient(data, request, response);
            //response.getWriter().write("false");

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"status\": \"false\", \"message\": \"email in used\"}");

            //resp.sendRedirect("signupForm.jsp");

        } else {
            //response.getWriter().write("true");
            s = count+1;
            String id = ""+s;
            System.out.println(id);

            //int y = parseInt(year);
            User newUser = new User(id, "user", fname, gender, state, city, street,
                    zip,parseInt(year) , email, pwd);
            newUser.setId(id);
            System.out.println(id);
            //listUser = data.addUser(id, "user", name, gender, state, city, street, zip, parseInt(year), email, password);
            listUser.add(newUser);
            System.out.println(newUser.getFullName());

            updateRegisterSession(request, newUser, true);
            // Redirect to User page

//            sendToClient(data, request, response);
//            response.getWriter().write("true");

//            response.sendRedirect("userTravelInfo.jsp");
            System.out.println("THis is test to send");
            return;
        }


    }

    public void updateRegisterSession(HttpServletRequest req, User user , Boolean isLogged) {
        HttpSession session = req.getSession();
        session.setAttribute("userId", user.getId());
        session.setAttribute("userType", user.getUserType());
        session.setAttribute("isLogged", isLogged);

        session.setAttribute("user", user);

//        session.setAttribute("userID", user.getId());
//
//        session.setAttribute("userType", user.getUserType());
//        session.setAttribute("name", user.getFullName());
//        session.setAttribute("gender", user.getGender());
//        session.setAttribute("state", user.getState());
//        session.setAttribute("city", user.getCity());
//        session.setAttribute("street", user.getStreet());
//        session.setAttribute("yearOfBirth", user.getBirthYear());
//        session.setAttribute("email", user.getEmail());
//        session.setAttribute("pass", user.getPassword());
//
//        session.setAttribute("isLogged", isLogged);
        // Log tracking
        System.out.println("Updated session: " + user.getId() + ", " + user.getUserType() + ", " +user.getFullName()
                + ", "+ user.getGender()+", "+ user.getState()+", "+ user.getCity()+", "+ user.getZipCode()
                +", "+ user.getStreet()+", "+ user.getStreet() +", "+ user.getBirthYear()
                +", "+user.getEmail()+ ", "+ user.getPassword()+ ", "+isLogged);
    }
    public void sendToClient(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String respJson = new Gson().toJson(data.getUserList());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);

    }
    public void response(HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.close();
    }
}