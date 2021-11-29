package thegang;

import java.util.Observable;
import java.util.Observer;

// Класс водителя - наблюдателя
public class Driver implements Observer {
    
    //поле для информации об аресте 
    private boolean arrested = false;

    //метод интерфейса Observer
    @Override
    public void update(Observable o, Object arg) {
         //если получает сообщение от главаря о начале ограбления
        if (o.getClass() == Leader.class & arg.equals("Идем грабить банк!")) {
            //подтверждает готовность 
            System.out.println("Водитель: Готов!");
            //иначе,если сообщенеи от агента 
        } else if (o.getClass() == Agent.class) {
            //производится арест 
            arrested = Arrest();
        }
    }
    
    //метод для арреста 
    public boolean Arrest() {
        System.out.println("Водитель: * арестован *");
        return true;
    }

}