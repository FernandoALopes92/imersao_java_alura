import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception{

        // fazer uma conexão HTTP e buscar

        //fILmes
        //String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        //ExtratoDeConteudoIMDB extrator = new ExtratoDeConteudoIMDB();

        //Nasa
        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-07-10&end_date=2022-07-15";
        //ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();

        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudoLinguagens extrator = new ExtratorDeConteudoLinguagens();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

      //exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extrairConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

           for(int i = 0; i < 5; i++){

              Conteudo conteudo = conteudos.get(i);

              InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
              String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

              geradora.cria(inputStream, nomeArquivo);

              System.out.println(conteudo.getTitulo());
              System.out.println();
           }

    }
}
