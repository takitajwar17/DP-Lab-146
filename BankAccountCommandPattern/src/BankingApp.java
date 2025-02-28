import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import command.CreateAccountCommand;
import command.DepositCommand;
import command.ICommand;
import command.TransferCommand;
import command.WithdrawCommand;
import model.Transaction;
import query.AccountQuery;
import repository.AccountRepository;

public class BankingApp {
    private static AccountRepository repository = new AccountRepository();
    private static AccountQuery query = new AccountQuery(repository);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Banking Application");
        String currentAccount = null;

        while (running) {
            System.out.println("\n===== Banking Menu =====");
            System.out.println("1. Create New Account");
            System.out.println("2. Select Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. View Transaction History");
            System.out.println("7. Transfer Money");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = -1;
            boolean validInput = false;
            
            while (!validInput) {
                try {
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        validInput = true;
                    } else {
                        System.out.println("Invalid input! Please enter a number.");
                        System.out.print("Enter choice: ");
                    }
                    scanner.nextLine();  // consume newline
                } catch (Exception e) {
                    System.out.println("Error reading input. Please try again.");
                    System.out.print("Enter choice: ");
                    scanner.nextLine();  // clear the invalid input
                }
            }

            switch (choice) {
                case 1:
                    double initialDeposit = 0;
                    boolean validDepositInput = false;
                    while (!validDepositInput) {
                        System.out.print("Enter initial deposit amount: ");
                        try {
                            if (scanner.hasNextDouble()) {
                                initialDeposit = scanner.nextDouble();
                                if (initialDeposit < 0) {
                                    System.out.println("Invalid input! Deposit amount cannot be negative.");
                                } else {
                                    validDepositInput = true;
                                }
                            } else {
                                System.out.println("Invalid input! Please enter a valid number.");
                            }
                            scanner.nextLine();  // consume newline
                        } catch (Exception e) {
                            System.out.println("Error reading input. Please try again.");
                            scanner.nextLine();  // clear the invalid input
                        }
                    }
                    String accountId = UUID.randomUUID().toString().substring(0, 8);
                    ICommand createCommand = new CreateAccountCommand(accountId, initialDeposit, repository);
                    createCommand.execute();
                    System.out.println("Account created with ID: " + accountId);
                    currentAccount = accountId;
                    break;

                case 2:
                    System.out.print("Enter account ID: ");
                    currentAccount = scanner.nextLine();
                    if (repository.findById(currentAccount) == null) {
                        System.out.println("Account not found!");
                        currentAccount = null;
                    } else {
                        System.out.println("Account selected: " + currentAccount);
                    }
                    break;

                case 3:
                    if (currentAccount == null) {
                        System.out.println("No account selected!");
                        break;
                    }
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter description: ");
                    String depositDesc = scanner.nextLine();
                    ICommand depositCommand = new DepositCommand(currentAccount, depositAmount, depositDesc, repository);
                    depositCommand.execute();
                    System.out.println("Deposit successful");
                    break;

                case 4:
                    if (currentAccount == null) {
                        System.out.println("No account selected!");
                        break;
                    }
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter description: ");
                    String withdrawDesc = scanner.nextLine();
                    WithdrawCommand withdrawCommand = new WithdrawCommand(currentAccount, withdrawAmount, withdrawDesc, repository);
                    withdrawCommand.execute();
                    if (withdrawCommand.isSucceeded()) {
                        System.out.println("Withdrawal successful");
                    } else {
                        System.out.println("Insufficient funds");
                    }
                    break;

                case 5:
                    if (currentAccount == null) {
                        System.out.println("No account selected!");
                        break;
                    }
                    double balance = query.getBalance(currentAccount);
                    System.out.println("Current balance: $" + balance);
                    break;

                case 6:
                    if (currentAccount == null) {
                        System.out.println("No account selected!");
                        break;
                    }
                    List<Transaction> transactions = query.getTransactionHistory(currentAccount);
                    System.out.println("Transaction History:");
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction);
                    }
                    break;

                case 7:
                    if (currentAccount == null) {
                        System.out.println("No account selected!");
                        break;
                    }
                    List<String> toAccountIds = new ArrayList<>();
                    boolean addingRecipients = true;
                    
                    while (addingRecipients) {
                        System.out.print("Enter recipient account ID (or 'done' to finish): ");
                        String toAccountId = scanner.nextLine();
                        
                        if (toAccountId.equalsIgnoreCase("done")) {
                            addingRecipients = false;
                        } else {
                            if (repository.findById(toAccountId) == null) {
                                System.out.println("Recipient account not found!");
                            } else if (toAccountId.equals(currentAccount)) {
                                System.out.println("Cannot transfer to your own account!");
                            } else if (toAccountIds.contains(toAccountId)) {
                                System.out.println("This recipient is already added!");
                            } else {
                                toAccountIds.add(toAccountId);
                                System.out.println("Recipient added successfully.");
                            }
                        }
                    }
                    
                    if (toAccountIds.isEmpty()) {
                        System.out.println("No valid recipients added!");
                        break;
                    }
                    
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter description: ");
                    String transferDesc = scanner.nextLine();
                    
                    // Show confirmation prompt
                    double totalAmount = transferAmount * toAccountIds.size();
                    System.out.println("\nTransfer Details:");
                    System.out.println("From Account: " + currentAccount);
                    System.out.println("To Accounts: " + String.join(", ", toAccountIds));
                    System.out.println("Amount per recipient: $" + transferAmount);
                    System.out.println("Total amount to be withdrawn: $" + totalAmount);
                    System.out.println("Description: " + transferDesc);
                    System.out.print("\nConfirm transfer? (yes/no): ");
                    
                    String confirmation = scanner.nextLine();
                    if (confirmation.equalsIgnoreCase("yes")) {
                        TransferCommand transferCommand = new TransferCommand(currentAccount, toAccountIds, transferAmount, transferDesc, repository);
                        transferCommand.execute();
                        if (transferCommand.isSucceeded()) {
                            System.out.println("Transfer successful");
                        } else {
                            System.out.println("Transfer failed - Insufficient funds");
                        }
                    } else {
                        System.out.println("Transfer cancelled");
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Thank you for using Banking Application");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }
}