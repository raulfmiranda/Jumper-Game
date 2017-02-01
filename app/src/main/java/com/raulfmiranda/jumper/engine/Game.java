package com.raulfmiranda.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.raulfmiranda.jumper.Passaro;
import com.raulfmiranda.jumper.R;
import com.raulfmiranda.jumper.Tela;

public class Game extends SurfaceView implements Runnable {
    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private Tela tela;

    public Game(Context context) {
        super(context);
        tela = new Tela(context);
        inicializaElementos();
    }

    @Override
    public void run() {
        while (isRunning) {
            if(!holder.getSurface().isValid()) continue;

            Canvas canvas = holder.lockCanvas();

            canvas.drawBitmap(background, 0, 0, null);
            passaro.desenhaNo(canvas);
            passaro.cai();

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
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        this.background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);
        this.isRunning = true;
    }
}
