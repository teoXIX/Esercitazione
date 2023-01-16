package businessLogic;

import oggetti.SoftSkills;

import java.util.List;

public interface SoftSkillsBO {
    public void addSoftSkill(SoftSkills softSkills);

    public List<SoftSkills> getAllSoftSkills();

    public void deleteSoftSkill(int id);

}
