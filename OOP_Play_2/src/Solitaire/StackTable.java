package Solitaire;
import java.util.Enumeration ;
import java.awt.*;

//стопка карт на игровом столе
public class StackTable extends StackCard  {
    public StackTable (int x, int y, int c) { //для отображения стопки карт
        super(x, y);
        for (int i = 0; i < c; i++) {
            addCard(Solitaire.deckPile.pop());
        }
        top().flip();
    }

    public void select (int tx, int ty) { //действия со стопкой
        if (isEmpty()) return;
        Cardss topCard = top();
        if (! topCard.faceUp()) { //Если верхняя карта стопки перевернута, переворачивает обратно
            topCard.flip();
            return;
        }
        topCard = pop();
        for (int i = 0; i < 4; i++)
            if (Solitaire.suitPile[i].canTake(topCard)) { //Если верхняя карта стопки перевернута, проверяет, может ли эта карта быть помещена в колоду карт одной масти
                Solitaire.suitPile[i].addCard(topCard);
                return;
            }
        for (int i = 0; i < 7; i++)
            if (Solitaire.tableau[i].canTake(topCard)) { //или в другую стопку
                Solitaire.tableau[i].addCard(topCard);
                return;
            }
        addCard(topCard);

    }

    public boolean canTake (Cardss aCard) { //может ли карта быть помещена в стопку
        if (isEmpty()) //Если стопка пустая, карта может быть помещена только если она королева
            return aCard.rank() == 12;

        Cardss topCard = top(); //Если в стопке уже карты, она может быть помещена только если ее цвет отличается от цвета верхней карты в стопке и ее ранг на единицу меньше ранга верхней карты
        return (aCard.color() != topCard.color()) &&
                (aCard.rank() == topCard.rank()-1 );
    }
    public boolean includes (int tx, int ty) { //проверяет, включает ли стопка карту с координатами
        return x <= tx && tx <= x + Cardss.width && y <= ty;
    }
    public void display (Graphics g) { //отображает стопку карт на экране
        int localy = y;
        for (Enumeration e = thePile.elements(); e.hasMoreElements();) {
            Cardss aCard = (Cardss) e.nextElement();
            aCard.draw (g, x,localy );
            localy += 15;
        }
    }


}
