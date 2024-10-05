
public class SavingsAccount extends Account  {
    
    private float monthlyInterestRate;

    
    public SavingsAccount(String CNIC, long accountNumber, String accountTitle, double balance,
            float monthlyInterestRate) {
        
        super(CNIC, accountNumber, accountTitle, balance);

        
        this.monthlyInterestRate = checkMonthlyInterestRate(monthlyInterestRate);
        this.accountType="Savings Account";
        
        count++;

    }
    
    
    public float checkMonthlyInterestRate(float monthlyInterestRate)
    {
        if(monthlyInterestRate<=0.0F)
        {
            throw new IllegalArgumentException("Monthly Interest Rate can't be less than 0");
        }
        else
        return monthlyInterestRate;
    }

    
    public void setInterestRate(float interestRate) {
        if(interestRate <=0.0F)
        {
            throw new IllegalArgumentException("Monthly Interest Rate can't be less than 0");
        }
        else
        this.monthlyInterestRate=interestRate;    
     
        System.out.println("Monthly Interest Rate Updated To: "+this.monthlyInterestRate);

    }

    
    public float calculateInterest() {
        return (float)balance * monthlyInterestRate;

    }

    @Override
    public void addAccount(String CNIC, long accountNumber, String accountTitle, double balance)
     {

        
        checkCNIC(CNIC);

        
        checkAccountNumber(accountNumber);

        
        checkAccountTitle(accountTitle);
        
        checkBalance(balance);
        

        count++;

    }

    
    @Override
    public void checkAccountNumber(long accountNumber) {
        String accountNo = Long.toString(accountNumber);
        char firstDigit = accountNo.charAt(0);

        if (firstDigit != '2') {
            throw new IllegalArgumentException("\nAccount number must start with digit 2");
        }

        for (int i = 1; i < accountNo.length(); i++) {
            char digit = accountNo.charAt(i);
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException("\nAccount number can only contain digits");
            }
        }

        this.accountNumber = accountNumber;

    }

    
    
    @Override
    public void deposit(double depositBalance) {
        super.deposit(depositBalance);

    }

    
    @Override
    public void withdraw(double withdrawBalance)
    {
       super.withdraw(withdrawBalance);
    }

    
    @Override
    public void checkBalanceAmount() {
        super.checkBalanceAmount();
    }

    
    @Override
    public int totalAccounts() {
        
        return super.totalAccounts();
    }


    
}
