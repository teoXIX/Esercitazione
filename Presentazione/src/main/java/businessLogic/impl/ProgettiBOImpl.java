package businessLogic.impl;

import businessLogic.ProgettiBO;
import oggetti.Progetti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ProgettiRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProgettiBOImpl implements ProgettiBO {

    @Autowired
    private ProgettiRepository progettiRepository;

    @Override
    public void addProgetto(Progetti progetto){
        progettiRepository.save(progetto);
    }

    @Override
    public List<Progetti> getProgetti(){
        return (List<Progetti>) progettiRepository.findAll();
    }

    @Override
    public void deleteProgetto(int id){
        Optional<Progetti> ProgettiDB = progettiRepository.findById(id);

        if (ProgettiDB.isPresent() ) {
            Progetti softSkill = ProgettiDB.get();
            progettiRepository.delete(softSkill);
        }
    }
}
