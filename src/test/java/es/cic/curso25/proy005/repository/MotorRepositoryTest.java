package es.cic.curso25.proy005.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic.curso25.proy005.model.Motor;

@SpringBootTest
public class MotorRepositoryTest {

    @Autowired
    private MotorRepository motorRepository;

    @Test
    void testGetSiguienteId() {

        Motor motor = new Motor();
        motor.setEncendido(true);
        motor.setMarca("Opel");
        motor.setPotencia(4.5);

        motorRepository.motores.put(5L, motor);

        assertEquals(6L, motorRepository.getSiguienteId());
        assertEquals(6L, motorRepository.getSiguienteIdConStreams());
    }

}
