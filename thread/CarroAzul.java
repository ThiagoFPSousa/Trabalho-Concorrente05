/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 23/11/2023 (23 de Novembro de 2023).
* Ultima alteracao.: 03/12/2023 (03 de Dezembro de 2023).
* Nome.............: CarroAzul.java
* Funcao...........: Esta classe representa um carro que se move
dentro de um sistema de simulacao de trafego. Ela estende a classe
abstrata Percursos, que controla o movimento dos carros em uma
interface grafica JavaFX. O carro implementa sua logica de movimento,
utilizando semaforos (classe Semaforos) para controlar o acesso as
diferentes ruas e direcoes. O carro segue um percurso definido pelas
operacoes de irDireita, irEsquerda, irDescida e irSubida, respeitando
as condicoes dos semaforos para prosseguir em cada trecho do caminho.
*************************************************************** */
package thread;

import javafx.scene.control.Slider; // Importacao para a classe 'Slider' do JavaFX, usada para criar controles deslizantes.
import javafx.scene.image.ImageView;// Importacao para a classe 'ImageView' do JavaFX, usada para exibir imagens em uma interface grafica.
import model.Semaforos;// Importando a classe de model.
import javafx.scene.control.Label;// Importacao para a classe 'Label' do JavaFX, usada para criar label(textos).

public class CarroAzul extends Percursos{

/* ***************************************************************
* Metodo: CarroAzul.
* Funcao: Controlador.
* Parametros: ImageView carro, Slider sliderVelocidade, Label labelVelocidade.
* Retorno: nenhum.
*************************************************************** */
  public CarroAzul(ImageView carro, Slider sliderVelocidade, Label labelVelocidade){
    super(carro, sliderVelocidade, labelVelocidade, 234, 19, 0);
  }

/* ***************************************************************
* Metodo: run.
* Funcao: Define o comportamento da thread.
* Parametros: nenhum.
* Retorno: nenhum.
*************************************************************** */
  @Override
  public void run(){
    try{
    sleep(1000);
    }catch(InterruptedException e){}
    try{
      Semaforos.ruasVerticais3[0].acquire();
    }catch(InterruptedException e){}
    while (true) {
      try {
        //DESCIDA
        irDescida(110);
        Semaforos.plus3.acquire();
        Semaforos.ruasVerticais3[1].acquire();
        irDescida(157);
        Semaforos.ruasVerticais3[0].release();
        irDescida(226);
        Semaforos.ruasVerticais3[2].acquire();
        Semaforos.azulVerdeCruzamento.acquire();
        irDescida(274);
        Semaforos.ruasVerticais3[1].release();
        Semaforos.azulVerdeCruzamento.release();
        Semaforos.plus3.release();
        irDescida(341);
        irDescida(364);
        //DIREITA
        carro.setRotate(-90);
        irDireita(282);
        Semaforos.ruasVerticais3[2].release();
        irDireita(345);
        Semaforos.plus4.acquire();
        Semaforos.ruasHorizontais4[3].acquire();
        Semaforos.azulLaranjaCruzamento.acquire();
        irDireita(396);
        Semaforos.azulLaranjaCruzamento.release();
        irDireita(460);
        Semaforos.plus2.acquire();
        Semaforos.ruasHorizontais4[4].acquire();
        Semaforos.azulAmareloCruzamento.acquire();
        irDireita(511);
        Semaforos.ruasHorizontais4[3].release();
        Semaforos.azulAmareloCruzamento.release();
        Semaforos.plus4.release();
        irDireita(583);
        Semaforos.ruasVerticais6[3].acquire();
        irDireita(608);
        //DESCIDA
        carro.setRotate(0);
        irDescida(389);
        Semaforos.ruasHorizontais4[4].release();
        irDescida(456);
        Semaforos.ruasVerticais6[4].acquire();
        irDescida(502);
        Semaforos.ruasVerticais6[3].release();
        Semaforos.plus2.release();
        irDescida(569);
        Semaforos.ruasHorizontais6[4].acquire();
        irDescida(596);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(564);
        Semaforos.ruasVerticais6[4].release();
        irEsquerda(490);
        Semaforos.azulAmarelo.acquire();
        Semaforos.ruasHorizontais6[3].acquire();
        irEsquerda(441);
        Semaforos.ruasHorizontais6[4].release();
        irEsquerda(376);
        Semaforos.ruasHorizontais6[2].acquire();
        irEsquerda(326);
        Semaforos.ruasHorizontais6[3].release();
        irEsquerda(260);
        Semaforos.ruasHorizontais6[1].acquire();
        irEsquerda(210);
        Semaforos.azulAmarelo.release();
        Semaforos.ruasHorizontais6[2].release();
        irEsquerda(145);
        Semaforos.ruasHorizontais6[0].acquire();
        irEsquerda(94);
        Semaforos.ruasHorizontais6[1].release();
        irEsquerda(27);
        Semaforos.ruasVerticais1[4].acquire();
        irEsquerda(0);
        //SUBIDA
        carro.setRotate(180);
        irSubida(549);
        Semaforos.ruasHorizontais6[0].release();
        irSubida(486);
        Semaforos.azulVerde.acquire();
        Semaforos.ruasVerticais1[3].acquire();
        irSubida(435);
        Semaforos.ruasVerticais1[4].release();
        irSubida(369);
        Semaforos.ruasVerticais1[2].acquire();
        irSubida(320);
        Semaforos.ruasVerticais1[3].release();
        irSubida(253);
        Semaforos.ruasVerticais1[1].acquire();
        irSubida(204);
        Semaforos.azulVerde.release();
        Semaforos.ruasVerticais1[2].release();
        irSubida(137);
        Semaforos.ruasVerticais1[0].acquire();
        irSubida(89);
        Semaforos.ruasVerticais1[1].release();
        irSubida(18);
        Semaforos.ruasHorizontais1[0].acquire();
        irSubida(-7);
        //DIREITA
        carro.setRotate(-90);
        irDireita(46);
        Semaforos.ruasVerticais1[0].release();
        irDireita(115);
        Semaforos.ruasHorizontais1[1].acquire();
        irDireita(164);
        Semaforos.ruasHorizontais1[0].release();
        irDireita(229);
        Semaforos.ruasVerticais3[0].acquire();
        irDireita(254);
        //DESCIDA
        carro.setRotate(0);
        irDescida(39);
        Semaforos.ruasHorizontais1[1].release();
      } catch (InterruptedException e) {
      } 
    }
  }
}