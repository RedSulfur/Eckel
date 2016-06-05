package com.preparation.handling;

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
    /*
    И конструктор и метод event() обьявляют, что будут выбрасывать исключения,
    но этого никогда не делают. Это разрешается, поскольку это заставляет пользо-
    вателя перехватить все виды исключений, которые могут быть добавлены в пере-
    определенные версии метода event()
     */

    public Inning() throws BaseballException {}
    public void event() throws BaseballException{}

    public abstract void atBat() throws Foul,Strike;
    public void walk() {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    void event() throws RainedOut;
    void rainedHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{

    public StormyInning()
            throws BaseballException, RainedOut {
    }

    public StormyInning(String s)
            throws Foul, BaseballException {}

    /*
    Можно не возбуждать исключенния вообще, даже если базовая версия это
    делает
     */
    public void event() {}

    /*
     Переопределнные методы могут возбуждать унаследованные исключения

     Если кто-то работает с базовым классом Inning, то он должен перехватить
     исключение Foul, но так как PopFoul унаследован от Foul обработчик
     исключения для Foul перехватит PopFoul
     */
    @Override
//    public void atBat() throws Foul, Strike {
    public void atBat() throws PopFoul{
    }

    @Override
    public void rainedHard() throws RainedOut {
    }

    public static void main(String[] args) {

        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("PopFoul");
        } catch (BaseballException e) {
            System.out.println("Generic exception");
        } catch (RainedOut rainedOut) {
            System.out.println("RainedOut");
        }

        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (BaseballException e) {
            System.out.println("Generic exception");
        } catch (RainedOut rainedOut) {
            System.out.println("RainedOut");
        }

    }

}
