package games.stardew.valley.stardew_workshop.models.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import games.stardew.valley.stardew_workshop.models.StardewFishModel;
import games.stardew.valley.stardew_workshop.models.pricing_models.AnglerProfessionPricing;

import java.io.IOException;
import java.time.Duration;
import java.time.ZonedDateTime;

public class StardewFishDeserializer extends StdDeserializer<StardewFishModel> {

    public StardewFishDeserializer(){

        this(null);
    }

    public StardewFishDeserializer(Class<?> vc){
        super(vc);
    }

    @Override
    public StardewFishModel deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException, IOException {

        JsonNode fish_config_node = jp.getCodec().readTree(jp);
        StardewFishModel fish_object = new StardewFishModel();
        fish_object.setFish_name(fish_config_node.findParent("header").findValue("name").asText());
        return fish_object;
    }
}
