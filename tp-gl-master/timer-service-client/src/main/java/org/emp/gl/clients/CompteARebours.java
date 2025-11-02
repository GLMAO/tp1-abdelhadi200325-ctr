package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class CompteARebours implements TimerChangeListener {

    private String name;
    private int valeur;
    private TimerService timerService;

    public CompteARebours(String name, int valeurInitiale, TimerService timerService) {
        this.name = name;
        this.valeur = valeurInitiale;
        this.timerService = timerService;

        // S'inscrire comme observateur
        timerService.addTimeChangeListener(this);

        System.out.println("Compte à rebours " + name + " initialisé à " + valeur + " secondes.");
    }


   @Override
public void propertyChange(PropertyChangeEvent evt) {
    if (evt.getPropertyName().equals(SECONDE_PROP)) {
        if (valeur > 0) {
            valeur--;
            System.out.println(name + " : " + valeur + " seconde(s) restante(s)");
        }
        if (valeur == 0) {
            System.out.println(name + " terminé !");
            timerService.removeTimeChangeListener(this);
        }
    }
}}


