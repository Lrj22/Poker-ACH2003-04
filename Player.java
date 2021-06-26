public class Player {

    private Card[] cards;
    private int handIndex;

    public Player(String strCards){
        this.cards = montaCartas(strCards);
        this.handIndex = 0;
    }

    public Card[] getCards(){

        return this.cards;
    }

    public int getHandIndex(){

        return this.handIndex;
    }

    public void setCards(String strCards){
      this.cards = montaCartas(strCards);
    }

    public Card[] montaCartas(){
        String[] arrStrCards = strCards.split(" ");
        Card[] auxCards = new Card[arrStrCards.length];

        for(int i = 0; i < cards.length; i++)
            auxCards[i] = new Card(arrStrCards[i]);

        return auxCards;
    }
    
    public void setHandIndex(int handIndex){

        this.handIndex = handIndex;
    }

    public String toString(){

        String result = "";

        for(Card card : cards)
            result += card + " ";

        return result;
    }
}
