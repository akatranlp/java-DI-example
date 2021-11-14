package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/*  Wenn Service oder Component definiert wird,
    wird die Klasse automatisch durch die Configuration erkannt und ein Bean erzeugt
 */
@Component
public class MyApplication {
    // Field Injection
    // Autowired sucht sich die passende Injection selbst heraus
    @Autowired
    Logger logger;

    // über die Ressource wird die Instanz anhand des Namens aus der Configuration geholt
    @Resource(name="bean1")
    Database db1;

    // Wenn es mehrere Beans der gleichen Klasse gibt und man autowired benutzen möchte,
    // muss die Variable den Namen des Beans haben
    @Autowired
    Database bean2;

    // Constructor Injection
    Logger logger2;

    @Autowired
    public MyApplication(Logger logger){
        this.logger2 = logger;
    }

    // Method Injection
    Database db3;

    @Autowired
    public void setDb3(Database bean3){
        db3 = bean3;
    }

    public void run() {
        // Hier testen wir inwiefern verschiedene Objekte erzeugt werden
        logger.log(db1.toString());
        logger2.log(bean2.toString());
        logger.log(db3.toString());

        System.out.println(logger.toString());
        System.out.println(logger2.toString());
    }
}
