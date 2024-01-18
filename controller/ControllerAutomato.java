/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 23/11/2023 (23 de Novembro de 2023).
* Ultima alteracao.: 03/12/2023 (03 de Dezembro de 2023).
* Nome.............: ControllerAutomato.java
* Funcao...........: Controla a lagica e a interacao da interface
grafica da aplicacao "Carros Automatos". Esta classe manipula os
elementos graficos, como botoes, imagens e controles deslizantes,
alem de instanciar e gerenciar as threads responsaveis pela simulacao
dos carros. Inicializa a interface e define a visibilidade inicial dos
elementos,alem de fornecer metodos para iniciar a simulacao, pausar ou
dar play nos carros,controlar a visibilidade dos percursos e redefinir
a simulacao para seu esta do inicial.
*************************************************************** */
package controller;

//Importacoes Necessarias.
import model.*;// Importando as classes de model.
import thread.*;// Importando as classes de threads.
import java.net.URL;// Importacao necessaria para trabalhar com URLs, que podem ser uteis para carregar recursos ou interagir com a internet.
import java.util.ResourceBundle;// Importacao necessaria para trabalhar com pacotes de recursos (resource bundles), que sao usados para internacionalizar aplicativos.
import javafx.event.ActionEvent;// Importacao para a classe 'ActionEvent' do JavaFX, usada para lidar com eventos de açao, como cliques de botao.
import javafx.fxml.FXML;// Importacao para a anotacao 'FXML', usada para injetar elementos do arquivo FXML no codigo Java.
import javafx.scene.control.Label;// Importacao para a classe 'Label' do JavaFX, usada para criar label(textos).
import javafx.fxml.Initializable;// Importacao para a interface 'Initializable', que requer a implementação de um metodo 'initialize'.
import javafx.scene.control.Button;// Importacao para a classe 'Button' do JavaFX, usada para criar botoes clicaveis.
import javafx.scene.control.Slider;// Importacao para a classe 'Slider' do JavaFX, usada para criar controles deslizantes.
import javafx.scene.image.Image;// Importacao para a classe 'Image' do JavaFX, usada para trabalhar com imagens.
import javafx.scene.image.ImageView;// Importacao para a classe 'ImageView' do JavaFX, usada para exibir imagens em uma interface grafica.
import javafx.scene.layout.AnchorPane;// Importacao para a classe 'AnchorPane' do JavaFX, que e um layout que permite ancorar elementos de interface em relacao a bordas ou outros elementos.


public class ControllerAutomato implements Initializable {
  // ---------------------------------- ATRIBUTOS----------------------------------//
  // AnchorPane
  @FXML
  private AnchorPane anchorPaneGeral, anchorPaneInicial, anchorPanePrincipal;
  //Label
  @FXML
  private Label labelVermelho, labelAzul, labelVerde, labelLaranja, labelBranco, labelMarrom, labelAmarelo, labelRoxo;
  // ImagemView
  @FXML
  private ImageView imgBackgroundInicial, imgPlayInicial, imgBackgroundTransito, imgResetar;
  @FXML
  private ImageView imgPlayVermelho, imgPlayAzul, imgPlayVerde, imgPlayLaranja, imgPlayBranco, imgPlayMarrom, imgPlayAmarelo, imgPlayRoxo;
  @FXML
  private ImageView imgViewVermelho, imgViewAzul, imgViewVerde, imgViewLaranja, imgViewBranco, imgViewMarrom, imgViewAmarelo, imgViewRoxo;
  @FXML
  private ImageView imgPercursoVermelho, imgPercursoAzul, imgPercursoVerde, imgPercursoLaranja, imgPercursoBranco, imgPercursoMarrom, imgPercursoAmarelo, imgPercursoRoxo;
  @FXML
  private ImageView imgCarroVermelho, imgCarroAzul, imgCarroVerde, imgCarroLaranja, imgCarroBranco, imgCarroMarrom, imgCarroAmarelo, imgCarroRoxo;
  // Button
  @FXML
  private Button btnIniciar, btnResetar;
  @FXML
  private Button btnPlayVermelho, btnPlayAzul, btnPlayVerde, btnPlayLaranja, btnPlayBranco, btnPlayMarrom, btnPlayAmarelo, btnPlayRoxo;
  @FXML
  private Button btnViewVermelho, btnViewAzul, btnViewVerde, btnViewLaranja, btnViewMarrom, btnViewBranco, btnViewAmarelo, btnViewRoxo;
  // Slider
  @FXML
  private Slider sliderVermelho, sliderAzul, sliderVerde, sliderLaranja, sliderBranco, sliderMarrom, sliderAmarelo, sliderRoxo;
  //Threads
  private Percursos[] carro = new Percursos[8];

/* ***************************************************************
* Metodo: initialize
* Funcao: Inicializa a interface e define a visibilidade inicial dos elementos.
* Parametros: location (URL do local do arquivo de FXML), resources (Pacote de recursos).
* Retorno: nenhum (void).
*************************************************************** */
  @Override
  public void initialize(URL location, ResourceBundle resource) {
    anchorPaneGeral.setVisible(true);
    anchorPaneInicial.setVisible(true);
    anchorPanePrincipal.setVisible(false);
  }


/* ***************************************************************
* Metodo: iniciar.
* Funcao: Iniciar a simulacao do "Carros Automatos"instanciando as threads e dando start.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: nenhum (void).
*************************************************************** */
  @FXML
  public void iniciar(ActionEvent event) {
    anchorPaneInicial.setVisible(false);
    anchorPanePrincipal.setVisible(true);
    carro[0] = new CarroVermelho(imgCarroVermelho, sliderVermelho, labelVermelho);
    carro[1] = new CarroAzul(imgCarroAzul, sliderAzul, labelAzul);
    carro[2] = new CarroVerde(imgCarroVerde, sliderVerde, labelVerde);
    carro[3] = new CarroLaranja(imgCarroLaranja, sliderLaranja, labelLaranja);
    carro[4] = new CarroBranco(imgCarroBranco, sliderBranco, labelBranco);
    carro[5] = new CarroMarrom(imgCarroMarrom, sliderMarrom, labelMarrom);
    carro[6] = new CarroAmarelo(imgCarroAmarelo, sliderAmarelo, labelAmarelo);
    carro[7] = new CarroRoxo(imgCarroRoxo, sliderRoxo, labelRoxo);
    for(int i=0; i<8; i++){
      carro[i].start(); 
    }
  }

