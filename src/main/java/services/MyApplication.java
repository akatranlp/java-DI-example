package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/*  Wenn Service oder Component definiert wird,
    wird die Klasse automatisch durch die Configuration erkannt und ein Bean erzeugt
 */
@Component
public class MyApplication {
    Logger logger;

    // Field Injection
    // Autowired sucht sich die passende Injection selbst heraus
    @Autowired
    Logger logger2;

    // über die Ressource wird die Instanz anhand des Namens aus der Configuration geholt
    @Resource(name="bean1")
    Database db1;

    // Wenn es mehrere Beans der gleichen Klasse gibt und man autowired benutzen möchte,
    // muss die Variable den Namen des Beans haben
    @Autowired
    Database bean2;

    Database db3;

    // Constructor Injection
    @Autowired
    public MyApplication(Logger logger){
        this.logger = logger;
    }

    // Method Injection
    @Autowired
    public void setDb3(Database bean3){
        db3 = bean3;
    }

    public void run() {
        // Hier testen wir inwiefern verschiedene Objekte erzeugt werden
        logger.log(db1.getOne());
        logger2.log(bean2.getOne());
        logger.log(db3.getOne());
    }
}
