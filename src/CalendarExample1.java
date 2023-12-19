

import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarExample1 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        // int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        // calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        //   calendar.set(Calendar.WEEK_OF_MONTH, calendar.getActualMinimum(Calendar.WEEK_OF_MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, 29);
        calendar.set(Calendar.MONTH, 12);

        System.out.println("Week of the month: " + calendar.getTime());
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        // Print the result
        //System.out.println("Week of the month: " + weekOfMonth);
        Calendar calendarEndDate = Calendar.getInstance();
        //   calendarEndDate.add(Calendar.MONTH, 3);
        //  System.out.println("2 years later: " + calendarEndDate.getTime());
        ArrayList<Date> list = new ArrayList<>();
        list.addAll(getEmptyDates(calendar));
        list.add(calendar.getTime());

        System.out.println("MON TUE WED THU FRI SAT SUN");
        StringBuilder stringBuilder = new StringBuilder();
        int count = Calendar.SUNDAY;
        stringBuilder.append(getEmptySpace(Calendar.SUNDAY, Calendar.MONDAY));
        stringBuilder.append(calendar.get(Calendar.DAY_OF_MONTH)).append("\t");
        while (calendar.compareTo(calendarEndDate) <= 0) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
                System.out.println("SUN MON TUE WED THU FRI SAT");
                list.addAll(getEmptyDates(calendar));
            }
            stringBuilder.append(calendar.get(Calendar.DAY_OF_MONTH)).append("\t");
            if (stringBuilder.toString().split("\t").length >= 7) {
                System.out.println(stringBuilder);
                stringBuilder = new StringBuilder();
                count = 0;
            }
            list.add(calendar.getTime());
            count++;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list == null) {
                System.out.println("Calendar: Null list" + list.get(i));
            } else
                System.out.println("Calendar: " + list.get(i));
        }


        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        // Set the dates in the Calendar objects (replace these with your actual dates)
        calendar1.set(2023, Calendar.NOVEMBER, 1); // Example: October 1, 2023
        calendar2.set(2023, Calendar.OCTOBER, 14); // Example: October 10, 2023

        // Convert Calendar objects to Date objects
        //  Date date1 = calendar1.getTime();
        //   Date date2 = calendar2.getTime();

        // Calculate the difference in milliseconds
        long millisecondsDifference = calendar2.getTimeInMillis() - calendar1.getTimeInMillis();

        // Calculate the difference in days
        long daysDifference = millisecondsDifference / (24 * 60 * 60 * 1000);

        System.out.println("Days difference: " + daysDifference);
    /*    // Get the current calendar instance
        Calendar calendar = Calendar.getInstance();
        // Move the calendar to the first day of the current month
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // Move the calendar one day back to get the last day of the previous month
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        // Get the day of the week for the last day of the previous month
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        // Calculate the difference between the current day of the week and the last day of the week (Sunday)
        int daysUntilLastWeek = Calendar.SATURDAY - dayOfWeek;
        // Move the calendar by the difference to get the last day of the last week of the previous month
        calendar.add(Calendar.DAY_OF_MONTH, daysUntilLastWeek);
        // Get the minimum date of the last week
        Date minDateOfLastWeek = calendar.getTime();
        // Format the date for better readability
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // Print the result
        System.out.println("Minimum Date of the Last Week of the Month: " + sdf.format(minDateOfLastWeek));*/

        GregorianCalendar calendar3 = new GregorianCalendar();

        // Print the current date
        System.out.println("Current date: " + calendar3.getTime());

        // Add 13 months
        calendar3.add(GregorianCalendar.MONTH, 13);

        // Print the new date
        System.out.println("Date after adding 13 months: " + calendar3.getTime());
    }

    //{sun=1,mon=2,....,SATURDAY = 7}
    public static ArrayList<Date> getEmptyDates(Calendar calendar) {
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int startOfWeek = Calendar.SATURDAY - day;
        ArrayList<Date> list = new ArrayList<>();
        for (int i = 0; i < startOfWeek; i++) {
            list.add(null);
        }
        return list;
    }

    public static String getEmptySpace(int repeatCount, int calendarStartDate) {
        String string = "";
        for (int i = repeatCount; i < calendarStartDate - 1; i++) {
            string = string + "\t";
        }
        return string;
    }
}

