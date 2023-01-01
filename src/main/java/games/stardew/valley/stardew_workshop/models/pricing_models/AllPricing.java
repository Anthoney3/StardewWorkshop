package games.stardew.valley.stardew_workshop.models.pricing_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import games.stardew.valley.stardew_workshop.models.pricing_models.PricingModel;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AllPricing {

    private List<PricingModel> pricing_list;
}
