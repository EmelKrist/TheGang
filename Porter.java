package thegang;

import java.util.Observable;
import java.util.Observer;

// Класс носильщика - наблюдателя
class Porter implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        //если получает сообщение от главаря о начале ограбления
        if (o.getClass() == Leader.class &  arg.equals("Идем грабить банк!")) {
            //подтвердждает готовность
            System.out.println("Носильщик: Готов!");
            //информации об аресте нет, так как на мето носильщика внедряется агент 
        }
    }
}