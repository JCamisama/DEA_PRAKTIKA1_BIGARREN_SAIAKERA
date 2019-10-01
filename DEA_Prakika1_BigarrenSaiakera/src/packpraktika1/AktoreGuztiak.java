package packpraktika1;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

public class AktoreGuztiak {
	
	private static AktoreGuztiak nireAktoreak;
	private HashMap<String, Aktorea> zerrenda;
	
	private AktoreGuztiak(){
		
		this.zerrenda = new HashMap<String, Aktorea>();
	}
	
	public static synchronized AktoreGuztiak getNireAktoreak(){
		
		if( nireAktoreak == null){
			
			nireAktoreak = new AktoreGuztiak();	
		}
		
		return nireAktoreak;
	}
	
	

	public void gehituAktorea(Aktorea pAktore){
		
		if(!this.zerrenda.containsKey( pAktore.getIzena() ) ){
			
		this.zerrenda.put(pAktore.getIzena(), pAktore);
		}
		
	}
	
	
	
	public static void idatziAktoreGuztiak(PrintWriter pOutputStream){
		
		pOutputStream.println("\t\t***AKTOREEN ZERRENDA***\n\n");
		
		Iterator<Aktorea> itr		= AktoreGuztiak.getNireAktoreak().getAktoreenIteradorea();
		Aktorea			  aktoreHau	= null;
		
		while( itr.hasNext() ){
			
			aktoreHau	= itr.next();
			aktoreHau.idatziAktorearenIzena(pOutputStream);
			aktoreHau.inprimatuAktorea();
			
		}
		
		
	}
	
	private Iterator<Aktorea> getAktoreenIteradorea(){
		
		return this.zerrenda.values().iterator();
	}
	
	/*public ListaAktoreak elkartuOrdenatu(){
		
		ListaAktoreak zerrendaHau = this.zerrenda;
		zerrendaHau.elkartuOrdenatu();
		
		return zerrendaHau;
	}*/

	

}
