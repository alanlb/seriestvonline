package br.com.alanlb.seriestvonline.controller;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CarregaImagensURL{
    private static Handler handler = new Handler();
    public static void doInBackground(final String url, final ImageView imagem) {
        new Thread() {
            public void run() {
                Bitmap imgBitmap = null;
                try{

                    URL urlOfImage = new URL(url);
                    HttpURLConnection conexao = (HttpURLConnection) urlOfImage.openConnection();
                    InputStream inputStream = conexao.getInputStream();
                    imgBitmap = BitmapFactory.decodeStream(inputStream);

                } catch (Exception e){ // Catch the download exception
                    e.printStackTrace();
                }
                final Bitmap bitmapAux = imgBitmap;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imagem.setImageBitmap(bitmapAux);
                    }
                });
            }
        }.start();


    }

}

