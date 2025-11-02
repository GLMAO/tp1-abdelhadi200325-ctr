package org.emp.gl.clients;

import java.awt.Font;
import java.beans.PropertyChangeEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class HorlogeGUI extends JFrame implements TimerChangeListener {

    private final TimerService timerService;
    private final JLabel labelHeure;

    public HorlogeGUI(TimerService timerService) {
        this.timerService = timerService;

        // Enregistrement comme listener du service
        timerService.addTimeChangeListener(this);

        // Configuration de la fenêtre
        setTitle("Horloge Graphique");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Créer le label de l'heure
        labelHeure = new JLabel("", JLabel.CENTER);
        labelHeure.setFont(new Font("Arial", Font.BOLD, 36));

        add(labelHeure);
        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // On ne met à jour que quand la seconde change
        if (evt.getPropertyName().equals(SECONDE_PROP)) {
            // Mise à jour du label sur le thread de Swing
            SwingUtilities.invokeLater(() -> {
                String texte = String.format("%02d:%02d:%02d",
                        timerService.getHeures(),
                        timerService.getMinutes(),
                        timerService.getSecondes());
                labelHeure.setText(texte);
            });
        }
    }
}
