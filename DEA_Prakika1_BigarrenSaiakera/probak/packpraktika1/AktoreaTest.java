package packpraktika1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class AktoreaTest {

	Aktorea			aktore1, aktore2, aktore3	= null;
	Pelikula		peli1, peli2, peli3			= null;
	ListaPelikulak	peliZerrenda				= null;
	

	@Before
	public void setUp() throws Exception {
		
		peli1			= new Pelikula("Joker");
		peli2			= new Pelikula("The Dark Knight");
		peli3			= new Pelikula("Suicide Squad");
		aktore1			= new Aktorea("Ledger, Heath");
		aktore2			= new Aktorea("Phoenix, Joaquín");
		aktore3			= new Aktorea("Leto, Jared");
		peliZerrenda	= new ListaPelikulak();
	}

	@After
	public void tearDown() throws Exception {
		
		aktore1			= null;
		aktore2			= null;
		aktore3			= null;
		
		peli1			= null;
		peli2			= null;
		peli3			= null;
		peliZerrenda	= null;
		
	}

	@Test
	public void testAktorea() {

		assertNotNull(aktore1); //Aktorea sortu egin du eraikitzaileak
	}

	@Test
	public void testGehituPelikula() {
		
		Pelikula peliNullua = null;
		//Pelikula bat gehituko zaio aktore1 aktoreari
		aktore1.gehituPelikula(peli2);
		
		//Bere pelikulen zerrenda bueltatzen
		peliZerrenda = aktore1.aktorearenPelikulakBueltatu();
		
		//peli2 zerrendan dagoen aztertzen
		assertTrue(peliZerrenda.badago(peli2));
		
		//Null pelikularen gehiketan arazorik badagoen aztertzen
		aktore1.gehituPelikula(peliNullua);
		
	}

	@Test
	public void testIdatziAktorearenIzena() {
	
		
		String fitxategiIzena = "Fitxategiak/probaAktorea.txt";
		
		try{
			
			PrintWriter outputStreamHau = new PrintWriter(fitxategiIzena);
			
			aktore1.idatziAktorearenIzena(outputStreamHau); //Proiektuaren karpetan fitxategia sortuko da, Heath Ledger inprimatzen
			outputStreamHau.close();
		}
		
		catch (FileNotFoundException e){
			
			e.printStackTrace();
		}
	}

	@Test
	public void testLehenagoDoa() {
		
		assertTrue(aktore1.lehenagoDoa(aktore2)); //Ledger, Heath - Phoenix, Joaquin
		assertFalse(aktore2.lehenagoDoa(aktore3)); //Phoenix, Joaquin - Leto, Jated
		assertFalse(aktore3.lehenagoDoa(aktore1)); //Leto, Jated - Ledger, Heath
	}

	@Test
	public void testGetIzena() {

		assertEquals("Ledger, Heath", aktore1.getIzena());
	}

	@Test
	public void testBilatzekoAktorea() {

		//Bilaketan erabiliko den objektua
		Aktorea aktoreBilatzen = new Aktorea("Ledger, Heath");
		
		assertTrue(aktore1.bilatzekoAktorea(aktoreBilatzen));
		
		//Aktorea ez bada bilatzen ari dena, false
		assertFalse(aktore1.bilatzekoAktorea(aktore2));
	}

	@Test
	public void testAktorearenPelikulakBueltatu() {
		
		aktore1.gehituPelikula(peli1);
		aktore1.gehituPelikula(peli2);
		aktore1.gehituPelikula(peli3);
		
		
		assertNotNull(aktore1.aktorearenPelikulakBueltatu());
		
		System.out.println(aktore1.aktorearenPelikulakBueltatu().luzera());
		aktore1.aktorearenPelikulakBueltatu().inprimatuGuztiak();
		
	}

}
