package br.usjt.hellospringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.usjt.hellospringboot.model.Calculadora;

@Configuration
public class AppConfig {
	@Bean
	public Calculadora getCalculadora() {
		return new Calculadora();
	}
}
