package games.stardew.valley.stardew_workshop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import games.stardew.valley.stardew_workshop.models.deserializers.StardewFishDeserializer;
import games.stardew.valley.stardew_workshop.models.pricing_models.PricingModel;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(using = StardewFishDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StardewFishModel {

    @JsonProperty("name")
    private String fish_name;

    private PricingModel pricingModel;

    @JsonProperty("location")
    private List<String> location_types;

    @JsonProperty("time")
    private List<String> fish_timings;

    @JsonProperty("season")
    private List<String> seasons;

    @JsonProperty("weather")
    private List<String> weather_types;

    public int getBasePrice(){
        return pricingModel.getNoProfessionPricing().getBase_price();
    }

    public int getSilverStarPrice(){
        return pricingModel.getNoProfessionPricing().getSilver_star_price();
    }

    public int getGoldStarPrice(){
        return pricingModel.getNoProfessionPricing().getGold_star_price();
    }

    public int getPurpleStarPrice(){
        return pricingModel.getNoProfessionPricing().getPurple_star_price();
    }

}
