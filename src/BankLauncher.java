public class BankLauncher {
    public static void main(String[] args) {
        Savings savingsTest = new Savings(1, "John", AccountType.SAVINGS, 1500, 2.0);
        System.out.println(savingsTest.getId());
        System.out.println(savingsTest.getBalance());
        System.out.println(savingsTest.getBalanceFormatted());
        System.out.println(savingsTest.getAccountType());
        System.out.println(savingsTest.getAccountHolder());
        savingsTest.withdraw(1000);
        savingsTest.withdraw(150);
        savingsTest.deposit(200);
        savingsTest.addInterest();
    }
}
