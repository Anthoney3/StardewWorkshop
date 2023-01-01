package games.stardew.valley.stardew_workshop.controller;

import games.stardew.valley.stardew_workshop.services.SortFishByFilterWord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/api")
@Slf4j
public class ServletServer {

    @Autowired
    private SortFishByFilterWord fish_sort;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage(Model model){
        return "index.html";
    }
}
