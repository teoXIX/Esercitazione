package controller;

import businessLogic.SoftSkillsBO;
import oggetti.SoftSkills;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import util.ClientResponse;

import java.util.List;

@Controller
@RequestMapping("/SoftSkills")
public class SoftSkillsController {

    @Autowired
    private SoftSkillsBO softSkillsBO;

    Logger logger = LoggerFactory.getLogger(SoftSkillsController.class);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getSoftSkills(Model model) {

        logger.debug("Soft Skills get() invoked");

        List<SoftSkills> list = softSkillsBO.getAllSoftSkills();

        model.addAttribute("list", list);

        return "SoftSkills";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String createSoftSkill(@PathVariable("descrizione") String descrizione, @PathVariable("livello") String livello ,Model model) {
        logger.debug("SoftSkills post() invoked");

        SoftSkills softSkill = new SoftSkills(descrizione, livello);
        List<SoftSkills> list;
        try {
            softSkillsBO.addSoftSkill(softSkill);
            list = softSkillsBO.getAllSoftSkills();
            model.addAttribute("response", new ClientResponse(true, "Operation success"));
            model.addAttribute("list", list);
        } catch (DataAccessException e) {
            logger.error("A DataAccessException has occurred: {}", e);
            model.addAttribute("response", new ClientResponse(false, e.getMessage()));
        }

        return "SoftSkills";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteSoftSkill(@PathVariable("id") int id, Model model) {
        logger.debug("SoftSkill delete() invoked");

        List<SoftSkills> list;

        try {
            softSkillsBO.deleteSoftSkill(id);
            list = softSkillsBO.getAllSoftSkills();
            model.addAttribute("response",
                    new ClientResponse(true, "Operation success"));
            model.addAttribute("list", list);
        } catch (DataAccessException e) {
            logger.error("A DataAccessException has occurred: {}", e);
            model.addAttribute("response", new ClientResponse(false, e.getMessage()));
        }

        return "SoftSkill";
    }
}
