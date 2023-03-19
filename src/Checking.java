public class Checking extends Account {
    private final int FREE_TRANSACTIONS;
    private int FEE_AMOUNT;
    private int transactions;

    public Checking(int id, String accountHolder, AccountType type, double balance, int freeTransactions) {
        super(id, accountHolder, type, balance);
        this.FREE_TRANSACTIONS = freeTransactions;
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