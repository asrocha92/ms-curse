package com.treiner.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.treiner.hrpayroll.entities.Work;


/**
 * Realizar requisições mais limpas para requisições rest em outros projetos
 * 
 * Injetamos a interface no componente para ser visto por todo projetos
 * 
 * A especificação na anotação feign cliente name, tem que ser igual a "application.proporties" configurada no projeto no qual é consulmido as requisições rest
 * 
 * @author alex
 *
 */

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "workers")
public interface HrWorkerFeignClients {
	
	@GetMapping(value = "/get/{id}")
	ResponseEntity<Work> findById(@PathVariable Long id);

}
