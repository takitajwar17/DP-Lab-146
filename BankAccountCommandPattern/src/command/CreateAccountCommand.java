package command;

import model.BankAccount;
import repository.AccountRepository;

public class CreateAccountCommand implements ICommand {
    private String accountId;
    private double initialBalance;
    private AccountRepository repository;

    public CreateAccountCommand(String accountId, double initialBalance, AccountRepository repository) {
        this.accountId = accountId;
        this.initialBalance = initialBalance;
        this.repository = repository;
    }

    @Override
    public void execute() {
        BankAccount account = new BankAccount(accountId, initialBalance);
        repository.save(account);
    }
}