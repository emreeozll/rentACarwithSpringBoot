package kodlamaio.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.rentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
	
	boolean existsByNameIgnoreCase(String name);
	
}
