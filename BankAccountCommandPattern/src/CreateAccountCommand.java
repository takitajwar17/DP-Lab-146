public class CreateAccountCommand implements ICommand {
    private String accountId;
    private double initialDeposit;
    private AccountRepository repository;

    public CreateAccountCommand(String accountId, double initialDeposit, AccountRepository repository) {
        this.accountId = accountId;
        this.initialDeposit = initialDeposit;
        this.repository = repository;
    }

    @Override
    public void execute() {
        BankAccount account = new BankAccount(accountId, initialDeposit);
        repository.save(account);
    }
}