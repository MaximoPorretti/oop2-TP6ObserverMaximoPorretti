package ar.unrn.oop2.programa.Dominio;

import ar.unrn.oop2.programa.model3.Concurso;
import ar.unrn.oop2.programa.model3.Participante;

public interface InscripcionObserver {
    void notificarInscripcion(Participante participante, Concurso concurso);
} 