/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 23/11/2023 (23 de Novembro de 2023).
* Ultima alteracao.: 03/12/2023 (03 de Dezembro de 2023).
* Nome.............: Percursos.java
* Funcao...........: Esta classe abstrata serve como base para
implementacoes de threads que movem carros em diferentes direcoes
dentro de uma interface grafica. Ela contém metodos para mover os
carros para a direita, esquerda, cima e baixo, alem de controlar a
velocidade desses movimentos. Utiliza a biblioteca JavaFX para
manipulacao de elementos graficos como ImageView, Slider e Label,
garantindo interacao e atualizacao visual enquanto os carros se
movem na simulacao.
*************************************************************** */
package thread;

import javafx.application.Platform;// Importando a classe Platform para interacao com a plataforma JavaFX.
import javafx.scene.control.Label;// Importacao para a classe 'Label' do JavaFX, usada para criar label(textos).
import javafx.scene.control.Slider;// Importacao para a classe 'Slider' do JavaFX, usada para criar controles deslizantes.
import javafx.scene.image.ImageView;// Importacao para a classe 'ImageView' do JavaFX, usada para exibir imagens em uma interface grafica.

public abstract class Percursos extends Thread {
  protected int carroPosicaoX;// Posicao do carro em x.
  protected int carroPosicaoY;// Posicao do carro em y.
  protected ImageView carro;// ImageView para o carro.
  protected int velocidade = 25;// Velocidade inicial do carro.
  protected Slider sliderVelocidade;// Slider para controlar velocidade.
  protected Label labelVelocidade;// Label para informar a velocidade.

/* ***************************************************************
* Metodo: Percursos.
* Funcao: Controlador.
* Parametros: ImageView carro, Slider sliderVelocidade, Label labelVelocidade, int x, int y, int r.
* Retorno: nenhum.
*************************************************************** */
  public Percursos(ImageView carro, Slider sliderVelocidade, Label labelVelocidade, int x, int y, int r) {
    this.carro = carro;
    this.sliderVelocidade = sliderVelocidade;
    this.labelVelocidade = labelVelocidade;
    carro.setLayoutX(x);
    carro.setLayoutY(y);
    carro.setRotate(r);
    mudarVelocidade(sliderVelocidade);
  }

/* ***************************************************************
* Metodo: run.
* Funcao: Define o comportamento da thread.
* Parametros: nenhum.
* Retorno: nenhum.
*************************************************************** */
  @Override
  public void run() {

  }

/* ***************************************************************
* Metodo: irDireita.
* Funcao: Mover o carro para a direita.
* Parametros: int PosicaoDeParada - ate onde o carro deve ir/onde deve parar.
* Retorno: nenhum.
*************************************************************** */
  protected void irDireita(int PosicaoDeParada) throws InterruptedException {
    carroPosicaoX = (int) carro.getLayoutX();
    PosicaoDeParada -= 20;
    while (carroPosicaoX < PosicaoDeParada) {
      sleep(velocidade);
      carroPosicaoX++;
      Platform.runLater(() -> carro.setLayoutX(carroPosicaoX));
    }
  }

/* ***************************************************************
* Metodo: irEsquerda.
* Funcao: Mover o carro para a esquerda.
* Parametros: int PosicaoDeParada - ate onde o carro deve ir/onde deve parar.
* Retorno: nenhum.
*************************************************************** */
  protected void irEsquerda(int PosicaoDeParada) throws InterruptedException {
    carroPosicaoX = (int) carro.getLayoutX();
    while (carroPosicaoX > PosicaoDeParada) {
      sleep(velocidade);
      carroPosicaoX--;
      Platform.runLater(() -> carro.setLayoutX(carroPosicaoX));
    }
  }

/* ***************************************************************
* Metodo: irDescida.
* Funcao: Mover o carro para baixo.
* Parametros: int PosicaoDeParada - ate onde o carro deve ir/onde deve parar.
* Retorno: nenhum.
*************************************************************** */
  protected void irDescida(int PosicaoDeParada) throws InterruptedException {
    carroPosicaoY = (int) carro.getLayoutY();
    PosicaoDeParada -= 20;
    while (carroPosicaoY < PosicaoDeParada) {
      sleep(velocidade);
      carroPosicaoY++;
      Platform.runLater(() -> carro.setLayoutY(carroPosicaoY));
    }
  }

/* ***************************************************************
* Metodo: irSubida.
* Funcao: Mover o carro para cima.
* Parametros: int PosicaoDeParada - ate onde o carro deve ir/onde deve parar.
* Retorno: nenhum.
*************************************************************** */
  protected void irSubida(int PosicaoDeParada) throws InterruptedException {
    carroPosicaoY = (int) carro.getLayoutY();
    while (carroPosicaoY > PosicaoDeParada) {
      sleep(velocidade);
      carroPosicaoY--;
      Platform.runLater(() -> carro.setLayoutY(carroPosicaoY));
    }
  }

/* ***************************************************************
* Metodo: mudarVelocidade.
* Funcao: Atualiza a velocidade do carro com base no valor do controle deslizante (Slider).
* Parametros: Slider sliderVelocidade - o controle deslizante que controla a velocidade do carro.
* Retorno: nenhum.
*************************************************************** */
  public void mudarVelocidade(Slider sliderVelocidade) {
    sliderVelocidade.valueProperty().addListener((observable, oldValue, newValue) -> {
    velocidade = newValue.intValue();
    labelVelocidade.setText(String.valueOf(500/velocidade));
    });
  }
}