package repository;

import oggetti.HardSkills;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillsRepository extends CrudRepository<HardSkills, Integer> {
}
