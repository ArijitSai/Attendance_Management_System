package Attendance_Management_System;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Attendance {
    private User user;
    private Date date;
    private boolean present;

    public Attendance(User user, Date date, boolean present) {
        this.user = user;
        this.date = date;
        this.present = present;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public boolean isPresent() {
        return present;
    }
}

class AttendanceManager {
    private List<Attendance> attendanceList;

    public AttendanceManager() {
        this.attendanceList = new ArrayList<>();
    }

    public void markAttendance(User user, Date date, boolean present) {
        Attendance attendance = new Attendance(user, date, present);
        attendanceList.add(attendance);
    }

    public List<Attendance> getAttendanceReport(User user, Date startDate, Date endDate) {
        List<Attendance> report = new ArrayList<>();
        for (Attendance attendance : attendanceList) {
            if (attendance.getUser().getUserId().equals(user.getUserId())
                    && attendance.getDate().compareTo(startDate) >= 0
                    && attendance.getDate().compareTo(endDate) <= 0) {
                report.add(attendance);
            }
        }
        return report;
    }
}

public class Main {
    public static void main(String[] args) throws ParseException {
        // Create users
        User user1 = new User("1", "john_doe", "password123");
        User user2 = new User("2", "jane_doe", "pass456");

        // Create AttendanceManager
        AttendanceManager attendanceManager = new AttendanceManager();

        // Mark attendance
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        attendanceManager.markAttendance(user1, dateFormat.parse("2023-01-01"), true);
        attendanceManager.markAttendance(user1, dateFormat.parse("2023-01-02"), false);
        attendanceManager.markAttendance(user2, dateFormat.parse("2023-01-01"), true);

        // Retrieve and print attendance report
        List<Attendance> report = attendanceManager.getAttendanceReport(user1, dateFormat.parse("2023-01-01"), dateFormat.parse("2023-01-03"));
        for (Attendance attendance : report) {
            System.out.println("Date: " + dateFormat.format(attendance.getDate()) +
                    ", Present: " + attendance.isPresent());
        }
    }
}


