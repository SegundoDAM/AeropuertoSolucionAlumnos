package aeropuerto.es.solucion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VueloTest {

	@Test
	void testDespegar() {
		Vuelo vuelo=new Vuelo("1", "zafra");
		/*
		 * vamos a recrear a la torre de vuelo dando una pista y autorizando el vuelo
		 */
		vuelo.setPistaAsignada(new Pista(1, Estado.ocupada));
		vuelo.setDespegueAutorizado(true);
		//el despegue puede ser true o false, es aleatorio
		//intentemoslo diez veces, alguna tiene que salir bien el despegue
		int veces=10;
		boolean banderaDespegueExitoso=false;
		for (int i = 0; i < veces; i++) {
			if(vuelo.despegar()) banderaDespegueExitoso=true;
			else {
				vuelo.setDespegueAutorizado(true);
			}
		}
		assertTrue(banderaDespegueExitoso);
	}
	@Test
	void testDespegarSinPista() {
		Vuelo vuelo=new Vuelo("1", "zafra");
		vuelo.setDespegueAutorizado(false);
		int veces=10;
		boolean banderaDespegueExitoso=false;
		for (int i = 0; i < veces; i++) {
			if(vuelo.despegar()) banderaDespegueExitoso=true;
		}
		assertFalse(banderaDespegueExitoso);
	}

}
