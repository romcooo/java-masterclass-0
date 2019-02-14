package com.roman.Chapter8.Boxing.Challenge;

public class Main {
    public static void main(String[] args) {
        Bank newBank = Bank.createBank("Mbank", "Brno1", "Peter", 100);
        newBank.getBranchByName("Brno1").getCustomerByName("Peter").addTransaction(200);
        newBank.getBranchByName("Brno1").addCustomer(Customer.createCustomer("Marek", 1500));
        newBank.getBranchByName("Brno1").addCustomer(Customer.createCustomer("Vlado", 1000));

        newBank.printBranches(false, false);

        newBank.addBranch(Branch.createBranch("Brno2", "Juraj", 500));
        newBank.addBranch("Brno Holandska");
        newBank.getBranchByName("Brno Holandska").addCustomer("Maxim");
        newBank.getBranchByName("Brno Holandska").getCustomerByName("Maxim").addTransaction(1300);
        newBank.getBranchByName("Brno Holandska").getCustomerByName("Maxim").addTransaction(1900);
        newBank.getBranchByName("Brno Holandska").getCustomerByName("Maxim").addTransaction(500);

        newBank.printBranches(true, true);
        newBank.printBranches(false, true);
    }
}
