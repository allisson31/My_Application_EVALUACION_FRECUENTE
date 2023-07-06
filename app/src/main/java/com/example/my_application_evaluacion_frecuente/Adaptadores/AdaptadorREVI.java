package com.example.my_application_evaluacion_frecuente.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.my_application_evaluacion_frecuente.Modelos.Revi;
import com.example.my_application_evaluacion_frecuente.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AdaptadorREVI extends ArrayAdapter<Revi> {


    public AdaptadorREVI(Context context, ArrayList<Revi> dato) {
        super(context, R.layout.lyitemrevista, dato);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemrevista, null);

        TextView lblNombre = (TextView) item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getName());
        TextView lblabreviacion = (TextView) item.findViewById(R.id.lblEmail);
        lblabreviacion.setText(getItem(position).getAbreviacion());
        ImageView imageView = (ImageView) item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada())
                .into(imageView);


        return (item);
    }
}
