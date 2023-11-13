package Solitaire;
import java.util.Random ;

//создание колоды карт в игре
public class DeckCards extends StackCard  {
    public DeckCards (int x, int y) { //координаты расположения колоды карт
        super(x, y);
        for (int i = 0; i < 4; i++) //за распределение масти
            for (int j = 0; j <= 12; j++) //за распределение ранга
                addCard(new Cardss(i, j)); //добавление карт в колоду
        Random generator = new Random(); //перемешивание карт
        for (int i = 0; i < 52; i++) {
            int j = Math.abs(generator.nextInt() % 52); //случайное число из 52
            Object temp = thePile.elementAt(i); //Значение двух карт (i и j) меняется местами с помощью временной переменной temp
            thePile.setElementAt(thePile.elementAt(j), i);
            thePile.setElementAt(temp, j);
        }
    }

    public void select(int tx, int ty) {
        if (isEmpty()) return; //Если колода карт пуста, то метод возвращает управление
        Solitaire.discardPile.addCard(pop()); //последняя карта из колоды удаляется и добавляется в колоду сброса
    }
}