  @FXML
  private int cont[] = {0, 0, 0, 0, 0, 0, 0, 0};// Vetor contador para o botao de pause.
 
/* ***************************************************************
* Metodo: pausar.
* Funcao: Pausar ou dar play nos carros e mudar img dos botoes, dependendo de qual botao for apertado.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: nenhum (void).
*************************************************************** */ 
  @FXML
  public void pausar(ActionEvent event) {
    // Realiza a acao de acordo ao botao clicado.
    if(event.getSource().equals(btnPlayVermelho)){
      cont[0]++;// incrementa cont[0].
      imgPlayVermelho.setImage(mudarImagemPlay(cont[0]));// Altera imagem do botao de pause.
      pausa(cont[0], 0);
    }else
    if(event.getSource().equals(btnPlayAzul)){
      cont[1]++;// incrementa cont[1].
      imgPlayAzul.setImage(mudarImagemPlay(cont[1]));// Altera imagem do botao de pause.
      pausa(cont[1], 1);
    }else
    if(event.getSource().equals(btnPlayVerde)){
      cont[2]++;// incrementa cont[2].
      imgPlayVerde.setImage(mudarImagemPlay(cont[2]));// Altera imagem do botao de pause.
      pausa(cont[2], 2);
    }else
    if(event.getSource().equals(btnPlayLaranja)){
      cont[3]++;// incrementa cont[3].
      imgPlayLaranja.setImage(mudarImagemPlay(cont[3]));// Altera imagem do botao de pause.
      pausa(cont[3], 3);
    }else
    if(event.getSource().equals(btnPlayBranco)){
      cont[4]++;// incrementa cont[4].
      imgPlayBranco.setImage(mudarImagemPlay(cont[4]));// Altera imagem do botao de pause.
      pausa(cont[4], 4);
    }else
    if(event.getSource().equals(btnPlayMarrom)){
      cont[5]++;// incrementa cont[5].
      imgPlayMarrom.setImage(mudarImagemPlay(cont[5]));// Altera imagem do botao de pause.
      pausa(cont[5], 5);
    }else
    if(event.getSource().equals(btnPlayAmarelo)){
      cont[6]++;// incrementa cont[6].
      imgPlayAmarelo.setImage(mudarImagemPlay(cont[6]));// Altera imagem do botao de pause.
      pausa(cont[6], 6);
    }else
    if(event.getSource().equals(btnPlayRoxo)){
      cont[7]++;// incrementa cont[7].
      imgPlayRoxo.setImage(mudarImagemPlay(cont[7]));// Altera imagem do botao de pause.
      pausa(cont[7], 7);
    }
  }

/* ***************************************************************
* Metodo: pausa.
* Funcao: Pausar ou dar play.
* Parametros: int cont - para definir se deve pausar ou dar play, int i - carro que sofre a acao.
* Retorno: nenhum (void).
*************************************************************** */ 
  @SuppressWarnings("deprecation")
  public void pausa(int cont, int i){
    if (cont % 2 == 0) {
      carro[i].resume();
    } else {
      carro[i].suspend();
    }
  }

/* ***************************************************************
* Metodo: mudarImagemPlay
* Funcao: Mudar img do botao play.
* Parametros: int cont - para definir para qual img mudar.
* Retorno: Image - img do botao play.
*************************************************************** */
  public Image mudarImagemPlay(int cont){
    Image imagemPlay;
    // Verifica se o contador e par ou impar.
    if (cont % 2 == 0) {
      imagemPlay = new Image("/resources/img/imgButtons/iconPause.png");// Se o contador cont for par, ele atribui a imagem "iconPause.png" a variavel imagemPlay.
    } else {
      imagemPlay = new Image("/resources/img/imgButtons/iconPlay.png");// Se o contador cont for par, ele atribui a imagem "iconPlay.png" a variavel imagemPlay.
    }
    return imagemPlay;
  }

