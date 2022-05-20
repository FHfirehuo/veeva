
public class VeeVaCalendar {

    public static int dayOfYear(int year, int month, int day) {
        try {
            effectiveCheck(year, month, day);
            return sumDays(year, month, day);
        } catch (Exception e) {
            //log.warn();
        }
        return -1;
    }

    private static int sumDays(int year, int month, int day) {

        if (month > 1) {
            day = day + 31;
        }

        if (month > 2) {
            day = day + februaryDay(year);
        }

        if (month > 3) {
            day = day + 31;
        }

        if (month > 4) {
            day = day + 30;
        }

        if (month > 5) {
            day = day + 31;
        }

        if (month > 6) {
            day = day + 30;
        }

        if (month > 7) {
            day = day + 31;
        }

        if (month > 8) {
            day = day + 31;
        }

        if (month > 9) {
            day = day + 30;
        }

        if (month > 10) {
            day = day + 31;
        }

        if (month > 11) {
            day = day + 30;
        }

        return day;
    }

    /**
     * 瑞年2月是29天
     * 非瑞年2月是28天
     */
    private static int februaryDay(int year) {
        if (leapYear(year)) {
            return 29;
        }
        return 28;
    }

    private static void effectiveCheck(int year, int month, int day) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day31Check(day);
                break;
            case 2:
                februaryCheck(year, day);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day30Check(day);
                break;
            default:
                throw new IllegalArgumentException("无效的月份: " + month);
        }
    }

    /**
     * 瑞年2月是29天
     * 非瑞年2月是28天
     */
    private static void februaryCheck(int year, int day) {
        if (leapYear(year)) {
            between(1, 29, day);
        } else {
            between(1, 28, day);
        }
    }

    /**
     * 瑞年判断
     */
    private static boolean leapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 != 0 && year % 4 == 0) {
            return true;
        }

        return false;
    }

    /**
     * 4、6、9、11月都是30天
     */
    private static void day30Check(int day) {
        between(1, 30, day);
    }

    /**
     * 1、3、5、7、8、10、12月都是31天
     */
    private static void day31Check(int day) {
        between(1, 31, day);
    }

    private static void between(int start, int end, int day) {
        if (day < start || day > end) {
            throw new IllegalArgumentException("无效的日: " + day);
        }
    }
}
