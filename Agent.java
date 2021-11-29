package thegang;

import java.util.Observable;
import java.util.Observer;

// Класс главаря, который является как наблюдателем, так и наблюдаемым объектом 
public class Agent extends Observable implements Observer {
    
    //сообщение агента
    private String message;
    
    //метод получения сообщения агента 
    public String getMessage() {
        System.out.println("Агент: " + message);
        return message;
    }
    
    //метод для установки сообщения агента 
    public void setMessage(String message) {
        this.message = message;
        setChanged();
    }
    
    //метод интерфейса Observer
    @Override
    public void update(Observable o, Object arg) {
        //если агент получает от лидера сообщения о начале ограбления
        if (o.getClass() == Leader.class & arg.equals("Идем грабить банк!")) {
            //задаем агенту сообщение об аресте
            setMessage("Полиция! Вы арестованы");
            //отправляем сообщение банде
            notifyObservers(getMessage());
        }
    }
}