package distribuido.sistemas.provafinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import distribuido.sistemas.provafinal.entities.Estudante;
import distribuido.sistemas.provafinal.entities.Materia;
import distribuido.sistemas.provafinal.repositories.EstudanteRepository;
import distribuido.sistemas.provafinal.repositories.MateriaRepository;
import distribuido.sistemas.provafinal.services.exceptions.DatabaseException;
import distribuido.sistemas.provafinal.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MateriaService {

	@Autowired
	private MateriaRepository repository;
	@Autowired
	private EstudanteRepository estRep;

	public List<Materia> findAll() {
		return repository.findAll();
	}

	public Materia findById(Long id) {
		Optional<Materia> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));

	}

	public Materia insert(Materia obj) {
		return repository.save(obj);
	}

	public void delete(Long materiaId) {

		try {
			Estudante estudante = new Estudante();
			Materia materia = repository.findById(materiaId).orElseThrow(() -> new EntityNotFoundException("asdfa"));

			for (Long i = (long) 1; i < 4; i++) {
				estudante = estRep.findById(i).orElseThrow(() -> new EntityNotFoundException("asdfa"));

				if (estudante.getMaterias().contains(materia)) {
					estudante.getMaterias().remove(materia);
					materia.getEstudantes().remove(estudante);
					estRep.save(estudante);
					repository.save(materia);
					
				}
			}
			repository.deleteById(materiaId);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(materiaId);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	

	public Materia update(Long id, Materia obj) {
		try {
			Materia entity = repository.getReferenceById(id);
			updateData(entity, obj); // oq vai ser dado upadte pelo metodo
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Materia entity, Materia obj) {
		entity.setNome(obj.getNome());
		entity.setCodigo(obj.getCodigo());
		entity.setProfessor(obj.getProfessor());
	}

}
