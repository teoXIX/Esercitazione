package businessLogic;

import oggetti.HardSkills;

import java.util.List;

public interface HardSkillsBO {

    public void addHardSkill(HardSkills hardSkills);

    public List<HardSkills> getAllHardSkills();

    public void deleteHardSkill(int id);

}
