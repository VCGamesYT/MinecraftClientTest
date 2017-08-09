package Plux.Event.events;

import Plux.Event.Event;

public class EventRender3D extends Event {

    public static float particlTicks;

    public EventRender3D(float particlTicks) {

        this.particlTicks = particlTicks;
    }

    public static float getParticlTicks() {

        return particlTicks;
    }

    public void setParticlTicks(float particlTicks) {

        this.particlTicks = particlTicks;
    }
}