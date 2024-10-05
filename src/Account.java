import java.io.Serializable;

public class Account extends Object implements Serializable{
    
    protected String CNIC;
    protected long accountNumber;
    protected String accountTitle;
    protected double balance;
    protected static int count = 0;
    protected String accountType;
    
    public String getAccountType()
    {
        return this.accountType;

    }
    
    
    public String getCNIC()
    {
        return this.CNIC;

    }
    public long getAccountNumber()
    {
        return this.accountNumber;
    }
    public String getAccountTitle()
    {
        return this.accountTitle;
    }
    public double getBalance()
    {
        return this.balance;
    }

    
    public void setCNIC(String CNIC)
    {
        this.CNIC=CNIC;
    }
    public void setAccountNumber(long accountNumber)
    {
        this.accountNumber=accountNumber;
    }
    public void setAccountTitle(String accounTitle)
    {
        this.accountTitle=accounTitle;
    }
    public void setBalance(double balance)
    {
        this.balance=balance;
    }



    
    public Account(String CNIC, long accountNumber, String accountTitle, double balance) {
        
        count++;

        
        checkCNIC(CNIC);
        checkAccountNumber(accountNumber);
        checkAccountTitle(accountTitle);
        checkBalance(balance);
    }

    
    public void addAccount(String CNIC, long accountNumber, String accountTitle, double balance) {

        
        checkCNIC(CNIC);

        
        checkAccountNumber(accountNumber);

        
        checkAccountTitle(accountTitle);
        
        checkBalance(balance);
        

        count++;

    }

    //
    public void checkCNIC(String CNIC) {
        for (int i = 0; i < CNIC.length(); i++) {
            char cnic = CNIC.charAt(i);
            if (Character.isLetter(cnic)) {
                throw new IllegalArgumentException("\nCNIC cannot contain alphabets");
            }
        }
        this.CNIC = CNIC;
    }

    //
    public void checkAccountNumber(long accountNumber) {
        String accountNo = Long.toString(accountNumber);
        char firstDigit = accountNo.charAt(0);

        if (firstDigit != '1') {
            throw new IllegalArgumentException("\nAccount number must start with digit 1");
        }

        for (int i = 1; i < accountNo.length(); i++) {
            char digit = accountNo.charAt(i);
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException("\nAccount number can only contain digits");
            }
        }

        this.accountNumber = accountNumber;

    }

    //
    public void checkAccountTitle(String accountTitle) {
        char firstLetter = accountTitle.charAt(0);
        if (!Character.isUpperCase(firstLetter)) {
            throw new IllegalArgumentException("\nAccount title must start with a capital letter");
        }

        for (int i = 1; i < accountTitle.length(); i++) {
            char letter = accountTitle.charAt(i);
            if (!Character.isLetter(letter)) {
                throw new IllegalArgumentException("\nAccount title can only contain letters");
            }
        }

        this.accountTitle = accountTitle;

    }

    //
    public void checkBalance(double balance) {
        if (balance <= 0.0)
            throw new IllegalArgumentException("\nThe Account Balance cannot be 0");

        else
            this.balance = balance;
    }

    
    public void withdraw(double withdrawBalance) {
        if (withdrawBalance <= this.balance) {
            this.balance = this.balance - withdrawBalance;
            System.out.println("Your Current Balance After the Deposit: " + this.balance);
        } else
            throw new IllegalArgumentException("\nthe transaction cannot be completed");

    }

    
    public void deposit(double depositBalance) {
        this.balance = this.balance + depositBalance;
        System.out.println("Your Current Balance After the Deposit: " + this.balance);

    }

    
    public int totalAccounts() {
        
        return count;
    }

    
    public void checkBalanceAmount() {
        System.out.println("Current Balance of " + accountNumber + " is: " + this.balance);
    }
}
