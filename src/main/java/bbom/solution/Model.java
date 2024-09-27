package bbom.solution;

import java.util.*;

public class Model {
    private int state;
    private List<ModelListener> listeners = new ArrayList<>();

    public Model(int state) {
        this.state = state;
    }

    public void update() {
        state++;
        listeners.forEach(ModelListener::modelUpdated);
    }

    public void addListener(ModelListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ModelListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    public int getState() {
        return state;
    }
}