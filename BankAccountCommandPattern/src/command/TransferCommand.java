package command;

import model.BankAccount;
import repository.AccountRepository;
import java.util.List;
import java.util.ArrayList;

public class TransferCommand implements ICommand {
    private String fromAccountId;
    private List<String> toAccountIds;
    private double amount;
    private String description;
    private AccountRepository repository;
    private boolean succeeded;

    public TransferCommand(String fromAccountId, List<String> toAccountIds, double amount, String description, AccountRepository repository) {
        this.fromAccountId = fromAccountId;
        this.toAccountIds = toAccountIds;
        this.amount = amount;
        this.description = description;
        this.repository = repository;
        this.succeeded = false;
    }

    @Override
    public void execute() {
        if (toAccountIds == null || toAccountIds.isEmpty()) {
            succeeded = false;
            return;
        }

        // Remove duplicates and self-transfers
        List<String> uniqueRecipients = new ArrayList<>();
        for (String toId : toAccountIds) {
            if (!toId.equals(fromAccountId) && !uniqueRecipients.contains(toId)) {
                uniqueRecipients.add(toId);
            }
        }

        if (uniqueRecipients.isEmpty()) {
            succeeded = false;
            return;
        }

        // Update toAccountIds with unique recipients
        toAccountIds = uniqueRecipients;

        BankAccount fromAccount = repository.findById(fromAccountId);
        if (fromAccount == null) {
            succeeded = false;
            return;
        }

        // Verify all recipient accounts exist
        List<BankAccount> toAccounts = new ArrayList<>();
        for (String toId : toAccountIds) {
            BankAccount toAccount = repository.findById(toId);
            if (toAccount == null) {
                succeeded = false;
                return;
            }
            toAccounts.add(toAccount);
        }

        // Each recipient will receive the full amount
        
        // Attempt withdrawal for total amount
        // Calculate total amount needed (amount × number of recipients)
        double totalAmount = amount * toAccountIds.size();
        succeeded = fromAccount.withdraw(totalAmount, "Transfer to multiple accounts (" + toAccountIds.size() + " recipients): " + description);
        
        if (succeeded) {
            // Deposit to each recipient
            for (int i = 0; i < toAccounts.size(); i++) {
                BankAccount toAccount = toAccounts.get(i);
                String toId = toAccountIds.get(i);
                toAccount.deposit(amount, "Transfer from " + fromAccountId + ": " + description);
                repository.save(toAccount);
            }
            repository.save(fromAccount);
        }
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}