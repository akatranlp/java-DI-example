package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import services.Database;
import services.MemoryDatabase;
import services.OtherDatabase;

// definiert, dass es sich um die Configuration handelt
@Configuration
// definiert in welchem Package es nach Components und Services suchen soll
// und erzeugt anhand denen eigene Beans
@ComponentScan(value={"services"})
public class DIConfiguration {
    // Hier definieren wir eigene Beans, da wir mehrere Arten von Datenbanken haben
    // und so spezialisieren welche genommen wird

    @Bean(name="bean1")
    public Database getDB1(){
        return new MemoryDatabase();
    }
    // wir erzeugen mehrere Instanzen der Klasse, um verschiedene Datenbanken, an verschiedenen Orten zu nutzen
    @Bean(name="bean2")
    public Database getDB2(){
        return new MemoryDatabase();
    }

    @Bean(name="bean3")
    public Database getDB3(){
        return new OtherDatabase();
    }
}
