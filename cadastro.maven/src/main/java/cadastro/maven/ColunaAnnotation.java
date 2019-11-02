package cadastro.maven;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface ColunaAnnotation {

	int pos();

	String name();

}