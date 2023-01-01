package games.stardew.valley.stardew_workshop;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import games.stardew.valley.stardew_workshop.models.StardewFishModel;
import games.stardew.valley.stardew_workshop.models.pricing_models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class StardewWorkshopApplication {

    public static List<StardewFishModel> fish_list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode full_node = objectMapper.readTree(StardewWorkshopApplication.class.getClassLoader().getResourceAsStream("config/stardew_fish.json"));
        JsonNode fish_data_bank = full_node.findPath("fish_data_bank");



//        System.out.println(fish_data_bank.findValue("header").findValue("pricing").findValue("no_profession_pricing").findValue("base_price"));

        for(JsonNode node : fish_data_bank){
            List<String> locations = new ArrayList<>();
            List<String> timings = new ArrayList<>();
            List<String> seasons = new ArrayList<>();
            List<String> weather_types = new ArrayList<>();
            StardewFishModel stardewFishModel = new StardewFishModel();
            PricingModel pricingModel = new PricingModel();


//            System.out.println(node.findValue("header").findValue("location").get(0));


                    NoProfessionPricing noProfessionPricing = new NoProfessionPricing();
                    FisherProfessionPricing fisherProfessionPricing = new FisherProfessionPricing();
                    AnglerProfessionPricing anglerProfessionPricing = new AnglerProfessionPricing();

                    noProfessionPricing.setBase_price(node.findValue("header").findValue("pricing").findValue("no_profession_pricing").findValue("base_price").asInt());
                    noProfessionPricing.setSilver_star_price(node.findValue("header").findValue("pricing").findValue("no_profession_pricing").findValue("silver_star").asInt());
                    noProfessionPricing.setGold_star_price(node.findValue("header").findValue("pricing").findValue("no_profession_pricing").findValue("gold_star").asInt());
                    noProfessionPricing.setPurple_star_price(node.findValue("header").findValue("pricing").findValue("no_profession_pricing").findValue("purple_star").asInt());

                    fisherProfessionPricing.setBase_price(node.findValue("header").findValue("pricing").findValue("fisher_profession").findValue("base_price").asInt());
                    fisherProfessionPricing.setSilver_star_price(node.findValue("header").findValue("pricing").findValue("fisher_profession").findValue("silver_star").asInt());
                    fisherProfessionPricing.setGold_star_price(node.findValue("header").findValue("pricing").findValue("fisher_profession").findValue("gold_star").asInt());
                    fisherProfessionPricing.setPurple_star_price(node.findValue("header").findValue("pricing").findValue("fisher_profession").findValue("purple_star").asInt());

                    anglerProfessionPricing.setBase_price(node.findValue("header").findValue("pricing").findValue("angler_profession").findValue("base_price").asInt());
                    anglerProfessionPricing.setSilver_star_price(node.findValue("header").findValue("pricing").findValue("angler_profession").findValue("silver_star").asInt());
                    anglerProfessionPricing.setGold_star_price(node.findValue("header").findValue("pricing").findValue("angler_profession").findValue("gold_star").asInt());
                    anglerProfessionPricing.setPurple_star_price(node.findValue("header").findValue("pricing").findValue("angler_profession").findValue("purple_star").asInt());

                    pricingModel.setNoProfessionPricing(noProfessionPricing);
                    pricingModel.setFisherProfessionPricing(fisherProfessionPricing);
                    pricingModel.setAnglerProfessionPricing(anglerProfessionPricing);

                for (JsonNode inner_node : node.findValue("location")) {
                    locations.add(inner_node.asText());
                }
                for (JsonNode inner_node : node.findValue("time")) {
                    timings.add(inner_node.asText());
                }
                for (JsonNode inner_node : node.findValue("season")) {
                    seasons.add(inner_node.asText());
                }
                for (JsonNode inner_node : node.findValue("weather")) {
                    weather_types.add(inner_node.asText());
                }

                stardewFishModel.setPricingModel(pricingModel);
                stardewFishModel.setFish_timings(timings);
                stardewFishModel.setLocation_types(locations);
                stardewFishModel.setSeasons(seasons);
                stardewFishModel.setWeather_types(weather_types);
                stardewFishModel.setFish_name(node.findValue("name").asText());

                fish_list.add(stardewFishModel);


        }

       /* boolean keep_looping = true;
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the Keyword you wish to look up a fish by");
            String keyword_to_filter_by = scanner.nextLine();

            List<StardewFishModel> filtered_list = fish_list.stream().filter(fish -> fish.getSeasons().contains(keyword_to_filter_by) || fish.getSeasons().contains("All Seasons") || fish.getFish_name().contains(keyword_to_filter_by) || fish.getWeather_types().contains(keyword_to_filter_by))
                    .collect(Collectors.toList());


            Comparator<StardewFishModel> byHighestPrice = Comparator.comparing(StardewFishModel::getBasePrice);

            filtered_list.sort(byHighestPrice);

            filtered_list.forEach(fish -> {
                System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%n", fish.getFish_name(),
                        fish.getPricingModel().getNoProfessionPricing().toString(), fish.getFish_timings().toString(),
                        fish.getLocation_types().toString(), fish.getWeather_types().toString(),
                        fish.getSeasons().toString());
            });

            System.out.println("Would you like to search for another criteria? (Y/N)");
            String answer = scanner.nextLine();

            if(answer.equalsIgnoreCase("n"))
                keep_looping = false;


        }while(keep_looping);*/
                
                
        SpringApplication.run(StardewWorkshopApplication.class, args);
    }

}
