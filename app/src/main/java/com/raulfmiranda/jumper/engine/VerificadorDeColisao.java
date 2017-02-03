package com.raulfmiranda.jumper.engine;

import com.raulfmiranda.jumper.elementos.Canos;
import com.raulfmiranda.jumper.elementos.Passaro;

public class VerificadorDeColisao {
    private final Passaro passaro;
    private final Canos canos;

    public VerificadorDeColisao(Canos canos, Passaro passaro) {
        this.canos = canos;
        this.passaro = passaro;
    }

    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }
}
