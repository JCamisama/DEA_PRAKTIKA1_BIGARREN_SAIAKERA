package packpraktika1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IrakurketakEtaIdazketak {
	
	private Scanner eskanerHau;
	
/**************************TEKLATUTIK IRAKURTZEKO******************************/
	public  String irakurriString(String pMezua){ //Teklatutik irakurtzeko metodoa
		
		System.out.print(pMezua+": ");
		String erantzuna	= this.eskanerHau.next();
		
		
		return erantzuna;
	}
	
	public int irakurriOsoaSalbuespen(String pMezua) {
		System.out.println(pMezua+": ");
		int zenbakia;
		zenbakia=eskanerHau.nextInt();
		return zenbakia;
	}
	
	public int irakurriOsoa(String pMezua) {
		int erantzuna=0;
		boolean kontrolpean=false;
		do{
			try{
				erantzuna=this.irakurriOsoaSalbuespen(pMezua);
				kontrolpean=true;
			}
			catch (InputMismatchException e){
				System.out.println("Sartu duzun balioa ez da zenbaki oso bat, saiatu berriz. ");
				eskanerHau=new Scanner(System.in);
			}
		}while (!kontrolpean);
		return erantzuna;
	}	
/*********************************************************************************/	
	
	
	
	public void fitxategiaIreki(){
		
		//String filename = "Fitxategiak/FilmakAktoreak.txt";
		String filename = "Fitxategiak/FilmsActors20162017.txt";
		try{
			
			eskanerHau = new Scanner(new File(filename));
		}
		
		catch(Exception e){
			
			System.out.println("Fitxategia ez da aurkitu.");
		}
	
	}
	
	public void fitxategiaIrakurri(){
		
		//Aurre-Baldintza:	Fitxategia irekita egongo da, klase honetako fitxategiaIreki() metodo erabiltzen.
		//Post-Baldinta: 	Aktoreen eta pelikulen zerrenda nagusiak beteta egongo dira, baita aktore-pelikula erlazioak ere.
		//Kostua:			O(n*m*konstantea); Non n pelikulen kopurua da, eta m aktoreen kopurua.	
		Stopwatch kronometroa = new Stopwatch();
		int zenbatLerro = 0;
		while(eskanerHau.hasNextLine()){
			
			String		lerroa			= this.eskanerHau.nextLine();
			String[]	peliAktBanatuak = lerroa.split("\\s+--->\\s+");
			String		pelikulaIzena	= peliAktBanatuak[0];
			String[]	aktoreak		= peliAktBanatuak[1].split("\\s+&&&\\s+");
			
			this.pelikulaAktoreakHasieratu(pelikulaIzena, aktoreak);
			zenbatLerro++;
			
			if(zenbatLerro % 10000 == 0){
				
				System.out.println("\nIrakurritako lerroak: " + zenbatLerro);
			}
		}
		System.out.println("Tardatutako denbora: "+kronometroa.elapsedTime()+" segundu.");
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
		
		//peliMaster.gehituPelikula(pelikulaHau);//ez errepikatzearena EZ DAGO INPLEMENTATUTA ORAINDIK
		peliMaster.pelikulaKargatu(pelikulaHau);
	}
	
	public void fitxategiaItxi(){
		
		//Aurre-Baldintza:	Fitxategia aurretik ireki da.
		//Post-Baldinta: 	Fitxategia itxita egongo da.
		//Kostua:			O(1)
		
		this.eskanerHau.close();
	}
	
	public static void AktoreenZerrendaIdatzi(){
		
		//Aurre-Baldintza:	Fitxategiaren kokapena/helburua  metodoaren barruan dagoena da.
		/*Post-Baldinta: 	Aktoreen zerrenda bere baitan daukan fitxategia sortuko da ez bada existitzen, 
							bestela horren gainean idatziko da. */
		//Kostua:			O(n); Non n aktore kopurua da.
		
		
		String filename		= "Fitxategiak/Aktoreak.txt";
		
		try{
			
			File file = new File (filename);
			PrintWriter outputStream = new PrintWriter(filename);
			AktoreGuztiak.idatziAktoreGuztiak(outputStream);
			outputStream.flush();
			outputStream.close();
			
			System.out.print("Eginda!");
		}
		
		catch (FileNotFoundException e){
			
			e.printStackTrace();
		}
		
	}


	
	
	/****************************MENUAREN METODOAK****************************/
	public void aktoreBatenBilaketaMenu(IrakurketakEtaIdazketak pIdaz){
		
		String aktoreIzena = pIdaz.irakurriString("\nSartu ezabatu nahi duzun aktorearen izena('Bale, Christian' adibidez):  ");
		Aktorea aktoreHau = AktoreGuztiak.getNireAktoreak().aktoreaBilatu(aktoreIzena);
		
		if( aktoreHau != null){
			
			System.out.println("Aktorea aurkitu da.");	
		}
		
		else{
			
			System.out.println("Aktorea ez da aurkitu.");
		}
	}
	
	public void aktoreBerriBatTxertatuMenu(IrakurketakEtaIdazketak pIdaz){
		
		//Borratu nahi den aktorea bilatzen
		String aktoreIzena = pIdaz.irakurriString("\nSartu ezabatu nahi duzun aktorearen izena('Bale, Christian' adibidez):  ");
		Aktorea aktoreHau  = new Aktorea(aktoreIzena);
		
		//Aktoreen zerrenda nagusiaren aktore kopurua gehitu baino lehen
		System.out.println("Aktore kopurua gehitu baino lehen: "+AktoreGuztiak.getNireAktoreak().luzera());
		//Aktoreen zerrenda nagusian sartzen
		AktoreGuztiak.getNireAktoreak().gehituAktorea(aktoreHau);
		//Aktoreen zerrenda nagusiaren aktore kopurua gehitu eta gero
		System.out.println("Aktore kopurua gehitu eta gero: "+AktoreGuztiak.getNireAktoreak().luzera());
		
	}
	
	public void aktoreBatenPelikulakBueltatuMenu(IrakurketakEtaIdazketak pIdaz){
		
		//Aktorea bilatzen
		String aktoreIzena = pIdaz.irakurriString("\nSartu ezabatu nahi duzun aktorearen izena('Bale, Christian' adibidez):  ");
		Aktorea aktoreHau = AktoreGuztiak.getNireAktoreak().aktoreaBilatu(aktoreIzena);
		
		//Aktorearen pelikulen zerrenda hartzen
		ListaPelikulak peliZerre = aktoreHau.aktorearenPelikulakBueltatu();
		//Pelikulak zeintzuk diren jakiteko, pantailaratuko dira
		peliZerre.inprimatuGuztiak();
		
		
	}
	public void pelikuaBatekoAktoreakBueltatuMenu(IrakurketakEtaIdazketak pIdaz){
		
		//Aldatu nahi den pelikula bilatzen
		String pelikulaIzena = pIdaz.irakurriString("\nSartu pelikularen izena(Zombie Beer Run adibidez):  ");
		Pelikula peliHau = PelikulaGuztiak.getNirePelikulak().pelikulaBilatu(pelikulaIzena);
		
		//Aktoreen zerrenda hartzen
		ListaAktoreak aktoreZerre = peliHau.pelikularenAktoreakBueltatu();
		//Aktoreak zeintzuk diren jakiteko, pantailaratuko dira
		aktoreZerre.inprimatuAktoreak();
		
	}
	public void pelikulaBatenDiruaGehituMenu(IrakurketakEtaIdazketak pIdaz){
		
		//Aldatu nahi den pelikula bilatzen
		String pelikulaIzena = pIdaz.irakurriString("\nSartu pelikularen izena(Zombie Beer Run adibidez):  ");
		int	   kantitatea	 = pIdaz.irakurriOsoa("\nSartu zenbat diru gehitu nahi diozu (kantitatea negatiboa bada, "
				+ "galera izango da:  ");
		Pelikula peliHau = PelikulaGuztiak.getNirePelikulak().pelikulaBilatu(pelikulaIzena);
		
		//Pelikulari diru kantitatea gehitzen
		peliHau.gehituDirua(kantitatea);
		peliHau.diruSarreraTotalakInprimatu();
		
		
		
	}
	
	public  void AktoreBatenEzabaketaMenu(IrakurketakEtaIdazketak pIdaz){
		
		//Borratu nahi den aktorea bilatzen
		String aktoreIzena = pIdaz.irakurriString("\nSartu ezabatu nahi duzun aktorearen izena('Bale, Christian' adibidez):  ");
		Aktorea aktoreHau = AktoreGuztiak.getNireAktoreak().aktoreaBilatu(aktoreIzena);
		
		//Jardun duen pelikuletatik kentzen
		aktoreHau.ezabatuBerePelikuletatik();
		
		//Aktore guztien zerrendatik kentzen
		AktoreGuztiak.getNireAktoreak().ezabatuAktoreenErregistrotik(aktoreHau.getIzena());
		
	}
	public void AktoreenZerrendaIdatziMenu(IrakurketakEtaIdazketak pIdaz){
		
		pIdaz.AktoreenZerrendaIdatzi();
		System.out.println("\nAktoreen zerrenda proiektu honetako Fitxategiak karpetan gorde da.");
	}
	public static void AktoreenZerrendaOrdenatuaMenu(){
		
		ListaAktoreak zerreOrdenatu = AktoreGuztiak.getNireAktoreak().zerrendaOrdenatuaBueltatu();
		System.out.println("Aktoreen zerrenda ordenatua inprimatuko da: \n\n");
		zerreOrdenatu.inprimatuAktoreak();
	}
	public static void amaieraMenu(){
		
		System.out.println("\nPrograma amaitu da.");
	}
	
	/***************************************************************************/
	
	public static void main(String[] args){
		
		IrakurketakEtaIdazketak cHau = new IrakurketakEtaIdazketak(); //Klase honetako metodoei deia egiteko: claseHau
		
		/*
		Stopwatch kronometroa = new Stopwatch();
		cHau.fitxategiaIreki();
		cHau.fitxategiaIrakurri();
		cHau.fitxategiaItxi();
		System.out.println("Tardatutako denbora: "+kronometroa.elapsedTime()+" segundu.");
		//ListaAktoreak zerrendaOrdenatua = zHau.AktoreOrdenatuakLortu();
		//zerrendaOrdenatua.inprimatuAktoreak();
		//bHau.AktoreenZerrendaIdatzi();
		
		//cHau.AktoreenZerrendaIdatzi();
		//PelikulaGuztiak.getNirePelikulak().inprimatuGuztiak();*/
		
		
		 Scanner sarrera	= new Scanner(System.in);
		 boolean jarraitu	= true;

		 int aukera;
		 
		 System.out.println("\t\t\t*******FILMAK ETA AKTOREAK - PRAKTIKA 1*******\n");
		 System.out.println("Filma eta pelikula guztiak irakurriko dira orain:\n\n ");
		 cHau.fitxategiaIreki();
		 cHau.fitxategiaIrakurri();
		 cHau.fitxategiaItxi();
		 
		 
		 while(jarraitu){
		        System.out.println("\t\t\t*******MENU NAGUSIA*******\n\n");
		        System.out.print("1.) Aktore baten bilaketa. \n");
		        System.out.print("2.) Aktore berri baten txertaketa.\n");
		        System.out.print("3.) Aktore baten pelikulak bueltatu.\n");
		        System.out.print("4.) Pelikula bateko aktoreak bueltatu.\n");
		        System.out.print("5.) Pelikula baten dirua gehitu, emandako kantiate batean.\n");
		        System.out.print("6.) Aktore baten ezabaketa.\n");
		        System.out.print("7.) Aktoreen zerrenda fitxategi batean gorde.\n");
		        System.out.print("8.) Aktoreen zerrenda ordenatua lortu (abizenak, izena).\n");
		        System.out.print("9.) Amaiera.\n");
		        
		        System.out.print("\nSartu zure aukera: ");

		        aukera = sarrera.nextInt();

		        switch(aukera){

		        case 1:
		            
		        	
		      
		            break;

		        case 2: 
		       
		        	cHau.aktoreBerriBatTxertatuMenu(cHau);
		            break;

		        case 3:
		          
		        	cHau.aktoreBatenPelikulakBueltatuMenu(cHau);
		            break;

		        case 4: 
		        
		        	cHau.pelikuaBatekoAktoreakBueltatuMenu(cHau);
		            break;

		        case 5:
		        	
		        	cHau.pelikulaBatenDiruaGehituMenu(cHau);
		            break;

		        case 6: 
		            
		        	cHau.AktoreBatenEzabaketaMenu(cHau);
		            break;
		            
		        case 7: 
		            
		        	cHau.AktoreenZerrendaIdatziMenu(cHau);
		            break;
		            
		        case 8: 
		        	
		        	IrakurketakEtaIdazketak.AktoreenZerrendaOrdenatuaMenu();
		        	break;
		        	
		        case 9:
		        	
		        	IrakurketakEtaIdazketak.amaieraMenu();
		        	break;

		        }


		        
		
	}
	}

}
