package io.fabs.util.settings;

import org.jdom.Element;

public interface SerializableOptions {
    public Element serialize();

    public void deserialize(Element element);
}
