package com.roman.controlFlowStatementsChapter.CodingExercises;

public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if(bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }
        // The formula should be:
        // 1. goal % 5 -> smallCount has to be equal or greater than this (eg. if goal is 11, I need at least one small pack...)
        // 2. total count needs to be bigCount*5 + smallCount and this needs to be equal to or larger than goal in addition to 1st condition
        int totalCount = bigCount*5 + smallCount;
        int fillerCount = goal % 5;
        if (totalCount >= goal && smallCount >= fillerCount) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPack(1,1,5)); // have 5, need 5
        System.out.println(canPack(1, 3, 9)); // have 8, need 9
        System.out.println(canPack(2, 1, 9)); //
        System.out.println(canPack(0, 5, 4)); //
        System.out.println(canPack(0, 5, 5)); //

    }
}
