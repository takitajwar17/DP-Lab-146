import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
    private Map<String, BankAccount> accounts = new HashMap<>();

    public void save(BankAccount account) {
        accounts.put(account.getAccountId(), account);
    }

    public BankAccount findById(String accountId) {
        return accounts.get(accountId);
    }
}