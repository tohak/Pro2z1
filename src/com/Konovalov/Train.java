package com.Konovalov;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.crypto.Data;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Тоха on 17.04.18.
 */
@XmlRootElement(name = "train")
public class Train {
    private int id;
    private String from;
    private String to;
    private String date;
    private String departure;

    public Train() {
    }

    public Train(int id, String from, String to, String date, String departure) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getDeparture() {
        return departure;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }

    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement
    public void setDeparture(String departure) {
        this.departure = departure;
    }
public LocalTime localTime(){
        return LocalTime.parse(departure, DateTimeFormatter.ISO_TIME);
}
    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                ", departure=" + departure +
                '}';
    }
}

