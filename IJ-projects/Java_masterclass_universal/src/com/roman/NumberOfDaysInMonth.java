package com.roman;

public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year){
        if (year < 1 || year > 9999){
            return false;
        }
        if ((year % 4 == 0 && year % 100 != 0)
                || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12 || year < 1 || year > 9999) {
            return -1;
        }
        int daysInMonth = -1;
        switch(month){
            case 1:
                daysInMonth = 31;
                break;
            case 2:
                if(isLeapYear(year)) {
                    daysInMonth = 29;
                } else daysInMonth = 28;
                break;
            case 3:
                daysInMonth = 31;
                break;
            case 4:
                daysInMonth = 30;
                break;
            case 5:
                daysInMonth = 31;
                break;
            case 6:
                daysInMonth = 30;
                break;
            case 7:
                daysInMonth = 31;
                break;
            case 8:
                daysInMonth =31;
                break;
            case 9:
                daysInMonth = 30;
                break;
            case 10:
                daysInMonth = 31;
                break;
            case 11:
                daysInMonth = 30;
                break;
            case 12:
                daysInMonth = 31;
                break;
            default:
                break;
        }
        return daysInMonth;
    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));
        System.out.println(getDaysInMonth(2,2016));
        System.out.println(getDaysInMonth(2, 2013));
    }
}
