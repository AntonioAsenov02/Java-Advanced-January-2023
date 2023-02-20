package Lab_6DefiningClasses.P03BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] lineArguments = scanner.nextLine().split("\\s+");

        Map<Integer,BankAccount> accounts = new HashMap<>();

        String command = lineArguments[0];
        while (!command.equals("End")){

            String result = "";

            switch (command) {
                case "Create":

                    BankAccount bankAccount = new BankAccount();
                    result = String.format("Account ID%d created",bankAccount.getId());

                    accounts.put(bankAccount.getId(),bankAccount);
                    break;
                case "Deposit":

                    int accountID = Integer.parseInt(lineArguments[1]);
                    double money = Double.parseDouble(lineArguments[2]);

                    if (accounts.containsKey(accountID)){

                        BankAccount bankAccountFromMap = accounts.get(accountID);
                        bankAccountFromMap.deposit(money);

                        accounts.put(accountID,bankAccountFromMap);
                        result = String.format("Deposited %.0f to ID%d",money,accountID);

                    }else {

                        result = "Account does not exist";
                    }

                    break;
                case "SetInterest":

                    double interest = Double.parseDouble(lineArguments[1]);

                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":

                    int id = Integer.parseInt(lineArguments[1]);
                    int years = Integer.parseInt(lineArguments[2]);



                    if (accounts.containsKey(id)){
                        BankAccount bankAccount1 = accounts.get(id);

                      double accumulatedInterest = bankAccount1.getInterest(years);
                      result = String.format("%.2f",accumulatedInterest);
                    }else {

                        result = "Account does not exist";
                    }
                    break;
            }

            if (!result.equals("")){

                System.out.println(result);
            }

            lineArguments = scanner.nextLine().split("\\s+");
            command = lineArguments[0];
        }
    }
}
