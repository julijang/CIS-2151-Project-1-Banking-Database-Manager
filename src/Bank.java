import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private static ArrayList<Account> accountsList = new ArrayList<>();

    public static void start() {

        System.out.println("Welcome to the J.G. Banking Application.");
        listOptions();
        int selNum = 0;
        boolean exit = false;

        while (exit == false) {
            try {

                Scanner keyboard = new Scanner(System.in);
                selNum = Integer.parseInt(keyboard.nextLine());

                switch (selNum) {
                    case 1:
                        System.out.println("You have selected the 'Add Account' option.");
                        addAccount();
                        break;
                    case 2:
                        System.out.println("You have selected the 'Remove Account' option.");
                        removeAccount();
                        break;
                    case 3:
                        System.out.println("You have selected the 'List Accounts' option.");
                        listAccounts();
                        break;
                    case 4:
                        System.out.println("You have selected the 'Check Balance' option.");
                        checkBalance();
                        break;
                    case 5:
                        System.out.println("You have selected the 'Withdraw' option.");
                        withdrawAccount();
                        break;
                    case 6:
                        System.out.println("You have selected the 'Deposit' option.");
                        depositAccount();
                        break;
                    case 7:
                        System.out.println("You have selected the 'Add Interest' option.");
                        addInterest();
                        break;
                    case 8:
                        System.out.println("Thank you for using the J.G. Banking Application. Goodbye.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Please select a valid menu option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid numerical input.");
            }
        }
    }

    public static void listOptions() {
        System.out.println("Please input a number corresponding to the menu option you would like to select: ");
        System.out.println("1. Add Account");
        System.out.println("2. Remove Account");
        System.out.println("3. List Accounts");
        System.out.println("4. Check Balance");
        System.out.println("5. Withdraw");
        System.out.println("6. Deposit");
        System.out.println("7. Add Interest");
        System.out.println("8. Exit J.G. Banking Application");
    }

    public static void addAccount() {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please select your account type: ");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        int accountType = Integer.parseInt(keyboard.nextLine());
        boolean accountExists = false;

        while (accountExists == false) {
            if (accountType == 1) {
                System.out.println("You have selected the Checking account type.");
                System.out.println("Please enter your first and last name: ");
                String accountHolder = keyboard.nextLine();
                System.out.println("Please enter an account ID: ");
                try {
                    int id = Integer.parseInt(keyboard.nextLine());
                    System.out.println("Please enter your initial deposit amount: ");
                    double balance = Double.parseDouble(keyboard.nextLine());
                    int freeTransactions = 3;
                    Account account = new Checking(id, accountHolder, AccountType.CHECKING, balance, freeTransactions);
                    System.out.println("Your new checking account has successfully been created.");
                    accountsList.add(account);
                    accountExists = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid numerical input.");
                }
            } else if (accountType == 2) {
                System.out.println("You have selected the Savings account type.");
                System.out.println("Please enter your first and last name: ");
                String accountHolder = keyboard.nextLine();
                System.out.println("Please enter an account ID: ");
                try {
                    int id = Integer.parseInt(keyboard.nextLine());
                    System.out.println("Please enter your initial deposit amount: ");
                    double balance = Double.parseDouble(keyboard.nextLine());
                    System.out.println("Please enter your account interest rate (1.0 - 4.0): ");
                    double interestRate = Double.parseDouble(keyboard.nextLine());
                    if (interestRate < 1.0 || interestRate > 4.0) {
                        System.out.println("Please enter a valid interest rate.");
                    } else {
                        Account account = new Savings(id, accountHolder, AccountType.SAVINGS, balance, interestRate);
                        System.out.println("Your account has been created.");
                        accountsList.add(account);
                        accountExists = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid numerical input.");
                }
            } else {
                System.out.println("Please select a valid account type.");
            }
        }
        listOptions();
    }

    public static void removeAccount() {
        Scanner keyboard = new Scanner(System.in);
        boolean accountFound = false;
        System.out.println("Please enter the account ID of the account you want to remove:");
        try {
            int accountId = Integer.parseInt(keyboard.nextLine());
            for (int i = 0; i < accountsList.size(); i++) {
                Account account = accountsList.get(i);
                if (account.getId() == accountId) {
                    accountsList.remove(i);
                    System.out.println("Account removed.");
                    accountFound = true;
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numerical input.");
        }
        if (!accountFound) {
            System.out.println("Account not found.");
        }
        listOptions();
    }

    public static void listAccounts() {
        if (accountsList.isEmpty()) {
            System.out.println("There are no accounts to list.");
        } else {
            System.out.println("Listing all accounts:");
            for (Account account : accountsList) {
                System.out.println("Account ID: " + account.getId());
                System.out.println("Account Holder: " + account.getAccountHolder());
                System.out.println("Account Type: " + account.getAccountType());
                System.out.println("Account Balance: " + account.getBalance());
            }
        }
        listOptions();
    }

    public static void checkBalance() {
        Scanner keyboard = new Scanner(System.in);
        boolean accountFound = false;
        System.out.println("Please enter the account ID of the account you want to check the balance of:");

        try {
            int accountId = Integer.parseInt(keyboard.nextLine());
            for (int i = 0; i < accountsList.size(); i++) {
                Account account = accountsList.get(i);
                if (account.getId() == accountId) {
                    System.out.println("Account balance: " + account.getBalance());
                    accountFound = true;
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numerical input.");
        }
        if (!accountFound) {
            System.out.println("Account not found.");
        }
        listOptions();
    }

    public static void withdrawAccount() {
        Scanner keyboard = new Scanner(System.in);
        boolean accountFound = false;
        System.out.println("Please enter the account ID of the account you want to withdraw from:");

        try {
            int accountId = Integer.parseInt(keyboard.nextLine());
            for (int i = 0; i < accountsList.size(); i++) {
                Account account = accountsList.get(i);
                if (account.getId() == accountId) {
                    accountFound = true;
                    System.out.println("Please enter the amount you would like to withdraw:");
                    double amount = Double.parseDouble(keyboard.nextLine());

                    if (amount > account.getBalance()) {
                        System.out.println("You do not have enough funds to withdraw this amount.");
                    } else {
                        account.withdraw(amount);
                        System.out.println("Account balance: " + account.getBalance());
                    }
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numerical input.");
        }
        if (!accountFound) {
            System.out.println("Account not found.");
        }
        listOptions();
    }

    public static void depositAccount() {
        Scanner keyboard = new Scanner(System.in);
        boolean accountFound = false;
        System.out.println("Please enter the account ID of the account you want to deposit to:");

        try {
            int accountId = Integer.parseInt(keyboard.nextLine());
            for (int i = 0; i < accountsList.size(); i++) {
                Account account = accountsList.get(i);
                if (account.getId() == accountId) {
                    accountFound = true;
                    System.out.println("Please enter the amount you would like to deposit:");
                    double amount = Double.parseDouble(keyboard.nextLine());

                    if (amount < 0) {
                        System.out.println("Please enter a valid amount.");
                    } else {
                        account.deposit(amount);
                        System.out.println("Account balance: " + account.getBalance());
                    }
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numerical input.");
        }
        if (!accountFound) {
            System.out.println("Account not found.");
        }
        listOptions();

    }

    public static void addInterest() {
        Scanner keyboard = new Scanner(System.in);
        boolean accountFound = false;
        System.out.println("Please enter the account ID of the account you want to add interest to:");

        try {
            int accountId = Integer.parseInt(keyboard.nextLine());
            for (int i = 0; i < accountsList.size(); i++) {
                Account account = accountsList.get(i);
                if (account.getId() == accountId) {
                    if (account.getAccountType() == AccountType.SAVINGS) {
                        Savings savingsAccount = (Savings) account;
                        savingsAccount.addInterest();
                        System.out.println("Account balance: " + account.getBalance());
                        accountFound = true;
                        break;
                    } else {
                        System.out.println("This account does not have interest.");
                        accountFound = true;
                        break;
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numerical input.");
        }
        if (!accountFound) {
            System.out.println("Account not found.");
        }
        listOptions();
    }
}