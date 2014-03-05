package restCalls;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONTokener;

public class NetClientJson {

	String outputState = new String();
	String outputFinalized = new String();

	public void getJson(String str, String auth) {
		HttpURLConnection conn = null;

		try {

			URL url = new URL(str);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization","Basic " + auth);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			try {
				JSONTokener tokener = new JSONTokener(conn.getInputStream());
				JSONObject root = new JSONObject(tokener);
				outputState = root.getString("state");
				outputFinalized = root.getString("finalized");
			} catch (Exception exc) {
				exc.printStackTrace();
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			conn.disconnect();
		}
	}

	public String getOutputState() {
		return outputState;
	}
	
	public String getOutputFinalized() {
		return outputFinalized;
	}
}
