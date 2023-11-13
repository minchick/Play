package Solitaire;

//дочерний класс класса CardPile. Колода сброшенных карт в игре
public class DroppedCards extends StackCard {
    public DroppedCards (int x, int y) { //Создает новый объект типа с указанными координатами x и y
        super (x, y);
    }
    public void addCard (Cardss aCard) { //Добавляет карту в колоду, если карта не открыта, то она переворачивается с помощью метода flip() и добавляется в колоду с помощью метода addCard()
        if (! aCard.faceUp())
            aCard.flip();
        super.addCard(aCard);
    }

    public void select (int tx, int ty) { //берем карту из колоды по координатам
        if (isEmpty()) //если колода пуста то ничего
            return;
        Cardss topCard = pop(); //верхняя карта извлекается методом pop()
        //поиск подходящей колоды для помещения выбранной карты
        for (int i = 0; i < 4; i++)
            if (Solitaire.suitPile[i].canTake(topCard)) { //проверка четырех колод
                Solitaire.suitPile[i].addCard(topCard); //Если одна из колод может принять карту, она добавляется с помощью метода addCard() соответствующей колоды
                return;
            }
        //Если ни одна из колод не может принять карту
        for (int i = 0; i < 7; i++)
            if (Solitaire.tableau[i].canTake(topCard)) { //проверка семи колод (tableau)
                Solitaire.tableau[i].addCard(topCard); //Если одна из колод-столов может принять карту, она добавляется с помощью метода addCard()
                return;
            }
        addCard(topCard); //иначе карта возвращается в колоду
    }

}
