package cantine;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.ViewForm;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class connexion_I {

	protected Shell shell;
	private Text champ_id;
	private Text champ_mdp;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			connexion_I window = new connexion_I();
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
		shell.setSize(381, 480);
		shell.setText("SWT Application");
		
		champ_id = new Text(shell, SWT.BORDER);
		champ_id.setBounds(53, 153, 242, 43);
		
		Label id_label = new Label(shell, SWT.NONE);
		id_label.setBounds(87, 122, 91, 25);
		id_label.setText("Identifiant");
		
		Label mdp_label = new Label(shell, SWT.NONE);
		mdp_label.setBounds(87, 242, 114, 25);
		mdp_label.setText("Mot de passe");
		
		champ_mdp = new Text(shell, SWT.BORDER);
		champ_mdp.setBounds(53, 273, 242, 43);
		
		Button valider_bouton = new Button(shell, SWT.NONE);
		valider_bouton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String mail = champ_id.getText();
				String mdp = champ_mdp.getText();
				bd connect = new bd();
				try {
					Utilisateur ut = connect.connexion(mail, mdp);
					if (ut.getNom()==null) {
						System.out.println("identifiant incorrecte");
					}
					else {
						System.out.println("connexion faite");
						System.out.println(ut.getNom());
						display.close();
						eleves_I eleves = new eleves_I();
						eleves.main(null);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					
				}
			}
		});
		valider_bouton.setBounds(117, 335, 105, 35);
		valider_bouton.setText("Valider");

	}
}

