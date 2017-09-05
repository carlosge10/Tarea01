package com.example.carlos.sesion5;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class ActivityMain extends AppCompatActivity {

    private Alumno a;

    private Button save;
    private Button clean;
    private EditText nombre;
    private EditText telefono;
    private Spinner escolaridad;
    private AutoCompleteTextView libro;
    private CheckBox deporte;
    private RadioButton femenino;
    static final String NAME_FIELD = "nameField";
    static final String PHONE_FIELD = "phoneField";
    static final String ESCOLARIDAD_FIELD = "escolaridadField";
    static final String GENERO_FIELD = "generoField";
    static final String LIBRO_FIELD = "libroField";
    static final String DEPORTE_FIELD = "deporteField";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = (Button) findViewById(R.id.activity_main_save);
        clean = (Button) findViewById(R.id.buttonClean);
        nombre = (EditText) findViewById(R.id.et_name);
        telefono = (EditText) findViewById(R.id.et_phone);
        escolaridad = (Spinner) findViewById(R.id.sp_escolaridad);
        deporte = (CheckBox) findViewById(R.id.checkbox_deporte);
        femenino = (RadioButton) findViewById(R.id.rb_femenino);

        String [] arr = getResources().getStringArray(R.array.activity_main_libros);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        libro = (AutoCompleteTextView) findViewById(R.id.activity_main_libros);
        libro.setAdapter(ad);

        a=new Alumno();
        a.setGenero("Femenino");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.activity_main_save:
                a.setNombre(nombre.getText().toString());
                a.setTelefono(telefono.getText().toString());
                a.setEscolaridad(escolaridad.getSelectedItem().toString());
                a.setGenero( femenino.isChecked() ? "Femenino" : "Masculino" );
                a.setLibro(libro.getText().toString());
                a.setDeporte(deporte.isChecked());
                Toast.makeText(this, "Guardar: \n" + a.toString(), Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(NAME_FIELD, a.getNombre() /*nombre.getText().toString()*/);
        savedInstanceState.putString(PHONE_FIELD, a.getTelefono() /*telefono.getText().toString()*/);
        savedInstanceState.putString(ESCOLARIDAD_FIELD, a.getEscolaridad() /*escolaridad.getSelectedItem().toString()*/);
        savedInstanceState.putString(GENERO_FIELD, a.getGenero() /*((RadioButton)findViewById(R.id.rb_femenino)).isChecked() ?  "Femenino" : "Masculino"*/);
        savedInstanceState.putString(LIBRO_FIELD, a.getLibro());
        savedInstanceState.putBoolean(DEPORTE_FIELD, a.isDeporte());
        super.onSaveInstanceState(savedInstanceState);
    }

    public void limpiar(final View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Desea limpiar el contenido?");
                alertDialogBuilder.setPositiveButton("Si",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                ActivityMain.this.limpiar();
                            }
                        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void limpiar(){

        a = new Alumno();
        nombre.setText("");
        telefono.setText("");
        escolaridad.setSelection(1);
        ((RadioButton) findViewById(R.id.rb_femenino)).setChecked(true);
        libro.setText("");
        deporte.setChecked(false);
    }
}