package cantine;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Combo;

public class new_eleve_I {

	protected Shell shell;
	private Text champ_nom;
	private Text champ_prenom;
	private Text champ_classe;
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
		createContents(display);
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
	protected void createContents(Display display) {
		shell = new Shell();
		shell.setSize(646, 457);
		shell.setText("SWT Application");
		
		champ_nom = new Text(shell, SWT.BORDER);
		champ_nom.setBounds(64, 88, 168, 31);
		
		Button boutton_valider = new Button(shell, SWT.NONE);
		boutton_valider.setBounds(221, 206, 105, 35);
		boutton_valider.setText("Valider");
		
		champ_prenom = new Text(shell, SWT.BORDER);
		champ_prenom.setBounds(286, 88, 168, 31);
		
		champ_classe = new Text(shell, SWT.BORDER);
		champ_classe.setBounds(286, 153, 168, 31);
		
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
		Combo champ_age = new Combo(shell, SWT.NONE);
		champ_age.setItems(age_combo);
		champ_age.setBounds(64, 153, 104, 33);
		boutton_valider.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String nom = champ_nom.getText();
				String prenom = champ_prenom.getText();
				String classe = champ_classe.getText();
				int age = Integer.parseInt(champ_age.getText());
				bd connect = new bd();
				try {
					System.out.println(connect.newUsers(nom, prenom, age, null, null, false, classe));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				display.close();
				eleves_I new_page = new eleves_I();
				new_page.main(null);
			}
		});

	}
}
