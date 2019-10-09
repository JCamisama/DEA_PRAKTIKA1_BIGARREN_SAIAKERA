package packpraktika1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
		
		
		//2. Zerrenda aktore bakarra izatea gehiketa baino lehen:
		
		assertEquals(aktorErregistro.luzera(), 1); //aktore1 dauka bakarrik.
		aktorErregistro.gehituAktorea(aktore3);   
		assertEquals(aktorErregistro.luzera(), 2); //Bi elementu ditu bere barnean orain.
		
		
		//3.  Aktorea jadanik listan egotea::
		
		assertEquals(aktorErregistro.luzera(), 2); //aktore1 eta aktore3 ditu bere baitan.
		aktorErregistro.gehituAktorea(aktore3);    //aktore3 jadanik dauka.
		assertEquals(aktorErregistro.luzera(), 2); //Luzera handitu da.
		
	}
	/******************************************/
	
	/***********AKTOREEN ZERRENDA FITXATEGI BATEAN GORDE******/
	@Test
	public void testIdatziAktoreGuztiak() {

		String fitxategiIzena = "Fitxategiak/probaAktoreGuztiak.txt";
		
		aktorErregistro.gehituAktorea(aktore1);
		aktorErregistro.gehituAktorea(aktore2);
		aktorErregistro.gehituAktorea(aktore3);
		aktorErregistro.gehituAktorea(aktore4);
		aktorErregistro.gehituAktorea(aktore5);
		try{
			
			PrintWriter outputStreamHau = new PrintWriter(fitxategiIzena);
			
			aktorErregistro.idatziAktoreGuztiak(outputStreamHau); //Proiektuaren karpetan fitxategia sortuko da (Fitxategiak karpetan)
			outputStreamHau.close();
		}
		
		catch (FileNotFoundException e){
			
			e.printStackTrace();
		}
	}
	/*********************************************************/
	
	
	
	/***********AKTOREEN BATEN BILAKETA******/	
	@Test
	public void testAktoreaBilatu() {
		
		aktorErregistro.gehituAktorea(aktore1);
		aktorErregistro.gehituAktorea(aktore2);
		aktorErregistro.gehituAktorea(aktore3);
	
		
		Aktorea aktoreBerriBat	= new Aktorea("Jackson, Samuel L.");
		Aktorea aktoreHau		= null;

		//1. Aktorea zerrendan ez egotea:
		
		aktoreHau = aktorErregistro.aktoreaBilatu(aktoreBerriBat.getIzena()); //aktore1, aktore2, aktore3 ditu bere baitan.
		assertNull(aktoreHau);
		
		
		
		//2. Aktorea hasieran egotea: HashMap-en aktoreak ez daude orden jakin batean, giltzaren bitartez bilatzen dira.
	
		//3. Aktorea amaieran egotea: HashMap-en aktoreak ez daude orden jakin batean, giltzaren bitartez bilatzen dira.
		
		//4. Aktorea erdian egotea: HashMap-en aktoreak ez daude orden jakin batean, giltzaren bitartez bilatzen dira.
		
		//5. Aktorea zerredan egotea:
		
		aktoreHau = aktorErregistro.aktoreaBilatu(aktore2.getIzena());    //aktore1, aktore2, aktore3 ditu bere baitan.
		assertTrue(aktoreHau.equals(aktore2));
		
		
		
		//5. Aktorea bakarra egotea:
		
		aktorErregistro.ezabatuAktoreenErregistrotik(aktore1.getIzena());
		aktorErregistro.ezabatuAktoreenErregistrotik(aktore2.getIzena());
		aktoreHau = aktorErregistro.aktoreaBilatu(aktore3.getIzena());    //aktore3 dauka bere baitan.
		assertTrue(aktoreHau.equals(aktore3));
	}
	/****************************************/
	
	/***********AKTOREEN ZERRENDA ORDENATUA LORTU******/	
	@Test
	public void testZerrendaOrdenatuaBueltatu() {
		
		/*Metodo honek HashMap-en dituen aktoreak ListaAktoreak batera pasatzen ditu,
		  hortaz, honen proba kasu guztiak ListaAktoreakTest fitxategian daude.
		 */
		aktorErregistro.gehituAktorea(aktore2);
		aktorErregistro.gehituAktorea(aktore4);
		aktorErregistro.gehituAktorea(aktore1);
		aktorErregistro.gehituAktorea(aktore5);
		aktorErregistro.gehituAktorea(aktore3);
		
		ListaAktoreak guztiakOrdenatuta = aktorErregistro.zerrendaOrdenatuaBueltatu();
		assertTrue(guztiakOrdenatuta.ordenatutaDago());
	}
	/**************************************************/
}
