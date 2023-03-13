package kodlamaio.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.rentACar.entities.concretes.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {

//repository - veritabani islemlerini yapacak siniflara verilen isimdir. Örnek: ....Dao, ...Repository

   boolean existsByNameIgnoreCase(String name);

}
