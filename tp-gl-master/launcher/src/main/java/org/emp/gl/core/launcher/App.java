package org.emp.gl.core.launcher;

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
         Horloge h1 = new Horloge("H1", timerService);
         Horloge h2 = new Horloge("H2", timerService);

          // Créer un compte à rebours de 5 secondes
        CompteARebours c1 = new CompteARebours("C1", 5, timerService);
        
        
    }

    private static void testDuTimeService() {
       
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
