package br.com.alanlb.seriestvonline;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.Inflater;

public class AppMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        replaceFragment(R.layout.content_app_main);



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

        } else if (id == R.id.nav_comedia) {

        } else if (id == R.id.nav_acao) {

        } else if (id == R.id.nav_fcientifica) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void replaceFragment(int id){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.layoutparafragmentos, FooFragment.getFragment(id));
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