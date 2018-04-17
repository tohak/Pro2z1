package com.Konovalov;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Тоха on 17.04.18.
 */
@XmlRootElement(name = "trains")
public class Trains {

    @XmlElement(name = "train")
    private List<Train> trains = new ArrayList<>();

    public void add(Train train) {
        trains.add(train);
    }

    public int nextId(){
        return this.trains.size()+1;
    }

    public void getCheckTrains() {
        LocalTime fromTime = LocalTime.of(15, 00);
        LocalTime toTime = LocalTime.of(19, 05);
        StringBuffer sb = new StringBuffer();
        for (Train element :
                this.trains) {
            if ((element.localTime().compareTo(fromTime) >= 0) && (element.localTime().compareTo(toTime)) <= 0) {
                sb.append(element.toString()).append(System.lineSeparator());
            }

        }
        if (sb != null) {
            System.out.println("Trains from " + fromTime.toString() + " to " + toTime.toString());
            System.out.println(sb.toString());
        } else {
            System.out.println("Trains from " + fromTime.toString() + " to " + toTime.toString() + "no trains");
        }
    }


    @Override
    public String toString() {
        return Arrays.deepToString(trains.toArray());
    }
}
