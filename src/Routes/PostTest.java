package Routes;

import handler.AbstractHandler;

public class PostTest extends AbstractHandler {
    @Override
    protected String processBody(String body) {
        return "{\"received\": \"" + body + "\"}";
    }
}

