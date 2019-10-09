package packpraktika1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class ListaAktoreakTest {
	
	Aktorea			aktore1, aktore2, aktore3, aktore4, aktore5				= null;
	ListaAktoreak 	zerrenda1, zerrenda2, zerrendaHutsa, zerrendaOrdenatua	= null;
	



	@Before
	public void setUp() throws Exception { 
		
		//Aktoreak era ordenatuan egikarituko dira
		aktore1				= new Aktorea("Bale, Christian");
		aktore2				= new Aktorea("DiCaprio, Leonardo");
		aktore3				= new Aktorea("Ledger, Heath");
		aktore4				= new Aktorea("Leto, Jared");
		aktore5				= new Aktorea("Phoenix, Joaquín");
		
		
		zerrenda1			= new ListaAktoreak();
		zerrenda2			= new ListaAktoreak();
		zerrendaHutsa		= new ListaAktoreak();
		zerrendaOrdenatua	= new ListaAktoreak();
		
		zerrenda1.gehituAktorea(aktore2);
		zerrenda1.gehituAktorea(aktore4);
		zerrenda1.gehituAktorea(aktore3);
		zerrenda1.gehituAktorea(aktore1);
		zerrenda1.gehituAktorea(aktore5);
		
		zerrendaOrdenatua.gehituAktorea(aktore1);
		zerrendaOrdenatua.gehituAktorea(aktore2);
		zerrendaOrdenatua.gehituAktorea(aktore3);
		
		zerrenda2.gehituAktorea(aktore3);
		
	}

	@After
	public void tearDown() throws Exception {
		
		aktore1			= null;
		aktore2			= null;
		aktore3			= null;
		aktore4			= null;
		aktore5			= null;
				
		zerrenda1		= null;
	}

	@Test
	public void testListaAktoreak() {
		
		assertNotNull(zerrenda1);
	}

	/***********AKTOREEN ZERRENDA FITXATEGI BATEAN GORDE******/
	@Test
	public void testIdatziAktoreGuztiak() {
		
		String fitxategiIzena = "Fitxategiak/probaListaAktoreak.txt";
		
		try{
			
			PrintWriter outputStreamHau = new PrintWriter(fitxategiIzena);
			
			zerrenda1.idatziAktoreGuztiak(outputStreamHau); //Proiektuaren karpetan fitxategia sortuko da
			outputStreamHau.close();
		}
		
		catch (FileNotFoundException e){
			
			e.printStackTrace();
		}
	}
	/*********************************************************/
	
	
	@Test
	public void testLuzera() {
		
		//Zerrenda hutsa: 0
		assertEquals(zerrendaHutsa.luzera(), 0);
		
		//Elementu bakarreko zerrenda: 1
		assertEquals(zerrenda2.luzera(), 1);
		
		//Elementu anitzeko zerrenda: 3
		assertEquals(zerrenda1.luzera(), 5);
	}

	@Test
	public void testOrdenatutaDago() {
		
		//Zerrenda hutsa denean, true:
		assertTrue(zerrendaHutsa.ordenatutaDago());

		//Zerrenda ordenatuta dagoenean:
		
		assertTrue(zerrendaOrdenatua.ordenatutaDago());
		
		//Zerrenda ordenaturik ez dagoenean:
		
		assertFalse(zerrenda1.ordenatutaDago());
	}
	
	
	
	/***********AKTOREEN ZERRENDA ORDENATUA LORTU******/
	@Test
	public void testElkartuOrdenatu() {

		//1. Elementurik gabeko zerrenda: 
		zerrendaHutsa.elkartuOrdenatu();
		assertTrue(zerrendaHutsa.ordenatutaDago());
		
		
		//2. Elementu bakarreko zerrenda: 
		zerrenda2.elkartuOrdenatu();			//aktore3 dauka bere baitan bakarrik.
		assertTrue(zerrenda2.ordenatutaDago());
		
		
		//3. Zerrenda jadanik ordenatua: 
		zerrendaOrdenatua.elkartuOrdenatu();	//aktore1, aktore2 eta aktore3 ditu bere baitan, orden horretan.
		assertTrue(zerrendaOrdenatua.ordenatutaDago());
		
		
		//4. Lehenengo aktorea ordenaturik ez egotea:
		
		ListaAktoreak lehenaEzOrdenatua = new ListaAktoreak();
		lehenaEzOrdenatua.gehituAktorea(aktore2);
		lehenaEzOrdenatua.gehituAktorea(aktore1);
		lehenaEzOrdenatua.gehituAktorea(aktore3);
		lehenaEzOrdenatua.gehituAktorea(aktore4);
		lehenaEzOrdenatua.gehituAktorea(aktore5);
		
		lehenaEzOrdenatua.elkartuOrdenatu();
		assertTrue(lehenaEzOrdenatua.ordenatutaDago());
		
		
		//5. Lehenengo aktorea azkenengo posizioan egotea:
		
		ListaAktoreak lehenaAzkenean = new ListaAktoreak();
		lehenaAzkenean.gehituAktorea(aktore2);
		lehenaAzkenean.gehituAktorea(aktore3);
		lehenaAzkenean.gehituAktorea(aktore4);
		lehenaAzkenean.gehituAktorea(aktore5);
		lehenaAzkenean.gehituAktorea(aktore1);
		
		lehenaAzkenean.elkartuOrdenatu();
		assertTrue(lehenaAzkenean.ordenatutaDago());
		
		
		//6. Erdiko aktoreren bat ordenaturik ez egotea:
		
		ListaAktoreak erdikorenBatEzOrdenatua = new ListaAktoreak();
		erdikorenBatEzOrdenatua.gehituAktorea(aktore1);
		erdikorenBatEzOrdenatua.gehituAktorea(aktore2);
		erdikorenBatEzOrdenatua.gehituAktorea(aktore4);
		erdikorenBatEzOrdenatua.gehituAktorea(aktore3);
		erdikorenBatEzOrdenatua.gehituAktorea(aktore5);
		
		erdikorenBatEzOrdenatua.elkartuOrdenatu();
		assertTrue(erdikorenBatEzOrdenatua.ordenatutaDago());
		
		
		//7. Azkenengo aktorea lehenengo posizioan egotea:
		
		ListaAktoreak azkenaLehenengoan = new ListaAktoreak();
		azkenaLehenengoan.gehituAktorea(aktore5);
		azkenaLehenengoan.gehituAktorea(aktore1);
		azkenaLehenengoan.gehituAktorea(aktore2);
		azkenaLehenengoan.gehituAktorea(aktore3);
		azkenaLehenengoan.gehituAktorea(aktore4);
		
		azkenaLehenengoan.elkartuOrdenatu();
		assertTrue(azkenaLehenengoan.ordenatutaDago());
		
		
		//8. Zerrenda kontrako ordenean egotea:
		
		ListaAktoreak kontrakoOrdenean = new ListaAktoreak();
		kontrakoOrdenean.gehituAktorea(aktore5);
		kontrakoOrdenean.gehituAktorea(aktore4);
		kontrakoOrdenean.gehituAktorea(aktore3);
		kontrakoOrdenean.gehituAktorea(aktore2);
		kontrakoOrdenean.gehituAktorea(aktore1);
		
		kontrakoOrdenean.elkartuOrdenatu();
		assertTrue(kontrakoOrdenean.ordenatutaDago());
		
		//9. Zerrenda guztiz eragabe izatea :
		
		zerrenda1.elkartuOrdenatu();
		assertTrue(zerrenda1.ordenatutaDago());
		
	}
	/**************************************************/
	


	
	@Test
	public void testBadagoAktorea() {
		
		//1. Aktorea zerrendan ez egotea:
		assertFalse(zerrenda2.badagoAktorea("Bale, Christian"));
		
		
		//2. Aktorea hasieran egotea:
		assertTrue(zerrendaOrdenatua.badagoAktorea("Bale, Christian"));
		
		
		//3. Aktorea amaieran egotea:
		assertTrue(zerrendaOrdenatua.badagoAktorea("Ledger, Heath"));
		
		
		//4. Aktorea erdian egotea:
		assertTrue(zerrendaOrdenatua.badagoAktorea("DiCaprio, Leonardo"));
		
		
		//5. Aktorea bakarrik egotea:
		assertTrue(zerrenda2.badagoAktorea("Ledger, Heath"));
		
		
	}


	
	/***********AKTOREEN BATEN EZABAKETA******/
	@Test
	public void testEzabatuAktorea() {
		
		//1. Emandako lista hutsa izatea:
		zerrendaHutsa.ezabatuAktorea(aktore1);
		assertEquals(zerrendaHutsa.luzera(), 0);
		
		
		//2. Ezabatu nahi den aktorea zerrendan ez egotea:
		assertEquals(zerrenda2.luzera(), 1); //aktore3 dauka bakarrik.
		zerrenda2.ezabatuAktorea(aktore5);
		assertEquals(zerrenda2.luzera(), 1); //aktore3 izaten jarraitzen du.
		
		
		//3. Ezabatu nahi den aktorea hasieran egotea:
		ListaAktoreak besteZerrendaBat = new ListaAktoreak();
		besteZerrendaBat.gehituAktorea(aktore1);
		besteZerrendaBat.gehituAktorea(aktore2);
		besteZerrendaBat.gehituAktorea(aktore3);
		besteZerrendaBat.gehituAktorea(aktore4);
		
		assertEquals(besteZerrendaBat.luzera(), 4); //Zerrendaren luzera ezabatu baino lehen.
		besteZerrendaBat.ezabatuAktorea(aktore1);
		assertEquals(besteZerrendaBat.luzera(), 3); //Zerrendaren luzera ezabatu eta gero.
		
		
		//4. Ezabatu nahi den aktorea amaieran egotea:
		
		ListaAktoreak besteZerrenda2 = new ListaAktoreak();
		besteZerrenda2.gehituAktorea(aktore1);
		besteZerrenda2.gehituAktorea(aktore2);
		besteZerrenda2.gehituAktorea(aktore3);
		
		assertEquals(besteZerrenda2.luzera(), 3); //Zerrendaren luzera ezabatu baino lehen.
		besteZerrenda2.ezabatuAktorea(aktore3);
		assertEquals(besteZerrenda2.luzera(), 2); //Zerrendaren luzera ezabatu eta gero.
		
	
		
	}
	/*****************************************/

	
	

	
	
	
	/***********AKTOREEN BATEN TXERTAKETA******/
	@Test
	public void testGehituAktorea() {

		//1. Aktoreen zerrenda hutsik egotea, aktorea gehitu:
		
		zerrendaHutsa.gehituAktorea(aktore1);
		assertEquals(zerrendaHutsa.luzera(), 1);
		
		
		//2. Aktorea jadanik listan egotea:
		
		assertEquals(zerrenda1.luzera(), 5); //5 aktore ditu bere baitan.
		zerrenda1.gehituAktorea(aktore3); 	 // aktore3 jadanik dauka.
		assertEquals(zerrenda1.luzera(), 5); //Luzera berdina izaten jarraitzen du.
		
		
		//3. Zerrenda aktore bakarra izatea gehiketa baino lehen:
		
		assertEquals(zerrenda2.luzera(), 1); //aktore bakarra dauka.
		zerrenda2.gehituAktorea(aktore2); 	 //aktore3 jadanik dauka.
		assertEquals(zerrenda2.luzera(), 2); //Luzera handitu da.
		
		
	}
	/******************************************/
	
	

	
	
	/***********AKTOREEN BATEN BILAKETA******/	
	@Test
	public void testAktoreaBilatu() {

		//1. Aktorea zerrendan ez egotea:
		
		Aktorea aktoreHau = zerrendaOrdenatua.aktoreaBilatu(aktore5); //aktore1, aktore2 eta aktore3 ditu bere baitan.
		assertNull(aktoreHau);
		
		
		
		//2. Aktorea hasieran egotea:
		
		aktoreHau = zerrendaOrdenatua.aktoreaBilatu(aktore1); //aktore1, aktore2 eta aktore3 ditu bere baitan, orden honetan.
		assertTrue(aktoreHau.getIzena().equals(aktore1.getIzena()));
		
		
		
		//3. Aktorea amaieran egotea:
		
		aktoreHau = zerrendaOrdenatua.aktoreaBilatu(aktore3); //aktore1, aktore2 eta aktore3 ditu bere baitan, orden honetan.
		assertTrue(aktoreHau.getIzena().equals(aktore3.getIzena()));
		
		
		//4. Aktorea erdian egotea:
		
		aktoreHau = zerrendaOrdenatua.aktoreaBilatu(aktore2); //aktore1, aktore2 eta aktore3 ditu bere baitan, orden honetan.
		assertTrue(aktoreHau.getIzena().equals(aktore2.getIzena()));
		
		
		//5. Aktorea bakarra egotea:
		
		aktoreHau = zerrenda2.aktoreaBilatu(aktore3); //aktore3 dauka bere baitan.
		assertTrue(aktoreHau.getIzena().equals(aktore3.getIzena()));
		
	}
	/****************************************/
}
