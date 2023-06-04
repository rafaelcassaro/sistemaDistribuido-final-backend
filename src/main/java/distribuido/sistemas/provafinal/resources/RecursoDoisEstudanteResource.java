package distribuido.sistemas.provafinal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import distribuido.sistemas.provafinal.entities.Estudante;
import distribuido.sistemas.provafinal.services.EstudanteService;

@RestController
@RequestMapping(value = "/api/recurso2/estudante")
public class RecursoDoisEstudanteResource {
	
	@Autowired
	private EstudanteService estudanteServ;
	
	
	
	@GetMapping
	public ResponseEntity<List<Estudante>> findAll() {
		List<Estudante> list = estudanteServ.findAll();
		return ResponseEntity.ok().body(list);
	}

}
