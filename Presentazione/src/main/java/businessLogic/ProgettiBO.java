package businessLogic;

import oggetti.Progetti;

import java.util.List;

public interface ProgettiBO {

    public void addProgetto(Progetti hardSkills);

    public List<Progetti> getProgetti();

    public void deleteProgetto(int id);

}
