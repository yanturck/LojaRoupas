package cadastro.maven;

public class Filme {
	public Filme(String title, String director) {
		super();
		this.title = title;
		this.director = director;
	}
	
	@ColunaAnnotation(name = "Titulo", pos = 0)
	private String title;
	
	@ColunaAnnotation(name = "Diretor", pos = 1)
	private String director;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
}
