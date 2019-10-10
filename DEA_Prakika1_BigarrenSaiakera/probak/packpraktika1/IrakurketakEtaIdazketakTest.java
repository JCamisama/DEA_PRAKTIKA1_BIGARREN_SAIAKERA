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
	
	
	
	/*************AKTORE BATEN PELIKULAK BUELTATU******************************/	
	@Test
	public void testAktoreBatenPelikulakBueltatuMenu() {
		
		nagusia.aktoreBatenPelikulakBueltatuMenu(nagusia);
		
		//Aktore baten pelikulak bueltatzearen tratamendua probatzeko, ikusi ListaAktoreakTest eta AktoreGuztiakTest
		
	}
	/*********************************************************************************/
	
	
	
	/*************PELIKULA BATEN AKTOREAK BUELTATU******************************/
	@Test
	public void testPelikuaBatekoAktoreakBueltatuMenu() {
		
		nagusia.pelikuaBatekoAktoreakBueltatuMenu(nagusia);
		
		//Pelikula baten aktoreak bueltatzearen tratamendua probatzeko, ikusi ListaAktoreakTest eta AktoreGuztiakTest
	}
	/*********************************************************************************/
	
	
	
	/*************PELIKULA BATEN DIRUA GEHITU******************************/
	@Test
	public void testPelikulaBatenDiruaGehituMenu() {
		
		nagusia.pelikulaBatenDiruaGehituMenu(nagusia);
		
		//Pelikula baten dirua gehitzearen tratamendua probatzeko, ikusi ListaAktoreakTest eta AktoreGuztiakTest	
		
	}
	/*********************************************************************************/
	
	
	
	
	/*************AKTORE BAT EZABATU******************************/
	@Test
	public void testAktoreBatenEzabaketaMenu() {
		
		nagusia.AktoreBatenEzabaketaMenu(nagusia);
		
		//Aktore baten ezabaketaren tratamendua probatzeko, ikusi ListaAktoreakTest eta AktoreGuztiakTest
		
	}
	/*********************************************************************************/
	
	
	
	
	/*************AKTOREEN ZERRENDA IDATZI******************************/
	@Test
	public void testAktoreenZerrendaIdatziMenu() {
		
		nagusia.AktoreenZerrendaIdatziMenu(nagusia);
		
		//Aktoreen zerrenda idaztearen tratamendua probatzeko, ikusi ListaAktoreakTest eta AktoreGuztiakTest
		
		
	}
	/*********************************************************************************/
	
	
	
	
	/*************AKTORE ZERRENDA ORDENATU******************************/
	@Test
	public void testAktoreenZerrendaOrdenatuaMenu() {
		
		nagusia.AktoreenZerrendaOrdenatuaMenu();
		
		//Aktoreen zerrenda ordenatzerakoan tratamendua probatzeko, ikusi ListaAktoreakTest eta AktoreGuztiakTest
		
		
	}
	/*********************************************************************************/

}
