package com.raulfmiranda.jumper.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.raulfmiranda.jumper.Passaro;

public class Game extends SurfaceView implements Runnable {
    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;

    public Game(Context context) {
        super(context);
        inicializaElementos();
    }

    @Override
    public void run() {
        while (isRunning) {
            if(!holder.getSurface().isValid()) continue;

            Canvas canvas = holder.lockCanvas();

            passaro.desenhaNo(canvas);

            holder.unlockCanvasAndPost(canvas);
        }
    }

    private void inicializaElementos() {
        this.passaro = new Passaro();
    }

    public void cancela() {
        this.isRunning = false;
    }

    public void inicia() {
        this.isRunning = true;
    }
}
