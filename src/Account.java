import java.text.NumberFormat;

public abstract class Account {
    private int id;
    private String accountHolder;
    private AccountType accountType;
    protected double balance;
    protected NumberFormat currency;

    public Account(int id, String accountHolder, AccountType accountType, double balance) {
        this.id = id;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.balance = balance;
        this.currency = NumberFormat.getCurrencyInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBalanceFormatted() {
        return currency.format(balance);
    }

    public Double deposit(double amount) {
        balance += amount;
        return amount;
    }

    public Double withdraw(double amount) {
        balance -= amount;
        return amount;
    }

    public abstract String logTransaction(String transaction);
}