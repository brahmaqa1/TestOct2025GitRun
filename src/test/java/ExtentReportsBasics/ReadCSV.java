package ExtentReportsBasics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
	public static void main(String[] args) throws IOException {
		String fname= ".\\Sample.csv";
		
		//  .txt -- classes -->  FileReader , BufferedReader , readLine()
		//  write data into .txt --> FileWriter, BufferedWriter,  
		
		FileReader fr  = new FileReader(fname);
		BufferedReader br = new BufferedReader(fr);
		String x;
		while((x=br.readLine())!=null)
		{
			System.out.println("lin1="+ x);
		}
	
//		        lin1=ram,10,Bng, 100
//				lin2=sita,20, CHN,200
//				lin2=sita,20, CHN,200
//				lin3=null
		
		
		//HW  get  Ram 10 Bng 100  without comma's frm lin1=ram,10,Bng, 100
			// USE String class method-   split(", ")
			
		

	}


}
