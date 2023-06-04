package distribuido.sistemas.provafinal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import distribuido.sistemas.provafinal.entities.Materia;
import distribuido.sistemas.provafinal.services.MateriaService;

@RestController
@RequestMapping(value = "/api/recurso3/materia/")
public class RecursoTresMateriaResource {
	
	@Autowired
	private MateriaService service;
	

	
	@PutMapping(value = "/{id}") 
	public ResponseEntity<Materia> update(@PathVariable Long id, @RequestBody Materia obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@DeleteMapping(value = "/{materiaId}")  //anotacao do spring boot para delecao 
	public ResponseEntity<Void> deleteMat(@PathVariable Long materiaId){
		service.delete(materiaId);		
		return ResponseEntity.noContent().build();
	}
	
	


}
