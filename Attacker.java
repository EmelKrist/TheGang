package thegang;

import java.util.Observable;
import java.util.Observer;

// Класс взломщика - наблюдателя
public class Attacker implements Observer {
    
        //поле для информации об аресте 
    private boolean arrested = false;
    
    //метод интерфейса Observer
    @Override
    public void update(Observable o, Object arg) {
        //если получает сообщение от главаря о начале ограбления
        if (o.getClass() == Leader.class & arg.equals("Идем грабить банк!")) {
            //подтверждает готовность 
            System.out.println("Взломщик: Готов!");
            //иначе, если сообщение от агента
        } else if (o.getClass() == Agent.class) {
            //происзовдим арест 
           arrested = Arrest();
        }
    }
    
    //метод для ареста 
    public boolean Arrest() {
        System.out.println("Взломщик: * арестован *");
        return true;
    }
}