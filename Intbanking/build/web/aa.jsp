<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <link rel="shortcut icon" type="image/png" href="/icon.png"/>

    <title>Bankist</title>
    <style>
        body {
            background-color: #f4f4f4;
            color: #333;
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        nav {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px;
        }

        .app {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
        }

        .balance {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
            padding: 20px;
            text-align: center;
            width: 100%;
        }

        .bal {
            background-color: #ffcccb;
            border-radius: 10px;
            margin-top: 10px;
            padding: 10px;
            text-align: center;
            width: 100%;
        }

        .send, .operation--delete {
            background-color: #f4f4f4;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            margin-top: 10px;
            padding: 10px;
            text-align: center;
            width: 100%;
        }

        form {
            margin-top: 10px;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        .form__input {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form__btn {
            background: linear-gradient(to right, #06beb6, #48b1bf);
            color: white;
            font-size: 16px;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .balance__value {
            font-size: 24px;
            margin-top: 10px;
        }

        .operation--delete {
            background: linear-gradient(to right, #fd746c, #ff9068);
            color: white;
            padding: 10px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        #signOut {
            margin-top: 10px;
            background: linear-gradient(to right, #555555, #333333);
            color: white;
            font-size: 16px;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            text-align: center;
        }
        #cidToDelete{
            width: 60px;
        }
    </style>
</head>
<body>
    <!-- TOP NAVIGATION -->
    <nav>
    
        <img src="logo.png" alt="Logo" class="logo"/>
    </nav>

    <main class="app">
        <!-- BALANCE -->
        <div class="balance">
            <div>
                <p class="balance__label">Current</p>
                <p class="balance__date">As of <span class="date">05/03/2037</span></p>
            </div>
            <div class="bal">
                <form action="tran" method="get">
                    <label for="cid" id="ballabel">Enter CID:</label>
                    <input type="text" id="cid" name="cid" required>
                    <button type="submit" name="action" value="fetchBalance" id="getbal">Get Balance</button>
                </form>
            </div>

            <div class="send">
                <form action="tran" method="get">
                    <label for="senderCID" id="sendtext">Sender CID:</label>
                    <input type="text" id="senderCID" name="senderCID" required>
                    <br>
                    <label for="receiverCID" id="recieve">Receiver CID:</label>
                    <input type="text" id="receiverCID" name="receiverCID" required>
                    <br>
                    <label for="amount" id="amounttext">Amount:</label>
                    <input type="number" id="amount" name="amount" required>
                    <br>
                    <button type="submit" id="transfer" name="action" value="transferMoney" class="form__btn">Transfer Money</button>
                </form>
            </div>

            <p class="balance__value"><%= request.getAttribute("balance") %> INR</p>
        </div>

        <div id="sss" class="operation operation--delete">
            <h2>Delete Row</h2>
            <form class="form form--delete" action="tran" method="get">
                <label for="cidToDelete">CID to delete:</label>
                <input type="text" id="cidToDelete" name="cidToDelete" class="form__input" required>
                <button type="submit" name="action" value="deleteRow" class="form__btn">&rarr;</button>
            </form>
        </div>

        <!-- LOGOUT TIMER -->
        <a href="login.html" id="signOut">Sign Out</a>
    </main>
</body>
</html>
