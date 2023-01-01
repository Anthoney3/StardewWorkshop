package games.stardew.valley.stardew_workshop.controller;

import games.stardew.valley.stardew_workshop.models.StardewFishModel;
import games.stardew.valley.stardew_workshop.services.SortFishByFilterWord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
@Slf4j
public class RetrieveSortedFishInfo {

    @Autowired
    private SortFishByFilterWord fish_sort;

    @GetMapping(value = "fish_info")
    public String getFishInfo(@RequestParam("filter") String filter_word, Model model){
        List<StardewFishModel> filtered_list = fish_sort.sort_fish_by_keyword(filter_word);

        if(!filtered_list.isEmpty()) {
            model.addAttribute("fish_list", filtered_list);
        } else {
            throw new HttpServerErrorException(HttpStatusCode.valueOf(500),"No Results Found for the Desired Search Criteria");
        }
        return "index.html";
    }

}
