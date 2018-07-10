package br.com.alanlb.seriestvonline.controller;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import br.com.alanlb.seriestvonline.model.Item;
import br.com.alanlb.seriestvonline.view.PrincipalFragment;
import br.com.alanlb.seriestvonline.R;

public class AppMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fm = getSupportFragmentManager();
        if (savedInstanceState == null){
            PrincipalFragment principalFragment = new PrincipalFragment();
            replaceFragment(principalFragment,"principalFragment");
        }




        //text.setText("Olá");
        int[] lista = new int[]{R.drawable.comediaicon};
        //gv.setAdapter(new GridViewAdapter(this, lista));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_login) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_lancamentos) {
            PrincipalFragment pf = (PrincipalFragment)fm.findFragmentByTag("principalFragment");
            pf.alteraTitulo("Lançamentos");
            ArrayList<Item> itens = new ArrayList<Item>();
            itens.add(new Item("Liga da justiça","http://www.planocritico.com/wp-content/uploads/2017/11/lista_DC_Comics_filmes_live_action_plano_critico-600x400.jpg"));
            itens.add(new Item("Dois Homens e Meio","https://http2.mlstatic.com/dois-homens-e-meio-two-and-a-half-men-9-temporadas-D_NQ_NP_778293-MLB26912791593_022018-F.jpg"));
            //itens.add(new Item("how i met your mother","https://image.tmdb.org/t/p/w600_and_h900_bestv2/sidx8cEiYG1ZBwzyF5wiXFaBm6Q.jpg"));
            //itens.add(new Item("Game of Thrones","https://cabanadoleitor.com.br/wp-content/uploads/2017/10/conquest-game-of-thrones-.jpg"));
            //itens.add(new Item("The Walking Dead","https://pbs.twimg.com/profile_images/1014984923118108672/e7JhBbd0_400x400.jpg"));
            //itens.add(new Item("Vikings","https://ambrosia.com.br/wp-content/uploads/2014/05/Vikings-History-Channel-segunda-temporada.jpg"));
            ListaAdapterItem adapter = new ListaAdapterItem(this,itens);
            pf.adcionaVideos(adapter);
        } else if (id == R.id.nav_comedia) {
            PrincipalFragment pf = (PrincipalFragment)fm.findFragmentByTag("principalFragment");
            pf.alteraTitulo("Comédia");
        } else if (id == R.id.nav_acao) {
            PrincipalFragment pf = (PrincipalFragment)fm.findFragmentByTag("principalFragment");
            pf.alteraTitulo("Ação");
        } else if (id == R.id.nav_fcientifica) {
            PrincipalFragment pf = (PrincipalFragment)fm.findFragmentByTag("principalFragment");
            pf.alteraTitulo("Ficção Científica");
        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void replaceFragment(Fragment frag, String tag){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.layoutparafragmentos, frag, tag);
        ft.commit();
    }

//    public void pegaVideos(){
//        Uri uri = Uri.parse("http://www.villopim.com.br/android/video.3gp");
//
//        ArrayList<VideoView> videos = new ArrayList<>();
//
//        //videoView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
//
//        TableRow tableRow = new TableRow(this);
//        tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
//        TableLayout table = findViewById(R.id.tablelayoutlancamentos);
//        for (int i = 0; i < 10; i++){
//            int cont = 0;
//            VideoView videoView = new VideoView(this);
//            videoView.setVideoURI(uri);
//            //videoView.setPadding(5,5,5,5);
//            //videoView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
//            videoView.setMediaController(new MediaController(this));
//            if (tableRow.getChildCount()>2){
//                cont = 0;
//                table.addView(tableRow);
//                //View view = new View(this);
//                //view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,1));
//                //PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);
//                //view.getBackground().setColorFilter(colorFilter);
//                //table.addView(view);
//                tableRow = new TableRow(this);
//                tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
//            }
//            tableRow.addView(videoView, cont);
//            cont++;
//        }
//    }
}


/*    <TableRow
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:padding="5dp">

                <VideoView
                    android:id="@+id/videoView1"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="5dp"/>
                <VideoView
                    android:id="@+id/videoView2"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="5dp"/>

            </TableRow>*/