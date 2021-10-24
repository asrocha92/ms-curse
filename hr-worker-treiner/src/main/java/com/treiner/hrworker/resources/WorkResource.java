package com.treiner.hrworker.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treiner.hrworker.entities.Work;
import com.treiner.hrworker.repositories.WorkRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkResource {

	
	@Autowired
	private WorkRepository repository;
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<Work>> findAll() {
		List<Work> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Work> findById(@PathVariable Long id) {
		Work work = repository.findById(id).get();
		return ResponseEntity.ok(work);
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<Map<String, Object>> create(@RequestBody Work work) {
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("mensagem", "Salvo com sucesso!");
			map.put("work", repository.save(work));
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("mensagem", "Erro ao salvar!");
		return ResponseEntity.status(400).body(map);
	}
	
	@PutMapping(path = "/edit")
	public ResponseEntity<Map<String, Object>> edit(@RequestBody Work work) {
		Map<String, Object> map = new HashMap<>();
		try {
			System.out.println("work: " + work.getId());
			if (repository.existsById(work.getId())) {
				map.put("mensagem", "Alterado com sucesso!");
				map.put("work", repository.saveAndFlush(work));
				return ResponseEntity.ok(map);
			} else {
				map.put("mensagem", "Work não existe, verifique!");
				return ResponseEntity.status(400).body(map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("mensagem", "Erro ao alterar!");
		return ResponseEntity.status(400).body(map);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<>();
		try {
			if (repository.existsById(id)) {
				repository.deleteById(id);
				map.put("mensagem", "Excluído com sucesso!");
			} else {
				map.put("mensagem", "Não existe work!");
			}
			
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("mensagem", "Erro ao Excluir!");
		return ResponseEntity.status(400).body(map);
	}
}
