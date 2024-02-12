package view.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InfoDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InfoDialog dialog = new InfoDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InfoDialog() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
//				Method
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 316, 193);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMessage = new JLabel("New label");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblMessage);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JButton okButton = new JButton("OK");
				okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
