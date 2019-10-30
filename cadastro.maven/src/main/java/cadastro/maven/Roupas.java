package cadastro.maven;

public class Roupas {
	private String tipo;
	private String tam;
	private String preco;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTam() {
		return tam;
	}
	public void setTam(String tam) {
		this.tam = tam;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Roupas [tipo=" + tipo + ", tam=" + tam + ", preco=" + preco + "]";
	}
	
	public Roupas(String tipo, String tam, String preco) {
		super();
		this.tipo = tipo;
		this.tam = tam;
		this.preco = preco;
}
}
