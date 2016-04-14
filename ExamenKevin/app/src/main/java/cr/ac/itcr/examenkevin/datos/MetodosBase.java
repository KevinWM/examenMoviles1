package cr.ac.itcr.examenkevin.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import cr.ac.itcr.examenkevin.entity.Usuarios;

/**
 * Created by Kevin on 9/4/2016.
 */
public class MetodosBase implements IRepository<Usuarios> {

    private Conexion conexion;

    public MetodosBase(Context context) {
        conexion = new Conexion(context);
    }


    @Override
    public boolean Save(Usuarios usuario) {
        try {
            SQLiteDatabase db = conexion.getWritableDatabase();

            if (db != null) {
                ContentValues newData = new ContentValues();
                newData.put("user", usuario.getUser());
                newData.put("pass", usuario.getPass());

                db.insert("usuario", null, newData);

                conexion.close();
                return false;
            }
        } catch (Exception error) {
            Log.d("error", error.getMessage());
        }
        return true;
    }

    @Override
    public boolean Update(Usuarios usuario) {
        return true;
    }

    @Override
    public boolean Delete(Usuarios usuario) {
        return true;
    }

    @Override
    public ArrayList<Usuarios> GetAll() {

        ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();

        try {

            SQLiteDatabase db = conexion.getWritableDatabase();

            if (db != null) {

                Cursor cursor = db.query("usuario", new String[]{"user", "pass"}, null,
                        null, null, null, null , null);

                if (cursor.moveToFirst()) {
                    do {
                        String id = cursor.getString(0);
                        String nombre = cursor.getString(1);

                        Usuarios usuario = new Usuarios();
                        usuario.setUser(id);
                        usuario.setPass(nombre);

                        usuarios.add(usuario);
                    } while (cursor.moveToNext());
                }

                conexion.close();
                return usuarios;
            }
        } catch (Exception error) {
            Log.d("error", error.getMessage());
        }

        return usuarios;
    }

}
