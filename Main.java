package lab2;

import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String args[]){

        Employee w1 = new Employee();

        w1.setId(1);
        w1.setSurname("Dorosenko");
        w1.setName("Artem");
        w1.setLastname("Panasovych");
        w1.setGender("Male");
        w1.setAge(51);
        w1.older();
        w1.Employee();
        w1.getGenderStr();

        Employee w2 = new Employee();
        w2.setId(2);
        w2.setSurname("Vatin");
        w2.setName("Sasha");
        w2.setLastname("Olehyvna");
        w2.setGender("Female");
        w2.setAge(22);
        w2.older();
        w2.Employee();
        w2.getGenderStr();

        Employee w3 = new Employee();
        w3.setId(3);
        w3.setSurname("Rusnak");
        w3.setName("Vasyl");
        w3.setLastname("Vasylovych");
        w3.setGender("Male");
        w3.setAge(26);
        w3.older();
        w3.Employee();
        w3.getGenderStr();

        Employee w4 = new Employee();
        w4.setId(4);
        w4.setSurname("Krypov");
        w4.setName("Anton");
        w4.setLastname("Denisovych");
        w4.setAge(31);
        w4.setGender("Male");
        w4.older();
        w4.Employee();
        w4.getGenderStr();

        Employee w5 = new Employee();
        w5.setId(5);
        w5.setSurname("Puzenko");
        w5.setName("Yevhen");
        w5.setLastname("Viktoryvna");
        w5.setAge(19);
        w5.setGender("Female");
        w5.older();
        w5.Employee();
        w5.getGenderStr();

        Employee w6 = new Employee();
        w6.setId(6);
        w6.setSurname("Sytenko");
        w6.setName("Antonina");
        w6.setLastname("Valetyvna");
        w6.setAge(44);
        w6.setGender("Female");
        w6.older();
        w6.Employee();
        w6.getGenderStr();

        Employee w7 = new Employee();
        w7.setId(7);
        w7.setSurname("Baluk");
        w7.setName("Ihor");
        w7.setLastname("Andriovych");
        w7.setAge(31);
        w7.setGender("Male");
        w7.older();
        w7.Employee();
        w7.getGenderStr();



        Airport Airport = new Airport();
        Airport.setNumberAirport(1);
        Airport.setNameAirport("Boruspil");
        List<Employee> list = new ArrayList<Employee>();
        list.add(w1);
        list.add(w2);
        list.add(w6);
        Airport.setList(list);

        Airport.SerializeToTxt(Airport);
      Airport Airport1 = Airport.SerializeFromTxt();
        System.out.println(Airport1);


        Airport Airport2 = new Airport();
        Airport2.setNumberAirport(2);
        Airport2.setNameAirport("Kharkiv");
        List<Employee> list1 = new ArrayList<Employee>();

        list1.add(w3);
        list1.add(w7);
        list1.add(w5);
        list1.add(w6);

        Airport2.setList(list1);

        Airport2.SerializeToXml(Airport2);

        Airport Airport3 = Airport2.SerializeFromXml();
        System.out.println(Airport3);

       Airport Airport4 = new Airport();
        Airport4.setNumberAirport(3);
        Airport4.setNameAirport("Shevchenko");

       List<Employee> list2 = new ArrayList<Employee>();

        list2.add(w4);
        list2.add(w2);
        list2.add(w5);
        list2.add(w1);

        Airport4.setList(list2);

        Airport4.SerializeToJson(Airport4);

        Airport Airport5 = Airport4.SerializeFromJson();
        System.out.println(Airport5);

    }
}
