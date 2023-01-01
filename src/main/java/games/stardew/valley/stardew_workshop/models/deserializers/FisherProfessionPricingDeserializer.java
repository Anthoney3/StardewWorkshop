package games.stardew.valley.stardew_workshop.models.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import games.stardew.valley.stardew_workshop.models.pricing_models.FisherProfessionPricing;
import games.stardew.valley.stardew_workshop.models.pricing_models.NoProfessionPricing;

import java.io.IOException;

public class FisherProfessionPricingDeserializer extends StdDeserializer<FisherProfessionPricing> {

    public FisherProfessionPricingDeserializer(){

        this(null);
    }

    public FisherProfessionPricingDeserializer(Class<?> vc){
        super(vc);
    }

    @Override
    public FisherProfessionPricing deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException, IOException {

        JsonNode fish_config_node = jp.getCodec().readTree(jp);
        FisherProfessionPricing pricing_object = new FisherProfessionPricing();
        pricing_object.setBase_price(fish_config_node.findParent("fisher_profession").findValue("base_price").asInt());
        pricing_object.setSilver_star_price(fish_config_node.findParent("fisher_profession").findValue("silver_star").asInt());
        pricing_object.setGold_star_price(fish_config_node.findParent("fisher_profession").findValue("gold_star").asInt());
        pricing_object.setPurple_star_price(fish_config_node.findParent("fisher_profession").findValue("purple_star").asInt());
        return pricing_object;
    }
}
