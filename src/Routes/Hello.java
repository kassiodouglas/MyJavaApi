package Routes;

import handler.AbstractHandler;

public class Hello extends AbstractHandler {
    @Override
    public String processBody(String body)   {
        return "{\"message\": \"Hello, World!\"}";
    }
}
