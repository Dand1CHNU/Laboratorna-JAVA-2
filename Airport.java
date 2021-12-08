package lab2;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@XmlRootElement(name = "Airport")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"numberAirport","nameAirport","list"})
public class Airport implements Serializate, Serializable {

    private String nameAirport;
    private int numberAirport;
    private List<Employee> list;

    public String getNameAirport() {
        return nameAirport;
    }
    @XmlElement
    public void setNameAirport(String nameAirport) {
        this.nameAirport = nameAirport;
    }

    public int getNumberAirport() {
        return numberAirport;
    }
    @XmlAttribute(name = "id")
    public void setNumberAirport(int numberAirport) {
        this.numberAirport = numberAirport;
    }

    public List<Employee> getList() {
        return list;
    }

    @XmlElement(name = "Employees")
    public void setList(List<Employee> list) {
        this.list = list;
    }


    //@XmlElement
    public List<Employee> filter(List<Employee> list){

        for(int i = list.size()-1; i >=0 ;i--){
            if(list.get(i).getAge() > 40) {
                list.remove(i);
            }
        }

        return list;
    }


   // @XmlElement
    public List<Employee> sort(List<Employee> list){
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object EmployeeOne, Object EmployeeTwo) {
                return ((Employee) EmployeeOne).getSurname().compareTo(((Employee) EmployeeTwo).getSurname());
            }
        });

        return list;
    }

    @Override
    public String toString(){
        return "\nName Airport: -> " + nameAirport
                + "\nCode Airport: -> " + numberAirport
                + "\nList Employees: -> "+list +
                "\n";
    }

}
