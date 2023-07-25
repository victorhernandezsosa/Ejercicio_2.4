package com.example.ejercicio_24;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;
import com.example.ejercicio_24.Configuracion.SQLiteConexion;
import com.example.ejercicio_24.Configuracion.Tabla;
import java.util.ArrayList;
import java.util.List;

public class MostrarFirmas extends AppCompatActivity {

    private List<signaturess> lista;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_firmas);

        lista = new ArrayList<>();
        adapter = new CustomAdapter(lista);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        ObtenerFirmas();
    }

    private void ObtenerFirmas() {
        SQLiteConexion conexion = new SQLiteConexion(this, Tabla.NameDatabase, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] columnas = {Tabla.descripcion, Tabla.firma};
        Cursor cursor = db.query(Tabla.tablaFirma, columnas, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String descripcion = cursor.getString(cursor.getColumnIndex(Tabla.descripcion));
            byte[] firmaBytes = cursor.getBlob(cursor.getColumnIndex(Tabla.firma));

            Bitmap firmaBitmap = BitmapFactory.decodeByteArray(firmaBytes, 0, firmaBytes.length);
            signaturess firma = new signaturess(firmaBitmap, descripcion);
            lista.add(firma);
        }

        cursor.close();
        db.close();

        adapter.notifyDataSetChanged();
    }
}
