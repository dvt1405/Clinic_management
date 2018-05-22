package entity;

/**
 *
 * @author MrLELOI
 */
public abstract class iEntity {
    protected int id;
    
    public int getId(){
        return id;
    }
    
    public Object[] toRowDataTable(){
        return null;
    }
}
