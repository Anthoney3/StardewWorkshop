package games.stardew.valley.stardew_workshop.models.pricing_models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FisherProfessionPricing {

    @JsonProperty("base_price")
    private int base_price;

    @JsonProperty("silver_star")
    private int silver_star_price;

    @JsonProperty("gold_star")
    private int gold_star_price;

    @JsonProperty("purple_star")
    private int purple_star_price;

}
