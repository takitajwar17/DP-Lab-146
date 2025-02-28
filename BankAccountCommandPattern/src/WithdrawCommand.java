public class WithdrawCommand implements ICommand {
    private String accountId;
    private double amount;
    private String description;
    private AccountRepository repository;
    private boolean succeeded;

    public WithdrawCommand(String accountId, double amount, String description, AccountRepository repository) {
        this.accountId = accountId;
        this.amount = amount;
        this.description = description;
        this.repository = repository;
        this.succeeded = false;
    }

    @Override
    public void execute() {
        BankAccount account = repository.findById(accountId);
        if (account != null) {
            succeeded = account.withdraw(amount, description);
            if (succeeded) {
                repository.save(account);
            }
        }
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}