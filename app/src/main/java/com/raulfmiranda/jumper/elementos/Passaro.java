package com.raulfmiranda.jumper.elementos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Toast;

import com.raulfmiranda.jumper.Cores;
import com.raulfmiranda.jumper.Tela;

public class Passaro {
    private static final Paint vermelho = Cores.getCorDoPassaro();
    private static final int X = 100;
    private static final int RAIO = 50;
    private final Tela tela;
    private int altura;

    public Passaro(Tela tela) {
        this.tela = tela;
        this.altura = 100;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawCircle(X, altura, RAIO, vermelho);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();

        if(!chegouNoChao) {
            this.altura +=5;
        }
    }

    public void pula() {
        if(altura > RAIO) {
            this.altura -= 150;
        }
    }
}
