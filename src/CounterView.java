import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Observable;

/**
 * A Controller for a window that shows the value of a Counter.
 * This has only one component (but you can add more components),
 * so write it in code instead of FXML.
 *
 */
public class CounterView implements java.util.Observer {
	/** the stage (top-level window) for showing scene */
	private Stage stage;
	/** a counter to show value of */
	private NumberGame counter;
	/** the label that shows the counter value. */
	private Label label;

	/**
	 * Initialize a CounterView, which shows value of a counter.
	 * @param counter the Counter to show.
	 */
	public CounterView(NumberGame counter) {
		this.counter = counter;
		initComponents();
	}

	private void initComponents() {
		stage = new Stage();
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		label = new Label("   ");
		label.setPrefWidth(250);
		label.setFont(new Font("Arial", 80.0));
		label.setTextFill(Color.RED);
		label.setAlignment(Pos.CENTER);
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Count");
		stage.sizeToScene();
	}

	/** Show the window and update the counter value. */
	public void run() {
		stage.show();
		displayCount();
	}

	public void displayCount() {
		label.setText( String.format("%2d", counter.getCount()) );
	}

	@Override
	public void update(Observable o, Object arg) {
		displayCount();
	}
}
