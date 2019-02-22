package mundo;

public class AlgoritmosMundo {

	//Clase principal
	
	private Binary relacionBinario;
	private Karatsuba relacionKaratsuba;
	private Tradicional relacionTradicional;
	
	
	public AlgoritmosMundo() {
		relacionBinario = new Binary();
		relacionKaratsuba = new Karatsuba();
		relacionTradicional = new Tradicional();
	}
	
	public void reiniciarKaratsuba(){
		relacionKaratsuba=new Karatsuba();
	}
	public String darProcesoKaratsuba(){
		return relacionKaratsuba.devolverProceso();
	}


	public Binary getRelacionBinario() {
		return relacionBinario;
	}


	public void setRelacionBinario(Binary relacionBinario) {
		this.relacionBinario = relacionBinario;
	}


	public Karatsuba getRelacionKaratsuba() {
		return relacionKaratsuba;
	}


	public void setRelacionKaratsuba(Karatsuba relacionKaratsuba) {
		this.relacionKaratsuba = relacionKaratsuba;
	}


	public Tradicional getRelacionTradicional() {
		return relacionTradicional;
	}


	public void setRelacionTradicional(Tradicional relacionTradicional) {
		this.relacionTradicional = relacionTradicional;
	}
	
	
	
	
}
