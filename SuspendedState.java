public class SuspendedState implements AccountState {
    private static final SuspendedState instance = new SuspendedState();
    private SuspendedState() {}
    public static SuspendedState getInstance() { return instance; }

    @Override
    public void deposit(Account account, double amount) {
        System.out.println("You cannot deposit on a suspended account!");
        System.out.println(account.toString());
    }

    @Override
    public void withdraw(Account account, double amount) {
        System.out.println("You cannot withdraw on a suspended account!");
        System.out.println(account.toString());
    }

    @Override
    public void activate(Account account) {
        account.setState(ActiveState.getInstance());
        System.out.println("Account is activated!");
    }

    @Override
    public void suspend(Account account) {
        System.out.println("Account is already suspended!");
    }

    @Override
    public void close(Account account) {
        account.setState(ClosedState.getInstance());
        System.out.println("Account is closed!");
    }
}
