package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChoferTest {

	//Atributos generales
	Chofer chofer1;
	
	@BeforeEach
	void setUp() throws Exception {
	//DOC
		
	//SUT
		chofer1 = new Chofer();
	}

	@Test
	void testConstructor() {
		assertNotNull(chofer1);
	}

}
