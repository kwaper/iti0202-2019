package ee.taltech.iti0202.idcode;

public class IDCode {
    private enum Gender {
        MALE, FEMALE
    }

    private static final int SEVEN = 7;

    private static final int ELEVEN = 11;

    private static final int EIGHT = 8;

    private static final int THIRTEEN = 13;

    private static final int TWELVE = 12;

    private static final int SIX = 6;

    private static final int NINE = 9;

    private static final int THIRTY = 30;

    private static final int THIRTYONE = 31;

    private static final int TRHIRTYTWO = 32;

    private static final int TWENTYNINE = 29;

    private static final int FH = 400;

    private static final int ETH = 1800;

    private static final int NTH = 1900;

    private static final int TH = 2000;


    public static boolean isIDCodeCorrect(String idCode) {
        return idCode.length() == ELEVEN && isDayNumberCorrect(idCode) && isMonthNumberCorrect(idCode)
                && isYearNumberCorrect(idCode) && isControlNumberCorrect(idCode) && isGenderNumberCorrect(idCode)
                && isQueueNumberCorrect(idCode);
    }

    private static boolean isGenderNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(0, 1)) > 0 && Integer.parseInt(idCode.substring(0, 1)) < SEVEN;
    }

    private static boolean isYearNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(1, 3)) >= 0 && Integer.parseInt(idCode.substring(1, 3)) < 100;
    }

    private static boolean isMonthNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(3, 5)) > 0 && Integer.parseInt(idCode.substring(3, 5)) < THIRTEEN;
    }

    private static boolean isDayNumberCorrect(String idCode) {
        int day = Integer.parseInt(idCode.substring(5, SEVEN));
        int month = Integer.parseInt(idCode.substring(3, 5));
        int[] more = {1, 3, 5, SEVEN, EIGHT, 10, TWELVE};
        int[] less = {4, SIX, NINE, ELEVEN};
        int leap = 2;
        if (day > 0 && day < TRHIRTYTWO) {
            for (int x : more) {
                if (month == x) {
                    return true;
                }
            }
            for (int x : less) {
                if (month == x) {
                    return day < THIRTYONE;
                }
            }
            if (month == leap) {
                if (isLeapYear(getFullYear(idCode))) {
                    return day < THIRTY;
                }
                return day < TWENTYNINE;
            }
        }
        return false;
    }

    private static boolean isQueueNumberCorrect(String idCode) {
        return Integer.parseInt(idCode.substring(SEVEN, 10)) > 0
                && Integer.parseInt(idCode.substring(SEVEN, 10)) < 1000;
    }

    private static boolean isControlNumberCorrect(String idCode) {
        int[] multipliers1 = {1, 2, 3, 4, 5, SIX, SEVEN, EIGHT, NINE, 1};
        int[] multipliers2 = {3, 4, 5, SIX, SEVEN, EIGHT, NINE, 1, 2, 3};
        int s = 0;
        for (int i = 0; i < 10; i++) {
            s += Integer.parseInt(idCode.substring(i, i + 1)) * multipliers1[i];
        }
        if (s % ELEVEN == Integer.parseInt(idCode.substring(10, ELEVEN)) && s != 10) {
            return true;
        } else if (s % ELEVEN == 10) {
            s = 0;
            for (int i = 0; i < 10; i++) {
                s += Integer.parseInt(idCode.substring(i, i + 1)) * multipliers2[i];
            }
            return (s % ELEVEN == Integer.parseInt(idCode.substring(10, ELEVEN)));
        }
        return false;
    }

    private static boolean isLeapYear(int fullYear) {
        return ((fullYear % 4 == 0) && (fullYear % 100 != 0) || (fullYear % FH == 0));
    }

    public static String getInformationFromIDCode(String idCode) {
        if (isIDCodeCorrect(idCode)) {
            return "This is a " + getGender(idCode).toString().toLowerCase() + " born on " + idCode.substring(5, SEVEN)
                    + "." + idCode.substring(3, 5) + "." + getFullYear(idCode);
        }
        return "Given invalid ID code!";

    }

    public static Gender getGender(String idCode) {
        int g = Integer.parseInt(idCode.substring(0, 1));
        switch (g) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            case 3:
                return Gender.MALE;
            case 4:
                return Gender.FEMALE;
            case 5:
                return Gender.MALE;
            case SIX:
                return Gender.FEMALE;
            default:
                return null;
        }
    }

    public static int getFullYear(String idCode) {
        int g = Integer.parseInt(idCode.substring(0, 1));
        int y = Integer.parseInt(idCode.substring(1, 3));
        int year;
        if (g == 1 || g == 2) {
            year = ETH + y;
            return year;
        } else if (g == 3 || g == 4) {
            year = NTH + y;
            return year;
        } else if (g == 5 || g == SIX) {
            year = TH + y;
            return year;
        }
        return 0;
    }
}
