package distribuido.sistemas.provafinal.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import distribuido.sistemas.provafinal.entities.Estudante;
import distribuido.sistemas.provafinal.services.EstudanteService;

@RestController
@RequestMapping(value = "/api/recurso1/estudante")
public class RecursoUmEstudanteResource {
	
	@Autowired
	private EstudanteService estudanteServ;
	
	
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Estudante> findByIdEstudante(@PathVariable Long id){
		Estudante obj = estudanteServ.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

	
	@PostMapping
	public ResponseEntity<Estudante> insert (@RequestBody Estudante obj){
		obj = estudanteServ.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);	//created(espera um obj uri) para voltar o voltar o padrao http certo 
	}

}
