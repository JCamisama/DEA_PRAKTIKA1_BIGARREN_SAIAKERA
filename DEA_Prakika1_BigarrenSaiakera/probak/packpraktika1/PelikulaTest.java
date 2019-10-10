package packpraktika1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PelikulaTest {
	
	Aktorea			aktore1, aktore2, aktore3	= null;
	Pelikula		peli1, peli2, peli3			= null;
	ListaAktoreak	aktoreZerrenda				= null;

	@Before
	public void setUp() throws Exception {
		
		peli1			= new Pelikula("Joker");
		peli2			= new Pelikula("The Dark Knight");
		peli3			= new Pelikula("Suicide Squad");
		aktore1			= new Aktorea("Ledger, Heath");
		aktore2			= new Aktorea("Phoenix, Joaquín");
		aktore3			= new Aktorea("Leto, Jared");
		aktoreZerrenda	= new ListaAktoreak();
	}

	@After
	public void tearDown() throws Exception {
		
		aktore1			= null;
		aktore2			= null;
		aktore3			= null;
		
		peli1			= null;
		peli2			= null;
		peli3			= null;
		aktoreZerrenda	= null;
		
	}


	@Test
	public void testPelikula() {
		
		assertNotNull(peli1); //Pelikula sortu egin du eraikitzaileak
	}

	@Test
	public void testAktoreBerriaSartu() {
		
		Aktorea aktoreNullua = null;
		//Aktore bat gehituko zaio peli1 pelikulari
		peli1.aktoreBerriaSartu(aktore2);
		
		//Bere aktorearen zerrenda bueltatzen
		aktoreZerrenda = peli1.pelikularenAktoreakBueltatu();
		
		//aktore2 zerrendan dagoen aztertzen
		assertTrue(aktoreZerrenda.badagoAktorea(aktore2.getIzena()));
		
		//Null aktorearen gehiketan arazorik badagoen aztertzen
		peli1.aktoreBerriaSartu(aktoreNullua);
		
	}

	@Test
	public void testInprimatuIzena() {
		
		this.peli1.inprimatuIzena();
		
	}

	@Test
	public void testGehituDirua() {
		
		peli1.gehituDirua(1000);//0€ duen pelikula batean, dirua sartu		
		peli1.gehituDirua(-3000);//1000€ duen pelikula batean, dirua kendu eta kantitate negatiboetan gelditu
		
		peli2.gehituDirua(200);
		peli2.gehituDirua(8000);//200€ duen pelikula batean, dirua gehitu
		
		peli3.gehituDirua(800);
		peli3.gehituDirua(-400);//800€ duen pelikula batean, dirua kendu
		
		
		
	}

	@Test
	public void testPelikularenAktoreakBueltatu() {
		
		assertNotNull(peli1.pelikularenAktoreakBueltatu());
		
	}

	@Test
	public void testGetIzena() {
		
		assertEquals("Joker", peli1.getIzena());
		
	}

	@Test
	public void testBilatzekoPelikula() {
		
		//Bilaketan erabiliko den objektua
		Pelikula pelikulaBilatzen = new Pelikula("The Dark Knight");
				
		assertTrue(peli2.bilatzekoPelikula(pelikulaBilatzen.getIzena()));
				
		//Pelikula ez bada bilatzen ari dena, false
		assertFalse(peli1.bilatzekoPelikula(peli2.getIzena()));
		
	}
	
	@Test
	public void AktoreaPelikulatikKendu(){ 		

		Aktorea aktore4				= new Aktorea("Bale, Christian");
		Aktorea aktore5				= new Aktorea("DiCaprio, Leonardo");
		Aktorea aktore6				= new Aktorea("Ledger, Heath");
		
		peli1.aktoreBerriaSartu(aktore4);
		peli2.aktoreBerriaSartu(aktore4);
		
		peli1.aktoreBerriaSartu(aktore5);
		
		//1. Emandako aktorea pelikulan ez egotea:	
		
		peli1.AktoreaPelikulatikKendu(aktore6);	
		
				
		//3. Ezabatu nahi den aktorea pelikula batean egotea:		
			
		peli1.AktoreaPelikulatikKendu(aktore5);			 
		
				 
		//4. Ezabatu nahi den aktorea pelikula askotan egotea:
		
		peli1.AktoreaPelikulatikKendu(aktore4);	
		peli2.AktoreaPelikulatikKendu(aktore4);	
	}

	@Test
	public void diruSarreraTotalakInprimatu(){
		
		peli2.gehituDirua(200);
		peli2.gehituDirua(8000);
		
		peli2.diruSarreraTotalakInprimatu();
	}

}
