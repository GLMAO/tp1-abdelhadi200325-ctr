package org.emp.gl.time.service.impl;

import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class DummyTimeServiceImpl implements TimerService {

    int dixiemeDeSeconde;
    int minutes;
    int secondes;
    int heures;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public DummyTimeServiceImpl() {
        setTimeValues();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeChanged();
            }
        }, 100, 100);
    }

    private void setTimeValues() {
        LocalTime localTime = LocalTime.now();
        setSecondes(localTime.getSecond());
        setMinutes(localTime.getMinute());
        setHeures(localTime.getHour());
        setDixiemeDeSeconde(localTime.getNano() / 100_000_000);
    }

    @Override
    public void addTimeChangeListener(TimerChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }

    private void timeChanged() {
        setTimeValues();
    }

    public void setDixiemeDeSeconde(int newVal) {
        if (dixiemeDeSeconde == newVal) return;
        int old = dixiemeDeSeconde;
        dixiemeDeSeconde = newVal;
        pcs.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP, old, newVal);
    }

    public void setSecondes(int newVal) {
        if (secondes == newVal) return;
        int old = secondes;
        secondes = newVal;
        pcs.firePropertyChange(TimerChangeListener.SECONDE_PROP, old, newVal);
    }

    public void setMinutes(int newVal) {
        if (minutes == newVal) return;
        int old = minutes;
        minutes = newVal;
        pcs.firePropertyChange(TimerChangeListener.MINUTE_PROP, old, newVal);
    }

    public void setHeures(int newVal) {
        if (heures == newVal) return;
        int old = heures;
        heures = newVal;
        pcs.firePropertyChange(TimerChangeListener.HEURE_PROP, old, newVal);
    }

    @Override
    public int getDixiemeDeSeconde() { return dixiemeDeSeconde; }

    @Override
    public int getSecondes() { return secondes; }

    @Override
    public int getMinutes() { return minutes; }

    @Override
    public int getHeures() { return heures; }
}
