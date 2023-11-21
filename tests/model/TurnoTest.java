package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurnoTest {

	//Atributos generales
	Turno 	  turno1;
	LocalDate arribo1;
	ICliente  cliente1;
	
	@BeforeEach
	void setUp() throws Exception {
	//DOC
		
	//SUT
		turno1 = new Turno(arribo1, cliente1);	
	
	}

	@Test
	void testConstructor() {
		assertNotNull(turno1);
	}

}
