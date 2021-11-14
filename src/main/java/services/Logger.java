package services;

import org.springframework.stereotype.Service;

/*  Wenn Service oder Component definiert wird,
    wird die Klasse automatisch durch die Configuration erkannt und ein Bean erzeugt
 */
@Service
public class Logger {
    public void log(String msg) {
        System.out.println("LOG: " + msg);
    }
}
