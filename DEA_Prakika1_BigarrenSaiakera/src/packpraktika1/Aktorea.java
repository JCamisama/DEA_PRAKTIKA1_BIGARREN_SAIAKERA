package packpraktika1;
import java.io.PrintWriter;
import java.util.*;

public class Aktorea {
	
	private String 				izena;
	private ListaPelikulak		starringPelikula; //Jardun duen pelikularen posizioa (errenkada) gordeko da
	
	public Aktorea(String pIzena){
		
		this.izena = pIzena;
		starringPelikula = new ListaPelikulak();
	}
	
	public void gehituPelikula(Pelikula pFilma){
		
		this.starringPelikula.gehituPelikula(pFilma);
	}

	
	public void inprimatuAktorea(){
		
		System.out.println("\nIzen Osoa: " + this.izena + "\n\n");
		
	}
	
	public void idatziAktorearenIzena(PrintWriter pOutputStream){
		
		pOutputStream.println(this.izena);
	}
	
	public boolean lehenagoDoa(Aktorea pBesteAktorea){
		
		return pBesteAktorea.lehenagoDoa(this.izena);
		
	}
	
	private boolean lehenagoDoa(String pIzena){
		
		return pIzena.compareToIgnoreCase(this.izena) <= 0;
		
		
	}
	
	public String getIzena(){
		
		return this.izena;
	}
	
	/****************************************JONPORT**********************************************/
	
	public boolean bilatzekoAktorea(Aktorea pAktore) {
		
		return this.izena.equals(pAktore.getIzena());
	}

	
	public ListaPelikulak aktorearenPelikulakBueltatu() {
		
		return this.starringPelikula;
	}
		
}
