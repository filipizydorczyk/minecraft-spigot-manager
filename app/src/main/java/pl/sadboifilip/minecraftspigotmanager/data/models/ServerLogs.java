package pl.sadboifilip.minecraftspigotmanager.data.models;

import java.util.Date;

public class ServerLogs {

    private String logs;
    private Date date;

    public ServerLogs(String logs, Date date) {
        this.logs = logs;
        this.date = date;
    }

    public String getLogs() {
        return logs;
    }

    public Date getDate() {
        return date;
    }
}
