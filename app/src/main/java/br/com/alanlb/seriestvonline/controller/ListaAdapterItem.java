package br.com.alanlb.seriestvonline.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.alanlb.seriestvonline.R;
import br.com.alanlb.seriestvonline.model.Item;

public class ListaAdapterItem extends ArrayAdapter<Item> {
    private Context context;
    private ArrayList<Item> lista;

    public ListaAdapterItem(Context context, ArrayList<Item> lista){
        super(context,0,lista);
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Item itemAtual = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.itemlayout,null);

        ImageView imagem = (ImageView) convertView.findViewById(R.id.imageviewitem);
        CarregaImagensURL.doInBackground(itemAtual.getImagemURL(), imagem);

        TextView titulo = (TextView) convertView.findViewById(R.id.tituloitem);
        titulo.setText(itemAtual.getTitulo());

        return convertView;
    }
}
