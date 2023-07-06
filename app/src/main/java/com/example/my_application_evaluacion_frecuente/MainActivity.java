package com.example.my_application_evaluacion_frecuente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.my_application_evaluacion_frecuente.Adaptadores.AdaptadorREVI;
import com.example.my_application_evaluacion_frecuente.Modelos.Revi;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {
ListView Lopcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lopcion = (ListView)findViewById(R.id.id_Lista);
        View header = getLayoutInflater().inflate(R.layout.lyherrevisa, null);
        Lopcion.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jsonArray= new JSONArray(result);

        ArrayList<Revi> lstUsuarios = Revi.JsonObjectsBuild(jsonArray);
        AdaptadorREVI adaptadorRevista = new AdaptadorREVI(this, lstUsuarios);
        Lopcion.setAdapter(adaptadorRevista);

    }

}