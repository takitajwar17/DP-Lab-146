package command;

import model.BankAccount;
import repository.AccountRepository;

public class DepositCommand implements ICommand {
    private String accountId;
    private double amount;
    private String description;
    private AccountRepository repository;

    public DepositCommand(String accountId, double amount, String description, AccountRepository repository) {
        this.accountId = accountId;
        this.amount = amount;
        this.description = description;
        this.repository = repository;
    }

    @Override
    public void execute() {
        BankAccount account = repository.findById(accountId);
        if (account != null) {
            account.deposit(amount, description);
            repository.save(account);
        }
    }
}