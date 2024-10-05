

public class CurrentAccount  extends Account { 
    private float serviceFee;

    
    public CurrentAccount(String CNIC, long accountNumber, String accountTitle, double balance, float serviceFee) {
        
        super(CNIC, accountNumber, accountTitle, balance);

        
        this.serviceFee = setServiceFee(serviceFee);
        this.accountType="Current Account";
        
        count++;

    }

    

    @Override
    public void deposit(double depositBalance) {
        this.balance = this.balance + depositBalance - serviceFee;
        System.out.println("Your Current Balance After the Deposit: " + this.balance);

    }

    
    @Override
    public void withdraw(double withdrawBalance)
    {
        if (withdrawBalance+serviceFee<=this.balance)
        {
        this.balance=this.balance - (withdrawBalance+serviceFee);
        System.out.println("Your Current Balance After the Deposit: "+ this.balance);
        }
        else
        throw new IllegalArgumentException("\nthe transaction cannot be completed");
    }

    
    @Override
    public void addAccount(String CNIC, long accountNumber, String accountTitle, double balance) {

     super.addAccount(CNIC, accountNumber, accountTitle, balance);

    }


    
    public float setServiceFee(float serviceFee) {
        //
        if (serviceFee >= 0.0F)
            return serviceFee;

        else
            throw new IllegalArgumentException("\nService Fee Cannot be negative");

    }

    
    @Override
    public int totalAccounts() {
        
        return super.totalAccounts();
    }
    

    
    @Override
    public void checkBalanceAmount() {
        super.checkBalanceAmount();
    }

}
