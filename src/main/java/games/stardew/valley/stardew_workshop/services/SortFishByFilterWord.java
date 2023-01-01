package games.stardew.valley.stardew_workshop.services;

import games.stardew.valley.stardew_workshop.models.StardewFishModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static games.stardew.valley.stardew_workshop.StardewWorkshopApplication.fish_list;

@Service
@Slf4j
public class SortFishByFilterWord {

    public List<StardewFishModel> sort_fish_by_keyword(String filter_word){

        List<StardewFishModel> filtered_list;


        List<String> fish_names = new ArrayList<>();
        fish_list.forEach(fish -> fish_names.add(fish.getFish_name()));

        String[] filter_words = filter_word.split(",");

        if(filter_words.length == 0)
            return new ArrayList<>();

       if (filter_words.length == 1){

           filtered_list = fish_list.stream().filter(fish -> fish.getSeasons().contains(filter_words[0]) || fish.getSeasons().contains("All Seasons") || fish.getWeather_types().contains(filter_words[0]) || fish.getFish_name().equalsIgnoreCase(filter_words[0])).collect(Collectors.toList());

           if(fish_names.stream().anyMatch(fish -> fish.equalsIgnoreCase(filter_words[0]))) {
               filtered_list.removeIf(fish -> !fish.getFish_name().equalsIgnoreCase(filter_words[0]));
           } else if (filtered_list.stream().noneMatch(fish -> fish.getSeasons().contains(filter_words[0]) || fish.getWeather_types().contains(filter_words[0])))
               filtered_list = new ArrayList<>();

       }else {

           switch (check_filter_word_placement(filter_words[0])) {
               case "Season is First" -> {
                   filtered_list = fish_list.stream()
                           .filter(fish -> fish.getSeasons().contains(filter_words[0]) || fish.getSeasons().contains("All Seasons"))
                           .filter(fish -> fish.getWeather_types().contains(filter_words[1]))
                           .collect(Collectors.toList());
               }
               case "Weather type is First" -> {
                   filtered_list = fish_list.stream()
                           .filter(fish -> fish.getWeather_types().contains(filter_words[0]))
                           .filter(fish -> fish.getSeasons().contains(filter_words[1]) || fish.getSeasons().contains("All Seasons"))
                           .collect(Collectors.toList());
               }
               default -> throw new RuntimeException("Something Went wrong with filtering the lists");

           }
       }

        Comparator<StardewFishModel> byHighestPrice = Comparator.comparing(StardewFishModel::getBasePrice).reversed().thenComparing(StardewFishModel::getFish_name);
        filtered_list.sort(byHighestPrice);

        return filtered_list;
    }

    private String check_filter_word_placement(String filter_word){

        String[] seasons = {"Summer","Winter","Fall","Spring"};
        String[] weather_types = {"Rain","Any","Sunny","Windy"};
        String[] split_filter_words = filter_word.split(",");

        for(int i =0; i < seasons.length; i++){
            if(split_filter_words[0].contains(seasons[i]))
                return "Season is First";
            if(split_filter_words[0].contains(weather_types[i]))
                return "Weather type is First";
        }
     return "No Season Or Weather Found";
    }

}
