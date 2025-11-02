package org.emp.gl.core.launcher;

import java.util.Random;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge ;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        testDuTimeService();
         // 1. Créer le service
         TimerService timerService = new DummyTimeServiceImpl();

         // 2. Créer quelques horloges et leur passer le même service
         //Horloge h1 = new Horloge("H1", timerService);
         //Horloge h2 = new Horloge("H2", timerService);

          // Créer un compte à rebours de 5 secondes
        //CompteARebours c1 = new CompteARebours("C1", 5, timerService);
        
         // Créer une horloge
        Horloge h1 = new Horloge("H1", timerService);

        // Générateur aléatoire
        Random rand = new Random();

        // Créer 10 comptes à rebours avec des valeurs aléatoires entre 10 et 20
        for (int i = 1; i <= 10; i++) {
            int valeurInitiale = 10 + rand.nextInt(11); // entre 10 et 20 inclus
            new CompteARebours("C" + i, valeurInitiale, timerService);
        }


        
        
    }

    private static void testDuTimeService() {
       
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
