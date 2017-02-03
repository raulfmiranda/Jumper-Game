package com.raulfmiranda.jumper.elementos;

import android.graphics.Canvas;

import com.raulfmiranda.jumper.Tela;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Canos {
    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 250;
    private List<Cano> canos = new ArrayList<>();
    private Tela tela;

    public Canos(Tela tela) {
        int posicaoInicial = 200;
        this.tela = tela;

        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial));
        }
    }

    public void desenhaNo(Canvas canvas) {
        ListIterator<Cano> iterator = canos.listIterator();
        while (iterator.hasNext()) {
            Cano cano = (Cano) iterator.next();
            cano.desenhaNo(canvas);
            cano.move();

            if (cano.saiuDaTela()) {
                iterator.remove();
                Cano outroCano = new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS);
                iterator.add(outroCano);
            }
        }
    }

    private int getMaximo() {
        int maximo = 0;
        for (Cano cano : canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    public void move() {
        for (Cano cano : canos)
            cano.move();
    }
}
