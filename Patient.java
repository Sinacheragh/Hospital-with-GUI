package hospital;
import java.util.*;
public class Patient {
    private int code;
    private String name;
    private String doctor;
    private String date;
    private ArrayList<String> drugs = new ArrayList<>();
    public Patient(int code, String name, String doctor, String date, ArrayList<String> drugs){
        this.code = code;
        this.date = date;
        this.name = name;
        this.drugs = drugs;
        this.doctor = doctor;
    }
    public void add_drug(String drug){
        this.drugs.add(drug);
    }
    public void remove_drug(int index){
        this.drugs.remove(index);
    }
    public int get_code(){return this.code;}
    public String get_name(){return this.name;}
    public String get_date(){return this.date;}
    public String get_drname(){return this.doctor;}
    public ArrayList<String> get_drug(){return this.drugs;}
}
