import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.util.*;
import javax.swing.JTable;
import java.awt.Window.Type;

public class List {

	private JFrame frame;
	private JTextField textPush;
	private JButton btnpop;
	private JButton btnPeek;
	private JLabel lblPush;
	StackAsLinkedList sll = new StackAsLinkedList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List window = new List();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public List() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 652, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnpush = new JButton("Push");
		btnpush.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnpush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				 int i;
				 String s[] = textPush.getText().split(" ");
				 int a[]=new int[s.length];
				 String p="";
			        	 for(i=0; i < s.length;i++) {
							 a[i] = Integer.parseInt(s[i]);
							 sll.push(a[i]);
							 p =p + s[i]+"  ";
							   lblPush.setText(p+"pushed to stack");
							   lblPush.setText(p+"pushed to stack");
							   lblPush.setText(p+"pushed to stack");
							   lblPush.setText(p+"pushed to stack");
			        }
			}
				 
		});
		btnpush.setBounds(99, 92, 163, 55);
		frame.getContentPane().add(btnpush);
		
		textPush = new JTextField();
		textPush.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPush.setBounds(41, 29, 265, 33);
		frame.getContentPane().add(textPush);
		textPush.setColumns(10);
		
		
		
		btnPeek = new JButton("Peek");
		btnPeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (sll.top==null) {
					 lblPush.setText("Stack is Empty");
			        }
			        else {
			        	lblPush.setText("Top element is " + sll.peek());
			        }
				
			}
		});
		btnPeek.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPeek.setBounds(99, 359, 163, 55);
		frame.getContentPane().add(btnPeek);
		lblPush = new JLabel("");
		lblPush.setVerticalAlignment(SwingConstants.TOP);
		lblPush.setLabelFor(frame);
		lblPush.setHorizontalAlignment(SwingConstants.LEFT);
		lblPush.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPush.setBounds(359, 92, 248, 55);
		frame.getContentPane().add(lblPush);
		
		lblPush = new JLabel("");
		lblPush.setVerticalAlignment(SwingConstants.TOP);
		lblPush.setLabelFor(frame);
		lblPush.setHorizontalAlignment(SwingConstants.LEFT);
		lblPush.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPush.setBounds(359, 92, 248, 55);
		frame.getContentPane().add(lblPush);
		btnpop = new JButton("Pop");
		btnpop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (sll.top==null) {
					 lblPush.setText("Stack is Empty");
			        }
			        else {
				String out = String.valueOf(sll.pop());
			lblPush.setText(out + " popped from stack");
			}
			}
		});
		btnpop.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnpop.setBounds(99, 220, 163, 55);
		frame.getContentPane().add(btnpop);
	}
}
