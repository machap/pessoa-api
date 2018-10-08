package com.paulo.api.pessoas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.api.pessoas.model.Pessoa;
import com.paulo.api.pessoas.repository.PessoaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Pessoa")
@CrossOrigin(origins="*")
public class PessoaResource {

	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping("/pessoas")
	@ApiOperation(value="Retorna uma lista de Pessoas")
	public List<Pessoa> listPerson(){
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/pessoa/{id}")
	@ApiOperation(value="Retorna um unico registo de Pessoas")
	public Pessoa listPersonOne(@PathVariable(value = "id") long id) {
		return pessoaRepository.findById(id);		
	}
	
	@PostMapping("/pessoa")
	@ApiOperation(value="Guarda um registro de Pessoa")
	public Pessoa salvePerson(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@DeleteMapping("/pessoa")
	@ApiOperation(value="Apaga um registro de Pessoa")
	public void deletePerson(@RequestBody Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}
	
	@PutMapping("/pessoa")
	@ApiOperation(value="Atualiza um registro de Pessoa")
	public Pessoa udpatePerson(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
}
