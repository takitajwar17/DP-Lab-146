import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private String transactionId;
    private String type;
    private double amount;
    private String description;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount, String description) {
        this.transactionId = UUID.randomUUID().toString();
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: $%.2f - %s",
                timestamp.toString(), type, amount, description);
    }
}
