package intbank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signupdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("aa");
        String email = request.getParameter("bb");
        String pwd = request.getParameter("cc");
        String mno = request.getParameter("dd");

        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1238");

            // Set the default balance to 2000
            int defaultBalance = 2000;

            String sql = "INSERT INTO customer (CNAME, CEMAIL, CPWD, CMNO, BAL) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pwd);
            ps.setString(4, mno);
            ps.setInt(5, defaultBalance); // Set the default balance

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                response.sendRedirect("login.html");
            } else {
                out.println("Failed to insert record");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Failed to insert record. Please check the logs for more details.");
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
