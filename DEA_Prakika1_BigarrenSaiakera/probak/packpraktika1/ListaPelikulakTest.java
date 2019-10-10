package packpraktika1;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaPelikulakTest {
	
	ListaPelikulak listaPelikulak, zerrendaHutsa =  null;
	
	Pelikula filma1, filma2, filma3, filma4, filma5;
	
	

	@Before
	public void setUp() throws Exception {
		
		filma1 = new Pelikula ("Eager to Die");
		filma2 = new Pelikula ("Mitologia do submundo");
		filma3 = new Pelikula ("Einsatz in 4 W nden");
		filma4 = new Pelikula ("God's Pocket");
		filma5 = new Pelikula ("Epitaph: Bread and Salt");	
		
		listaPelikulak = new ListaPelikulak();
		zerrendaHutsa = new ListaPelikulak();
		
		listaPelikulak.gehituPelikula(filma1);
		listaPelikulak.gehituPelikula(filma2);
		listaPelikulak.gehituPelikula(filma3);
		listaPelikulak.gehituPelikula(filma4);
		listaPelikulak.gehituPelikula(filma5);
		
	}

	@After
	public void tearDown() throws Exception {
		
		
		filma1 = null;
		filma2 = null;
		filma3 = null;
		filma4 = null;
		filma5 = null;
		
	}

	@Test
	public void testListaPelikulak() {
		
		assertNotNull(listaPelikulak);
	}

	@Test
	public void testGehituPelikula() {
		
		//1. Pelikuleen zerrenda hutsik egotea, Pelikula gehitu:		
		zerrendaHutsa.gehituPelikula(filma1);		
		zerrendaHutsa.inprimatuGuztiak();
		
		//2. Pelikula jadanik listan egotea:
		listaPelikulak.gehituPelikula(filma1);		
		listaPelikulak.inprimatuGuztiak();
		
		//3. Zerrenda pelikula bakarra izatea gehiketa baino lehen:
		ListaPelikulak besteListaBat = new ListaPelikulak();
		besteListaBat.gehituPelikula(filma1);
		
		Pelikula filma6 = new Pelikula ("Universal Ninjas");				
		besteListaBat.gehituPelikula(filma6);
		
		besteListaBat.inprimatuGuztiak();
		
	}

	@Test
	public void testEzabatuFilma() {
		
		//1. Emandako lista hutsa izatea:			
		zerrendaHutsa.ezabatuFilma(filma1);
		zerrendaHutsa.inprimatuGuztiak();
		
		//2. Ezabatu nahi den pelikula zerrendan ez egotea:			
		Pelikula filma7 = new Pelikula ("Hollywood Dreams");		
		listaPelikulak.ezabatuFilma(filma7);
		
		//3. Ezabatu nahi den Pelikula hasieran egotea:		
		 ListaPelikulak besteListaBat = new ListaPelikulak();
		 besteListaBat.gehituPelikula(filma1);
		 besteListaBat.gehituPelikula(filma2);
		 besteListaBat.gehituPelikula(filma3);
		 besteListaBat.gehituPelikula(filma4);
		 besteListaBat.gehituPelikula(filma5);
		
		 besteListaBat.ezabatuFilma(filma1);
		 
		 besteListaBat.inprimatuGuztiak();
		 
		//4. Ezabatu nahi den Pelikula amaieran egotea:
		 ListaPelikulak besteListaBat2 = new ListaPelikulak();
		 besteListaBat2.gehituPelikula(filma1);
		 besteListaBat2.gehituPelikula(filma2);
		 besteListaBat2.gehituPelikula(filma3);
		 
		 besteListaBat2.ezabatuFilma(filma3);
		 
		 besteListaBat2.inprimatuGuztiak();
		
	}

	@Test
	public void testInprimatuGuztiak() {
		
		listaPelikulak.inprimatuGuztiak();
		
	}

	@Test
	public void testPelikulaBilatu() {
		
		 ListaPelikulak besteListaBat = new ListaPelikulak();
		 besteListaBat.gehituPelikula(filma1);
		 besteListaBat.gehituPelikula(filma2);
		 besteListaBat.gehituPelikula(filma3);
		
		//1. Pelikula zerrendan ez egotea:
		
			Pelikula pelikulaHau = besteListaBat.pelikulaBilatu(filma5.getIzena()); ////filma1, filma2 eta filma3 ditu bere baitan
			assertNull(pelikulaHau);
				
				
				
		//2. Pelikula hasieran egotea:
				
			pelikulaHau = besteListaBat.pelikulaBilatu(filma1.getIzena()); //filma1, filma2 eta filma3 ditu bere baitan, orden honetan.
			assertTrue(pelikulaHau.getIzena().equals(filma1.getIzena()));
				
				
				
		//3. Pelikula amaieran egotea:
				
			pelikulaHau = besteListaBat.pelikulaBilatu(filma3.getIzena()); //filma1, filma2 eta filma3 ditu bere baitan, orden honetan.
			assertTrue(pelikulaHau.getIzena().equals(filma3.getIzena()));
				
				
		//4. Pelikula erdian egotea:
				
			pelikulaHau = besteListaBat.pelikulaBilatu(filma2.getIzena()); //filma1, filma2 eta filma3 ditu bere baitan, orden honetan.
			assertTrue(pelikulaHau.getIzena().equals(filma2.getIzena()));		
		
	}
	
	
	@Test
	public void badago(){	
		
		Pelikula filma9 = new Pelikula ("Joker");
		ListaPelikulak besteListaBat3 = new ListaPelikulak();
		besteListaBat3.gehituPelikula(filma9);
		
		//1. Filma zerrendan ez egotea:
		assertFalse(listaPelikulak.badago(filma9));
				
				
		//2. Filma hasieran egotea:
		assertTrue(listaPelikulak.badago(filma1));
				
				
		//3. Filma amaieran egotea:
		assertTrue(listaPelikulak.badago(filma5));
				
				
		//4. Filma erdian egotea:
		assertTrue(listaPelikulak.badago(filma3));
				
				
		//5. Filma bakarrik egotea:
		assertTrue(besteListaBat3.badago(filma9));				
		
	}
	
	@Test
	public void pelikulaKargatu(){ 	
		
		//1. Pelikuleen zerrenda hutsik egotea, Pelikula gehitu:		
		zerrendaHutsa.gehituPelikula(filma1);		
		zerrendaHutsa.inprimatuGuztiak();
				
		//2. Pelikula jadanik listan egotea:
		listaPelikulak.gehituPelikula(filma1);		
		listaPelikulak.inprimatuGuztiak();
				
		//3. Zerrenda pelikula bakarra izatea gehiketa baino lehen:
		ListaPelikulak besteListaBat4 = new ListaPelikulak();
		besteListaBat4.gehituPelikula(filma1);
				
		Pelikula filma6 = new Pelikula ("Universal Ninjas");				
		besteListaBat4.gehituPelikula(filma6);
				
		besteListaBat4.inprimatuGuztiak();
		
		
	}
	
	@Test
	public void ezabatuPelikulaHauetatik(){	
		
		Aktorea aktore1				= new Aktorea("Bale, Christian");
		Aktorea aktore2				= new Aktorea("DiCaprio, Leonardo");
		Aktorea aktore3				= new Aktorea("Ledger, Heath");
		
		//1. Emandako lista hutsa izatea:			
		zerrendaHutsa.ezabatuPelikulaHauetatik(aktore1);
		zerrendaHutsa.inprimatuGuztiak();
				
		//2. Ezabatu nahi den aktorea pelikuletan ez egotea:		
				
		listaPelikulak.ezabatuPelikulaHauetatik(aktore2);
				
		//3. Ezabatu nahi den aktorea pelikula batean egotea:		
			
		Pelikula filma10	= new Pelikula("Titanic");
		listaPelikulak.gehituPelikula(filma10);
		
		listaPelikulak.ezabatuPelikulaHauetatik(aktore2);				 
		
				 
		//4. Ezabatu nahi den aktorea pelikula askotan egotea:
		
		Pelikula filma11	= new Pelikula("Inception");
		listaPelikulak.gehituPelikula(filma11);
		
		listaPelikulak.ezabatuPelikulaHauetatik(aktore2);	
				
	}
	
	@Test
	public void luzera(){ 
		
		ListaPelikulak besteListaBat5 = new ListaPelikulak();
		besteListaBat5.gehituPelikula(filma1);
		
		//Zerrenda hutsa: 0
		assertEquals(zerrendaHutsa.luzera(), 0);
		
		//Elementu bakarra egotea zerrendan: 1
		assertEquals(besteListaBat5.luzera(), 1);
				
		//Elementu asko duen zerrenda: 5
		assertEquals(listaPelikulak.luzera(), 5);				
		
	}
	
	@Test
	public void erreseteatu() {
		
		listaPelikulak.erreseteatu();
		
	}
	
	@Test
	public void garbitu(){
		
		listaPelikulak.garbitu();
	}

}
