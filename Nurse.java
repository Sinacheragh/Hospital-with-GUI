package hospital;
public class Nurse {
    private int code;
    private String password;
    public Nurse(int code, String password){
        this.code = code;
        this.password = password;
    }
    public int get_code(){return this.code;}
    public String get_password(){return this.password;}
    public void set_password(String newpass){this.password = newpass;}
}
