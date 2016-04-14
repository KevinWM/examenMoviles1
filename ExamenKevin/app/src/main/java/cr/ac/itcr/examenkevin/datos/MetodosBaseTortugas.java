package cr.ac.itcr.examenkevin.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import cr.ac.itcr.examenkevin.entity.Tortugas;
import cr.ac.itcr.examenkevin.entity.Usuarios;

/**
 * Created by Kevin on 11/4/2016.
 */
public class MetodosBaseTortugas implements IRepository<Tortugas>{

    private Conexion conexion;

    public MetodosBaseTortugas(Context context) {
        conexion = new Conexion(context);
    }


    @Override
    public boolean Save(Tortugas tortuga) {
        try {
            SQLiteDatabase db = conexion.getWritableDatabase();

            if (db != null) {
                ContentValues newData = new ContentValues();
                newData.put("nombre", tortuga.getNombre());
                newData.put("peso", tortuga.getPeso());
                newData.put("color", tortuga.getColor());
                newData.put("raza", tortuga.getRaza());

                db.insert("tortuga", null, newData);

                conexion.close();
                return false;
            }
        } catch (Exception error) {
            Log.d("error", error.getMessage());
        }
        return true;
    }

    @Override
    public ArrayList<Tortugas> GetAll() {

        ArrayList<Tortugas> tortugas = new ArrayList<Tortugas>();

        try {

            SQLiteDatabase db = conexion.getWritableDatabase();

            if (db != null) {

                Cursor cursor = db.query("tortuga", new String[]{"nombre", "peso", "color", "raza"}, null,
                        null, null, null, null , null);

                if (cursor.moveToFirst()) {
                    do {
                        String nombre = cursor.getString(0);
                        String peso = cursor.getString(1);
                        String color = cursor.getString(2);
                        String raza = cursor.getString(3);

                        Tortugas tortuga = new Tortugas();
                        tortuga.setNombre(nombre);
                        tortuga.setPeso(peso);
                        tortuga.setColor(color);
                        tortuga.setRaza(raza);

                        tortugas.add(tortuga);
                    } while (cursor.moveToNext());
                }

                conexion.close();
                return tortugas;
            }
        } catch (Exception error) {
            Log.d("error", error.getMessage());
        }

        return tortugas;
    }

    @Override
    public boolean Update(Tortugas tortuga) {

        try {
            SQLiteDatabase db = conexion.getWritableDatabase();

            if (db != null) {

                ContentValues updateData = new ContentValues();
                updateData.put("nombre", tortuga.getNombre());
                updateData.put("peso", tortuga.getPeso());
                updateData.put("color", tortuga.getColor());
                updateData.put("raza", tortuga.getRaza());

                db.update("tortuga", updateData, "nombre=?", new String[]{String.valueOf(tortuga.getNombre())});

                conexion.close();
                return false;
            }
        } catch (Exception error) {
            Log.d("error", error.getMessage());
        }

        return true;
    }


    @Override
    public boolean Delete(Tortugas tortuga) {

        try {

            SQLiteDatabase db = conexion.getWritableDatabase();

            if (db != null) {
                String[] args = new String[]{String.valueOf(tortuga.getNombre())};

                db.delete("tortuga", "nombre=?", args);

                conexion.close();
                return false;
            }
        } catch (Exception error) {
            Log.d("error", error.getMessage());
        }

        return true;
    }



}
