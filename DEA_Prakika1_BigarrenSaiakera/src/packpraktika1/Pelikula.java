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
		
		this.jardunDutenak.gehituAktorea(pAktore);
		
	}
	
	public void inprimatuIzena(){
		
		System.out.println(this.izena);
	}
	
	
	public void gehituDirua(int pZenbatekoa){
		
		this.diruBilketa = this.diruBilketa + pZenbatekoa;
	}

	
	public ListaAktoreak pelikularenAktoreakBueltatu() {
		
		return this.jardunDutenak;
	}
	
	public String getIzena(){
		
		return this.izena;
	}
	
	public boolean bilatzekoPelikula(Pelikula pFilma) {
		
		return this.izena.equals(pFilma.getIzena());
	}

}
