package controller;

import businessLogic.ProgettiBO;
import oggetti.HardSkills;
import oggetti.Progetti;
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
@RequestMapping("/Progetti")
public class ProgettiController {
    @Autowired
    private ProgettiBO progettiBO;

    Logger logger = LoggerFactory.getLogger(Progetti.class);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getProgetti(Model model) {

        logger.debug("Progetti get() invoked");

        List<Progetti> list = progettiBO.getProgetti();

        model.addAttribute("list", list);

        return "Progetti";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String createProgetto(@PathVariable("nome") String nome, @PathVariable("descrizione") String descrizione, @PathVariable("link") String link, Model model) {
        logger.debug("Progetti post() invoked");

        Progetti progetti = new Progetti(nome, descrizione, link);
        List<Progetti> list;
        try {
            progettiBO.addProgetto(progetti);
            list = progettiBO.getProgetti();
            model.addAttribute("response", new ClientResponse(true, "Operation success"));
            model.addAttribute("list", list);
        } catch (DataAccessException e) {
            logger.error("A DataAccessException has occurred: {}", e);
            model.addAttribute("response", new ClientResponse(false, e.getMessage()));
        }

        return "Progetti";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteProgetto(@PathVariable("id") int id, Model model) {
        logger.debug("Progetti delete() invoked");

        List<Progetti> list;

        try {
            progettiBO.deleteProgetto(id);
            list = progettiBO.getProgetti();
            model.addAttribute("response",
                    new ClientResponse(true, "Operation success"));
            model.addAttribute("list", list);
        } catch (DataAccessException e) {
            logger.error("A DataAccessException has occurred: {}", e);
            model.addAttribute("response", new ClientResponse(false, e.getMessage()));
        }

        return "Progetti";
    }
}
