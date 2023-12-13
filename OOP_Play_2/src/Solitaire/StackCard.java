package Solitaire;
import java.awt.*;
import java.util.EmptyStackException;
import java.util.Stack;

//операции связанные с колодой карт
public class StackCard {
    public StackCard (int xl, int yl) { //Создает новый объект с указанными координатами
        x = xl;
        y = yl;
        thePile = new Stack();
    }
    public final Cardss pop() { //Удаляет верхнюю карту из колоды и возвращает ее, если колода пуста, возвращает null
        try {
            return (Cardss) thePile.pop();
        } catch (EmptyStackException e) {
            return null;
        }
    }

    public void addCard (Cardss aCard) { //Добавляет карту в колоду
        thePile.push(aCard);
    }

    public void select (int tx, int ty) { }

    public final Cardss top() { //Возвращает верхнюю карту из колоды, не удаляя ее
        return (Cardss) thePile.peek();
    }

    public final boolean isEmpty() { //Проверяет, пуста ли колода, возвращает true, если пуста, иначе false
        return thePile.empty();
    }

    public boolean includes (int tx, int ty) { //Проверяет, включает ли колода указанные координаты, возвращает true, если включает, иначе false
        return x <= tx && tx <= x + Cardss.width
                && y <= ty && ty <= y + Cardss.height;
    }

    public boolean canTake (Cardss aCard) { //Проверяет, можно ли взять карту из колоды, возвращает true, если можно взять, иначе false
        return false;
    }

    public void display (Graphics g) { //Отображает колоду, если колода пуста, отображается прямоугольник, иначе, отображается верхняя карта с помощью метода draw()
        g.setColor(Color.white);
        if (isEmpty())
            g.drawRect(x, y, Cardss.width, Cardss.height);
        else
            top().draw(g, x, y);
    }

    protected int x; //координата x верхнего левого угла колоды
    protected int y; //координата y верхнего левого угла колоды
    protected Stack thePile; //стек, который представляет колоду карт
}



