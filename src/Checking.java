public class Checking extends Account {

    private final int FREE_TRANSACTIONS;
    private int FEE_AMOUNT;
    private int transactions;

    public Checking(int id, String accountHolder, AccountType accountType, double balance, int FREE_TRANSACTIONS) {
        super(id, accountHolder, accountType, balance);
        this.FREE_TRANSACTIONS = FREE_TRANSACTIONS;
        this.FEE_AMOUNT = 4;
    }

    public void deductFees() {
        if (transactions > FREE_TRANSACTIONS) {
            int fees = transactions - FREE_TRANSACTIONS;
            balance -= fees * FEE_AMOUNT;
            System.out.println("Fees deducted: " + currency.format(fees * FEE_AMOUNT));
        }
    }
    @Override
    public String logTransaction(String transaction) {
        return transaction;
    }
}
