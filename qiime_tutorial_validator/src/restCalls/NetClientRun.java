package restCalls;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

@SuppressWarnings("deprecation")
public class NetClientRun {

	String locationService = null;
	String locationJsonResponse = null;
	ArrayList<JSONObject> parameters = new ArrayList<>();

	public void executeCommand(String[] args, String repositoryFolder, String json) {
		String baseURLString = "n3phele-dev.appspot.com";
		// private String charset = "UTF-8";
		@SuppressWarnings("resource")
		HttpClient client = new DefaultHttpClient();

		try {
			URIBuilder builder = new URIBuilder();
			builder.setScheme("https").setHost(baseURLString)
					.setPath("/resources/process/exec");

			for (int i = 0; i < args.length; i = i + 2) {
				try {
					builder.setParameter(args[i], args[i + 1]);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			URI uri = builder.build();

			System.out.println("URL: " + uri.toString());

			HttpPost post = new HttpPost(uri);

			post.addHeader("Authorization",
					"Basic bmlnZWwuY29vay5hdC0uaHAuY29tOmZvb2Jhcg==");
			// bmlnZWwuY29vay5hdC0uaHAuY29tOmZvb2Jhcg== NIGEL (foobar)
			// dGVzdC11c2VyLmF0LS5nbWFpbC5jb206dGVzdGl0IQ== test-user
			post.addHeader("Accept-Charset", "UTF-8");
			post.addHeader("Content-Type", "application/json");
			post.addHeader("Connection", "keep-alive");
			post.addHeader("Accept-Encoding", "gzip, deflate");

			try {
				
				post.setEntity(new StringEntity(json.toString()));
				System.out.println("---POST--- " + post);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Header[] head = null;
			HttpResponse response = client.execute(post);
			head = response.getHeaders("Location");
			if (locationService == null) {
				locationService = head[0].getValue();
			}
			locationJsonResponse = head[0].getValue();
			System.out.println(response + "\n");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
	}

	public String getLocationService() {
		return locationService;
	}

	public String getLocationJsonResponse() {
		return locationJsonResponse;
	}
}
