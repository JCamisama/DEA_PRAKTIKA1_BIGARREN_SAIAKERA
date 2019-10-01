package packpraktika1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IrakurketakEtaIdazketak {
	
	private Scanner eskanerHau;
	
	public void fitxategiaIreki(){
		
		String filename = "FilmakAktoreak.txt";
		try{
			
			eskanerHau = new Scanner(new File(filename));
		}
		
		catch(Exception e){///******TO-DO**********************
			
			System.out.println("Fitxategia ez da aurkitu.");
		}
	
	}
	
	public void fitxategiaIrakurri(){
		
		while(eskanerHau.hasNextLine()){
			
			String		lerroa			= this.eskanerHau.nextLine();
			String[]	peliAktBanatuak = lerroa.split("\\s+--->\\s+");
			String		pelikulaIzena	= peliAktBanatuak[0];
			String[]	aktoreak		= peliAktBanatuak[1].split("\\s+&&&\\s+");
			
			this.pelikulaAktoreakHasieratu(pelikulaIzena, aktoreak);
			
		}
	}
	
	public void pelikulaAktoreakHasieratu(String pFilmaIzena, String[] pAktoreakIzenak){
		
		PelikulaGuztiak	peliMaster	= PelikulaGuztiak.getNirePelikulak();
		AktoreGuztiak	aktorMaster	= AktoreGuztiak.getNireAktoreak();
		
		//Pelikula bakoitzeko aktoreak gehitzen
		Pelikula	pelikulaHau		= new Pelikula(pFilmaIzena);
		int			AktorPosizio	= 0;
		
		while( AktorPosizio < pAktoreakIzenak.length ){
			
			Aktorea	aktoreHau	= new Aktorea(pAktoreakIzenak[AktorPosizio]);
			
			aktoreHau.gehituPelikula(pelikulaHau);
			aktorMaster.gehituAktorea(aktoreHau);
			pelikulaHau.aktoreBerriaSartu(aktoreHau);
				
			AktorPosizio++;
		}
		
		peliMaster.gehituPelikula(pelikulaHau);//ez errepikatzearena EZ DAGO INPLEMENTATUTA ORAINDIK
	}
	
	public void fitxategiaItxi(){
		
		this.eskanerHau.close();
	}
	
	public void AktoreenZerrendaIdatzi(){
		
		String filename = "C:\\Users\\GySyX\\Desktop\\Aktoreak.txt";
		
		try{
			
			PrintWriter outputStream = new PrintWriter(filename);
			AktoreGuztiak.idatziAktoreGuztiak(outputStream);
			outputStream.flush();
			outputStream.close();
			
			System.out.print("Eginda!");
		}
		
		catch (FileNotFoundException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static void main(String[] args){
		
		IrakurketakEtaIdazketak cHau = new IrakurketakEtaIdazketak();
		
		cHau.fitxategiaIreki();
		cHau.fitxategiaIrakurri();
		cHau.fitxategiaItxi();
		//ListaAktoreak zerrendaOrdenatua = zHau.AktoreOrdenatuakLortu();
		//zerrendaOrdenatua.inprimatuAktoreak();
		//bHau.AktoreenZerrendaIdatzi();
		
		cHau.AktoreenZerrendaIdatzi();
		//PelikulaGuztiak.getNirePelikulak().inprimatuGuztiak();
	}

}
