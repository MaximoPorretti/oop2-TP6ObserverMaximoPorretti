package ar.unrn.oop2.programa.main3;

import ar.unrn.oop2.programa.Dominio.EmailSenderObserver;
import ar.unrn.oop2.programa.Dominio.ObservableServicioDeInscripciones;
import ar.unrn.oop2.programa.database3.ArchivoRepositorioConcursos;
import ar.unrn.oop2.programa.database3.ArchivoServicioInscripciones;
import ar.unrn.oop2.programa.model3.RepositorioConcursos;
import ar.unrn.oop2.programa.model3.ServicioDeInscripciones;
import ar.unrn.oop2.programa.ui3.RadioCompetition;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new SetUpDatabase("concursos.txt", "inscriptos.txt").inicializar();

        SwingUtilities.invokeLater(() -> {
            RepositorioConcursos repo = new ArchivoRepositorioConcursos("concursos.txt");
            
            ServicioDeInscripciones servicioReal = new ArchivoServicioInscripciones("inscriptos.txt");
            ObservableServicioDeInscripciones servicioObservable = new ObservableServicioDeInscripciones(servicioReal);
            servicioObservable.addObserver(new EmailSenderObserver());

            new RadioCompetition(repo, servicioObservable);
        });
    }
} 