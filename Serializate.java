package lab2;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public interface Serializate {

    default void SerializeToXml(Airport Airport) {

         File file = new File("Airport.xml");
             try {
                 JAXBContext jc = JAXBContext.newInstance(Airport.class);
                 Marshaller marshaller = jc.createMarshaller();

                 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                 marshaller.marshal(Airport,file);
                 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                 marshaller.marshal(Airport,System.out);
             } catch (JAXBException e) {
                 e.printStackTrace();
             }
    }

    default Airport SerializeFromXml(){

        File file = new File("Airport.xml");

        Airport Airport = new Airport();
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Airport.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Airport = (Airport) unmarshaller.unmarshal(file);
            return Airport;
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }


    default void SerializeToJson(Airport Airport){

        File file = new File("Airport.json");

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, Airport);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    default Airport SerializeFromJson(){

        File file = new File("Airport.json");
        Airport Airport = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
           Airport =  mapper.readValue(file,Airport.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Airport;

    }

    default void SerializeToTxt(Airport Airport){

        File file = new File("Airport.txt");

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            if(fos != null) {
                try {
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(Airport);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    default Airport SerializeFromTxt(){

        File file = new File("Airport.txt");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            if(fis != null) {
                try {
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    try {
                        Airport Airport = (Airport) ois.readObject();
                        return Airport;
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
