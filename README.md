# Imersão Java Alura <img src="./img-readme/java_32x32.png">

[![GitHub license](https://img.shields.io/github/license/FernandoALopes92/imersao_java_alura)](https://github.com/FernandoALopes92/imersao_java_alura/blob/main/LICENSE)
![!Badge Parte 1 - Concluída](https://img.shields.io/badge/Parte%201-Conclu%C3%ADda-green)

<hr>
<img src="./img-readme/tela_inicial.png">
<hr>
### Projeto criado na semana de Imersão Java Alura. O projeto foi desenvolvido na plataforma intelliJ, utilizamos como ecossistema o Spring,integrando com o MongoDb e Heroku como cloud, para o frontend utilizei NodeJs e Bootstrap
O CRUD está funcionando no backend, faltando implementar no frontend (Parte a desenvolver)
<hr>


### **Temas Abordados:**

<!--ts-->
   * [Aula 01 - Consumindo uma api de filmes com Java](#aula01)
   * [Aula 02 - Gerando figurinhas para whatsapp](#aula02)
   * [Aula 03 - Ligando as pontas, refatoração e orientação a objetos](#aula03)
   * [Aula 04 - Criando nossa própria api com Spring](#aula04)
   * [Aula 05 - Publicando nossa api no cloud](#aula05) 
<!--te-->
<hr>

### ✔️ **Tecnologias Utilizadas**
- Java
- InteliJ IDEA
- Paradigma de orientação a objetos
- Spring
- MongoDB
- Postman
- Cloud Heroku
- NodeJs
- Bootstrap
<hr>


 **<p id="aula01">Aula 01 - Consumindo uma api de filmes com Java<p>** 

Api's Alternantivas ao IMDB

- (https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060) criada pelo @rezendecas
- (https://alura-imdb-api.herokuapp.com/movies) criada pelo Jhon Santana

*Opção para criação no Visual Studio

- Install Visual Studio Code for Java

https://code.visualstudio.com/docs/languages/java#_install-visual-studio-code-for-java

No visual Studio:

- ctrl + shift + p
- Java Create Java project
- opção: No build tools

**links úteis**

 https://www.alura.com.br/artigos/desenvolvendo-aplicacoes-java-vs-code

<hr>

**<p id="aula02">Aula 02 - Gerando figurinhas para whatsapp<p>**

**links úteis**

- Java Polimorfismo: entenda herança e interfaces - Alura

https://www.alura.com.br/conteudo/java-heranca-interfaces-polimorfismo

- Java e Orientação a Objetos - Alura

https://www.alura.com.br/apostila-java-orientacao-objetos/apendice-pacote-java-io
<hr>

**<p id="aula03">Aula 03 - Ligando as pontas, refatoração e orientação a objetos<p>**

Consumindo uma nova Api

- Api Nasa

https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-07-10&end_date=2022-07-15

- Apis - Alternativas caso a da Nasa não Funcione

https://api.mocki.io/v2/549a5d8b/NASA-APOD

https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json

Separando o código em clases (Refatoração)

**links úteis**
- Como não aprender Java e Orientação a Objetos: getters e setters - Alura

https://www.alura.com.br/artigos/nao-aprender-oo-getters-e-setters

<hr>

**<p id="aula04">Aula 04 - Criando nossa própria api com Spring<p>**

**Spring:** 

- Documentação: https://spring.io/
- Iniciar um Projeto (**Spring initializr**): https://start.spring.io/


**Configuração inicial (Spring boot):** 

<img src="./img-readme/spring_config.png">

- clicar em GENERATE

- Irá gerar um zip, é necessário extrair, mova a pasta para um outro local

- Abrir com IntelliJ


**MongoDB:** 

https://www.mongodb.com/cloud/atlas/register

- Criar Conta

- Criar new project

- Clicar em collections e Add My Own Data

- Em create Database:   
    - ***Database name:*** aluraDB  
    - ***Collection name:*** principaisLinguagens
    - Clicar em **Create**.


**Criando o banco, clicar em *INSERT DOCUMENT*:**

-  Clicar nas chaves e inserir os dados em formato JSON.

**Pegando connection string:**

- Em Overview ir CONNECT, e Connect your application, copie a connection string.

- Na aplicação dentro da pasta **resources**, ir  em **application.properties** colar a string de conexão


**Conectando o banco de dados com a aplicação**
 
- Ir no site **Spring initializr**
- Procurar dependência **"Spring Data MongoDB"**
-Colar o seguinte código nas dependências no arquivo **pom.xml**
    
        <dependency>
        <groupId>org.springframework.boot</groupId>
    
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>

- Baixar as novas dependências

-  Voltando em **application.properties**, digitar as seguintes informações:

        spring.data.mongodb.uri = mongodb+srv://FernandoLopes92:<SENHA>@cluster0.xtgbf1l.mongodb.net/aluraDB?retryWrites=true&w=majority


- Consumir api's no POSTMAN

**links úteis**

- Maven: (caso necessário, IntelliJ já tem)

https://maven.apache.org/download.cgi - 

- Postman:

 https://www.postman.com/

- GitHub com logos das linguagens de programação

https://github.com/abrahamcalf/programming-languages-logos

**Desafios Concluídos**

- Completar o Crud
- Trazer arrayList em ordem de ranking
- Retornar o status 201 quando um recurso (linguagem, no nosso caso) for cadastrado através do POST;


<hr>

**<p id="aula05">Aula 05 - Publicando nossa api no cloud<p>**

Spring Já tem um teste -Executar o script, baixar os jars, compilar testes, gerar um jar com a aplicação (Napasta Target)

    ./mvnw package

Subir aplicação a partir do Jar

    java -jar nome do jar (linguagens-api-0.0.1-SNAPSHOT.jar

Fazer deployed Heroku
- Create new app
- nome: alura-linguagens-api
- region(padrão)

instalar Heroku CLI ( irá abrir o navegador para logar)

    heroku login 

Configurar um repositorio remoto Heroku.

    heroku git:remote -a alura-linguagens-api

Gravar os dados no repositorio

    git push heroku main

Vai dar erro de versão ideal é Criar o arquivo abaixo antes de mandar para o cloud)

Criar arquivo system.properties na raiz do projeto com o seguinte código:

    java.runtime.version = 17

Subir de novo

    git add system.properties
    git commit -m "configurando versão java no heroku"
    git push heroku main

Gerou jar e o link com repositorio Heroku

Na aplicação Mudar a string url para a nova

No Postman colocar link(metodo post) - Cadastrar


