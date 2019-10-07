package packpraktika1;

import java.util.ArrayList;

public class PelikulaGuztiak {
	
	private static PelikulaGuztiak nirePelikulak;
	private ListaPelikulak zerrenda;
	
	private PelikulaGuztiak(){
			
			this.zerrenda = new ListaPelikulak();
		}
	public static synchronized PelikulaGuztiak getNirePelikulak(){
			
		if(PelikulaGuztiak.nirePelikulak == null){
			
			PelikulaGuztiak.nirePelikulak = new PelikulaGuztiak();
		}
		
		return PelikulaGuztiak.nirePelikulak;
	}
	
	public void gehituPelikula(Pelikula pFilma){//******BERRIKUSI*******************
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Pelikula ez bada null eta ez badago zerrendan, gehituko da.
		//Kostua:			O(m); Non m pelikulen kopurua da.
		
		this.zerrenda.gehituPelikula(pFilma);
	}
	
	public void ezabatuFilma(Pelikula pFilma){
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Pelikula ez bada null eta pelikulen zerrendan  badago, zerrendatik ezabatuko da.
		//Kostua:			O(m); Non m pelikulen kopurua da.
		
		this.zerrenda.ezabatuFilma(pFilma);
	}
	
	public void inprimatuGuztiak(){//Frogak egiteko programatu da bakarrik, ez da memorian idatzi behar
		
		this.zerrenda.inprimatuGuztiak();
	}

}
