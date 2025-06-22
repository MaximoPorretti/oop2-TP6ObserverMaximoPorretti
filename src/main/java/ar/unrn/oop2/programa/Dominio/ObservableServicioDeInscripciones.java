package ar.unrn.oop2.programa.Dominio;

import ar.unrn.oop2.programa.model3.Concurso;
import ar.unrn.oop2.programa.model3.Participante;
import ar.unrn.oop2.programa.model3.ServicioDeInscripciones;

import java.util.ArrayList;
import java.util.List;

public class ObservableServicioDeInscripciones implements ServicioDeInscripciones {
    private ServicioDeInscripciones decorated;
    private List<InscripcionObserver> observers = new ArrayList<>();

    public ObservableServicioDeInscripciones(ServicioDeInscripciones decorated) {
        this.decorated = decorated;
    }

    public void addObserver(InscripcionObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void inscribir(Participante p, Concurso c) {
        decorated.inscribir(p, c);
        for (InscripcionObserver observer : observers) {
            observer.notificarInscripcion(p, c);
        }
    }
} 