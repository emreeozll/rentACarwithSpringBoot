package kodlamaio.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.rentACar.entities.concretes.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	boolean existsByPlateIgnoreCase(String Plate);
}
