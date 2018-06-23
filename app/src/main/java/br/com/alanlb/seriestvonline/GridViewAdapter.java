package br.com.alanlb.seriestvonline;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridViewAdapter extends BaseAdapter{
    private Context contexto;
    private int[] lista;

    public GridViewAdapter(Context contexto, int[] lista){
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int i) {
        return lista[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView iv = new ImageView(contexto);
        iv.setImageResource(lista[i]);
        iv.setAdjustViewBounds(true);
        return iv;
    }
}
