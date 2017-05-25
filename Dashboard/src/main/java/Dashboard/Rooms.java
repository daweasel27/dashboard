
package Dashboard;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class Rooms implements Serializable{

    private int 
            temp_room_study=16, 
            temp_room_sleep2 =14, 
            temp_room_sleep1 =15;

    public Rooms(){
        
    }
   

    public int getTemp_room_study() {
        return temp_room_study;
    }

    public int getTemp_room_sleep1() {
        return temp_room_sleep1;
    }

    public int getTemp_room_sleep2() {
        return temp_room_sleep2;
    }

    public void setTemp_room_study(int temp_room_study) {
        this.temp_room_study = temp_room_study;
    }

    public void setTemp_room_sleep1(int temp_room_sleep1) {
        this.temp_room_sleep1 = temp_room_sleep1;
    }

    public void setTemp_room_sleep2(int temp_room_sleep2) {
        this.temp_room_sleep2 = temp_room_sleep2;
    }
    
}
