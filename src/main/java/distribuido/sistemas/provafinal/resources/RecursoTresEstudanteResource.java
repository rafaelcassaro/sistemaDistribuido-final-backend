package distribuido.sistemas.provafinal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import distribuido.sistemas.provafinal.entities.Estudante;
import distribuido.sistemas.provafinal.services.EstudanteService;

@RestController
@RequestMapping(value = "/api/recurso3/estudante")
public class RecursoTresEstudanteResource {
	
	@Autowired
	private EstudanteService service;
	
	
	@PutMapping(value = "/{id}") 
	public ResponseEntity<Estudante> update(@PathVariable Long id, @RequestBody Estudante obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@DeleteMapping(value = "/{estudanteId}")  //anotacao do spring boot para delecao 
	public ResponseEntity<Void> delete(@PathVariable Long estudanteId){

		service.delete(estudanteId);
		return ResponseEntity.noContent().build();
	}
	
}
