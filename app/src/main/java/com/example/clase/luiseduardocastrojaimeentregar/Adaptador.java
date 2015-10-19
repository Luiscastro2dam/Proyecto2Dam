package com.example.clase.luiseduardocastrojaimeentregar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Clase on 18/10/2015.
 */
public class Adaptador extends ArrayAdapter<Contacto> {
    private Context contexto;
    private int res;
    private LayoutInflater inflador;
    private List<Contacto> personas;//donde metemos todos los contactos
    /*constructor*/
    public Adaptador(Context contexto, int res, List<Contacto> personas) {
        super(contexto, res, personas);
        this.contexto = contexto;
        this.personas = personas;
        this.res = res;
        inflador= (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class guardaLista{
        public TextView tv1;
        public TextView tv2;
        public ImageView iv;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        guardaLista gv = new guardaLista();
        if(convertView==null){
            convertView = inflador.inflate(res,null);
            TextView tv1 = (TextView) convertView.findViewById(R.id.tv1);
            gv.tv1 = tv1;
            TextView tv2 = (TextView) convertView.findViewById(R.id.tv2);
            gv.tv2 = tv2;
//          ImageView iv = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(gv);
        } else {
            gv = (guardaLista) convertView.getTag();
        }
        gv.tv1.setText(personas.get(position).getNombre());
        gv.tv2.setText(personas.get(position).untelefono(0));//coje el primero
//        gv.iv.setImageResource(R.drawable.cruznegra);

        return convertView;
    }




}
