import org.jpl7.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
		Spongebob sponge=new Spongebob();
		sponge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sponge.setSize(650,350);
		sponge.setVisible(true);
		sponge.setResizable(false);
		try {
			FileWriter fwOb = new FileWriter("F:/Spongebob and Corona/prolog/input.pl", false); 
        	PrintWriter pwOb = new PrintWriter(fwOb, false);
        	pwOb.flush();
        	pwOb.close();
		}catch(Exception e) {
			System.out.println("Failed");
		}
	}
	public static boolean isDigit(char a) {
		if(a=='0')
			return true;
		else if(a=='1')
			return true;
		else if(a=='2')
			return true;
		else if(a=='3')
			return true;
		else if(a=='4')
			return true;
		else if(a=='5')
			return true;
		else if(a=='6')
			return true;
		else if(a=='7')
			return true;
		else if(a=='8')
			return true;
		else if(a=='9')
			return true;
		return false;
	}
	public static ArrayList<String> parser(String x) {
		ArrayList<String> arr=new ArrayList<String>();
		ArrayList<String> ret=new ArrayList<String>();
		String dummy="";
		for(int i=0;i<x.length();i++) {
			if(isDigit(x.charAt(i))) {
				dummy+=x.charAt(i);
			}
			else {
				if(dummy.length()>0) {
					arr.add(dummy);
					dummy="";
				}
			}
		}
		for(int i=0;i<arr.size();i+=2) {
			ret.add("("+arr.get(i)+","+arr.get(i+1)+")");
		}
		return ret;
	}
}
