public class Savings extends Account {
    private final double INTEREST_RATE;

    public Savings(int id, String accountHolder, AccountType type, double balance, double interestRate) {
        super(id, accountHolder, type, balance);
        this.INTEREST_RATE = interestRate;
    }

    public void addInterest() {
        double interest = (INTEREST_RATE / 12) * balance;
        balance += interest;
        System.out.println("Interest added: " + currency.format(interest));
    }

    @Override
    public String logTransaction(String transaction) {
        return transaction;
    }
}