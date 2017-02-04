package com.raulfmiranda.jumper.elementos;

import android.content.Context;
import android.graphics.Canvas;

import com.raulfmiranda.jumper.Tela;
import com.raulfmiranda.jumper.engine.Som;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Canos {
    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 250;
    private final Context context;
    private List<Cano> canos = new ArrayList<>();
    private Tela tela;
    private final Pontuacao pontuacao;
    private Som som;

    public Canos(Tela tela, Pontuacao pontuacao, Context context, Som som) {
        this.pontuacao = pontuacao;
        this.som = som;
        int posicaoInicial = 200;
        this.tela = tela;
        this.context = context;

        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial, context));
        }
    }

    public void desenhaNo(Canvas canvas) {
        ListIterator<Cano> iterator = canos.listIterator();
        while (iterator.hasNext()) {
            Cano cano = (Cano) iterator.next();
            cano.desenhaNo(canvas);
            cano.move();

            if (cano.saiuDaTela()) {
                som.play(Som.PONTOS);
                pontuacao.aumenta();
                iterator.remove();
                Cano outroCano = new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS, context);
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

    public boolean temColisaoCom(Passaro passaro) {
        for (Cano cano: canos) {
            if(cano.temColisaoHorizontalCom(passaro) && cano.temColisaoVerticalCom(passaro)) {
                return true;
            }
        }
        return false;
    }
}
