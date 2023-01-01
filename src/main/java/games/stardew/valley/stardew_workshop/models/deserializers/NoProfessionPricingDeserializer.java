package games.stardew.valley.stardew_workshop.models.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import games.stardew.valley.stardew_workshop.models.pricing_models.NoProfessionPricing;

import java.io.IOException;

public class NoProfessionPricingDeserializer extends StdDeserializer<NoProfessionPricing> {

    public NoProfessionPricingDeserializer(){

        this(null);
    }

    public NoProfessionPricingDeserializer(Class<?> vc){
        super(vc);
    }

    @Override
    public NoProfessionPricing deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException, IOException {

        JsonNode fish_config_node = jp.getCodec().readTree(jp);
        NoProfessionPricing pricing_object = new NoProfessionPricing();
        pricing_object.setBase_price(fish_config_node.findParent("no_profession_pricing").findValue("base_price").asInt());
        pricing_object.setSilver_star_price(fish_config_node.findParent("no_profession_pricing").findValue("silver_star").asInt());
        pricing_object.setGold_star_price(fish_config_node.findParent("no_profession_pricing").findValue("gold_star").asInt());
        pricing_object.setPurple_star_price(fish_config_node.findParent("no_profession_pricing").findValue("purple_star").asInt());
        return pricing_object;
    }
}
