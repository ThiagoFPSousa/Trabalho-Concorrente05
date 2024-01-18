/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 23/11/2023 (23 de Novembro de 2023).
* Ultima alteracao.: 03/12/2023 (03 de Dezembro de 2023).
* Nome.............: CarroMarrom.java
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

public class CarroMarrom extends Percursos{

/* ***************************************************************
* Metodo: CarroMarrom.
* Funcao: Controlador.
* Parametros: ImageView carro, Slider sliderVelocidade, Label labelVelocidade.
* Retorno: nenhum.
*************************************************************** */
  public CarroMarrom(ImageView carro, Slider sliderVelocidade, Label labelVelocidade){
    super(carro, sliderVelocidade, labelVelocidade, 588, 18, 0);
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
      Semaforos.ruasVerticais6[0].acquire();
    }catch(InterruptedException e){}
    while (true) {
      try {
        //DESCIDA
        irDescida(109);
        Semaforos.ruasVerticais6[1].acquire();
        irDescida(157);
        Semaforos.ruasVerticais6[0].release();
        irDescida(225);
        Semaforos.plus1.acquire();
        Semaforos.ruasHorizontais3[4].acquire();
        irDescida(249);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(563);
        Semaforos.ruasVerticais6[1].release();
        irEsquerda(492);
        Semaforos.plus4.acquire();
        Semaforos.ruasVerticais5[2].acquire();
        irEsquerda(465);
        //DESCIDA
        carro.setRotate(0);
        irDescida(274);
        Semaforos.ruasHorizontais3[4].release();
        irDescida(340);
        Semaforos.ruasHorizontais4[3].acquire();
        Semaforos.brancoMarromCruzamento1.acquire();
        irDescida(364);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(439);
        Semaforos.ruasVerticais5[2].release();
        Semaforos.brancoMarromCruzamento1.release();
        Semaforos.plus1.release();
        irEsquerda(376);
        Semaforos.ruasVerticais4[3].acquire();
        irEsquerda(350);
        //DESCIDA
        carro.setRotate(0);
        irDescida(388);
        Semaforos.ruasHorizontais4[3].release();
        Semaforos.plus4.release();
        irDescida(455);
        Semaforos.ruasHorizontais5[2].acquire();
        irDescida(480);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(325);
        Semaforos.ruasVerticais4[3].release();
        irEsquerda(260);
        Semaforos.ruasVerticais3[4].acquire();
        irEsquerda(234);
        //DESCIDA
        carro.setRotate(0);
        irDescida(505);
        Semaforos.ruasHorizontais5[2].release();
        irDescida(570);
        Semaforos.ruasHorizontais6[1].acquire();
        irDescida(596);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(209);
        Semaforos.ruasVerticais3[4].release();
        irEsquerda(145);
        Semaforos.ruasHorizontais6[0].acquire();
        irEsquerda(94);
        Semaforos.ruasHorizontais6[1].release();
        irEsquerda(26);
        Semaforos.ruasVerticais1[4].acquire();
        irEsquerda(0);
        //SUBIDA
        carro.setRotate(180);
        irSubida(552);
        Semaforos.ruasHorizontais6[0].release();
        irSubida(485);
        Semaforos.plus8.acquire();
        Semaforos.ruasVerticais1[3].acquire();
        irSubida(435);
        Semaforos.ruasVerticais1[4].release();
        irSubida(368);
        Semaforos.ruasHorizontais4[0].acquire();
        irSubida(344);
        //DIREITA
        carro.setRotate(-90);
        irDireita(46);
        Semaforos.ruasVerticais1[3].release();
        irDireita(113);
        Semaforos.ruasVerticais2[2].acquire();
        irDireita(139);
        //SUBIDA
        carro.setRotate(180);
        irSubida(320);
        Semaforos.ruasHorizontais4[0].release();
        Semaforos.plus8.release();
        irSubida(253);
        Semaforos.plus3.acquire();
        Semaforos.ruasHorizontais3[1].acquire();
        Semaforos.brancoMarromCruzamento2.acquire();
        irSubida(229);
        //DIREITA
        carro.setRotate(-90);
        irDireita(165);
        Semaforos.ruasVerticais2[2].release();
        Semaforos.brancoMarromCruzamento2.release();
        irDireita(229);
        Semaforos.ruasVerticais3[1].acquire();
        Semaforos.marromRoxoCruzamento.acquire();
        irDireita(254);
        //SUBIDA
        carro.setRotate(180);
        irSubida(204);
        Semaforos.ruasHorizontais3[1].release();
        Semaforos.marromRoxoCruzamento.release();
        Semaforos.plus3.release();
        irSubida(137);
        irSubida(113);
        //DIREITA
        carro.setRotate(-90);
        irDireita(280);
        Semaforos.ruasVerticais3[1].release();
        irDireita(345);
        Semaforos.ruasVerticais4[0].acquire();
        irDireita(370);
        //SUBIDA
        carro.setRotate(180);
        irSubida(89);
        irSubida(19);
        Semaforos.ruasHorizontais1[3].acquire();
        irSubida(-5);
        //DIREITA
        carro.setRotate(-90);
        irDireita(395);
        Semaforos.ruasVerticais4[0].release();
        irDireita(460);
        Semaforos.ruasHorizontais1[4].acquire();
        irDireita(511);
        Semaforos.ruasHorizontais1[3].release();
        irDireita(583);
        Semaforos.ruasVerticais6[0].acquire();
        irDireita(608);
        //DESCIDA
        carro.setRotate(0);
        irDescida(38);
        Semaforos.ruasHorizontais1[4].release();
      } catch (InterruptedException e) {
      } 
    }
  } 
}