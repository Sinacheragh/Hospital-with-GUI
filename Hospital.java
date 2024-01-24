package hospital;
import java.util.*;
import javax.swing.JOptionPane;
public class Hospital {
    static ArrayList<Nurse> nurses = new ArrayList<>();
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<String> drugs = new ArrayList<>();
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        //nurses and patient
        Nurse nurse1 = new Nurse(100,"sina");
        Nurse nurse2 = new Nurse(101,"hasan");
        Nurse nurse3 = new Nurse(102,"mehdi");
        Nurse nurse4 = new Nurse(103,"hosein");
        Nurse nurse5 = new Nurse(104,"ali");
        nurses.add(nurse1);
        nurses.add(nurse2);
        nurses.add(nurse3);
        nurses.add(nurse4);
        nurses.add(nurse5);
        drugs.add("staminophen");
        drugs.add("noaphen");
        Patient patient1 = new Patient(1000,"sina","ali","1402/5/3",drugs);
        Patient patient2 = new Patient(1001,"ali","payam","1402/5/3",drugs);
        Patient patient3 = new Patient(1002,"hasan","mehdi","1402/5/3",drugs);
        Patient patient4 = new Patient(1003,"reza","sara","1402/5/3",drugs);
        Patient patient5 = new Patient(1004,"shahriar","neda","1402/5/3",drugs);
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);
        patients.add(patient5);
        
        
        
        
        
        
        while(true){
            
            
            
            
            //first pannel recaption and nurse:
            Welcome w_pannel = new Welcome(true);
            w_pannel.setVisible(true);
            while(true){
                if(w_pannel.get_visibalaty() == false){
                    break;
                }
                System.out.print("");
            }

            
            
            
            //Nurse
            int counter=0;
            
            if (w_pannel.get_situation()==1){
                
                //confirmation
                String pass;
                
                Confirm c_pannel = new Confirm(true);
                for(int i=0;i<3;i++){
                    c_pannel.setVisible(true);
                    c_pannel.set_visibalaty();
                    while(true){
                        if(c_pannel.get_visibalaty() == false){
                            break;
                        }
                        System.out.print("");
                    }
                    if(confirm(c_pannel.get_code(), c_pannel.get_password())){
                        break;
                    }
                    counter++;
                    JOptionPane.showMessageDialog(null,"Wrong username or password!!");
                }
                if(counter == 3){
                    JOptionPane.showMessageDialog(null, "*You do not have premision to access the application*");
                    break;
                }
                
                
                
                
                
                //Nurse pannel
                NursePannel n_pannel = new NursePannel(true);
                n_pannel.setVisible(true);
                while(true){
                    if(n_pannel.get_visibalaty()==false){
                        break;
                    }
                    System.out.print("");
                }
                
                
                
                
                
                if(n_pannel.get_situation()==1){
                    //edit medicins
                    Getcode g_pannel = new Getcode(true);
                    g_pannel.setVisible(true);
                    while (true){
                        if(g_pannel.get_visibalaty() == false){
                            break;
                        }
                        System.out.print("");
                    }
                    if(confirm(g_pannel.get_code())){
                        Edit e_pannel = new Edit(true);
                        e_pannel.setVisible(true);
                        while(true){
                            if(e_pannel.get_visibalaty()==false){
                                break;
                            }
                            System.out.print("");
                        }
                        
                        
                        if(e_pannel.get_situation()==1){
                            //add drug
                            AddDrug d_pannel = new AddDrug(true);
                            d_pannel.setVisible(true);
                            while (true){
                                if(d_pannel.get_visibalaty() == false){
                                    break;
                                }
                                System.out.print("");
                            }
                            String drug = d_pannel.get_drug();
                            for(Patient i: patients){
                                if(i.get_code() == g_pannel.get_code()){
                                    i.add_drug(drug);
                                }
                            }
                        }
                        
                        
                        else{
                            //remove drug
                            RemoveDrug r_pannel = new RemoveDrug(true);
                            r_pannel.setVisible(true);
                            while(true){
                                if(r_pannel.visibalaty == false){
                                    break;
                                }
                                System.out.print("");
                            }
                            if(r_pannel.get_index()==-1){
                                JOptionPane.showMessageDialog(null, "it must be an integer");
                            }
                            else{
                                try{
                                    patients.remove(r_pannel.get_index());
                                    JOptionPane.showMessageDialog(null, "drug removed succesfully");
                                }
                                catch(Exception e){
                                    JOptionPane.showMessageDialog(null, "Wrong index");
                                }
                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Wrong code!");
                    }
                }
                
                
                
                else{
                    //change password
                    ChangePassPannel ch_pannel = new ChangePassPannel(true);
                    ch_pannel.setVisible(true);
                    while(true){
                        if(ch_pannel.get_visibalaty() == false){
                            break;
                        }
                        System.out.print("");
                    }
                    if(confirm(c_pannel.get_code(),ch_pannel.get_currentpass())){
                        ChangePannel chs_pannel = new ChangePannel(true);
                        chs_pannel.setVisible(true);
                        while(true){
                            if(chs_pannel.get_visibalaty() == false){
                                break;
                            }
                            System.out.print("");
                        }
                        for(Nurse i:nurses){
                            if(i.get_code()==c_pannel.get_code()){
                                i.set_password(chs_pannel.get_newpass());
                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Wrong password!");
                    }
                    
                    ch_pannel.set_currentPasstxt();
                }
                
                
                
                
            }
            
            
            
            
            
            
            
            else{
                //reception
                Reception r_pannel = new Reception(true);
                r_pannel.setVisible(true);
                while(true){
                    if(r_pannel.get_visibalaty()==false){
                        break;
                    }
                    System.out.print("");
                }
                
                
                
                
                
                if(r_pannel.get_situation()==1){
                    //add patient
                    Get_patient p_pannel = new Get_patient(true);
                    p_pannel.setVisible(true);
                    while(true){
                        if(p_pannel.get_visibalaty() == false){
                            if(p_pannel.get_code()==-1 || p_pannel.get_DRname().equals("") || p_pannel.get_name().equals("")){
                                JOptionPane.showMessageDialog(null, "please fill all mandatory fields!");
                                p_pannel.setVisible(true);
                                continue;
                            }
                            break;
                            
                        }
                        System.out.print("");
                    }
                    ArrayList<String> newdrugs = new ArrayList<>();
                    newdrugs.add(p_pannel.get_drugs());
                    Patient patient = new Patient(p_pannel.get_code(),p_pannel.get_name(),p_pannel.get_DRname(),p_pannel.get_date(),newdrugs);
                    patients.add(patient);
                }
                
                
                
                
                
                
                
                else if(r_pannel.get_situation()==2){
                     //remove
                     Getcode c_pannel = new Getcode(true);
                     c_pannel.setVisible(true);
                     while(true){
                         if(c_pannel.get_visibalaty() == false){
                             break;
                         }
                         System.out.print("");
                     }
                     
                     if(confirm(c_pannel.get_code())){
                         for(Patient i: patients){
                             if(i.get_code() == c_pannel.get_code()){
                                 patients.remove(i);
                                 JOptionPane.showMessageDialog(null, "Removed seccessfully!");
                                 break;
                             }
                         }
                     }
                     else{
                         JOptionPane.showMessageDialog(null, "Wrong code");
                     }
                }
                
                
                
                
                
                
                
                else if(r_pannel.get_situation()==3){
                    //search patient
                    Getcode c_pannel = new Getcode(true);
                    c_pannel.setVisible(true);
                    while(true){
                        if(c_pannel.get_visibalaty() == false){
                             break;
                         }
                         System.out.print("");
                    }
                    String name="";
                    String date="";
                    ArrayList<String> drugss = new ArrayList<>();
                    String doc="";
                    if(confirm(c_pannel.get_code())){
                         for(Patient i: patients){
                             if(i.get_code() == c_pannel.get_code()){
                                 name = i.get_name();
                                 doc = i.get_drname();
                                 drugss = i.get_drug();
                                 date = i.get_date();
                                 break;
                             }
                         }
                         ShowPatient s_pannel = new ShowPatient(true);
                         String s="";
                         for(String i:drugss){
                             s = s+" "+i;
                         }
                         s_pannel.set_Label(name, c_pannel.get_code(), date, doc, s);
                         s_pannel.setVisible(true);
                         while(true){
                             if(s_pannel.get_visibalaty() == false){
                                 break;
                             }
                             System.out.print("");
                         }
                     }
                     else{
                         JOptionPane.showMessageDialog(null, "Wrong code");
                     }
                }
                
                
                
                
                
                
                
                else{
                    //show patients
                    String codes="";
                    String names="";
                    for(Patient i: patients){
                        codes+=i.get_code()+"\n";
                        names+=i.get_name()+"\n";
                    }
                    ShowFiles sh_pannel = new ShowFiles(true);
                    sh_pannel.set_Lable(codes, names);
                    sh_pannel.setVisible(true);
                    while(true){
                        if(sh_pannel.get_visibalaty() == false){
                            break;
                        }
                        System.out.print("");
                    }
                    
                }
                
                
                
                
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }
        
        
    }
    
    public static boolean confirm(int code, String password){
       for(Nurse i:nurses){
           if(i.get_code() == code && i.get_password().equals(password))
           {return true;}
       }
       return false;
    }
    public static boolean confirm(int code){
        for(Patient i:patients){
            if(i.get_code() == code){
                return true;
            }
        }
        return false;
    }
}
