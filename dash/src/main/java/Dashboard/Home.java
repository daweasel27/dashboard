
package Dashboard;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class Home implements Serializable{
    
    private boolean mail_box;
    private boolean door;

    public Home(){
        
    }

    public boolean isMail_box() {
        return mail_box;
    }

    public void setMail_box(boolean mail_box) {
        this.mail_box = mail_box;
    }

    public boolean isDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    public Home(boolean mail_box, boolean door) {
        this.mail_box = mail_box;
        this.door = door;
    }
    
    
    
    
}
