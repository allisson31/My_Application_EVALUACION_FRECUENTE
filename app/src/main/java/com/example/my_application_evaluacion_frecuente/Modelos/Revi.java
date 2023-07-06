package com.example.my_application_evaluacion_frecuente.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revi {
    private String name;
    private String portada;
    private String id;
    private String abreviacion;

    public Revi (JSONObject a) throws JSONException {

        name = a.getString("name").toString() ;
        portada = a.getString("portada").toString() ;
        id = a.getString("journal_id").toString() ;
        abreviacion = a.getString("abbreviation").toString() ;

    }
    public static ArrayList<Revi> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revi> contenido = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            contenido.add(new Revi(datos.getJSONObject(i)));
        }
        return contenido;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }
}
