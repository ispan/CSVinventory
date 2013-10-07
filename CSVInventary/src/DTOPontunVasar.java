
public class DTOPontunVasar {

	
	private String pontunarN;
	private String vasaN;
	
	public DTOPontunVasar(String pontunarN, String vasaN){
		this.pontunarN = pontunarN;
		this.vasaN = vasaN;
	}
/*	
	public String toString() {
		return "DTOPontunVasar [pontunarN=" + pontunarN + ",vasaN=" + vasaN  + "]";
	}*/
	
	public String getPontunarN() {
		return pontunarN;
	}
	public void setPontunarN(String pontunarN) {
		this.pontunarN = pontunarN;
	}
	public String getVasaN() {
		return vasaN;
	}
	public void setVasaN(String vasaN) {
		this.vasaN = vasaN;
	}
	
	
}
