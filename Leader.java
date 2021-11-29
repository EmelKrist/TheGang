package thegang;

import java.util.Observable;
import java.util.Observer;

// Класс главаря, который является как наблюдателем, так и наблюдаемым объектом 
public class Leader extends Observable implements Observer {
    //сообщения главаря 
    private String message;
        //поле для информации об аресте 
    private boolean arrested = false;
    
    //метод для получения ссообщения главаря
    public String getMessage() {
        System.out.println("Гловарь: " + message);
        return message;
    }
    
    //метод для установки сообщения главаря
    public void setMessage(String message) {
        this.message = message;
        setChanged();
    }
    
    //метод интерфейса Observer
    @Override
    public void update(Observable o, Object arg) {
        //Если гловарь получил собщение об аресте от агента и арест главаря состоялся 
        if (o.getClass() == Agent.class & (arrested  = Arrest()) == true) {
            //задаем сообщение об отмене ограбления 
            setMessage("Ограбление не состоится!");
            //отправляем сообщение банде 
            notifyObservers(getMessage());
        }
    }
    
    //метод для ареста 
    public boolean Arrest() {
        System.out.println("Гловарь: * арестован *");
        return true;
    }
}