  @FXML
  private int contPercurso[] = {0, 0, 0, 0, 0, 0, 0, 0};// Vetor contador para o botao de visibilidade.
  
  private boolean valor[] = {false, false, false, false, false, false, false, false};// Vetor valor para setar a visibilidade do percurso.
  
/* ***************************************************************
* Metodo: visualizarPercurso
* Funcao: Mudar img do botao visibilidade e tornar ou nao visivel o percurso.
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: nenhum (void).
*************************************************************** */
  @FXML
  public void visualizarPercurso(ActionEvent event) {
    // Realiza a acao de acordo ao botao clicado.
    if(event.getSource().equals(btnViewVermelho)){
      contPercurso[0]++;// Incrementa contPercurso[0].
      imgViewVermelho.setImage(visibilidadePercurso(contPercurso[0]));// Altera imagem da visibilidade do percurso.
      valor[0] = !valor[0];// Alterna o valor (true <=> false) da variavel.
      imgPercursoVermelho.setVisible(valor[0]);// Seta a visibilidade do percurso.
    }else
    if(event.getSource().equals(btnViewAzul)){
      contPercurso[1]++;//incrementa contPercurso[1].
      imgViewAzul.setImage(visibilidadePercurso(contPercurso[1]));// Altera imagem da visibilidade do percurso.
      valor[1] = !valor[1];// Alterna o valor (true <=> false) da variavel.
      imgPercursoAzul.setVisible(valor[1]);// Seta a visibilidade do percurso.
    }else
    if(event.getSource().equals(btnViewVerde)){
      contPercurso[2]++;//incrementa contPercurso[2].
      imgViewVerde.setImage(visibilidadePercurso(contPercurso[2]));// Altera imagem da visibilidade do percurso.
      valor[2] = !valor[2];// Alterna o valor (true <=> false) da variavel.
      imgPercursoVerde.setVisible(valor[2]);// Seta a visibilidade do percurso.
    }else
    if(event.getSource().equals(btnViewLaranja)){
      contPercurso[3]++;//incrementa contPercurso[3].
      imgViewLaranja.setImage(visibilidadePercurso(contPercurso[3]));// Altera imagem da visibilidade do percurso.
      valor[3] = !valor[3];// Alterna o valor (true <=> false) da variavel.
      imgPercursoLaranja.setVisible(valor[3]);// Seta a visibilidade do percurso.
    }else
    if(event.getSource().equals(btnViewBranco)){
      contPercurso[4]++;//incrementa contPercurso[4].
      imgViewBranco.setImage(visibilidadePercurso(contPercurso[4]));// Altera imagem da visibilidade do percurso.
      valor[4] = !valor[4];// Alterna o valor (true <=> false) da variavel.
      imgPercursoBranco.setVisible(valor[4]);// Seta a visibilidade do percurso.
    }else
    if(event.getSource().equals(btnViewMarrom)){
      contPercurso[5]++;//incrementa contPercurso[5].
      imgViewMarrom.setImage(visibilidadePercurso(contPercurso[5]));// Altera imagem da visibilidade do percurso.
      valor[5] = !valor[5];// Alterna o valor (true <=> false) da variavel.
      imgPercursoMarrom.setVisible(valor[5]);// Seta a visibilidade do percurso.
    }else
    if(event.getSource().equals(btnViewAmarelo)){
      contPercurso[6]++;//incrementa contPercurso[6].
      imgViewAmarelo.setImage(visibilidadePercurso(contPercurso[6]));// Altera imagem da visibilidade do percurso.
      valor[6] = !valor[6];// Alterna o valor (true <=> false) da variavel.
      imgPercursoAmarelo.setVisible(valor[6]);// Seta a visibilidade do percurso.
    }else
    if(event.getSource().equals(btnViewRoxo)){
      contPercurso[7]++;//incrementa contPercurso[7].
      imgViewRoxo.setImage(visibilidadePercurso(contPercurso[7]));// Altera imagem da visibilidade do percurso.
      valor[7] = !valor[7];// Alterna o valor (true <=> false) da variavel.
      imgPercursoRoxo.setVisible(valor[7]);// Seta a visibilidade do percurso.
    }
  }

/* ***************************************************************
* Metodo: visibilidadePercurso
* Funcao: Mudar img do botao visibilidade.
* Parametros: int cont - para definir para qual img mudar.
* Retorno: Image - img do botao visibilidade.
*************************************************************** */
  public Image visibilidadePercurso(int cont){
    Image imagemVisibilidade;
    // Verifica se o contador e par ou impar.
    if (cont % 2 == 0) {
      imagemVisibilidade = new Image("/resources/img/imgButtons/visivel.png");//Se o contador cont for par, ele atribui a imagem "invisivel.png" a variavel imagemVisibilidade.
    } else {
      imagemVisibilidade = new Image("/resources/img/imgButtons/invisivel.png");//Se o contador cont for par, ele atribui a imagem "visivel.png" a variavel imagemVisibilidade.
    }
    return imagemVisibilidade;
  }

/* ***************************************************************
* Metodo: Resetar.
* Funcao: Redefinir e reiniciar a simulacao do "Carros Automatos" para seu estado inicial. 
* Parametros: event (O evento de clique do mouse que acionou o metodo).
* Retorno: nenhum (void).
*************************************************************** */
  @FXML
  public void resetar(ActionEvent event) {
    for(int i=0; i<8; i++){
      for(int j=0; j<8; j++){
        pausa(1, j);
      }
      for(int k=0; k<8; k++){
      	carro[k].interrupt();
      }
      Semaforos.instanciarSemaforos();
      for(int l=0; l<8; l++){
        cont[l] = 0;
        contPercurso[l] = 0;
        valor[l] = false;
      }
      configuracoesIniciais();
      iniciar(event);
    }
  }

/* ***************************************************************
* Metodo: configuracoesIniciais
* Funcao: Redefinir a simulacao do "Carros Automatos" para seu estado inicial. 
* Parametros: nenhum.
* Retorno: nenhum (void).
*************************************************************** */
  public void configuracoesIniciais(){
    imgPlayVermelho.setImage(mudarImagemPlay(cont[0]));
    imgViewVermelho.setImage(visibilidadePercurso(contPercurso[0]));
    imgPercursoVermelho.setVisible(false);
    sliderVermelho.setValue(25);
    
    imgPlayAzul.setImage(mudarImagemPlay(cont[1]));
    imgViewAzul.setImage(visibilidadePercurso(contPercurso[1]));
    imgPercursoAzul.setVisible(false);
    sliderAzul.setValue(25);
    
    imgPlayVerde.setImage(mudarImagemPlay(cont[2]));
    imgViewVerde.setImage(visibilidadePercurso(contPercurso[2]));
    imgPercursoVerde.setVisible(false);
    sliderVerde.setValue(25);
    
    imgPlayLaranja.setImage(mudarImagemPlay(cont[3]));
    imgViewLaranja.setImage(visibilidadePercurso(contPercurso[3]));
    imgPercursoLaranja.setVisible(false);
    sliderLaranja.setValue(25);
    
    imgPlayBranco.setImage(mudarImagemPlay(cont[4]));
    imgViewBranco.setImage(visibilidadePercurso(contPercurso[4]));
    imgPercursoBranco.setVisible(false);
    sliderBranco.setValue(25);
    
    imgPlayMarrom.setImage(mudarImagemPlay(cont[5]));
    imgViewMarrom.setImage(visibilidadePercurso(contPercurso[5]));
    imgPercursoMarrom.setVisible(false);
    sliderMarrom.setValue(25);
    
    imgPlayAmarelo.setImage(mudarImagemPlay(cont[6]));
    imgViewAmarelo.setImage(visibilidadePercurso(contPercurso[6]));
    imgPercursoAmarelo.setVisible(false);
    sliderAmarelo.setValue(25);

    imgPlayRoxo.setImage(mudarImagemPlay(cont[7]));
    imgViewRoxo.setImage(visibilidadePercurso(contPercurso[7]));
    imgPercursoRoxo.setVisible(false);
    sliderRoxo.setValue(25);
  }
}