package nl.bsoft.behavioral.observer;

public interface SpringSubject {

    void addListener(SpringObserver o);

    void removeListener(SpringObserver o);

    void notifyListeners();
}
