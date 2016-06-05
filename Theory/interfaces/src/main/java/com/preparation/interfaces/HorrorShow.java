package com.preparation.interfaces;

/**
 * Created by sulfur on 05.04.16.
 */

/*
Наследование позволяет легко добавить в интерфейс обьявления новых методов
а также совместить несколько интерфейсов в одном
*/

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {
    public void menace() {

    }

    public void destroy() {

    }
}

interface Vampire extends DangerousMonster,Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {
    public void drinkBlood() {

    }

    public void destroy() {

    }

    public void kill() {

    }

    public void menace() {

    }
}

public class HorrorShow {
    static void u(Monster m) {m.menace();}
    static void v(DangerousMonster m) {
        m.menace();
        m.destroy();
    }
    static void w(Lethal l) {l.kill();}
    /*
    Так как интерфейс можно составить из нескольких других интерфейсов,
    ключевое слово extends подходит для написания нескольких имен интерфейсов
    при создании нового интерфейса
    */
    public static void main(String[] args) {
        DangerousMonster danny = new DragonZilla();
        u(danny);
        v(danny);
        Vampire Vlad = new VeryBadVampire();
        u(Vlad);
        v(Vlad);
        w(Vlad);
    }

}
