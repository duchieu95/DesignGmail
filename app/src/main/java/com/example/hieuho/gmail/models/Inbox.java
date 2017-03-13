package com.example.hieuho.gmail.models;

/**
 * Created by HieuHo on 12/03/2017.
 */

public class Inbox {
    public int id;
    public String from;
    public String subject;
    public String message;
    public String timestamp;
    public String picture;
    public int isImportant;
    public int isRead;
    public int color = -1;
    public int Type;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int Type){
        this.Type = Type;
    }

    public int getType(){
        return Type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(int isImportant) {
        this.isImportant = isImportant;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}
