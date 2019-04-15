import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class Ex1Teste {
	
	public static void main(String args[]) {
		
		imprimirTexto("Turma!");
		somar(20, 3);
		
	}
	
	private static void 	imprimirTexto(String texto) {
		
		try {
			URL url = new URL("http://localhost:8080/Rest/rest/helloworld/show=" + texto);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("ERRO: " + conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String output;
			System.out.println("Saída: \n");
			while ((output = br.readLine()) != null ) {
				System.out.println(output);
			}
			
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void somar(int a, int b) {
		try {
			URL url = new URL("http://localhost:8080/Rest/rest/helloworld/somar/" + a +"/" + b);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200 ) {
				throw new RuntimeException("ERRO: " + conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String output;
			System.out.println("\nSaída: \n");
			while((output = br.readLine()) != null) {
				System.out.println(output);
			}
			
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
