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

@WebServlet(name = "tran", urlPatterns = { "/tran" })
public class tran extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("fetchBalance".equals(action)) {
            fetchBalance(request, response);
        } else if ("addBalance".equals(action)) {
            addBalance(request, response);
        } else if ("deleteRow".equals(action)) {
            deleteRow(request, response);
        } else if ("transferMoney".equals(action)) {
            transferMoney(request, response);
        }
    }

    private void fetchBalance(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            // Retrieve CID from session
            HttpSession session = request.getSession(false);
            if (session != null) {
                int cid = (int) session.getAttribute("cid");

                // Establish a database connection (replace with your database credentials)
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1238");

                // Fetch balance for the given CID
                String sql = "SELECT BAL FROM customer WHERE CID=?";
                try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                    pstmt.setInt(1, cid);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            int balance = rs.getInt("BAL");
                            request.setAttribute("balance", balance);
                            request.getRequestDispatcher("aa.jsp").forward(request, response);
                        } else {
                            out.println("Balance not found for CID: " + cid);
                        }
                    }
                }
            } else {
                out.println("Session not found. Please log in.");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }

    private void addBalance(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            // Retrieve CID from session
            HttpSession session = request.getSession(false);
            if (session != null) {
                int cid = (int) session.getAttribute("cid");
                int amount = Integer.parseInt(request.getParameter("amount"));

                // Establish a database connection (replace with your database credentials)
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1238");

                // Fetch current balance
                String fetchBalanceSQL = "SELECT BAL FROM customer WHERE CID=?";
                try (PreparedStatement fetchBalancePstmt = con.prepareStatement(fetchBalanceSQL)) {
                    fetchBalancePstmt.setInt(1, cid);
                    try (ResultSet rs = fetchBalancePstmt.executeQuery()) {
                        if (rs.next()) {
                            int currentBalance = rs.getInt("BAL");

                            // Update balance
                            String updateBalanceSQL = "UPDATE customer SET BAL = BAL + ? WHERE CID=?";
                            try (PreparedStatement updateBalancePstmt = con.prepareStatement(updateBalanceSQL)) {
                                updateBalancePstmt.setInt(1, amount);
                                updateBalancePstmt.setInt(2, cid);
                                updateBalancePstmt.executeUpdate();

                                out.println("Balance added successfully!");
                            }
                        } else {
                            out.println("CID not found: " + cid);
                        }
                    }
                }
            } else {
                out.println("Session not found. Please log in.");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }

    private void transferMoney(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            // Retrieve CID from session
            HttpSession session = request.getSession(false);
            if (session != null) {
                int senderCID = (int) session.getAttribute("cid");
                int receiverCID = Integer.parseInt(request.getParameter("receiverCID"));
                int amount = Integer.parseInt(request.getParameter("amount"));

                // Establish a database connection (replace with your database credentials)
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1238");

                // Fetch balance of the sender
                String senderBalanceSQL = "SELECT BAL FROM customer WHERE CID=?";
                try (PreparedStatement senderPstmt = con.prepareStatement(senderBalanceSQL)) {
                    senderPstmt.setInt(1, senderCID);
                    try (ResultSet senderRs = senderPstmt.executeQuery()) {
                        if (senderRs.next()) {
                            int senderBalance = senderRs.getInt("BAL");

                            // Check if the sender has enough balance
                            if (senderBalance >= amount) {
                                // Update balance for the sender
                                String updateSenderBalanceSQL = "UPDATE customer SET BAL = BAL - ? WHERE CID=?";
                                try (PreparedStatement updateSenderPstmt = con.prepareStatement(updateSenderBalanceSQL)) {
                                    updateSenderPstmt.setInt(1, amount);
                                    updateSenderPstmt.setInt(2, senderCID);
                                    updateSenderPstmt.executeUpdate();
                                }

                                // Update balance for the receiver
                                String updateReceiverBalanceSQL = "UPDATE customer SET BAL = BAL + ? WHERE CID=?";
                                try (PreparedStatement updateReceiverPstmt = con.prepareStatement(updateReceiverBalanceSQL)) {
                                    updateReceiverPstmt.setInt(1, amount);
                                    updateReceiverPstmt.setInt(2, receiverCID);
                                    updateReceiverPstmt.executeUpdate();

                                    out.println("Transfer successful!");
                                }
                            } else {
                                out.println("Insufficient balance for the sender.");
                            }
                        } else {
                            out.println("Sender CID not found: " + senderCID);
                        }
                    }
                }
            } else {
                out.println("Session not found. Please log in.");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }

    private void deleteRow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            // Retrieve CID from session
            HttpSession session = request.getSession(false);
            if (session != null) {
                int cidToDelete = (int) session.getAttribute("cid");

                // Establish a database connection (replace with your database credentials)
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1238");

                // Delete row based on CID
                String deleteRowSQL = "DELETE FROM customer WHERE CID=?";
                try (PreparedStatement deleteRowPstmt = con.prepareStatement(deleteRowSQL)) {
                    deleteRowPstmt.setInt(1, cidToDelete);
                    int rowsAffected = deleteRowPstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        out.println("Row deleted successfully.");
                    } else {
                        out.println("No row found with CID: " + cidToDelete);
                    }
                }
            } else {
                out.println("Session not found. Please log in.");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
