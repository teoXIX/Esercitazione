package businessLogic.impl;

import businessLogic.SoftSkillsBO;
import oggetti.SoftSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.SoftSkillsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SoftSkillsBOImpl implements SoftSkillsBO {

    @Autowired
    private SoftSkillsRepository SSrepository;

    @Override
    public void addSoftSkill(SoftSkills softSkills){
        SSrepository.save(softSkills);
    }

    @Override
    public List<SoftSkills> getAllSoftSkills(){
        return (List<SoftSkills>) SSrepository.findAll();
    }

    @Override
    public void deleteSoftSkill(int id){
        Optional<SoftSkills> SSDB = SSrepository.findById(id);

        if ( SSDB.isPresent() ) {
            SoftSkills softSkill = SSDB.get();
            SSrepository.delete(softSkill);
        }
    }
}
