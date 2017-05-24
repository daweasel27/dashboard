/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Dashboard;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoÃ£o Melo <code>- jota.viworkx@gmail.com</code>
 */
public class DataSelecter {
    PersistenceSingleton ps = PersistenceSingleton.getInstance();
    private final static Logger LOGGER = Logger.getLogger(SensorMessageBean.class.toString());
    
    public void dataSelect(String msg){
        LOGGER.log(Level.INFO, "Entrou na funçao dataSelect");
        
        ps.qrt.setTemp_room_study(Integer.parseInt(msg));
    }
}
