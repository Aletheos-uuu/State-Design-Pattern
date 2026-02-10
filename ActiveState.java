public class ActiveState implements AccountState {
    private static final ActiveState instance = new ActiveState();
    private ActiveState() {}
    public static ActiveState getInstance() { return instance; }

    @Override
    public void deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposited " + amount);
        System.out.println(account.toString());
    }

    @Override
    public void withdraw(Account account, double amount) {
        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrew " + amount);
            System.out.println(account.toString());
        } else {
            System.out.println("Insufficient funds. " + account.toString());
        }
    }

    @Override
    public void activate(Account account) {
        System.out.println("Account is already activated!");
    }

    @Override
    public void suspend(Account account) {
        account.setState(SuspendedState.getInstance());
        System.out.println("Account is suspended!");
    }

    @Override
    public void close(Account account) {
        account.setState(ClosedState.getInstance());
        System.out.println("Account is closed!");
    }
}