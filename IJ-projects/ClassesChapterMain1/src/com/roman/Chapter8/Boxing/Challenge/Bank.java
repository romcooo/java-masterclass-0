package com.roman.Chapter8.Boxing.Challenge;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(final String name) {
        this.name = name;
    }

    public Bank(final String name, final ArrayList<Branch> branches) {
        this.name = name;
        this.branches = branches;
    }

    public Bank(String name, String branchName, String customerName, double initialCustomerTransaction) {
        this.name = name;
        this.branches = new ArrayList<>();
        addBranch(
                Branch.createBranch(branchName, customerName, initialCustomerTransaction)
        );
    }

    public static Bank createBank(String name, String branchName, String customerName, double initialCustomerTransaction) {
        return new Bank(name, branchName, customerName, initialCustomerTransaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        for (Branch branch:branches) {
            System.out.println("Branch: " + branch.getName());
        }
        return branches;
    }

    public Branch getBranchByName(String name) {
        for (Branch branch : branches) {
            if (branch.getName() == name) {
                return branch;
            }
        }
        return null;
    }


    public void printName() {
        System.out.println("Bank: " + name);
    }

    public void printBranches(boolean showCustomers, boolean showTransactions) {
        for (Branch branch : branches) {
            branch.printName();
            if(showCustomers) {
                branch.printCustomersWithTransactions(showTransactions);
            }
        }
    }

    public boolean addBranch(Branch branch) {
        branches.add(branch);
        return true;
    }

    public boolean addBranch(String branchName) {
        if (getBranchByName(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }
}
