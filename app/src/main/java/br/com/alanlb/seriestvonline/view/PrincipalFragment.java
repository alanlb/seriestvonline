package br.com.alanlb.seriestvonline.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.com.alanlb.seriestvonline.R;
import br.com.alanlb.seriestvonline.controller.ListaAdapterItem;

public class PrincipalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.principal_frag, null);

        return view;
    }

    public void alteraTitulo(String titulo){
        TextView textTitulo = (TextView) getView().findViewById(R.id.testviewfragtitulo);
        textTitulo.setText(titulo);
    }

    public void adcionaVideos(ListaAdapterItem adapter){
        ListView lv = (ListView)getView().findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }
    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
}