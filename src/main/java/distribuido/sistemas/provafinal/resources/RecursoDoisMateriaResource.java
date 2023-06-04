package distribuido.sistemas.provafinal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import distribuido.sistemas.provafinal.entities.Materia;
import distribuido.sistemas.provafinal.services.MateriaService;

@RestController
@RequestMapping(value = "/api/recurso2/materia")
public class RecursoDoisMateriaResource {
	

	@Autowired
	private MateriaService materiaServ;
	

	
	@GetMapping
	public ResponseEntity<List<Materia>> findAll() {
		List<Materia> list = materiaServ.findAll();
		return ResponseEntity.ok().body(list);
	}

}
