package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class Horloge implements TimerChangeListener {

    private String name;
    private TimerService timerService;

    public Horloge(String name, TimerService timerService) {
        this.name = name;
        this.timerService = timerService;

        // S'inscrire comme observateur du service
        timerService.addTimeChangeListener(this);

        System.out.println("Horloge " + name + " initialisée !");
    }

    // Méthode appelée automatiquement à chaque changement
    @Override
   public void propertyChange(PropertyChangeEvent evt) {
    if (evt.getPropertyName().equals(SECONDE_PROP)) {
        afficherHeure();
    }
       }

    public void afficherHeure() {
        System.out.println(name + " affiche " +
                String.format("%02d:%02d:%02d",
                        timerService.getHeures(),
                        timerService.getMinutes(),
                        timerService.getSecondes()));
    }
}
