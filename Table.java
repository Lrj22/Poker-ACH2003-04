import java.util.Arrays;
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

	private boolean isRoyalFlush(Card[] cards){

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
			if ((cards[i - 1].getRank() - 1) != cards[i].getRank())
				return false;
		}

		return true;
	}
  
  private boolean isThreeKind(Card[] cards) {
		for(int i = 1; i < cards.length; i++) {
			if(cards[i-1].getRank() == cards[i].getRank() && cards[i-1].getRank() == cards[i+1].getRank())
				return true;
		}
		return false;
	}

	// Método que retorna se há (2 pares) OU (1 par e 1 trinca)
	private boolean isTwoPair(Card[] cards) {
		// variável que contabiliza quantas comparações entre pares são diferentes
		int cont = 0;
		for (int i = 1; i < cards.length; i++) {
			if (cards[i - 1].getRank() != cards[i].getRank())
				cont++;
		}
		return cont <= 2 ? true : false;

	}

	private boolean isPair(Card[] cards) {
		// Como este método será chamado por último, caso identifique uma carta com
		// mesmo rank podemos já assumir que é um par
		for (int i = 1; i < cards.length; i++) {
			if ((cards[i - 1].getRank()) == cards[i].getRank())
				return true;
		}
		return false;
	}

	// Método que apenas testa a classificação de 5 cartas
	public String individualTest(String cardsString) {

		Player p = new Player(cardsString);
		String classificacao = Table.hands[this.defineHand(p)];
		return p + classificacao;
	}

	// Algoritmo quicksort para ordenar o arrajo de cartas
	private void quicksort(Card[] cards, int p, int r) {
		if (p < r) {
			int q = particiona(cards, p, r);
			quicksort(cards, p, q - 1);
			quicksort(cards, q + 1, r);
		}
	}

	// Eu troco os valores entre as cartas. Utilizo esta função dentro do algoritmo
	// QuickSorter, mais especificamente no método particiona
	private void trocaValorEntreCards(Card carta1, Card carta2) {
		int aux1 = carta1.getRank();
		char aux2 = carta1.getSuit();
		carta1.setRank(carta2.getRank());
		carta1.setSuit(carta2.getSuit());
		carta2.setRank(aux1);
		carta2.setSuit(aux2);
	}

	// reorganiza o subarranjo cards[p ..r] para o algoritmo quicksort
	private int particiona(Card[] cards, int p, int r) {
		Card x = cards[r];
		int i = p - 1;

		for (int j = p; j < r; j++) {
			if (cards[j].compareCard(x) > 0) {
				i++;
				trocaValorEntreCards(cards[i], cards[j]);
			}
		}
		trocaValorEntreCards(cards[i + 1], cards[r]);
		return i + 1;
	}

	private void sortCards(Card[] cards) {
		quicksort(cards, 0, cards.length - 1);
	}
}
