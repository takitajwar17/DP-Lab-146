package model;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountId;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        this.transactions.add(new Transaction("DEPOSIT", initialBalance, "Initial deposit"));
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public void deposit(double amount, String description) {
        balance += amount;
        transactions.add(new Transaction("DEPOSIT", amount, description));
    }

    public boolean withdraw(double amount, String description) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("WITHDRAW", amount, description));
            return true;
        }
        return false;
    }
}