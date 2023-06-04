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

import distribuido.sistemas.provafinal.entities.Materia;
import distribuido.sistemas.provafinal.services.MateriaService;

@RestController
@RequestMapping(value = "/api/recurso1/materia")
public class RecursoUmMateriaResource {
	

	@Autowired
	private MateriaService materiaServ;
	

	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Materia> findByIdMateria(@PathVariable Long id){
		Materia obj = materiaServ.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

	
	@PostMapping
	public ResponseEntity<Materia> insert (@RequestBody Materia obj){
		obj = materiaServ.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);	//created(espera um obj uri) para voltar o voltar o padrao http certo 
	}

}
