package businessLogic.impl;

import businessLogic.HardSkillsBO;
import oggetti.HardSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.HardSkillsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HardSkillsBOImpl implements HardSkillsBO {

    @Autowired
    private HardSkillsRepository HSrepository;

    @Override
    public void addHardSkill(HardSkills hardSkills){
        HSrepository.save(hardSkills);
    }

    @Override
    public List<HardSkills> getAllHardSkills(){
        return (List<HardSkills>) HSrepository.findAll();
    }

    @Override
    public void deleteHardSkill(int id){
        Optional<HardSkills> HSDB = HSrepository.findById(id);

        if (HSDB.isPresent() ) {
            HardSkills softSkill = HSDB.get();
            HSrepository.delete(softSkill);
        }
    }

}
