package repository;

import oggetti.Progetti;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProgettiRepository extends CrudRepository<Progetti, Integer> {
}
