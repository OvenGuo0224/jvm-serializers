package serializers;

import data.media.MediaContent;
import serializers.jackson.StdJacksonDataBind;

import org.codehaus.jackson.map.*;

/**
 * This serializer uses Jackson in full automated data binding mode, which
 * can handle typical Java POJOs (esp. beans; otherwise may need to annotate
 * to configure)
 */
public class JsonJacksonDatabind
{
    public static void register(TestGroups groups)
    {
        ObjectMapper mapper = new ObjectMapper();
        // note: could also force static typing; left out to keep defaults
        groups.media.add(JavaBuiltIn.MediaTransformer,
                new StdJacksonDataBind<MediaContent>("json/jackson-databind", MediaContent.class, mapper));
    }
}
