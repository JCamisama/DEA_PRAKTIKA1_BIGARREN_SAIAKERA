package packpraktika1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IrakurketakEtaIdazketak {
	
	private Scanner eskanerHau;
	
	public void fitxategiaIreki(){
		
		String filename = "Fitxategiak/FilmakAktoreak.txt";
		try{
			
			eskanerHau = new Scanner(new File(filename));
		}
		
		catch(Exception e){///******TO-DO**********************
			
			System.out.println("Fitxategia ez da aurkitu.");
		}
	
	}
	
	public void fitxategiaIrakurri(){
		
		//Aurre-Baldintza:	Fitxategia irekita egongo da, klase honetako fitxategiaIreki() metodo erabiltzen.
		//Post-Baldinta: 	Aktoreen eta pelikulen zerrenda nagusiak beteta egongo dira, baita aktore-pelikula erlazioak ere.
		//Kostua:			O(n*m*konstantea); Non n pelikulen kopurua da, eta m aktoreen kopurua.	
		
		while(eskanerHau.hasNextLine()){
			
			String		lerroa			= this.eskanerHau.nextLine();
			String[]	peliAktBanatuak = lerroa.split("\\s+--->\\s+");
			String		pelikulaIzena	= peliAktBanatuak[0];
			String[]	aktoreak		= peliAktBanatuak[1].split("\\s+&&&\\s+");
			
			this.pelikulaAktoreakHasieratu(pelikulaIzena, aktoreak);
			
		}
	}
	
	public void pelikulaAktoreakHasieratu(String pFilmaIzena, String[] pAktoreakIzenak){
		
		//Aurre-Baldintza:	Pelikularen izena eta aktoreen izenen zerrenda ondo irakurri dira.
		/*Post-Baldinta: 	Pelikula objektua pelikulen zerrenda nagusian gehituta egongo da, aktore
		 					berriak aktoreen zerrenda nagusian gehituko dira. Gainera, pelikularen eta
		 					aktoreen arteko erlazioa finkatuta egongo da. */
		//Kostua:			O(m*konstantea); non m aktoreen kopurua den.		

		
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
		
		//Aurre-Baldintza:	Fitxategia aurretik ireki da.
		//Post-Baldinta: 	Fitxategia itxita egongo da.
		//Kostua:			O(1)
		
		this.eskanerHau.close();
	}
	
	public void AktoreenZerrendaIdatzi(){
		
		//Aurre-Baldintza:	Fitxategiaren kokapena/helburua  metodoaren barruan dagoena da.
		/*Post-Baldinta: 	Aktoreen zerrenda bere baitan daukan fitxategia sortuko da ez bada existitzen, 
							bestela horren gainean idatziko da. */
		//Kostua:			O(n); Non n aktore kopurua da.
		
		
		String filename		= "Fitxategiak/Aktoreak.txt";
		//String filename		= "C:/Users/GySyX/Desktop/Aktoreak.txt";
		//String filename = "Fitxategiak/Aktoreak.txt";
		//String filename = "Fitxategiak"+File.separator+"Aktoreak.txt";
		//File file = new File (filename);
		//"Fitxategiak"+File.separator+"Galdera_berdeaBiologia.txt";
		
		try{
			
			File file = new File (filename);
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
