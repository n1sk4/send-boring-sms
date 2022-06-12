package com.niksazupcic.smssender;

public class SMSItems {

    private String title;
    private String phone;
    private String message;
    private SMSNotification notification;
    private boolean expanded;

    public SMSItems(){
        this.title = "";
        this.phone = "";
        this.message = "";
        this.expanded = false;
    }

    public SMSItems(String title, String phone, String message, SMSNotification notification) {
        this.title = title;
        this.phone = phone;
        this.message = message;
        this.notification = notification;
        this.expanded = false;
    }

    public SMSItems(String title, String phone, String message) {
        this.title = title;
        this.phone = phone;
        this.message = message;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SMSNotification getNotification() {
        return notification;
    }

    public void setNotification(SMSNotification notification) {
        this.notification = notification;
    }
}
