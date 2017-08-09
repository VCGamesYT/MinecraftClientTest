package Plux.Event.events;

import Plux.Event.Event;

public class EventKeyboard extends Event {

    public int key;

    public EventKeyboard(int key) {

        this.key = key;
    }

    public int getKey() {

        return key;
    }
}
