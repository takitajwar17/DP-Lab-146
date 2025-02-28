// AccountQuery.java
import java.util.List;

public class AccountQuery {
    private AccountRepository repository;

    public AccountQuery(AccountRepository repository) {
        this.repository = repository;
    }

    public double getBalance(String accountId) {
        BankAccount account = repository.findById(accountId);
        return account != null ? account.getBalance() : 0;
    }

    public List<Transaction> getTransactionHistory(String accountId) {
        BankAccount account = repository.findById(accountId);
        return account != null ? account.getTransactions() : List.of();
    }
}
