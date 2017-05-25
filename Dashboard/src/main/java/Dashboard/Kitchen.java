
package Dashboard;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "kitchen", eager = true)
@ViewScoped
public class Kitchen implements Serializable{
    private final static Logger LOGGER = Logger.getLogger(SensorMessageBean.class.toString());
    @ManagedProperty(value = "#{smoke}")
    private boolean smoke=false;
    
    private int temp = 23;
    private static final long serialVersionUID = 8150756503956053844L;
    
    public Kitchen(){
        
    }
    
    public boolean isSmoke() {
        return smoke;
    }
    
    public int getTemp() {
        return temp;
    }
    
    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }
    
    public void setTemp(int temp) {
        LOGGER.log(Level.INFO,"valor {0}",  Integer.toString(temp));
        this.temp = temp;
    }
    
}
