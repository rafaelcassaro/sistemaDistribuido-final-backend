package distribuido.sistemas.provafinal.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import distribuido.sistemas.provafinal.entities.Estudante;
import distribuido.sistemas.provafinal.entities.Materia;
import distribuido.sistemas.provafinal.repositories.EstudanteRepository;
import distribuido.sistemas.provafinal.repositories.MateriaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private EstudanteRepository estudanteRep;
	@Autowired
	private MateriaRepository materiaRep;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Estudante e1 = new Estudante(null, "Rafael Cassaro", "rafael@gmail.com", "966666666", "123411");
		Estudante e2 = new Estudante(null, "Alex Green", "alex@gmail.com", "977777777", "123422");
		Estudante e3 = new Estudante(null, "Maria Brown", "maria@gmail.com", "988888888", "123433");
		
		
		
		
		
		
		Materia m1 = new Materia(null,"SISTEMAS DISTRIBUIDOS","Plotze", "AD322A");
		Materia m2 = new Materia(null,"MANUTENCAO DE SOFTWARE","Fabiano", "AC922A");
		Materia m3 = new Materia(null,"DESENVOLVIMENTO DE GAMES II","Diogo", "AD222A");
		Materia m4 = new Materia(null,"PROJETO CONCLUSAO DE CURSO I","Pablo", "AD422A");
		Materia m5 = new Materia(null,"TOPICOS ESPEC.ENGENHARIA I","Milton", "GM722B");
		
		
		
		
		estudanteRep.saveAll(Arrays.asList(e1,e2,e3));
		materiaRep.saveAll(Arrays.asList(m1,m2,m3,m4,m5));
		
		e1.getMaterias().add(m5);
		e1.getMaterias().add(m1);
		
		e2.getMaterias().add(m2);
		e2.getMaterias().add(m3);
		
		e3.getMaterias().add(m5);
		e3.getMaterias().add(m2);
		e3.getMaterias().add(m4);
		
		estudanteRep.saveAll(Arrays.asList(e1,e2,e3));
		
		
		
	}

}
