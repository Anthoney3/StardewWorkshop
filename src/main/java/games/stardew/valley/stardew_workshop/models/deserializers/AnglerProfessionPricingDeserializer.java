package games.stardew.valley.stardew_workshop.models.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import games.stardew.valley.stardew_workshop.models.pricing_models.AnglerProfessionPricing;
import games.stardew.valley.stardew_workshop.models.pricing_models.FisherProfessionPricing;

import java.io.IOException;

public class AnglerProfessionPricingDeserializer extends StdDeserializer<AnglerProfessionPricing> {

    public AnglerProfessionPricingDeserializer(){

        this(null);
    }

    public AnglerProfessionPricingDeserializer(Class<?> vc){
        super(vc);
    }

    @Override
    public AnglerProfessionPricing deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException, IOException {

        JsonNode fish_config_node = jp.getCodec().readTree(jp);
        AnglerProfessionPricing pricing_object = new AnglerProfessionPricing();
        pricing_object.setBase_price(fish_config_node.findParent("angler_profession").findValue("base_price").asInt());
        pricing_object.setSilver_star_price(fish_config_node.findParent("angler_profession").findValue("silver_star").asInt());
        pricing_object.setGold_star_price(fish_config_node.findParent("angler_profession").findValue("gold_star").asInt());
        pricing_object.setPurple_star_price(fish_config_node.findParent("angler_profession").findValue("purple_star").asInt());
        return pricing_object;
    }
}
