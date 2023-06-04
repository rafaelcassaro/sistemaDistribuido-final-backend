package distribuido.sistemas.provafinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import distribuido.sistemas.provafinal.entities.Estudante;
import distribuido.sistemas.provafinal.repositories.EstudanteRepository;
import distribuido.sistemas.provafinal.services.exceptions.DatabaseException;
import distribuido.sistemas.provafinal.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EstudanteService {
	@Autowired
	private EstudanteRepository repository;

	// passa a chamada de procurar tds no banco da tabela usuario para o repository
	public List<Estudante> findAll() {
		return repository.findAll();
	}

	public Estudante findById(Long id) {
		Optional<Estudante> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Estudante insert(Estudante obj) {
		return repository.save(obj);
	}

	@Transactional
	public void delete(Long id) {
		try {
			Estudante estudante = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("deu ruim"));

			estudante.deleteAllMaterias();
			repository.delete(estudante);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Estudante update(Long id, Estudante obj) {
		try {
			Estudante entity = repository.getReferenceById(id);
			updateData(entity, obj); // oq vai ser dado upadte pelo metodo
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Estudante entity, Estudante obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setCodigoAluno(obj.getCodigoAluno());
	}

}
