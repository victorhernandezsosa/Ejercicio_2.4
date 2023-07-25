package com.example.ejercicio_24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio_24.Configuracion.SQLiteConexion;
import com.example.ejercicio_24.Configuracion.Tabla;
import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private SignatureView signatureView;
    EditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signatureView = findViewById(R.id.signatureView);
        descripcion = findViewById(R.id.descripcion);

        Button btnSaveSignature = findViewById(R.id.btnSaveSignature);
        btnSaveSignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap signatureBitmap = signatureView.getSignatureBitmap();
                guardar(signatureBitmap);
            }
        });

        Button btnClearSignature = findViewById(R.id.btnClearSignature);
        btnClearSignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signatureView.clearSignature();
            }
        });

        Button bntir = findViewById(R.id.btnir);
        bntir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MostrarFirmas.class);
                startActivity(intent);
            }
        });
    }

    private void guardar(Bitmap signatureBitmap) {
        byte[] signatureBytes = convertBitmapToByteArray(signatureBitmap);


        SQLiteConexion conexion = new SQLiteConexion(this, Tabla.NameDatabase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Tabla.descripcion, descripcion.getText().toString());
        valores.put(Tabla.firma, signatureBytes);

        long result = db.insert(Tabla.tablaFirma, null, valores);
        Toast.makeText(getApplicationContext(),"Registro Ingresado",Toast.LENGTH_LONG).show();

        db.close();
    }

    private byte[] convertBitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
}

