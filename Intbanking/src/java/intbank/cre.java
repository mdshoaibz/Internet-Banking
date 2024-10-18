import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cre", urlPatterns = {"/cre"})
public class cre extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String name = request.getParameter("aa");
        String email = request.getParameter("bb");
        String password = request.getParameter("cc");
        String phoneNumber = request.getParameter("dd");

        // Set the initial balance to 2000
        long initialBalance = 2000;

        // JDBC URL, username, and password of MySQL server
        String jdbcUrl = "jdbc:mysql://localhost:3306/bank";
        String dbUser = "root";
        String dbPassword = "1238";

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                // SQL query to insert customer data into the table
                String sql = "INSERT INTO customer1 (CNAME, CEMAIL, CMNO, BAL) VALUES (?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, name);
                    statement.setString(2, email);
                    statement.setLong(3, Long.parseLong(phoneNumber));
                    statement.setLong(4, initialBalance);

                    // Execute the query
                    statement.executeUpdate();
                }
            }

            // Redirect to a success page or do further processing
            response.sendRedirect("success.html");

        } catch (ClassNotFoundException | SQLException e) {
            // Handle errors
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}

