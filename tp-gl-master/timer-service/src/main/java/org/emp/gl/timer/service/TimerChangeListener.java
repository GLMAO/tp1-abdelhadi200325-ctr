/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tina
 */
package org.emp.gl.timer.service;

import java.beans.PropertyChangeListener;

public interface TimerChangeListener extends PropertyChangeListener {
    String DIXEME_DE_SECONDE_PROP = "dixième";
    String SECONDE_PROP = "seconde";
    String MINUTE_PROP = "minute";
    String HEURE_PROP = "heure";
}

