import java.util.List;
import java.util.Scanner;
import java.util.UUID;

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
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter initial deposit amount: ");
                    double initialDeposit = scanner.nextDouble();
                    scanner.nextLine();  // consume newline
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

                case 0:
                    running = false;
                    System.out.println("Thank you for using Banking Application");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}