public class VeeVaCalendar2 {
    private static int[] days= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

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
        for (int i = 0; i < month-1; i++) {
            day = day + days[i];
        }
        if (leapYear(year) && month > 2){
            return day + 1;
        }
        return day;
    }

    private static void effectiveCheck(int year, int month, int day) {
        if (day < 1){
            throw new IllegalArgumentException("");
        }
        if (month == 2){
            februaryCheck(year, day);
        }else if(day > days[month-1]){
            throw new IllegalArgumentException("");
        }

    }

    /**
     * 瑞年2月是29天
     * 非瑞年2月是28天
     */
    private static void februaryCheck(int year, int day) {
        if (leapYear(year) && day > days[1] + 1){
            throw new IllegalArgumentException("无效的天" + day);
        }

        if (!leapYear(year) && day > days[1]){
            throw new IllegalArgumentException("无效的天" + day);
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
}
