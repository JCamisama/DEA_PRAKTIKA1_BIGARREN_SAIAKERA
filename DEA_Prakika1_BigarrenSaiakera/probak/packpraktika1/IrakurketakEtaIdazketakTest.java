package packpraktika1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class IrakurketakEtaIdazketakTest {

	IrakurketakEtaIdazketak nagusia = null;

	/**************AKTOREEN ETA PELIKULEN KARGA***************************/
	@Before
	public void setUp() throws Exception {
		
		nagusia = new IrakurketakEtaIdazketak();
		System.out.println("\t\t\t*******FILMAK ETA AKTOREAK - PRAKTIKA 1*******\n");
		System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		nagusia.fitxategiaIreki();
		nagusia.fitxategiaIrakurri();
		nagusia.fitxategiaItxi();
		
		System.out.println("\nAktore kopurua: " + AktoreGuztiak.getNireAktoreak().luzera());
		System.out.println("\nAktore kopurua: " + PelikulaGuztiak.getNirePelikulak().luzera());
	}
	/*********************************************************************/
	
	@After
	public void tearDown() throws Exception {
		
		nagusia = null;
		AktoreGuztiak.getNireAktoreak().erreseteatu();
		PelikulaGuztiak.getNirePelikulak().erreseteatu();
	}
	
	
	
	/*************AKTORE BATEN BILAKETA******************************/
	@Test
	public void testAktoreBatenBilaketaMenu() {
		
		nagusia.aktoreBatenBilaketaMenu(nagusia);
		
		//Bilaketen kasu guztien tratamendua probatzeko, ikusi ListaAktoreakTest eta AktoreGuztiakTest
	}
	/***************************************************************/
	
	
	
	/****************************AKTORE BATEN TXERTAKETA*******************************/
	@Test
	public void testAktoreBerriBatTxertatuMenu() {
		
		nagusia.aktoreBerriBatTxertatuMenu(nagusia);
		
		//Aktoreen gehiketaren kasu guztien tratamendua probatzeko, ikusi ListaAktoreakTest eta AktoreGuztiakTest
		
	}
	/*********************************************************************************/
	
	
	
	//Continua, Jonport!
	@Test
	public void testAktoreBatenPelikulakBueltatuMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testPelikuaBatekoAktoreakBueltatuMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testPelikulaBatenDiruaGehituMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testAktoreBatenEzabaketaMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testAktoreenZerrendaIdatziMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testAktoreenZerrendaOrdenatuaMenu() {
		fail("Not yet implemented");
	}

}
