package nycschools.shared;

public abstract class BaseUnboundViewEvent {
    protected Object emitter;

    public Object getEmitter() {
        return emitter;
    }
}
