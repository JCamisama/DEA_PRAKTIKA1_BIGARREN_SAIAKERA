package packpraktika1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PelikulaGuztiakTest {
	
	PelikulaGuztiak listaPelikulaGuztiak, listaHutsa = null;
	Pelikula filma1, filma2, filma3, filma4, filma5;
	

	@Before
	public void setUp() throws Exception {
		
		
		filma1 = new Pelikula ("Eager to Die");
		filma2 = new Pelikula ("Mitologia do submundo");
		filma3 = new Pelikula ("Einsatz in 4 W nden");
		filma4 = new Pelikula ("God's Pocket");
		filma5 = new Pelikula ("Epitaph: Bread and Salt");
		
		listaPelikulaGuztiak = PelikulaGuztiak.getNirePelikulak();
		listaHutsa = PelikulaGuztiak.getNirePelikulak();
		
		
		listaPelikulaGuztiak.gehituPelikula(filma1);
		listaPelikulaGuztiak.gehituPelikula(filma2);
		listaPelikulaGuztiak.gehituPelikula(filma3);
		listaPelikulaGuztiak.gehituPelikula(filma4);
		listaPelikulaGuztiak.gehituPelikula(filma5);		
		
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
	public void testGetNirePelikulak() {
		
		assertNotNull(listaPelikulaGuztiak);
		
		
	}

	@Test
	public void testGehituPelikula() {
		
		//1. Pelikuleen zerrenda hutsik egotea, Pelikula gehitu:		
			listaHutsa.gehituPelikula(filma1);		
			listaHutsa.inprimatuGuztiak();
				
		//2. Pelikula jadanik listan egotea:
			listaPelikulaGuztiak.gehituPelikula(filma1);		
			listaPelikulaGuztiak.inprimatuGuztiak();
				
		//3. Zerrenda pelikula bakarra izatea gehiketa baino lehen:
			PelikulaGuztiak besteListaBat = null;
			besteListaBat = PelikulaGuztiak.getNirePelikulak();
			besteListaBat.gehituPelikula(filma1);
				
			Pelikula filma6 = new Pelikula ("Universal Ninjas");				
			besteListaBat.gehituPelikula(filma6);
				
			besteListaBat.inprimatuGuztiak();
		
	}

	@Test
	public void testEzabatuFilma() {
		
		//1. Emandako lista hutsa izatea:			
			listaHutsa.ezabatuFilma(filma1);
			listaHutsa.inprimatuGuztiak();
				
		//2. Ezabatu nahi den pelikula zerrendan ez egotea:			
			Pelikula filma7 = new Pelikula ("Hollywood Dreams");		
			listaPelikulaGuztiak.ezabatuFilma(filma7);
				
		//3. Ezabatu nahi den Pelikula hasieran egotea:		
				PelikulaGuztiak besteListaBat2 = null;
				besteListaBat2 = PelikulaGuztiak.getNirePelikulak();
				besteListaBat2.gehituPelikula(filma1);
				besteListaBat2.gehituPelikula(filma2);
				besteListaBat2.gehituPelikula(filma3);
				besteListaBat2.gehituPelikula(filma4);
				besteListaBat2.gehituPelikula(filma5);
				
				besteListaBat2.ezabatuFilma(filma1);
				 
				besteListaBat2.inprimatuGuztiak();
				 
		//4. Ezabatu nahi den Pelikula amaieran egotea:
				PelikulaGuztiak besteListaBat3 = null;
				besteListaBat3 = PelikulaGuztiak.getNirePelikulak();
				besteListaBat3.gehituPelikula(filma1);
				besteListaBat3.gehituPelikula(filma2);
				besteListaBat3.gehituPelikula(filma3);
				 
				besteListaBat3.ezabatuFilma(filma3);
				 
				besteListaBat3.inprimatuGuztiak();		
		
	}
	
	@Test
	public void pelikulaBilatu() {
		
		 PelikulaGuztiak besteListaBat4 = null;
		 besteListaBat4 = PelikulaGuztiak.getNirePelikulak();
		 besteListaBat4.gehituPelikula(filma1);
		 besteListaBat4.gehituPelikula(filma2);
		 besteListaBat4.gehituPelikula(filma3);
		 
		 Pelikula filma7 = new Pelikula ("Hollywood Dreams");	
		 
		 Pelikula pelikulaHau =null;
		
		//1. Pelikula zerrendan ez egotea:
		
			pelikulaHau = besteListaBat4.pelikulaBilatu(filma7.getIzena()); ////filma1, filma2 eta filma3 ditu bere baitan
			assertNull(pelikulaHau);
				
				
				
		//2. Pelikula hasieran egotea:
				
			pelikulaHau = besteListaBat4.pelikulaBilatu(filma1.getIzena()); //filma1, filma2 eta filma3 ditu bere baitan, orden honetan.
			assertTrue(pelikulaHau.getIzena().equals(filma1.getIzena()));
				
				
				
		//3. Pelikula amaieran egotea:
				
			pelikulaHau = besteListaBat4.pelikulaBilatu(filma3.getIzena()); //filma1, filma2 eta filma3 ditu bere baitan, orden honetan.
			assertTrue(pelikulaHau.getIzena().equals(filma3.getIzena()));
				
				
		//4. Pelikula erdian egotea:
				
			pelikulaHau = besteListaBat4.pelikulaBilatu(filma2.getIzena()); //filma1, filma2 eta filma3 ditu bere baitan, orden honetan.
			assertTrue(pelikulaHau.getIzena().equals(filma2.getIzena()));		
		
		
	}

	@Test
	public void testInprimatuGuztiak() {
		
		listaPelikulaGuztiak.inprimatuGuztiak();
		
	}

	@Test
	public void pelikulaKargatu(){
		
		//1. Pelikuleen zerrenda hutsik egotea, Pelikula gehitu:		
		listaHutsa.gehituPelikula(filma1);		
		listaHutsa.inprimatuGuztiak();
			
		//2. Pelikula jadanik listan egotea:
		listaPelikulaGuztiak.gehituPelikula(filma1);		
		listaPelikulaGuztiak.inprimatuGuztiak();
			
		//3. Zerrenda pelikula bakarra izatea gehiketa baino lehen:
		PelikulaGuztiak besteListaBat5 = null;
		besteListaBat5 = PelikulaGuztiak.getNirePelikulak();
		besteListaBat5.gehituPelikula(filma1);
			
		Pelikula filma6 = new Pelikula ("Universal Ninjas");				
		besteListaBat5.gehituPelikula(filma6);
			
		besteListaBat5.inprimatuGuztiak();
	}
	
	@Test
	public void luzera(){ 
		
		this.listaPelikulaGuztiak.luzera();
	}
	
	@Test
	public void erreseteatu(){ 
		
		this.listaPelikulaGuztiak.erreseteatu();
	}

}
