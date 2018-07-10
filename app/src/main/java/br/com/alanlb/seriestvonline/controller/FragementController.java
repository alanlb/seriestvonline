package br.com.alanlb.seriestvonline.controller;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import br.com.alanlb.seriestvonline.view.PrincipalFragment;
import br.com.alanlb.seriestvonline.R;

public class FragementController {
    private int idFragment;
    public void FragmentController(int idFragment){
        this.setNameFragment(idFragment);
    }

    public void adicionaFragment(Context context, FragmentManager fm){
        switch (idFragment){
            case 1:
                PrincipalFragment principalFrag = (PrincipalFragment) fm.findFragmentById(R.id.principal_fragment);
                break;
        }
    }

    public int getNameFragment() {
        return idFragment;
    }

    public void setNameFragment(int nameFragment) {
        this.idFragment = nameFragment;
    }
}
