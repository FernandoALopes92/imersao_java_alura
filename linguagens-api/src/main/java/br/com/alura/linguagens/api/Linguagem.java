package br.com.alura.linguagens.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "principaisLinguagens")
public class Linguagem implements Comparable<Linguagem>{
    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;

    public Linguagem() {

    }

    public Linguagem(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getRanking() {
        return ranking;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public int compareTo(Linguagem Outralinguagem) { //Listar em ordem de ranking

            if (this.ranking < Outralinguagem.getRanking()) {
                return -1;
            }
            if (this.ranking > Outralinguagem.getRanking()) {
                return 1;
            }
            return 0;
    }
}
