package servlets;

import model.User;
import service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;

@WebServlet(name = "servlets.LoginServlet")
public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession httpSession = request.getSession(true);

        try{
            UserServiceImpl userService = new UserServiceImpl();
            User user = userService.getUserByUsernameAndPassword(username, password);
            httpSession.setAttribute("type",user.getType());
            if(user!= null && user.getType().equals("admin")){
                ServletContext servletContext = getServletContext();
                servletContext.getRequestDispatcher("/admin.html").forward(request, response);
                //response.sendRedirect("/admin.html");
            }else{
                ServletContext servletContext = getServletContext();
                servletContext.getRequestDispatcher("/user.html").forward(request, response);
                //response.sendRedirect("/user.html");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
