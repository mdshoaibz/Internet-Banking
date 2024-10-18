import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "adminlogin", urlPatterns = {"/adminlogin"})
public class adminlogin extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String s = req.getParameter("email");
        String p = req.getParameter("pwd");
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1238");

            String sql = "SELECT * FROM admin";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            PrintWriter out = res.getWriter();
            boolean credentialsCorrect = false;

            while (rs.next()) {
                String ss = rs.getString("EMAIL");
                String pp = rs.getString("PWD");

                if (ss.equals(s) && pp.equals(p)) {
                    credentialsCorrect = true;
                    break;
                }
            }

            if (credentialsCorrect) {
                // Set admin email in session and redirect to dashboard.jsp
                HttpSession session = req.getSession(true);
                session.setAttribute("adminEmail", s);
                res.sendRedirect("dashboard.jsp");
            } else {
                res.sendRedirect("login.html");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 *
 * @author imran
 */

