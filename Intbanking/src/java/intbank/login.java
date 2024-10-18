
package intbank;

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

@WebServlet("/YourServletName")
public class login extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String s = req.getParameter("email");
        String p = req.getParameter("pwd");
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1238");

            String sql = "SELECT * FROM customer";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            PrintWriter out = res.getWriter();
            boolean credentialsCorrect = false;
            int cid = 0;  // Variable to store CID

            while (rs.next()) {
                String ss = rs.getString("CEMAIL"); // Assuming that the email column is named 'emailid'
                String pp = rs.getString("CPWD");

                if (ss.equals(s) && pp.equals(p)) {
                    credentialsCorrect = true;
                    cid = rs.getInt("CID");  // Store the CID
                    break; // No need to continue checking once correct credentials are found
                }
            }

            if (credentialsCorrect) {
                // Set CID in session and redirect to tran servlet
                HttpSession session = req.getSession(true);
                session.setAttribute("authenticatedUser", s);
                session.setAttribute("cid", cid);
                res.sendRedirect("tran?action=fetchBalance&cid=" + cid);
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































