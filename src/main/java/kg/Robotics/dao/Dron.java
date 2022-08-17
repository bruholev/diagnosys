package kg.Robotics.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Dron {

    public String action(InterfaceAct interfaceAct){
        return interfaceAct.action();
    }
}
