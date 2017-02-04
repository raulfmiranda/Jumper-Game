package com.raulfmiranda.jumper.elementos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Toast;

import com.raulfmiranda.jumper.Cores;
import com.raulfmiranda.jumper.R;
import com.raulfmiranda.jumper.Tela;
import com.raulfmiranda.jumper.engine.Som;

public class Passaro {
    private static final Paint vermelho = Cores.getCorDoPassaro();
    public static final int X = 100;
    public static final int RAIO = 50;
    private final Tela tela;
    private Bitmap passaro;
    private int altura;
    private Som som;

    public Passaro(Tela tela, Context context, Som som) {
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2, false);
        this.tela = tela;
        this.altura = 100;
        this.som = som;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawBitmap(passaro, X - RAIO, altura - RAIO, null);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();

        if(!chegouNoChao) {
            this.altura +=20;
        }
    }

    public void pula() {
        if(altura > RAIO) {
            som.play(Som.PULO);
            this.altura -= 150;
        }
    }

    public int getAltura() {
        return altura;
    }
}
