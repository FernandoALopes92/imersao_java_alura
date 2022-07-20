import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.lang.Math;

public class App {

    public static void main(String[] args) throws Exception{

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        //exibir e manipular os dados
        for(Map<String, String> filme : listaDeFilmes){

            Float rating;
            int estrelas;

            System.out.println("Título: "+ filme.get("title"));
            System.out.println("Poster: "+filme.get("image"));
            System.out.println("\u001b[97;1m \u001b[43;1m Classificação:  " +filme.get("imDbRating")+"\u001b[m");
            rating = Float.valueOf(filme.get("imDbRating"));
            estrelas = Math.round(rating);

            for (int indice = 1; indice <= estrelas; indice++) {
                System.out.print("\u2B50");
                //System.out.println("\u2B50");
            }
            System.out.println("\n");
        }


    }
}
