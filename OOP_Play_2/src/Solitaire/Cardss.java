package Solitaire;
import java.awt.*;

//визуальная реализация карт
public class Cardss {
    private boolean faceup; //открыта карта или нет
    private int r;//ранг карты
    private int s;//масть

    //ширина и высота карт
    public final static int width = 50;
    public final static int height = 70;

    // константы, представляющие масти карты
    public final static int heart = 0;
    public final static int spade = 1;
    public final static int diamond = 2;
    public final static int club = 3;
    public Cardss (int sv, int rv) { //установка масти, ранга и изначально закрытая
        s = sv;
        r = rv;
        faceup = false;
    }

    public final void flip() { //изменяет значение поля faceup на противоположное, т.е если карта была лицом вверх, она станет лицом вниз, и наоборот
        faceup = ! faceup;
    }

    //возвращение значений полей
    public final int rank () {
        return r;
    }

    public final int suit()
    {
        return s;
    }

    public final boolean faceUp()
    {
        return faceup;
    }

    public final Color color() { //возвращает цвет карты в зависимости открыта или закрыта и масти
        Color color1 = new Color(153,0,0);
        if (faceUp())
            if (suit() == heart || suit() == diamond)
                return color1;
            else
                return Color.black;
        return Color.green;
    }

    public void draw (Graphics g, int x, int y) { //отображение карты на экране
        String names[] = {"Туз", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "Валет", "Дама", "Король"};

        g.clearRect(x, y, width, height);
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);

        g.setColor(color());
        if (faceUp()) { //проверяется, открыта ли карта, если да, то в зависимости от масти рисуются соответствующие фигуры
            g.drawString(names[rank()], x + 3, y + 15);
            if (suit() == heart) {
                g.fillPolygon(new int[]{x + 25, x + 35, x + 45, x + 25, x + 5, x + 15},
                        new int[]{y + 30, y + 20, y + 30, y + 60, y + 30, y + 20}, 6);
            } else if (suit() == spade) {
                g.fillPolygon(new int[]{x + 25, x + 40, x + 10, x + 25},
                        new int[]{y + 20, y + 50, y + 50, y + 20}, 4);
                g.fillPolygon(new int[]{x + 23, x + 20, x + 30, x + 27},
                        new int[]{y + 45, y + 60, y + 60, y + 45}, 4);
            } else if (suit() == diamond) {
                g.fillPolygon(new int[]{x + 25, x + 40, x + 25, x + 10},
                        new int[]{y + 20, y + 40, y + 60, y + 40}, 4);
            } else if (suit() == club) {
                g.fillOval(x + 20, y + 25, 10, 10);
                g.fillOval(x + 25, y + 35, 10, 10);
                g.fillOval(x + 15, y + 35, 10, 10);
                g.fillPolygon(new int[]{x + 23, x + 20, x + 30, x + 27},
                        new int[]{y + 45, y + 55, y + 55, y + 45}, 4);
            }
        } else { //если карта закрыта, рисуется задняя сторона с темно-серым фоном и серыми линиями
            g.setColor(Color.darkGray);
            g.fillRect(x, y, width, height);
            g.setColor(Color.lightGray);
            g.drawLine(x + 15, y + 5, x + 15, y + 65);
            g.drawLine(x + 35, y + 5, x + 35, y + 65);
            g.drawLine(x + 5, y + 20, x + 45, y + 20);
            g.drawLine(x + 5, y + 35, x + 45, y + 35);
            g.drawLine(x + 5, y + 50, x + 45, y + 50);
        }
    }
}
