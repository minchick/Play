package Solitaire;

//определяет правила для добавления карт в колоду определенной масти

public class SuitCards extends StackCard {
    public SuitCards (int x, int y) { super(x, y); }

    public boolean canTake (Cardss aCard) {
        if (isEmpty()) //Если колода пуста, то карта может быть помещена только если ее ранг = 0
            return aCard.rank() == 0;
        Cardss topCard = top(); //Если в колоде уже есть карта,
        return (aCard.suit() == topCard.suit()) //то новая карта может быть помещена только если ее масть совпадает с мастью верхней карты в колоде
                && (aCard.rank() == 1 + topCard.rank()); //и ее ранг на единицу больше ранга верхней карты в колоде
    }
}
