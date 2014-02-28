package restCalls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
 
public class NetClientExport {
	
	public void redirectExport(String fileName, String folderName, String auth) throws IOException{
		
		URL url = new URL("https://n3phele-dev.appspot.com/resources/repository/1239007/redirect?name="+fileName+"&path="+folderName+"/");		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.addRequestProperty("Authorization","Basic " + auth);
		con.setInstanceFollowRedirects(false);
		System.out.println("Orignal URL: " + con.getURL());
		String responseFirstUrl = con.getHeaderField("Location");
		URL redUrl = new URL(responseFirstUrl);
		HttpURLConnection con2 = (HttpURLConnection) redUrl.openConnection();
		//get response
        InputStream is = con2.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();
        System.out.println("File Body: ");
        PrintWriter writer = new PrintWriter(System.getProperty("user.dir")+"/"+fileName);
        while((line = br.readLine()) != null){
            response.append(line);
            writer.println(line);
            response.append('\n');
        }
        writer.close();
        System.out.println(response.toString());
        br.close();
		System.out.println("Redirected URL: " + con2.getURL());
	}
}