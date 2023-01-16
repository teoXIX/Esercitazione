package repository;

import oggetti.SoftSkills;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillsRepository extends CrudRepository<SoftSkills, Integer> {
}
