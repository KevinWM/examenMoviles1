package cr.ac.itcr.examenkevin.datos;

import java.util.ArrayList;

/**
 * Created by Kevin on 9/4/2016.
 */
public interface IRepository <Object> {
    public boolean Save(Object object);

    public boolean Update(Object object);

    public boolean Delete(Object object);

    public ArrayList<Object> GetAll();

    //public ArrayList<Object> GetBy(Object object);
}
