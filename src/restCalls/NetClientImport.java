package restCalls;

import java.io.File;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class NetClientImport {

	public void importCommand(String nameFile, String auth){
		try {
			URL url = new URL("https://n3phele-dev.appspot.com/resources/command/import");
			
			@SuppressWarnings("resource")
			HttpClient client = new DefaultHttpClient();
			
			HttpPost post = new HttpPost(url.toURI());
			post.addHeader("Authorization","Basic " + auth);
			MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			
			File fileName = new File(System.getProperty("user.dir")+"/"+nameFile);
			// For File parameters
			entity.addPart(new FormBodyPart("file",new FileBody(fileName)));
			// For usual String parameters
			entity.addPart("file", new FileBody(fileName, "application/octet-stream"));
			post.setEntity(entity);
			System.out.println(entity.getContentType());
			System.out.println(entity.getContentLength());
			// Here we go!
			HttpResponse response = client.execute(post);
			System.out.println(response + "\n");
			client.getConnectionManager().shutdown();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}