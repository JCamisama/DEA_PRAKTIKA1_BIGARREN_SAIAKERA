package packpraktika1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class AktoreGuztiakTest {

	Aktorea			aktore1, aktore2, aktore3, aktore4, aktore5				= null;
	AktoreGuztiak	aktorErregistro											= null;
	


	@Before
	public void setUp() throws Exception {
		
		//Aktoreak era ordenatuan egikarituko dira
		aktore1				= new Aktorea("Bale, Christian");
		aktore2				= new Aktorea("DiCaprio, Leonardo");
		aktore3				= new Aktorea("Ledger, Heath");
		aktore4				= new Aktorea("Leto, Jared");
		aktore5				= new Aktorea("Phoenix, Joaquín");
		
		aktorErregistro		= AktoreGuztiak.getNireAktoreak();
	}

	@After
	public void tearDown() throws Exception {
		
		aktore1			= null;
		aktore2			= null;
		aktore3			= null;
		aktore4			= null;
		aktore5			= null;
		
		aktorErregistro.erreseteatu();	
	}

	@Test
	public void testGetNireAktoreak() {

		assertNotNull(aktorErregistro);
	}

	
	/***********AKTOREEN BATEN TXERTAKETA******/
	@Test
	public void testGehituAktorea() {

		//1. Aktoreen zerrenda hutsik egotea, aktorea gehitu:
		
		aktorErregistro.gehituAktorea(aktore1);
		assertEquals(aktorErregistro.luzera(), 1);
		
		
	/*	//2. Aktorea jadanik listan egotea:
		
		assertEquals(zerrenda1.luzera(), 5); //5 aktore ditu bere baitan.
		zerrenda1.gehituAktorea(aktore3); 	 // aktore3 jadanik dauka.
		assertEquals(zerrenda1.luzera(), 5); //Luzera berdina izaten jarraitzen du.
		
		
		//2. Zerrenda aktore bakarra izatea gehiketa baino lehen:
		
		assertEquals(zerrenda2.luzera(), 1); //aktore bakarra dauka.
		zerrenda2.gehituAktorea(aktore2); 	 //aktore3 jadanik dauka.
		assertEquals(zerrenda2.luzera(), 2); //Luzera handitu da.
		*/
	}
	/******************************************/
	
	
	@Test
	public void testIdatziAktoreGuztiak() {
		fail("Not yet implemented");
	}

	@Test
	public void testAktoreaBilatu() {
		fail("Not yet implemented");
	}

	@Test
	public void testZerrendaOrdenatuaBueltatu() {
		fail("Not yet implemented");
	}

}
