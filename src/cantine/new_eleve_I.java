package cantine;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Combo;

public class new_eleve_I {

	protected Shell shell;
	private Text text;
	private Text text_2;
	private Text text_3;
	private String[] age_combo = new String [101];

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new_eleve_I window = new new_eleve_I();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(646, 457);
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(64, 88, 168, 31);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(384, 279, 105, 35);
		btnNewButton.setText("New Button");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(286, 88, 168, 31);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(286, 153, 168, 31);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(286, 57, 81, 25);
		lblNewLabel.setText("Prenom");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(64, 125, 81, 25);
		lblNewLabel_1.setText("Age");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(286, 125, 81, 25);
		lblNewLabel_2.setText("classe");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(64, 57, 81, 25);
		lblNewLabel_3.setText("Nom");
		for (int i = 0; i <= 100; i++) {
			age_combo[i] = String.valueOf(i);
		}
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(age_combo);
		combo.setBounds(64, 153, 104, 33);

	}
}
