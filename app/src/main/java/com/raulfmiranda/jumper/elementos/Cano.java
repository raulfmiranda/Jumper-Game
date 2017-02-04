package com.raulfmiranda.jumper.elementos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.raulfmiranda.jumper.Cores;
import com.raulfmiranda.jumper.R;
import com.raulfmiranda.jumper.Tela;

public class Cano {
    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;
    private final Paint VERDE = Cores.getCorDoCano();
    private final Context context;
    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private Tela tela;
    private int posicao;
    private Bitmap bp;
    private Bitmap canoInferior;
    private Bitmap canoSuperior;

    public Cano(Tela tela, int posicao, Context context) {
        this.tela = tela;
        this.posicao = posicao;
        this.context = context;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        this.alturaDoCanoSuperior = TAMANHO_DO_CANO + valorAleatorio();
        bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoSuperior(canvas);
        desenhaCanoInferior(canvas);
    }

    private void desenhaCanoSuperior(Canvas canvas) {
        this.canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, this.alturaDoCanoSuperior, false);
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
        //canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, VERDE);
    }

    private void desenhaCanoInferior(Canvas canvas) {
        this.canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, this.alturaDoCanoInferior, false);
        canvas.drawBitmap(canoInferior, posicao, alturaDoCanoInferior, null);
    }

    public void move() {
        posicao -= 5;
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {
        return passaro.getAltura() -
                passaro.RAIO < this.alturaDoCanoSuperior
                || passaro.getAltura() + passaro.RAIO >
                this.alturaDoCanoInferior;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return this.posicao - passaro.X < passaro.RAIO;
    }
}
