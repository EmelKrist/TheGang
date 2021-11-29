package thegang;

public class TheGang {

    public static void main(String[] args) {
        
        //Создаем главаря, взломщика и водителя, внедряем егента 
        Leader leader = new Leader();
        Agent agent = new Agent();
        Attacker attacker = new Attacker();
        Driver driver = new Driver();
        
        //агента, взломщика и водителя ставим на наблюдение за главарем
        leader.addObserver(agent);
        leader.addObserver(attacker);
        leader.addObserver(driver);
        
        //взломщика, водителя и главаря ставим на наблюдение за агентом
        agent.addObserver(attacker);
        agent.addObserver(driver);
        agent.addObserver(leader);
        
        //Главарь сообщает о ограблении банка 
        leader.setMessage("Идем грабить банк!");
        //Сообщение отправляется наблюдателям 
        leader.notifyObservers(leader.getMessage());
    }
}


