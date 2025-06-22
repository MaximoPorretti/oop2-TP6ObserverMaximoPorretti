package ar.unrn.oop2.programa.Dominio;

import ar.unrn.oop2.programa.model3.Concurso;
import ar.unrn.oop2.programa.model3.Participante;

public class EmailSenderObserver implements InscripcionObserver {
    @Override
    public void notificarInscripcion(Participante participante, Concurso concurso) {
        // Simulating sending an email
        System.out.println("Enviando correo electrónico a: " + participante.getEmail());
        System.out.println("Asunto: Confirmación de Inscripción");
        System.out.println("Cuerpo: Estimado/a " + participante.getNombre() + " " + participante.getApellido() + ",");
        System.out.println("Le confirmamos su inscripción al concurso '" + concurso.getNombre() + "'.");
        System.out.println("¡Mucha suerte!");
    }
} 