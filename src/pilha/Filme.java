package pilha;

public class Filme {
	
	private String codigo;
	private String titulo;
	private String midia;
	private String valor;
	private String genero;
	private String dataPedido;
	private int numeroInterno;
	
	public int getNumeroInterno() {
		return numeroInterno;
	}
	public void setNumeroInterno(int numeroInterno) {
		this.numeroInterno = numeroInterno;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMidia() {
		return midia;
	}
	public void setMidia(String midia) {
		this.midia = midia;
	}
//	public double getValor() {
//		return valor;
//	}
//	public void setValor(double valor) {
//		this.valor = valor;
//	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

}
