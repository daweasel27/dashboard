/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard;

/**
 *
 * @author arcmm
 */
public class PersistenceSingleton {
    public Kitchen cz;
    public Garden ext;
    public Home hm;
    public Rooms qrt;
    
    private PersistenceSingleton() {
        cz = new Kitchen();
        ext = new Garden();
        hm = new Home();
        qrt = new Rooms();
    }
    
    public static PersistenceSingleton getInstance() {
        return PersistenceSingletonHolder.INSTANCE;
    }
    
    private static class PersistenceSingletonHolder {

        private static final PersistenceSingleton INSTANCE = new PersistenceSingleton();
    }
    
    
}
