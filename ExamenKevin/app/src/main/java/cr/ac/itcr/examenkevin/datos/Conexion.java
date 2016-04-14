package cr.ac.itcr.examenkevin.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.Console;

/**
 * Created by Kevin on 9/4/2016.
 */
public class Conexion extends SQLiteOpenHelper {

    private static final int VERSION_BDD = 1;
    private static String  NAME_BDD = "examen";

    public Conexion(Context context) {
        super(context, NAME_BDD, null, VERSION_BDD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            StringBuilder sql = new StringBuilder();
            StringBuilder sql1 = new StringBuilder();

            String sqlCreateUser = "CREATE table IF NOT EXISTS usuario (user CHAR(20) PRIMARY KEY, pass CHAR(50))";

            sql.append(sqlCreateUser);
            db.execSQL(sql.toString());




            String sqlCreateTortuga = "CREATE table IF NOT EXISTS tortuga  (nombre CHAR(50) PRIMARY KEY, peso CHAR(50), color CHAR(20), raza CHAR(20))";

            sql1.append(sqlCreateTortuga);
            db.execSQL(sql1.toString());

        }catch (Exception error){
            Log.d("error", error.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            StringBuilder sql = new StringBuilder();

            for (int indiceVersion = oldVersion; indiceVersion < newVersion; indiceVersion++) {
                int nextVersion = indiceVersion + 1;
                switch (nextVersion) {
                    case 1:
                        String sqlDropUsuario = "DROP TABLE IF EXISTS USER";
                        String sqlDropTortuga = "DROP TABLE IF EXISTS TORTUGA";
                        sql.append(sqlDropUsuario);
                        sql.append(sqlDropTortuga);
                        break;
                }
            }
            db.execSQL(sql.toString());
        }

        catch (Exception error){
            Log.d("error", error.getMessage());
        }
    }
}
