import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;
public class A12_original {

	public static void main(String[] args) throws IOException {
		
		String pattern = "[a-zA-Z][a-zA-Z0-9]*";
		
		String[] keywords = {"WRITE","READ","IF","ELSE","RETURN","BEGIN", "END", "MAIN", "STRING", "INT", "REAL"};
					
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			BufferedWriter output = new BufferedWriter(new FileWriter("A1.output"));
			String input = new String();
			String temp;
			
			while((temp = in.readLine()) != null) {
				input += temp+"\n"; 
			}
			ArrayList<String> array = new ArrayList<String>();
			
			input = input.replaceAll("\"[^\"]*\"", "");
	
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(input);
			while(m.find()) {
				String key = input.substring(m.start(), m.end());
				boolean isKeyword = false;
				for(String keys: keywords) {
					if(keys.equals(key)) {
						isKeyword = !isKeyword;
					}
				}
				if(!isKeyword) {
					if(array.contains(key))
						continue;
					else
						array.add(key);
				}	
			}
			output.write("Identifiers: "+ array.size());
			output.close();


	}

}
