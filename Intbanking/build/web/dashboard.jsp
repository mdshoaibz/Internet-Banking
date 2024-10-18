<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="dashboard.css" />
    <style>
        body {
            background-color: #f0f5ff; /* Light Blue */
            color: #1a1a1a; /* Dark Gray */
            font-family: 'Poppins', sans-serif;
        }

        header {
            background-color: #0056b3; /* Dark Blue */
            color: #ffffff; /* White */
            padding: 10px;
            text-align: center;
        }

        .main-section {
            margin: 20px;
        }

        .customer-box {
            background-color: #ffffff; /* White */
            border: 1px solid #dcdcdc; /* Light Gray */
            padding: 15px;
            margin-bottom: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .footer {
            background-color: #0056b3; /* Dark Blue */
            color: #ffffff; /* White */
            padding: 10px;
            text-align: center;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
        
    </style>
</head>
<body>
    <header class="header-section">
        <!-- your header content here -->
    </header>
    
    <section class="main-section">
        <h2>Customer Details</h2>
        <a href="AdminLogin.html"> <h2 style="float:right;position: relative;top: -60px">Sign-Out</h2></a>
        <c:forEach var="customer" items="${requestScope.customers}">
            <div class="customer-box">
                <h2>ID: ${customer[0]}</h2>
                <p>Name: ${customer[1]}</p>
                <p>Email: ${customer[2]}</p>
                <p>Password: ${customer[3]}</p>
                <p>Mobile Number: ${customer[4]}</p>
                <p>Balance: ${customer[5]}</p>
                <!-- Add more details as needed -->

                <!-- Add your delete form here -->
            </div>
        </c:forEach>
    </section>

    <section class="footer">
        <!-- your footer content here -->
    </section>
</body>
</html>

