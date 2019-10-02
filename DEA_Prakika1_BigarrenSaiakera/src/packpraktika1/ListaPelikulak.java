package packpraktika1;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPelikulak {

	private ArrayList<Pelikula> zerrenda;
	
	public ListaPelikulak(){
		
		this.zerrenda = new ArrayList<Pelikula>();
	}
	
	
	
	private Iterator<Pelikula> getIteradorea(){
		
		return this.zerrenda.iterator();
	}
	
	public void gehituPelikula(Pelikula pFilma){
		
		this.zerrenda.add(pFilma);
	}
	
	public void ezabatuFilma(Pelikula pFilma){
		
		this.zerrenda.remove(pFilma);
	}
	
	public void inprimatuGuztiak(){
		
		Iterator<Pelikula> itr = this.getIteradorea();
		
		Pelikula peliHau = null;
		
		while( itr.hasNext() ){
			
			peliHau = itr.next();
			peliHau.inprimatuIzena();
		}
		
	}
	
	/********************************************JONPORT*********************************/
	public Pelikula pelikulaBilatu(Pelikula pFilma) {
		
		Iterator<Pelikula>	itr				= this.getIteradorea();
		Pelikula			egungoPelikula	= null;
		boolean				topatua			= false;
		
		while( itr.hasNext() && !topatua){
			
			egungoPelikula = itr.next();
			
			if (egungoPelikula.bilatzekoPelikula(pFilma)) {
				
				topatua = true;	
				System.out.println("Zure pelikula listan dago");								
			}			
		}
		
		if (!topatua) {
			
			System.out.println("Zure pelikula ez dago listan.");
			egungoPelikula	= null;
		}
		return egungoPelikula;
		

	
	}
}
