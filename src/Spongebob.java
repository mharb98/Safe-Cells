import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.*;
import org.jpl7.*;
import java.lang.Integer;


public class Spongebob extends JFrame{
	private JPanel DimensionPanel;
	private JPanel CreditPanel;
	private JPanel startPanel;
	private JPanel coronaPanel;
	private JPanel costPanel;
	private JPanel resultPanel;
	private JLabel dimension;
	private JTextField row;
	private JTextField column;
	private JButton enterDimension;
	private JLabel Credit;
	private JTextField CreditNum;
	private JButton enterCredit;
	private JLabel start;
	private JTextField startingRow;
	private JTextField startingColumn;
	private JButton enterStart;
	private JLabel corona;
	private JTextField coronaRow;
	private JTextField coronaColumn;
	private JButton enterCorona;
	private JLabel costs;
	private JTextField upCost;
	private JTextField downCost;
	private JTextField leftCost;
	private JTextField rightCost;
	private JButton enterCosts;
	private JButton run;
	private JTextField result;
	public Spongebob() {
		super("Deadlock And Safe State Detection");
		setLayout(new FlowLayout());
		dimension=new JLabel("Enter Dimension Here");
		row =new JTextField();
		column=new JTextField();
		enterDimension=new JButton("Enter Dimensions");
		DimensionPanel=new JPanel(new GridLayout(1,4,5,5));
		add(DimensionPanel);
		DimensionPanel.add(dimension);
		DimensionPanel.add(row);
		DimensionPanel.add(column);
		DimensionPanel.add(enterDimension);
		DimensionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		Credit=new JLabel("Enter Credit Here");
		CreditNum=new JTextField();
		enterCredit=new JButton("Enter Credit");
		CreditPanel=new JPanel(new GridLayout(1,3,5,5));
		add(CreditPanel);
		CreditPanel.add(Credit);
		CreditPanel.add(CreditNum);
		CreditPanel.add(enterCredit);
		CreditPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		start=new JLabel("Starting Position");
		startingRow=new JTextField();
		startingColumn=new JTextField();
		enterStart=new JButton("Enter Start");
		startPanel=new JPanel(new GridLayout(1,4,5,5));
		add(startPanel);
		startPanel.add(start);
		startPanel.add(startingRow);
		startPanel.add(startingColumn);
		startPanel.add(enterStart);
		startPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		corona=new JLabel("Add Corona Fact");
		coronaRow =new JTextField();
		coronaColumn=new JTextField();
		enterCorona=new JButton("Enter Corona");
		coronaPanel=new JPanel(new GridLayout(1,4,5,5));
		add(coronaPanel);
		coronaPanel.add(corona);
		coronaPanel.add(coronaRow);
		coronaPanel.add(coronaColumn);
		coronaPanel.add(enterCorona);
		coronaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		costs=new JLabel("Enter Costs Here");
		upCost=new JTextField("Up Cost");
		downCost=new JTextField("Down Cost");
		leftCost=new JTextField("Left Cost");
		rightCost=new JTextField("Right Cost");
		enterCosts=new JButton("Enter Costs");
		costPanel=new JPanel(new GridLayout(1,6,5,5));
		add(costPanel);
		costPanel.add(costs);
		costPanel.add(upCost);
		costPanel.add(downCost);
		costPanel.add(leftCost);
		costPanel.add(rightCost);
		costPanel.add(enterCosts);
		costPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		run=new JButton("Run");
		result=new JTextField();
		resultPanel=new JPanel(new GridLayout(1,2,5,5));
		add(resultPanel);
		resultPanel.add(run);
		resultPanel.add(result);
		
		Handler handler = new Handler();
		enterDimension.addActionListener(handler);
		enterCredit.addActionListener(handler);
		enterStart.addActionListener(handler);
		enterCorona.addActionListener(handler);
		enterCosts.addActionListener(handler);
		run.addActionListener(handler);
	}
	
	private class Handler implements ActionListener
	{
		public void actionPerformed(ActionEvent event) {
			String input1,input2,input3,input4;
			if(event.getSource()==enterDimension) {
				input1=row.getText();
				input2=column.getText();
				try {
					FileWriter fw = new FileWriter("F:/Spongebob and Corona/prolog/input.pl",true);
					BufferedWriter bw = new BufferedWriter(fw);
			        bw.write("dim("+input1+","+input2+").");
			        bw.write("\n");
			        bw.close();
				}catch(Exception e) {
					System.out.println("Couldn't write");
				}
			}
			else if(event.getSource()==enterCredit) {
				input1=CreditNum.getText();
				try {
					FileWriter fw = new FileWriter("F:/Spongebob and Corona/prolog/input.pl",true);
					BufferedWriter bw = new BufferedWriter(fw);
			        bw.write("cost("+input1+").");
			        bw.write("\n");
			        bw.close();
				}catch(Exception e) {
					System.out.println("Couldn't write");
				}
			}
			else if(event.getSource()==enterStart) {
				input1=startingRow.getText();
				input2=startingColumn.getText();
				try {
					FileWriter fw = new FileWriter("F:/Spongebob and Corona/prolog/input.pl",true);
					BufferedWriter bw = new BufferedWriter(fw);
			        bw.write("start(["+input1+","+input2+"]).");
			        bw.write("\n");
			        bw.close();
				}catch(Exception e) {
					System.out.println("Couldn't write");
				}
			}
			else if(event.getSource()==enterCorona) {
				input1=coronaRow.getText();
				input2=coronaColumn.getText();
				try {
					FileWriter fw = new FileWriter("F:/Spongebob and Corona/prolog/input.pl",true);
					BufferedWriter bw = new BufferedWriter(fw);
			        bw.write("corona(["+input1+","+input2+"]).");
			        bw.write("\n");
			        bw.close();
				}catch(Exception e) {
					System.out.println("Couldn't write");
				}
			}
			else if(event.getSource()==enterCosts) {
				input1=leftCost.getText();
				input2=rightCost.getText();
				input3=upCost.getText();
				input4=downCost.getText();
				try {
					FileWriter fw = new FileWriter("F:/Spongebob and Corona/prolog/input.pl",true);
					BufferedWriter bw = new BufferedWriter(fw);
			        bw.write("leftcost("+input1+").");
			        bw.write("\n");
			        bw.write("rightcost("+input2+").");
			        bw.write("\n");
			        bw.write("upcost("+input3+").");
			        bw.write("\n");
			        bw.write("downcost("+input4+").");
			        bw.write("\n");
			        bw.close();
				}catch(Exception e) {
					System.out.println("Couldn't write");
				}
			}
			else if(event.getSource()==run) {
				Query query=new Query("consult('F:/Spongebob and Corona/prolog/spongebob.pl')");
				query.hasSolution();
				Query query3=new Query("consult('F:/Spongebob and Corona/prolog/input.pl')");
				query3.hasSolution();
				Variable X = new Variable("X");
				Term arg[] = { X };
				Query query2=new Query("spongebob",arg);
				Map<String, Term> dummy = query2.oneSolution();
				ArrayList<String> arr=Main.parser(dummy.toString());
				result.setText(Integer.toString(arr.size()));
				String d="";
				for(int i=0;i<arr.size();i++) {
					d+=arr.get(i);
					d+="\n";
				}
				JOptionPane.showMessageDialog(null,d);
			}
		}
		
	}
}
