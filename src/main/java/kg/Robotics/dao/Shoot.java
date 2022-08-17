package kg.Robotics.dao;

public class Shoot implements InterfaceAct {


    @Override
    public String action() {
        System.out.println("Shoot!");
        return "Shoot!";
    }
}
