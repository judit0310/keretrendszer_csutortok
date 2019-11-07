package filmespelda.controller;

import filmespelda.model.Szereplo;
import filmespelda.service.SzereploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class SzereploController {

    SzereploService service;

    public SzereploController(@Autowired SzereploService service) {
        this.service = service;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public String showSzereploCount(){
        return String.valueOf(service.listAllSzereplo().size());

    }

    @RequestMapping(value = "/szereplok", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Szereplo> showAllSzereplo(){
           return service.listAllSzereplo();
    }

    @RequestMapping(value = "/addSzereplo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addSzereplo(@RequestBody Szereplo szereplo){
        System.out.println(szereplo);
        return "";
    }
}
