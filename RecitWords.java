package learnJavaCode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RecitWords extends JFrame {

	private JPanel contentPane;
	JLabel lblWord = new JLabel("");
	JLabel lblMeaning = new JLabel("");
	ArrayList<String> words = new ArrayList<>();
	ArrayList<String> meanings = new ArrayList<>();
	int current = 0;
	
	/**
	 * Create the frame.
	 */
	public RecitWords() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		lblWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblWord.setFont(new Font("Dialog", Font.PLAIN, 30));
		
		contentPane.add(lblWord);
		lblMeaning.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeaning.setFont(new Font("Dialog", Font.PLAIN, 20));
		contentPane.add(lblMeaning);
		setVisible(true);
	}
	
	public void start() {
		try {
			readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				lblWord.setText(words.get(current));
				lblMeaning.setText(meanings.get(current));
				current ++;
			}
		}, 1000, 1000);
	}
	public void readAll() throws IOException {
		String fileName = "/home/yf/eclipse-mars-workspace/learnJavaCode/src/learnJavaCode/cet4.txt"; ///home/yf/eclipse-mars-workspace/learnJavaCode/src/learnJavaCode/
		String charset = "GB2312";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), charset));
		
		String line;
		while((line = reader.readLine()) != null) {
			line = line.trim();
			if(line.length() == 0) continue;
//			int idx = line.indexOf("\t");
			String[] s1 = line.split("\t");
			words.add(s1[0]);
			meanings.add(s1[1]);
		}
		
		reader.close();
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecitWords frame = new RecitWords();
					frame.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}
