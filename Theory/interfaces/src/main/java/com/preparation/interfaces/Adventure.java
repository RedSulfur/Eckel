package com.preparation.interfaces;

/**
 * Created by sulfur on 05.04.16.
 */

interface CanSwin {
    void swim();
}

interface CanFight {
    void fight();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {};
}

class Hero extends ActionCharacter
        implements CanFight,CanSwin,CanFly {
    public void fly() {
    }
    public void swim() {
    }
}

public class Adventure {
    /*
    Возможность выполнять восходящее преоьразование к нескольким
    базовым типам
    */
    public static void t(CanFight x) {x.fight();}
    public static void u(CanSwin x) {x.swim();}
    public static void v(CanFly x) {x.fly();}
    public static void w(ActionCharacter x) {x.fight();}

    public static void main(String[] args) {
        Hero h = new Hero();
        t(h);
        u(h);
        v(h);
        w(h);
    }
}
