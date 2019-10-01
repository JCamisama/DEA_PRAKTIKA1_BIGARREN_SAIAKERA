package packpraktika1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaAktoreak {
	
	private ArrayList<Aktorea> zerrenda;
	
	public ListaAktoreak(){
		
		this.zerrenda = new ArrayList<Aktorea>();
	}
	

	private Iterator<Aktorea> getIteradorea(){
		
		return this.zerrenda.iterator();
	}
	
	public void gehituAktorea(Aktorea pAktore){
		
		this.zerrenda.add(pAktore);
	}
	
	public void ezabatuAktorea(Aktorea pAktore){
		
		this.zerrenda.remove(pAktore);
	}
	
	public void inprimatuAktoreak(){
		
		Iterator<Aktorea>	itr			= this.getIteradorea();
		Aktorea				aktoreHau	= null;
		
		while( itr.hasNext() ){
			
			aktoreHau = itr.next();
			aktoreHau.inprimatuAktorea();
		}
	}

	public void idatziAktoreGuztiak(PrintWriter pOutputStream){
		
		Iterator<Aktorea> itr		= this.getIteradorea();
		Aktorea			  aktoreHau = null;
		
		while(itr.hasNext() ){
			
			aktoreHau = itr.next();
			aktoreHau.idatziAktorearenIzena(pOutputStream);
		}
		
	}
	
	public int luzera(){
		
		return this.zerrenda.size();
	}
	
	public void elkartuOrdenatu(){
		
		this.elkartuOrdenatu(this.zerrenda, 0, this.zerrenda.size()-1);
		
	}
	
	private void elkartuOrdenatu(ArrayList<Aktorea> pAktoreak, int pHasiera, int pAmaiera){
		
		
		if(pHasiera < pAmaiera){
			
			this.elkartuOrdenatu( pAktoreak, pHasiera, ((pHasiera +pAmaiera)/2));
			this.elkartuOrdenatu( pAktoreak, ((pHasiera +pAmaiera)/2) +1, pAmaiera );
			this.bateratu(pAktoreak, pHasiera, ((pHasiera +pAmaiera)/2), pAmaiera);
		
		}
		
	}
	
	private  void bateratu(ArrayList<Aktorea> pAktoreak, int pHasiera, int pErdikoa, int pAmaiera){
		
		ArrayList<Aktorea>	bateratua	= new ArrayList<Aktorea>(pAmaiera-pHasiera+1);
		int					ezker		= pHasiera;
		int					eskuin		= pErdikoa + 1;
		//int					posBateratu	= 0;
		//String				ezkerrekoa	= "";
		//String				eskumakoa	= "";
		Aktorea				ezkerAktore	= null;
		Aktorea				eskuAktore	= null;
		
		while( ezker <= pErdikoa && eskuin <= pAmaiera){
			
			
			ezkerAktore = pAktoreak.get(ezker);
			eskuAktore	= pAktoreak.get(eskuin);
			 
			if( ezkerAktore.lehenagoDoa(eskuAktore)){
				
				bateratua.add(ezkerAktore);
				ezker++;
			}
			
			else{
				
				bateratua.add(eskuAktore);
				eskuin++;
			}	
		}
		
		if( ezker > pErdikoa ){

			while( eskuin <= pAmaiera ){
				
				eskuAktore	= pAktoreak.get(eskuin);
				bateratua.add(eskuAktore);
				eskuin++;
			}			
		}
		
		else{
			
			while( ezker <= pErdikoa ){
				
				ezkerAktore = pAktoreak.get(ezker);
				bateratua.add(ezkerAktore);
				ezker++;
			}
		}
		
		for(int i = pHasiera; i <= pAmaiera; i++){
			
			this.zerrenda.set(i, bateratua.get(i-pHasiera));
		}
		
		
		
	}
}
