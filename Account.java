public class Account {
    private String accountNumber;
    private double balance;
    private AccountState state;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.state = ActiveState.getInstance();
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public AccountState getState() { return state; }
    public void setState(AccountState state) { this.state = state; }

    public void deposit(Double depositAmount) { state.deposit(this, depositAmount); }
    public void withdraw(Double withdrawAmount) { state.withdraw(this, withdrawAmount); }
    public void suspend() { state.suspend(this); }
    public void activate() { state.activate(this); }
    public void close() { state.close(this); }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Current Balance: " + balance;
    }
}
