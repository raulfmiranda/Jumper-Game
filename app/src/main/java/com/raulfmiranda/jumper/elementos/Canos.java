package com.raulfmiranda.jumper.elementos;

import android.graphics.Canvas;

import com.raulfmiranda.jumper.Tela;

import java.util.ArrayList;
import java.util.List;

public class Canos {
    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 250;
    private List<Cano> canos = new ArrayList<>();

    public Canos(Tela tela) {
        int posicaoInicial = 200;

        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial));
        }
    }

    public void desenhaNo(Canvas canvas) {
        for(Cano cano : canos)
            cano.desenhaNo(canvas);
    }

    public void move() {
        for(Cano cano : canos)
            cano.move();
    }
}
