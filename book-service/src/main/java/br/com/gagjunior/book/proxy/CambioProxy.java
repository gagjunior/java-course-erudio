package br.com.gagjunior.book.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.gagjunior.book.response.Cambio;

@FeignClient(name = "cambio-service")
public interface CambioProxy {

	@GetMapping(value = "/cambio-service/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable Double amount, @PathVariable String from, @PathVariable String to);

}
