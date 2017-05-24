
package Dashboard;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class Garden implements Serializable{

    private int temp_pool;
    private int humity;
    private int wind;

    public Garden(){
        
    }

    public int getTemp_pool() {
        return temp_pool;
    }

    public void setTemp_pool(int temp_pool) {
        this.temp_pool = temp_pool;
    }

    public int getHumity() {
        return humity;
    }

    public void setHumity(int humity) {
        this.humity = humity;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public Garden(int temp_pool, int humity, int wind) {
        this.temp_pool = temp_pool;
        this.humity = humity;
        this.wind = wind;
    }
    
    
    
}
