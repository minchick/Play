package Solitaire;
import java.awt.*;
import java.awt.event.*;

//сама игра
public class Solitaire {
    static public DeckCards deckPile; //переменная колода карт
    static public DroppedCards discardPile; //переменная колода сброса
    static public StackTable tableau [ ]; //переменная стопки карт на столе
    static public SuitCards suitPile [ ]; //переменная масти
    static public StackCard allPiles [ ]; //ранг
    private Frame window;

    public static void main(String[] args) { //создает экземпляр класса Solitaire и вызывает метод init для инициализации игры, он отображает окно с игрой
        Solitaire world = new Solitaire();
    }

    public Solitaire () {
        window = new SolitaireFrame();
        init();
        window.setVisible(true); //видимое окно
        window.setLocationRelativeTo(null); //отображение окна по центру экрана

    }

    public void init () {
        allPiles = new StackCard[13];
        suitPile = new SuitCards[4];
        tableau = new StackTable[17];
        //создаются колоды карт, колода сброса, масти и кучи карт на столе
        allPiles[0] = deckPile = new DeckCards(375, 30);
        allPiles[1] = discardPile = new DroppedCards(308, 30);
        for (int i = 0; i < 4; i++)
            allPiles[2+i] = suitPile[i] = new SuitCards(55 + (Cardss.width+10) * i, 30);
        for (int i = 0; i < 7; i++){
            allPiles[6+i] = tableau[i] = new StackTable(55+(Cardss.width+10) * i, Cardss.height + 45,i+1);
        }
    }

    private class SolitaireFrame extends Frame { //нажатие кнопки и мыши
        private class RestartButtonListener implements ActionListener {
            public void actionPerformed (ActionEvent e) {
                init();
                window.repaint();
            }
        }

        private class MouseKeeper extends MouseAdapter { //получает координаты нажатия мыши и проверяет, включает ли какой-либо набор карт эти координаты, если да, то вызывается метод select для выбора этого набора карт
            public void mousePressed (MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                for (int i = 0; i < 13; i++)
                    if (allPiles[i].includes(x, y)) {
                        allPiles[i].select(x, y);
                        repaint();
                    }
            }
        }
        public SolitaireFrame() {
            setSize(700, 400);
            setTitle("Пасьянс");
            addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent we){
                    System.exit(0);
                }
            });
            addMouseListener (new MouseKeeper());
            Button restartButton = new Button("Заново");
            restartButton.addActionListener(new RestartButtonListener());
            add(restartButton, BorderLayout.SOUTH);
        }

        public void paint(Graphics g) { //для отображения карт в окне
            for (int i = 0; i < 13; i++)
                allPiles[i].display(g);
        }

    }
}



