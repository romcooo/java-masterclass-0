package com.roman;


public class Main {

    static String CM_VALIDATION_ERROR = "Validation error";

    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if (feet < 0 || (0 > inches || inches > 12)) {
            System.out.println(CM_VALIDATION_ERROR);
            return -1;
        }
        double result = calcFeetAndInchesToCentimeters(feet*12 + inches);
        System.out.println(feet+" feet, "+inches+" inches is equal to "+result + " cenitmeters.");
        return result;
    }

    public static double calcFeetAndInchesToCentimeters(double inches){
        if (0 > inches) {
            System.out.println(CM_VALIDATION_ERROR);
            return -1;
        }
        double feet = inches / 12;
        double remainingInches = (int) inches % 12;
        System.out.println(inches+" inches is equal to "+feet+" feet and "+remainingInches+" inches.");
        return (inches*2.54);
    }

    public static void main(String[] args) {
        // write your code here
        double inches = 2.5d;
        double feet = 0d;
        double result = calcFeetAndInchesToCentimeters(feet, inches);
        System.out.println(result);
    }
}