
public class CardTest {
    public static void main(String[] args) {
        Card card1 = new Card(Card.Value.ACE, Card.Suit.HEARTS);
        Card card2 = new Card(Card.Value.SEVEN, Card.Suit.DIAMONDS);
        Card card3 = new Card(Card.Value.KING, Card.Suit.CLUBS);

        System.out.println("Card 1: " + card1);
        System.out.println("Card 2: " + card2);
        System.out.println("Card 3: " + card3);
    }
}
