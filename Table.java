import java.util.Scanner;

public class Table {

	private static final String[] hands = { "", "HighCard", "Pair", "TwoPair", "ThreeKind", "Straight", "Flush",
			"FullHouse", "FourKind", "StraightFlush", "RoyalFlush" };

	private Player[] players;
	private int highHandIndex;

	public Table() {

		this.players = new Player[5];
		this.highHandIndex = 0;
	}

	private int defineHand(Player player) {

		if (player.getCards().length != 5)
			return 0;

		Card[] cards = player.getCards().clone();

		// Ordeno as cartas em ordem crescente
		sortCards(cards);

		if (isRoyalFlush(cards))
			return 10;
		if (isStraightFlush(cards))
			return 9;
		if (isFourKind(cards))
			return 8;
		if (isFullHouse(cards))
			return 7;
		if (isFlush(cards))
			return 6;
		if (isStraight(cards))
			return 5;
		if (isThreeKind(cards))
			return 4;
		if (isTwoPair(cards))
			return 3;
		if (isPair(cards))
			return 2;

		return 1;
	}

	private boolean isRoyalFlush(Card[] cards) {

		return cards[0].getRank() == 14 && isStraightFlush(cards);
	}

	private boolean isStraightFlush(Card[] cards) {

		return (isFlush(cards) && isStraight(cards));
	}

	private boolean isFourKind(Card[] cards) {

		return cards[0] == cards[3] || cards[1] == cards[4];
	}

	private boolean isFullHouse(Card[] cards) {

		return isTwoPair(cards) && isThreeKind(cards);
	}

	private boolean isFlush(Card[] cards) {

		for (int i = 1; i < cards.length; i++) {
			if (cards[i - 1].getSuit() != cards[i].getSuit())
				return false;
		}

		return true;
	}

	private boolean isStraight(Card[] cards) {

		for (int i = 1; i < cards.length; i++) {
			if ((cards[i - 1].getRank() + 1) != cards[i].getRank())
				return false;
		}

		return true;
	}

	private boolean isThreeKind(Card[] cards) {
		int cont = 0;
		for (int i = 1; i < cards.length; i++) {
			if (cards[i - 1].getRank() == cards[i].getRank())
				cont++;
			else {
				if (cont == 3)
					return true;
				cont = 0;
			}
		}
		return false;
	}

	// Método que retorna se há (2 pares) OU (1 par e 1 trinca)
	private boolean isTwoPair(Card[] cards) {
		int cont = 0;
		for (int i = 1; i < cards.length; i++) {
			if (cards[i - 1].getRank() != cards[i].getRank())
				cont++;
		}
		return cont <= 2 ? true : false;

	}

	private boolean isPair(Card[] cards) {
		for (int i = 1; i < cards.length; i++) {
			if ((cards[i - 1].getRank() + 1) == cards[i].getRank())
				return true;
		}
		return false;
	}

	public String individualTest(String cardsString) {

		Player p = new Player(cardsString);

		return cardsString + " " + Table.hands[this.defineHand(p)];
	}

}
