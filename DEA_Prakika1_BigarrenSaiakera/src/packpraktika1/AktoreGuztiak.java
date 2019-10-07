package packpraktika1;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

public class AktoreGuztiak {
	
	private static AktoreGuztiak nireAktoreak;
	private HashMap<String, Aktorea> zerrenda; //HashMap zuzenean inplementatu da klase honetan, beste klaserik ez duelako erabiliko.
	
	private AktoreGuztiak(){
		
		this.zerrenda = new HashMap<String, Aktorea>();// HashMap<Giltza, ZerGorde>()
	}
	
	public static synchronized AktoreGuztiak getNireAktoreak(){
		
		if( nireAktoreak == null){
			
			nireAktoreak = new AktoreGuztiak();	
		}
		
		return nireAktoreak;
	}
	
	

	public void gehituAktorea(Aktorea pAktore){
		
		//Aurre-Baldintza:	pAktorea ez da Null izango.
		//Post-Baldinta: 	Zerrenda badago dagoeneko, ez da gehituko, bestela bai.
		//Kostua:			O(1);	
		
		if(!this.zerrenda.containsKey( pAktore.getIzena() ) ){
			
			this.zerrenda.put(pAktore.getIzena(), pAktore);
		}
		

	}
	
	
	
	public static void idatziAktoreGuztiak(PrintWriter pOutputStream){
		
		//Aurre-Baldintza:	------------------------------------------
		//Post-Baldinta: 	Aktoreen zerrenda pOutputStream-ean idatzita agertuko dira.
		//Kostua:			O(2n) ---> O(n);	
		
		pOutputStream.println("\t\t***AKTOREEN ZERRENDA***\n\n");
		
		Iterator<Aktorea> itr		= AktoreGuztiak.getNireAktoreak().getAktoreenIteradorea(); //Aktoreen zerrenda bat sortzen
		Aktorea			  aktoreHau	= null;
		
		while( itr.hasNext() ){
			
			aktoreHau	= itr.next();
			aktoreHau.idatziAktorearenIzena(pOutputStream);
			//aktoreHau.inprimatuAktorea();
			
		}
		
		
	}
	
	private Iterator<Aktorea> getAktoreenIteradorea(){
		
		//Aurre-Baldintza:	------------------------------------------
		//Post-Baldinta: 	Aktoreen bilduma bat bueltatuko du, Iterator interfaz bezala.
		//Kostua:			O(n);
		
		return this.zerrenda.values().iterator(); //HashMap-eko aktore guztiak zerrenda batean kokaturik egongo dira.
	}
	
	
	public Aktorea aktoreaBilatu(String pIzena){
	
		//Aurre-Baldintza:	------------------------------------------
		//Post-Baldinta: 	Aktorea zerrendan badago, objektua bueltatuko du, bestela null.
		//Kostua:			O(1)
		
		Aktorea aktoreHau = null;
		
		this.zerrenda.get(pIzena);
		
		
		return aktoreHau;
		
	}
	
	

}
