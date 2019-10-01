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
	
}