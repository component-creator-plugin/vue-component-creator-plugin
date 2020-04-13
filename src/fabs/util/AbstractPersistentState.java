package fabs.util;

import com.intellij.openapi.components.PersistentStateComponent;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractPersistentState<T extends SerializableOptions> implements PersistentStateComponent<Element> {
    private T options;

    public AbstractPersistentState(T options) {
        this.options = options;
    }

    public T getOptions() {
        return options;
    }

    /**
     * Called when the state has to be persisted
     */
    @Nullable
    @Override
    public Element getState() {
        return options.serialize();
    }

    /**
     * Called when the settings start, and the data is loaded from store
     */
    @Override
    public void loadState(@NotNull Element element) {
        options.deserialize(element);
    }

}
