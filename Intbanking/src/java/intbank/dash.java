package intbank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "dash", urlPatterns = { "/dash" })
public class dash extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        fetchAllCustomers(request);

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

    private void fetchAllCustomers(HttpServletRequest request) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1238");

            String sql = "SELECT * FROM customer";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    List<List<String>> customers = new ArrayList<>();

                    while (rs.next()) {
                        int cid = rs.getInt("CID");
                        String cname = rs.getString("CNAME");
                        String cemail = rs.getString("CEMAIL");
                        String cpwd = rs.getString("CPWD");
                        String cmno = rs.getString("CMNO");
                        int balance = rs.getInt("BAL");

                        List<String> customerDetails = new ArrayList<>();
                        customerDetails.add(String.valueOf(cid));
                        customerDetails.add(cname);
                        customerDetails.add(cemail);
                        customerDetails.add(cpwd);
                        customerDetails.add(cmno);
                        customerDetails.add(String.valueOf(balance));

                        customers.add(customerDetails);
                    }

                    // Set the list of customers as a request attribute
                    request.setAttribute("customers", customers);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
