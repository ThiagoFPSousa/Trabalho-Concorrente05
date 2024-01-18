/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 23/11/2023 (23 de Novembro de 2023).
* Ultima alteracao.: 03/12/2023 (03 de Dezembro de 2023).
* Nome.............: Principal.java
* Funcao...........: Inicializa e configura a interface grafica
da aplicacao de Carros Automatos. Este metodo e o ponto de entrada
da aplicacao JavaFX, onde a hierarquia de elementos da interface e
carregada a partir de um arquivo FXML, definindo propriedades da
janela, como titulo, tamanho e comportamento de fechamento. Tambem
aplica um estilo CSS a cena e configura acoes de encerramento da
aplicacao ao fechar a janela principal.
*************************************************************** */
//Importacoes Necessarias.
import controller.ControllerAutomato;// Importando a classe de controlador, para interagir com a interface.
import javafx.application.Application;// Importando a classe base para iniciar a aplicacao JavaFX.
import javafx.application.Platform;// Importando a classe Platform para interacao com a plataforma JavaFX.
import javafx.fxml.FXMLLoader;// Importando a classe FXMLLoader para carregar arquivos FXML.
import javafx.scene.image.Image;// Importando a classe Image para trabalhar com imagens.
import javafx.scene.Parent;// Importando a classe Parent, que e a raiz da hierarquia de elementos da interface grafica.
import javafx.scene.Scene;// Importando a classe Scene, que representa o conteiner principal para os elementos da interface grafica.
import javafx.stage.Stage;// Importando a classe Stage, que é a janela principal da aplicacao.


public class Principal extends Application {

/* ***************************************************************
* Metodo: start
* Funcao: Ponto de entrada da aplicacao JavaFX. Pode lançar uma excecao "IOException".
* Parametros: stage (Do tipo array de "Stage", que representa a janela principal da aplicacao).
* Retorno: nenhum (void).
*************************************************************** */
  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("view/TelaControllerAutomato.fxml"));// carregando o arquivo fisico e carregando estrutura.
    Scene scene = new Scene(root);// criando uma cena.
    stage.setScene(scene);// atribui cena para a janela.
    stage.setWidth(800);// setando o tamanho da janela.
    stage.setHeight(600);// setando o tamanho da janela.
    stage.setResizable(false);// proibindo o usuario de redimencionar tela.
    stage.setTitle("Carros Automatos");// configurando o titulo da tela.
    scene.getStylesheets().add("view/EstiloAutomato.css");// carregando o arquivo css.
    stage.getIcons().add(new Image("resources/img/Icon.png"));// carregando uma imagem e atribuindo um icon na janela.
    stage.setOnCloseRequest(t -> {// Define o comportamento de fechamento da janela.
      Platform.exit();// Encerra a plataforma JavaFX.
      System.exit(0);// Encerra o aplicativo Java.
    });
    stage.show();// mostrando janela.
  }

/* ***************************************************************
* Metodo: main
* Funcao: Ponto de entrada da aplicacao Java.
* Parametros: args (Do tipo array de "strings", que pode conter argumentos da linha de comando).
* Retorno: nenhum (void).
*************************************************************** */
  public static void main(String[] args) {
    launch(args);
  }
}