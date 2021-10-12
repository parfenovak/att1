package Hearts;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;

/**
 * A class that represents a card in a regular deck of 52 cards
 */

class Card {

    private String suit;
    private String rank;
    private GridPane pane;

    /**
     * Constructor that creates a Hearts.Card with a suit and a rank
     * @param suit String
     * @param rank String
     */
    Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        pane = new GridPane();
        pane.setPrefSize(40.0, 70.0);
    }

    /**
     * Get method that returns the suit of the Hearts.Card
     * @return String
     */
    String suit() {
        return suit;
    }

    /**
     * Get method that returns the rank of the Hearts.Card
     * @return String
     */
    String rank() {
        return rank;
    }

    /**
     * Returns true if this Hearts.Card and the argument Hearts.Card are the same suit
     * Returns false otherwise
     * @param card Hearts.Card
     * @return boolean
     */
    public boolean compareSuit(Card card) {
        return this.suit().equals(card.suit());
    }

    /**
     * Returns the suit and rank of the card nicely formatted for printing
     * @return String
     */
    public String toString() {
        return this.rank + " of " + this.suit;
    }

    public GridPane pane() {
        Image img;
        if (suit.equals("Clubs")) {
            img = new Image("http://www.pd4pic.com/images/club-symbol-card-shape-game-playing-shapes-play.png");
        }else if (suit.equals("Diamonds")) {
            img = new Image("http://www.clipartkid.com/images/493/clip-art-shapes-diamond-wd8sA9-clipart.jpg");
        }else if (suit.equals("Spades")) {
            img = new Image("https://image.freepik.com/free-icon/spade-symbol_318-60433.png");
        }else {
            img = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Heart_coraz%C3%B3n.svg/2000px-Heart_coraz%C3%B3n.svg.png");
        }
        ImageView icon1 = new ImageView(img);
        ImageView icon2 = new ImageView(img);
        Text text1 = new Text(rank());
        text1.setFont(new Font(20));
        Text text2 = new Text(rank());
        text2.setFont(new Font(20));
        icon1.setFitHeight(15);
        icon1.setFitWidth(15);
        icon2.setFitHeight(15);
        icon2.setFitWidth(15);
        VBox vbox1 = new VBox(text1, icon1);
        VBox vbox2 = new VBox(text2, icon2);
        vbox2.getTransforms().add(new Rotate(180, 0, 0));
        GridPane.setConstraints(vbox1, 0, 0);
        GridPane.setConstraints(vbox2, 1, 1);
        pane.getChildren().addAll(vbox1, vbox2);
        pane.setHgap(80);
        pane.setVgap(100);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(20), BorderWidths.DEFAULT)));
        return pane;
    }
}
