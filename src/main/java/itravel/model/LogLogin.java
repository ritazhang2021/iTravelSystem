package itravel.model;

import java.time.LocalDateTime;

public class LogLogin {
    private int id;
    private String userId;
    private LocalDateTime timeLog;
    private int status;
    private String notes;

    public LogLogin() {
        this.id         = 0;
        this.userId     = "";
        this.timeLog    = null;
        this.notes      = "";
        this.status     = -1;
    }

    public LogLogin(int id, String userId, LocalDateTime timeLog, int status, String notes) {
        this.id         = id;
        this.userId     = userId;
        this.timeLog    = timeLog;
        this.status     = status;
        this.notes      = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getTimeLog() {
        return timeLog;
    }

    public void setTimeLog(LocalDateTime timeLog) {
        this.timeLog = timeLog;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
