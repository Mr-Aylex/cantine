package cantine;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Tree;

import java.sql.SQLException;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import cantine.*;

public class eleves_I {

	protected Shell shell;
	private Table eleves_table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			eleves_I window = new eleves_I();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws SQLException 
	 */
	public void open() throws SQLException {
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
	 * @throws SQLException 
	 */
	protected void createContents() throws SQLException {
		shell = new Shell();
		shell.setSize(790, 616);
		shell.setText("SWT Application");
		
		eleves_table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		eleves_table.setLinesVisible(true);
		eleves_table.setHeaderVisible(true);
		eleves_table.setBounds(10, 51, 698, 446);
		
		TableColumn tblclmnClasse = new TableColumn(eleves_table, SWT.NONE);
		tblclmnClasse.setWidth(129);
		tblclmnClasse.setText("Classe");
		
		TableColumn tblclmnNom = new TableColumn(eleves_table, SWT.NONE);
		tblclmnNom.setWidth(190);
		tblclmnNom.setText("Nom");
		
		TableColumn tblclmnPrenom = new TableColumn(eleves_table, SWT.NONE);
		tblclmnPrenom.setWidth(256);
		tblclmnPrenom.setText("Prenom");
		
		TableColumn tblclmnAge = new TableColumn(eleves_table, SWT.NONE);
		tblclmnAge.setWidth(117);
		tblclmnAge.setText("Age");
		bd bd = new bd();
		Utilisateur[] users = bd.getUsers();
		System.out.println(users);
		TableItem[] tab = new TableItem[users.length];
		
		TableItem eleve_item1 = new TableItem(eleves_table, SWT.NONE);
		eleve_item1.setText(new String[] {"classe1","nom1","prenom1","age1"});
		
		for(int i = 0; i<users.length;i++) {
			Utilisateur use = users[i];
			
			TableItem eleve_item = new TableItem(eleves_table, SWT.NONE);
			String[] text = new String[4];
			text[0] = use.getClasse();
			text[1] = use.getNom();
			text[2] = use.getPrenom();
			text[3] = String.valueOf(use.getAge());
			eleve_item.setText(text);
			tab[i] = eleve_item;
			
		}
		
		
		Button ajout_boutton = new Button(shell, SWT.NONE);
		ajout_boutton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("valider");
			}
		});
		ajout_boutton.setBounds(71, 10, 192, 35);
		ajout_boutton.setText("Ajouter un \u00E9tudiant");

	}
}
