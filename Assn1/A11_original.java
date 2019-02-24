import java.io.*;
import java.util.ArrayList;

public class A11_original {

	public static void main(String[] args) throws IOException{
		
		String[] keywords = {"WRITE","READ","IF","ELSE",
								"RETURN","BEGIN", "END", "MAIN", "STRING", "INT", "REAL"};		
		ArrayList<String> array = new ArrayList<String>();		
		int temp;		
		boolean isCollecting = false;
		boolean QuoteTrigger = false;
		String charset = new String();			
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		BufferedWriter output = new BufferedWriter(new FileWriter("A1.output"));
		while((temp = in.read()) != -1) {
				
			if(temp == '"') {
				QuoteTrigger = !QuoteTrigger;
				continue;
			}
			if(!QuoteTrigger) {
				if(temp != ' ') {						
					if(isCollecting) {
						
						if((temp >= 'A' && temp <= 'Z') || (temp >='a' && temp <='z') ||(temp >='0' && temp <= '9')){
							charset +=(char)temp;
						}else {
							isCollecting = false;
						}
						
					}else{
										
						if( (temp >= 'A' && temp <= 'Z') || (temp >='a' && temp <='z') ) {
							isCollecting = true;
							charset += (char)temp;						
						}						
					}
				}else {
					if(!isCollecting)
						continue;
					isCollecting = false;
				}	
				if(!isCollecting) {
						
					for(String keys: keywords) {
						if(keys.equals(charset)) {
							charset = "";
							}
					}
					if(charset != "") {
						if(!array.contains(charset)) {
							array.add(charset);
						}						
						charset = "";
					}							
				}							
			}								
		}
		output.write("Identifiers: "+ array.size());
		output.close();
	
	}
}
