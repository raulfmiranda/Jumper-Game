package com.raulfmiranda.jumper.engine;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import com.raulfmiranda.jumper.R;

public class Som {
    private SoundPool soundPool;
    public static int PULO;
    public static int COLISAO;
    public static int PONTOS;

    public Som(Context context) {
        if((android.os.Build.VERSION.SDK_INT) >= Build.VERSION_CODES.LOLLIPOP){
            this.soundPool = criaSoundPoolAPI21();
        } else {
            this.soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        }
        PULO = soundPool.load(context, R.raw.pulo, 1);
        COLISAO = soundPool.load(context, R.raw.colisao, 2);
        PONTOS = soundPool.load(context, R.raw.pontos, 3);
    }

    public void play(int som) {
        soundPool.play(som, 1, 1, 1, 0, 1);
    }

    @TargetApi(21)
    private SoundPool criaSoundPoolAPI21() {
        AudioAttributes audioAttrib = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        SoundPool sp21 = new SoundPool.Builder().setAudioAttributes(audioAttrib).setMaxStreams(3).build();

        return sp21;
    }
}
