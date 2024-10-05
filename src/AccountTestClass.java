import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AccountTestClass {

    //
    public static ObjectInputStream input;
    public static ObjectOutputStream output;

    public static void main(String[] args) {

        Account[] accounts = new Account[10];

        Scanner scanner = new Scanner(System.in);

        int accountIndex = 0;

        while (true) {
            System.out.println("\n");
            System.out.println("Enter 1 To Add Current Account");
            System.out.println("Enter 2 To Add a Saving Account");
            System.out.println("Enter 3 To Deposit Money ");
            System.out.println("Enter 4 To Withdraw Money ");
            System.out.println("Enter 5 To Check the Balance ");
            System.out.println("Enter 6 to Display All Accounts");
            System.out.println("Enter 7 To Exit");

            System.out.println("Enter Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter CNIC: ");
                    String cnic = scanner.next();
                    System.out.println("Enter the account number:");
                    long accountNumber = scanner.nextLong();
                    System.out.println("Enter the account title:");
                    String accountTitle = scanner.next();
                    System.out.println("Enter the balance:");
                    double balance = scanner.nextDouble();
                    System.out.println("Enter the service fee:");
                    float serviceFee = scanner.nextFloat();

                    try {
                        accounts[accountIndex++] = new CurrentAccount(cnic, accountNumber, accountTitle, balance,
                                serviceFee);
                        System.out.println("Current Account: " + accountNumber + " Sucessfully Created!");

                        //
                        openFileInWriteMode();
                        writeToFile(accounts);
                        outputStreamClose();

                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                case 2:

                    System.out.println("Enter the CNIC:");
                    String cnicc = scanner.next();
                    System.out.println("Enter the account number:");
                    long accountNumberr = scanner.nextLong();
                    System.out.println("Enter the account title:");
                    String accountTitlee = scanner.next();
                    System.out.println("Enter the balance:");
                    double balancee = scanner.nextDouble();
                    System.out.println("Enter Monthly Interest Rate(after dividing it by 100):");
                    float monthlyInterestRate = scanner.nextFloat();

                    try {
                        accounts[accountIndex++] = new SavingsAccount(cnicc, accountNumberr, accountTitlee, balancee,
                                monthlyInterestRate);
                        System.out.println("Saving Account: " + accountNumberr + " Sucessfully Created!");

                        //
                        openFileInWriteMode();
                        writeToFile(accounts);
                        outputStreamClose();
                        break;

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        break;

                    }

                case 3:
                    System.out.println("Enter the account number:");
                    accountNumber = scanner.nextLong();
                    System.out.println("Enter the amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    boolean found = false;

                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                            accounts[i].deposit(depositAmount);
                            System.out.println("Amount Depositied Successfully at Account Number: "
                                    + accounts[i].getAccountNumber());
                            found = true;

                            //
                            openFileInWriteMode();
                            writeToFile(accounts);
                            outputStreamClose();

                            break;
                        }
                        if (found == false && i == accounts.length - 1) {
                            System.out.println("Account not found");
                            break;
                        }

                    }

                    break;

                case 4:
                    System.out.println("Enter the account number:");
                    accountNumber = scanner.nextLong();
                    System.out.println("Enter the amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    boolean foundd = false;

                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                            accounts[i].withdraw(withdrawAmount);
                            System.out.println("Amount Withdrawn Successfully from Account Number: "
                                    + accounts[i].getAccountNumber());
                            foundd = true;

                            //
                            openFileInWriteMode();
                            writeToFile(accounts);
                            outputStreamClose();

                            break;

                        }
                        if (foundd == false && i == accounts.length - 1) {
                            System.out.println("Account not found");
                            break;
                        }

                    }

                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLong();
                    boolean founddd = false;
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                            accounts[i].checkBalanceAmount();
                            founddd = true;
                            break;
                        }
                        if (founddd == false && i == accounts.length - 1) {
                            System.out.println("Account not found");
                            break;
                        }
                    }
                    break;
                case 6:
                    openFileInReadMode();
                    readFromFile();
                    inputStreamClose();
                    break;

                case 7:
                    System.out.println("Application Closed Successfully!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("INVALID CHOICE");
            }
        }
    }

    // opening file
    public static void openFileInWriteMode() {
        try {
            FileOutputStream file = new FileOutputStream("bank.ser");
            output = new ObjectOutputStream(file);
        } catch (IOException ioException) {
            System.err.println("Error Opening File");
            System.exit(1);
        }

    }

    public static void openFileInReadMode() {
        try {
            FileInputStream file = new FileInputStream("bank.ser");
            input = new ObjectInputStream(file);
        } catch (IOException ioException) {
            System.err.println("Error Opening File");
            System.exit(1);
        }

    }

    // writing to file
    public static void writeToFile(Account[] accounts) {
        try {

            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("bank.ser")));
            {

                output.writeObject(accounts);

            }
        }

        catch (NoSuchElementException noSuchElementException) {
            System.err.println("Invalid Input");
        } catch (IOException ioException) {
            System.err.println("Error Writing To File");
        }
    }

    // reading from file
    public static void readFromFile() {
        System.out.printf("%-10s \t %-10s \t %-10s \t %-10s \t %-10s\n", "CNIC:", "ACCOUNT NUMBER:", "ACCOUNT TITLE:",
                "BALANCE:", "ACCOUNT TYPE:");
        try {
            input = new ObjectInputStream(Files.newInputStream(Paths.get("bank.ser")));

            while (true) {
                Account[] account = (Account[]) input.readObject();
                for (Account accounts : account) {
                    if (accounts == null) {
                        break;
                    }
                    if (accounts != null) {
                        System.out.printf("%-10s \t %-10d \t\t %-10s \t\t %-10f \t %-10s\n", accounts.getCNIC(),
                                accounts.getAccountNumber(), accounts.getAccountTitle(), accounts.getBalance(),
                                accounts.getAccountType());

                    }
                }
            }
        } catch (EOFException eofException) {
            System.out.println("Whole File Read!");
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Invalid Object Type");
        } catch (IOException ioException) {
            System.err.println("Error Reading File");
        }
    }

    // closing file
    public static void inputStreamClose() {
        try {
            if (input != null) {
                input.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error Closing File");
            System.exit(1);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ioException) {
                    System.err.println("Error Closing File");
                    System.exit(1);
                }
            }
        }
    }

    public static void outputStreamClose() {
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error Closing File");
            System.exit(1);
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException ioException) {
                    System.err.println("Error Closing File");
                    System.exit(1);
                }
            }
        }
    }

}
