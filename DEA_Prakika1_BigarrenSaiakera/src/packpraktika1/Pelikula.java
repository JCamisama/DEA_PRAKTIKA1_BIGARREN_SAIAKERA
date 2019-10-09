package packpraktika1;


public class Pelikula{
	
	private String			izena;
	private int				diruBilketa;
	private ListaAktoreak	jardunDutenak;
	
	public Pelikula(String pIzena){
		
		this.izena			= pIzena;
		this.jardunDutenak	= new ListaAktoreak();
	}
	
	public void aktoreBerriaSartu(Aktorea pAktore){
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Aktorea ez badago jardunDutenak zerrendan, horretan txertatuko da.
		//Kostua:			O(n); Non n aktore kopurua da.
		
		if( pAktore != null && !this.jardunDutenak.badagoAktorea( pAktore.getIzena() )){
		
				this.jardunDutenak.gehituAktorea(pAktore);
		}
		
	}
	
	public void inprimatuIzena(){ //Frogak egiteko bakarrik
		
		System.out.println(this.izena);
	}
	
	
	public void gehituDirua(int pZenbatekoa){
		
		//Aurre-Baldintza:	----------------------------------------------------------
		//Post-Baldinta: 	Pelikularen diru bilketa pZenbatekoa kantitateaz handituko da.
		//Kostua:			O(1)
		
		this.diruBilketa = this.diruBilketa + pZenbatekoa;
	}

	
	public ListaAktoreak pelikularenAktoreakBueltatu() {
		
		//Aurre-Baldintza:	----------------------------------------------
		//Post-Baldintza:	Pelikularen aktore guztiak ArrayList baten barruan sartuta bueltatuko dira.
		//Kostua:			O(1);
		
		return this.jardunDutenak;
	}
	
	public String getIzena(){
		
		//Aurre-Baldintza:	---------------------
		//Post-Baldinta:	pelikularen izena bueltatuko da, String motakoa
		//Kostua:			O(1);
		
		return this.izena;
	}
	
	public boolean bilatzekoPelikula(Pelikula pFilma) {
		
		//Aurre-Baldintza:	Letra larriak eta xeheak ezberdinduko dira.
		//Post-Baldintza:	pFilma izena pelikula honen izenaren berdina bada True, bestela False.
		//Kostua:			O(1);
		
		return this.izena.equals(pFilma.getIzena());
	}
	
	public void AktoreaPelikulatikKendu(String pAktoreIzena){ //METODO BERRIA, JUNIT BEHAR DU
		
		Aktorea aktoreHau = new Aktorea(pAktoreIzena);
		this.jardunDutenak.ezabatuAktorea(aktoreHau);
	}

}
