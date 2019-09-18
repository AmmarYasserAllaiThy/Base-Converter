
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Placeholder extends JFrame {

    public Placeholder(JTextField field, String value) {

        field.setText(value);
        field.setForeground(new Color(150, 150, 150));

        field.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(value)) {
                    field.setText("");
                }
                field.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().equals("")) {
                    field.setText(value);
                    field.setForeground(new Color(150, 150, 150));
                }
            }
        });

    }
}
