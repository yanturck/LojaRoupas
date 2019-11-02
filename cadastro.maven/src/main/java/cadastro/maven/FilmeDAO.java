package cadastro.maven;

import java.util.Arrays;
import java.util.List;

public class FilmeDAO implements AbstractDAO<Filme> {
	
	
	List<Filme> filmes = Arrays.asList(
			new Filme ("Pulp Fiction", "Tarantino"),
			new Filme ("Clube da luta","David Fincher")
			);

	@Override
	public void adiciona(Filme obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Filme> recupera() {
		// TODO Auto-generated method stub
		return filmes;
	}

}