package cadastro.maven;

import java.util.List;

public interface AbstractDAO<T> {
	void adiciona (T obj);
	List<T> recupera ();
}
