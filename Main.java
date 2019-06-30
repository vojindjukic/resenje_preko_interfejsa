import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //primer liste koja se dobija
        List list = new ArrayList();
        list.add(new Dog());
        list.add(new Bird());
        list.add(new Human());
        list.add(new Horse());

        list.forEach(obj -> doAbilities(obj)); //resen zadatak bez ikakvog nasledjivanja

        //primer za polimorfizam
        List<Abilities.ableToWalk> list2 = list;
        list2.forEach(s -> s.walk());

        //sad se ti pitas: a sto je to bolje nego ono tvoje.
        //evo na primer - sta bi se desilo kod tebe kada bi trebalo dodati klasu Avion (recimo da samo leti)?
        // pa onda jos potklasu za borberni avion (fly + strike)?
        //morala bi da dodajes proveru sa instanceof za svaku novu klasu, a ovako nista ne bi moralo da se dodaje u ostatku koda.
    }

    private static void doAbilities(Object obj){
        if (obj instanceof Abilities.ableToWalk) ((Abilities.ableToWalk) obj).walk();
        if (obj instanceof Abilities.ableToRun) ((Abilities.ableToRun) obj).run();
        if (obj instanceof Abilities.ableToStrike) ((Abilities.ableToStrike) obj).strike();
        if (obj instanceof Abilities.ableToFly) ((Abilities.ableToFly) obj).fly();
    }
}

class Dog implements Abilities.ableToWalk {

    @Override
    public void walk() {
        System.out.println("Dog is walking");
    }
}

class Human implements Abilities.ableToWalk, Abilities.ableToStrike{

    @Override
    public void walk() {
        System.out.println("Human is walking");
    }

    @Override
    public void strike() {
        System.out.println("Human is striking");
    }
}

class Horse implements Abilities.ableToWalk, Abilities.ableToRun{
    @Override
    public void walk() {
        System.out.println("Horse is walking");
    }

    @Override
    public void run() {
        System.out.println("Horse is running");
    }
}

class Bird implements Abilities.ableToWalk, Abilities.ableToFly{
    @Override
    public void walk() {
        System.out.println("Bird is walking");
    }

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}
