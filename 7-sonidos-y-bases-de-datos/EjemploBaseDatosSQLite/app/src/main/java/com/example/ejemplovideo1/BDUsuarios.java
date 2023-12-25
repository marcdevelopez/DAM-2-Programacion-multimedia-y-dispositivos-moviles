package com.example.ejemplovideo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDUsuarios extends SQLiteOpenHelper {
    private Context contexto;
    // Sentencia SQL para crear la tabla de Usuarios
    private final String SQLCREATE = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)";
    // Sentencia SQL para eliminar la tabla de Usuarios
    private final String SQLDROP = "DROP TABLE IF EXISTS Usuarios";
    // Base de datos
    private SQLiteDatabase bd = null;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DBUsuarios.db";

    /**
     * Constructor de la clase
     *
     * @param contexto Contexto de la aplicación
     */
    public BDUsuarios(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
        this.contexto = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        db.execSQL(SQLDROP);
        db.execSQL(SQLCREATE);
    }

    public void cerrarBD() {
        if (bd != null)
            bd.close();
    }

    /**
     * Inserta un nuevo usuario en la base de datos
     *
     * @param codigo Código del usuario
     * @param nombre Nombre del usuario
     * @throws Exception Esta excepción se lenzará si ocurre algún error en la inserción
     */
    public void insertarUsuario(int codigo, String nombre) throws Exception {
        // Obtengo los datos en modos de escritura
        bd = getWritableDatabase();
        // Si hemos abierto correctamente la base de datos
        if (bd != null) {
            long newRowId;
            try {
                // Creo un ContentValues con los valores a insertar
                ContentValues values = new ContentValues();
                values.put("codigo", codigo);
                values.put("nombre", nombre);
                // Inserta la nueva fila, devolviendo el valor de la clave
                // primaria de la nueva fila
                newRowId = bd.insert("Usuarios", "", values);

                cerrarBD();
            } catch (Exception e) {
                throw new Exception(e.toString());
            }
        }
    }
}
