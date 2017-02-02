package com.raulfmiranda.jumper.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.raulfmiranda.jumper.Cores;
import com.raulfmiranda.jumper.Tela;

public class Cano {
    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;
    private final Paint verde = Cores.getCorDoCano();
    private int alturaDoCanoInferior;
    private Tela tela;
    private int posicao;

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO;
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoInferior(canvas);
    }

    private void desenhaCanoInferior(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), verde);
    }

    public void move() {
        posicao -= 5;
    }
}
