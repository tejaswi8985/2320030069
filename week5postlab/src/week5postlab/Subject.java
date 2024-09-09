package week5postlab;

public interface Subject {
	 void addObserver(Observer observer);
	    void removeObserver(Observer observer);
	    void notifyObservers(String event);
}
