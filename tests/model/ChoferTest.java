package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChoferTest {

	//Atributos generales
	Chofer chofer1;
	
	@BeforeEach
	void setUp()  {
		chofer1 = new Chofer("diego" , 33);
	}

	@Test
	void testConstructor() {
		assertEquals(chofer1.getClass(), Chofer.class);
	}
	@Test
	void getNombreTest() {
		assertEquals(chofer1.getNombre(), "diego");
	}
	@Test
	void getEdadTest() {
		assertEquals(chofer1.getEdad(), 33);
	}

}
