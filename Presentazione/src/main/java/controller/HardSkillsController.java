package controller;

import businessLogic.HardSkillsBO;
import oggetti.HardSkills;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.ClientResponse;

import java.util.List;

@Controller
@RequestMapping("/HardSkills")
public class HardSkillsController {

    @Autowired
    private HardSkillsBO hardSkillsBO;

    Logger logger = LoggerFactory.getLogger(HardSkillsController.class);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getHardSkills(Model model) {

        logger.debug("Hard Skills get() invoked");

        List<HardSkills> list = hardSkillsBO.getAllHardSkills();

        model.addAttribute("list", list);

        return "HardSkills";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String createHardSkill(@PathVariable("descrizione") String descrizione, @PathVariable("livello") String livello, @PathVariable("provenienza") String provenienza, Model model) {
        logger.debug("HardSkills post() invoked");

        HardSkills hardSkills = new HardSkills(descrizione, livello, provenienza);
        List<HardSkills> list;
        try {
            hardSkillsBO.addHardSkill(hardSkills);
            list = hardSkillsBO.getAllHardSkills();
            model.addAttribute("response", new ClientResponse(true, "Operation success"));
            model.addAttribute("list", list);
        } catch (DataAccessException e) {
            logger.error("A DataAccessException has occurred: {}", e);
            model.addAttribute("response", new ClientResponse(false, e.getMessage()));
        }

        return "HardSkills";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteHardSkill(@PathVariable("id") int id, Model model) {
        logger.debug("HardSkills delete() invoked");

        List<HardSkills> list;

        try {
            hardSkillsBO.deleteHardSkill(id);
            list = hardSkillsBO.getAllHardSkills();
            model.addAttribute("response",
                    new ClientResponse(true, "Operation success"));
            model.addAttribute("list", list);
        } catch (DataAccessException e) {
            logger.error("A DataAccessException has occurred: {}", e);
            model.addAttribute("response", new ClientResponse(false, e.getMessage()));
        }

        return "HardSkills";
    }
}
