"use strict";

/////////////////////////////////////////////////
/////////////////////////////////////////////////
// BANKIST APP

// Data
const account1 = {
  owner: "rayyan Ahmed",
  movements: [200, 450, -400, 3000, -650, -130, 70, 1300],
  interestRate: 1.2, // %
  pin: 1111,
};

const account2 = {
  owner: "Imran Pasha",
  movements: [5000, 3400, -150, -790, -3210, -1000, 8500, -30],
  interestRate: 1.5,
  pin: 2222,
};

const account3 = {
  owner: "Steven Thomas Williams",
  movements: [200, -200, 340, -300, -20, 50, 400, -460],
  interestRate: 0.7,
  pin: 3333,
};

const account4 = {
  owner: "Sarah Smith",
  movements: [430, 1000, 700, 50, 90],
  interestRate: 1,
  pin: 4444,
};

const accounts = [account1, account2, account3, account4];

// Elements
const labelWelcome = document.querySelector(".welcome");
const labelDate = document.querySelector(".date");
const labelBalance = document.querySelector(".balance__value");
const labelSumIn = document.querySelector(".summary__value--in");
const labelSumOut = document.querySelector(".summary__value--out");
const labelSumInterest = document.querySelector(".summary__value--interest");
const labelTimer = document.querySelector(".timer");

const containerApp = document.querySelector(".app");
const containerMovements = document.querySelector(".movements");

const btnLogin = document.querySelector(".login__btn");
const btnTransfer = document.querySelector(".form__btn--transfer");
const btnLoan = document.querySelector(".form__btn--loan");
const btnClose = document.querySelector(".form__btn--close");
const btnSort = document.querySelector(".btn--sort");

const inputLoginUsername = document.querySelector(".login__input--user");
const inputLoginPin = document.querySelector(".login__input--pin");
const inputTransferTo = document.querySelector(".form__input--to");
const inputTransferAmount = document.querySelector(".form__input--amount");
const inputLoanAmount = document.querySelector(".form__input--loan-amount");
const inputCloseUsername = document.querySelector(".form__input--user");
const inputClosePin = document.querySelector(".form__input--pin");


const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

const displayMovements = function (movements) {
  containerMovements.innerHTML = "";

  movements.forEach(function (mov, i) {
    const type = mov > 0 ? "deposit" : "withdrawal";
    const html = `<div class="movements__row">
    <div class="movements__type movements__type--${type}">${i + 1} ${type}</div>
    <div class="movements__value">${mov}</div>
  </div>`;
    containerMovements.insertAdjacentHTML("afterbegin", html);
  });
};

//DISPLAYING IN, OUT AND INTEREST
const calcDisplaySummary = function (acc) {
  const income = acc.movements
    .filter((mov) => mov > 0)
    .reduce((acc, mov) => acc + mov, 0);
  labelSumIn.textContent = `${income}₹`;

  const outcome = acc.movements
    .filter((mov) => mov < 0)
    .reduce((acc, mov) => acc + Math.abs(mov), 0);
  labelSumOut.textContent = `${outcome}₹`;

  const interest = acc.movements
    .filter((mov) => mov > 0)
    .map((deposit) => (deposit * acc.interestRate) / 100)
    .filter((int, i, arr) => {
      return int >= 1;
    })
    .reduce((acc, int) => acc + int, 0);
  labelSumInterest.textContent = `${interest}₹`;
};
////////////////////////////

const createUsernames = function (accs) {
  accs.forEach(function (acc) {
    acc.username = acc.owner
      .toLowerCase()
      .split(" ")
      .map((name) => name[0])
      .join("");
  });
};

createUsernames(accounts);
// console.log(accounts);

function updateUI(acc) {
  //Display Movements
  displayMovements(acc.movements);

  //Display balance
  calcPrintBalance(acc);

  //Display Summary
  calcDisplaySummary(acc);
}

const calcPrintBalance = function (acc) {
  const balance = acc.movements.reduce((acc, mov) => acc + mov);
  acc.balance = balance;
  labelBalance.textContent = `${acc.balance} INR`;
};
// calcPrintBalance(account1.movements);

const deposits = movements.filter(function (mov) {
  return mov > 0;
});

// console.log(deposits);

const withdrawals = movements.filter((mov) => mov < 0);
// console.log(withdrawals);

const balance = movements.reduce(function (acc, cur) {
  return acc + cur;
});

// console.log(balance);

//Challenge 2
/*
const dogs = [5, 2, 4, 1, 15, 8, 3];
const calcAverageHumanAge = dogs.map(function (dogAge, i) {
  return dogAge > 2 ? 4 * dogAge + 16 : 2 * dogAge;
});
console.log(calcAverageHumanAge);

const adultDogs = calcAverageHumanAge.filter(function (dogHumanAge) {
  return dogHumanAge >= 18;
});
console.log(adultDogs);

const average = adultDogs.reduce(function (acc, dog) {
  return acc + dog / adultDogs.length;
}, 0);
console.log(average);
*/

//Converting to USD
const eurToUsd = 1.1;
const totalDepositUSD = movements
  .filter((mov) => mov > 0)
  .map((mov) => mov * eurToUsd)
  .reduce((acc, mov) => acc + mov, 0);
// console.log(totalDepositUSD);
//////////////////////////

// console.log(movements.find(mov => mov < 0));

const account = accounts.find((acc) => acc.owner === "Jessica Davis");
// console.log(account);

//Event Handler
let currentAccount;

//btnLogin.addEventListener("click", function (e) {
//  //Prevent form from submitting
//  e.preventDefault();
//  currentAccount = accounts.find(
//    (acc) => acc.username === inputLoginUsername.value
//  );
//
//  if (currentAccount?.pin === Number(inputLoginPin.value)) {
//    //Display UI and message
//    labelWelcome.textContent = `Welcome Back, ${
//      currentAccount.owner.split(" ")[0]
//    }`;
//    containerApp.style.opacity = 100;
//  }
//
//  //Clear input fields
//  inputLoginUsername.value = inputLoginPin.value = "";
//
//  inputLoginPin.blur();
//
//  //Update UI
//  updateUI(currentAccount);
//});

btnTransfer.addEventListener("click", function (e) {
  e.preventDefault();
  const amount = Number(inputTransferAmount.value);
  const receiverAcc = accounts.find(
    (acc) => acc.username === inputTransferTo.value
  );
  inputTransferAmount.value = inputTransferTo.value = "";

  if (
    amount > 0 &&
    currentAccount.balance >= amount &&
    receiverAcc?.username !== currentAccount.username
  ) {
    //Transferring amount
    currentAccount.movements.push(-amount);
    receiverAcc.movements.push(amount);

    //Update UI
    updateUI(currentAccount);
  }
});

btnClose.addEventListener("click", function (e) {
  e.preventDefault();
  if (
    inputCloseUsername.value === currentAccount.username &&
    Number(inputClosePin.value) === currentAccount.pin
  ) {
    const index = accounts.findIndex(
      (acc) => acc.username === currentAccount.username
    );

    //Delete Account
    accounts.splice(index, 1);

    //Hide UI
    containerApp.style.opacity = 0;
  }
  inputCloseUsername.value = inputClosePin.value = "";
});
