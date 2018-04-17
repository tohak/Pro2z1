package com.Konovalov;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        Trains trains = new Trains();
        try {
            File file = new File("E:\\1.xml");
            File fileTho = new File("E:\\new.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            trains = (Trains) unmarshaller.unmarshal(file);
            System.out.println(trains);
            trains.getCheckTrains();

            int idNew=trains.nextId();
            Train trainNew = new Train(trains.nextId(),"Dnepr","Lviv", "19.12.2013", "20:30");
            trains.add(trainNew);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(trains, fileTho);
            marshaller.marshal(trains, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
