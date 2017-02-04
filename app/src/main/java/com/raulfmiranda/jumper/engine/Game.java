package com.raulfmiranda.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.raulfmiranda.jumper.elementos.Canos;
import com.raulfmiranda.jumper.elementos.GameOver;
import com.raulfmiranda.jumper.elementos.Passaro;
import com.raulfmiranda.jumper.R;
import com.raulfmiranda.jumper.Tela;
import com.raulfmiranda.jumper.elementos.Pontuacao;

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {
    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Canos canos;
    private Bitmap background;
    private Tela tela;
    private Pontuacao pontuacao;
    private Context context;
    private Som som;

    public Game(Context context) {
        super(context);
        this.context = context;
        this.som = new Som(context);
        tela = new Tela(context);
        inicializaElementos();
        setOnTouchListener(this);
    }

    @Override
    public void run() {
        while (isRunning) {
            if (!holder.getSurface().isValid()) continue;

            Canvas canvas = holder.lockCanvas();

            canvas.drawBitmap(background, 0, 0, null);
            passaro.desenhaNo(canvas);
            passaro.cai();

            canos.desenhaNo(canvas);
            canos.move();

            pontuacao.desenhaNo(canvas);

            if(new VerificadorDeColisao(canos, passaro).temColisao()) {
                som.play(Som.COLISAO);
                new GameOver(tela).desenhaNo(canvas);
                isRunning = false;
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    private void inicializaElementos() {
        this.pontuacao = new Pontuacao();
        this.passaro = new Passaro(tela, context, som);
        this.canos = new Canos(tela, pontuacao, context, som);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        this.background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);
    }

    public void cancela() {
        this.isRunning = false;
    }

    public void inicia() {
        this.isRunning = true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        passaro.pula();
        return false;
    }
}
