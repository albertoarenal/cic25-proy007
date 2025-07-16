package es.cic.curso25.proy005.repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import es.cic.curso25.proy005.model.Motor;

@Repository
public class MotorRepository {

    public Map<Long, Motor> motores = new HashMap<>();

    public long create(Motor motor) {
        long mayor = getSiguienteId();
        motor.setId(mayor);
        motores.put(motor.getId(), motor);
        return motor.getId();
    }

    public long getSiguienteIdConStreams() {
        long mayor = 
            motores
                .keySet()
                .stream()
                .max(
                    (primero, segundo) -> (int) (segundo.longValue() - primero.longValue())
                ).get();
        return mayor + 1;        
    }



    public long getSiguienteId() {
        long mayor = 0;
        
        Set<Long> ids = motores.keySet();
        
        Iterator<Long> iteratorId =  ids.iterator();


        while (iteratorId.hasNext()) {
            Long siguiente = iteratorId.next();
            if (siguiente.longValue() > mayor) {
                mayor = siguiente;
            }
        }
        mayor++;
        return mayor;
    }
}
