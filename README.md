# Account Management System

This is a Java-based application that provides basic functionalities for managing accounts, including creating accounts, depositing and withdrawing money, checking balances, and displaying all accounts. The system supports two types of accounts: Current Accounts and Savings Accounts.

## Features
- **Add Current Account**: Allows the user to add a current account with a service fee.
- **Add Savings Account**: Allows the user to add a savings account with a monthly interest rate.
- **Deposit Money**: Enables depositing money into any account.
- **Withdraw Money**: Enables withdrawing money from any account.
- **Check Balance**: Displays the current balance of any account.
- **Display All Accounts**: Lists all accounts with their details.
- **Data Persistence**: All account data is stored and retrieved from a file (`bank.ser`).

## Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/account-management-system.git
    ```
2. Compile the Java files:
    ```bash
    javac AccountTestClass.java
    ```
3. Run the application:
    ```bash
    java AccountTestClass
    ```

## Usage
Upon running the program, a menu is displayed with options to:
1. Add a Current Account
2. Add a Savings Account
3. Deposit Money
4. Withdraw Money
5. Check Account Balance
6. Display All Accounts
7. Exit the application

Simply input the corresponding number to perform any action.

## Account Classes
- **Account**: This is the base class for accounts. It contains common attributes like CNIC, account number, account title, and balance. It also handles deposit, withdrawal, and balance checking.
- **CurrentAccount**: Inherits from `Account`, includes an additional service fee that is applied to transactions.
- **SavingsAccount**: Inherits from `Account`, includes a monthly interest rate that can be applied to the account balance.

## File Handling
The account data is stored in a file called `bank.ser` using Java’s serialization mechanism. The following methods handle file operations:
- `openFileInWriteMode()`: Opens the file for writing account data.
- `openFileInReadMode()`: Opens the file for reading account data.
- `writeToFile()`: Writes the account data to the file.
- `readFromFile()`: Reads account data from the file.
- `inputStreamClose()` and `outputStreamClose()`: Close the file streams after reading or writing.

## Example
```text
Enter 1 To Add Current Account
Enter 2 To Add a Saving Account
Enter 3 To Deposit Money 
Enter 4 To Withdraw Money 
Enter 5 To Check the Balance 
Enter 6 to Display All Accounts
Enter 7 To Exit

Enter Choice: 1
Enter CNIC: 12345-6789012-3
Enter the account number: 123456
Enter the account title: JohnDoe
Enter the balance: 5000
Enter the service fee: 100
Current Account: 123456 Successfully Created!
