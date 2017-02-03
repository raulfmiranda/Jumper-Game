package com.raulfmiranda.jumper.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.raulfmiranda.jumper.Cores;

public class Pontuacao {

    private static final Paint BRANCO = Cores.getCorDaPontuacao();
    private int pontos = 0;

    public void aumenta() {
        pontos++;
    }
    
    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100, 100, BRANCO);
    }
}
