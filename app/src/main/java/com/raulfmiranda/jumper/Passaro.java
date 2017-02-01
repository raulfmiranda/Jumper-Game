package com.raulfmiranda.jumper;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Passaro {
    private static final Paint vermelho = Cores.getCorDoPassaro();
    private static final int X = 100;
    private static final int RAIO = 50;
    private int altura;

    public Passaro() {
        this.altura = 100;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawCircle(X, altura, RAIO, vermelho);
    }

    public void cai() {
        this.altura +=5;
    }
}
