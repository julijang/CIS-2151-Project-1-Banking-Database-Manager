public class Savings extends Account {

    private final double INTEREST_RATE;

    public Savings(int id, String accountHolder, AccountType accountType, double balance, double interestRate) {
        super(id, accountHolder, accountType, balance);
        this.INTEREST_RATE = interestRate;
    }

    public void addInterest() {
        double addInterest = (INTEREST_RATE / 12) * balance;
        balance += addInterest;
        System.out.println("Interest added: " + currency.format(addInterest));
    }

    @Override
    public String logTransaction(String transaction) {
        Savings savings = new Savings(getId(), getAccountHolder(), getAccountType(), getBalance(), INTEREST_RATE);
        if (savings.withdraw() > savings.getBalance()) {
            System.out.println("You have insuffiecint funds to withdraw: " + savings.withdraw() + ".");
        } else {
            System.out.println("You have successfully withdrawn: " + savings.withdraw() + ".");
        }
        return transaction;
    }

}