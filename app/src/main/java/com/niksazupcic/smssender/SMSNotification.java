package com.niksazupcic.smssender;

import java.sql.Date;
import java.sql.Time;

public class SMSNotification {
    private Time time;
    private Date date;
    private boolean recurring;

    public SMSNotification(Time time, Date date, boolean recurring) {
        this.time = time;
        this.date = date;
        this.recurring = recurring;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }
}
