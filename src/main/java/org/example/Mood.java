package org.example;

public class Mood {
    private String date;
    private String mood;
    private String note;

    public Mood(String date, String mood, String note) {
        this.date = date;
        this.mood = mood;
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public String getMood() {
        return mood;
    }

    public String getNote() {
        return note;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String toCSV() {
        return date + "," + mood + "," + note;
    }
}
