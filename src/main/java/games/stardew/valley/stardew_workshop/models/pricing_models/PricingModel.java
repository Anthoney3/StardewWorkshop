package games.stardew.valley.stardew_workshop.models.pricing_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import games.stardew.valley.stardew_workshop.models.deserializers.NoProfessionPricingDeserializer;
import games.stardew.valley.stardew_workshop.models.pricing_models.AnglerProfessionPricing;
import games.stardew.valley.stardew_workshop.models.pricing_models.FisherProfessionPricing;
import games.stardew.valley.stardew_workshop.models.pricing_models.NoProfessionPricing;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = NoProfessionPricingDeserializer.class)
public class PricingModel {

    private NoProfessionPricing noProfessionPricing;
    private FisherProfessionPricing fisherProfessionPricing;
    private AnglerProfessionPricing anglerProfessionPricing;

}
