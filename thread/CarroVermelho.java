/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 23/11/2023 (23 de Novembro de 2023).
* Ultima alteracao.: 03/12/2023 (03 de Dezembro de 2023).
* Nome.............: CarroVermelho.java
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

public class CarroVermelho extends Percursos{

/* ***************************************************************
* Metodo: CarroVermelho.
* Funcao: Controlador.
* Parametros: ImageView carro, Slider sliderVelocidade, Label labelVelocidade.
* Retorno: nenhum.
*************************************************************** */
  public CarroVermelho(ImageView carro, Slider sliderVelocidade, Label labelVelocidade){
    super(carro, sliderVelocidade, labelVelocidade, 26, -6, -90);
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
      Semaforos.ruasHorizontais1[0].acquire();
    }catch(InterruptedException e){}
    while (true) {
      try {
        //DIREITA
        irDireita(112);
        Semaforos.ruasHorizontais1[1].acquire();
        irDireita(164);
        Semaforos.ruasHorizontais1[0].release();
        irDireita(230);
        Semaforos.vermelhoAmarelo.acquire();
        Semaforos.ruasHorizontais1[2].acquire();
        irDireita(279);
        Semaforos.ruasHorizontais1[1].release();
        irDireita(345);
        Semaforos.ruasHorizontais1[3].acquire();
        irDireita(395);
        Semaforos.ruasHorizontais1[2].release();
        irDireita(461);
        Semaforos.ruasHorizontais1[4].acquire();
        irDireita(510);
        Semaforos.vermelhoAmarelo.release();
        Semaforos.ruasHorizontais1[3].release();
        irDireita(583);
        Semaforos.ruasVerticais6[0].acquire();
        irDireita(609);
        //DESCIDA
        carro.setRotate(0);
        irDescida(38);
        Semaforos.ruasHorizontais1[4].release();
        irDescida(109);
        Semaforos.ruasVerticais6[1].acquire();
        irDescida(157);
        Semaforos.ruasVerticais6[0].release();
        irDescida(223);
        Semaforos.vermelhoRoxo.acquire();
        Semaforos.ruasHorizontais3[4].acquire();
        irDescida(248);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(563);
        Semaforos.ruasVerticais6[1].release();
        irEsquerda(491);
        Semaforos.ruasHorizontais3[3].acquire();
        Semaforos.vermelhoAmareloCruzamento.acquire();
        irEsquerda(440);
        Semaforos.ruasHorizontais3[4].release();
        Semaforos.vermelhoAmareloCruzamento.release();
        irEsquerda(375);
        Semaforos.ruasVerticais4[2].acquire();
        irEsquerda(350);
        //DESCIDA
        carro.setRotate(0);
        irDescida(275);
        Semaforos.vermelhoRoxo.release();
        Semaforos.ruasHorizontais3[3].release();
        irDescida(340);
        Semaforos.ruasHorizontais4[3].acquire();
        irDescida(363);
        //DIREITA
        carro.setRotate(-90);
        irDireita(395);
        Semaforos.ruasVerticais4[2].release();
        irDireita(462);
        Semaforos.ruasVerticais5[3].acquire();
        irDireita(485);
        //DESCIDA
        carro.setRotate(0);
        irDescida(388);
        Semaforos.ruasHorizontais4[3].release();
        irDescida(454);
        Semaforos.ruasHorizontais5[4].acquire();
        irDescida(479);
        //DIREITA
        carro.setRotate(-90);
        irDireita(511);
        Semaforos.ruasVerticais5[3].release();
        irDireita(583);
        Semaforos.ruasVerticais6[4].acquire();
        irDireita(608);
        //DESCIDA
        carro.setRotate(0);
        irDescida(508);
        Semaforos.ruasHorizontais5[4].release();
        irDescida(569);
        Semaforos.ruasHorizontais6[4].acquire();
        irDescida(595);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(563);
        Semaforos.ruasVerticais6[4].release();
        irEsquerda(491);
        Semaforos.plus7.acquire();
        Semaforos.ruasHorizontais6[3].acquire();
        irEsquerda(440);
        Semaforos.ruasHorizontais6[4].release();
        irEsquerda(377);
        Semaforos.ruasVerticais4[4].acquire();
        irEsquerda(350);
        //SUBIDA
        carro.setRotate(180);
        irSubida(548);
        Semaforos.ruasHorizontais6[3].release();
        irSubida(483);
        Semaforos.ruasHorizontais5[2].acquire();
        irSubida(459);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(325);
        Semaforos.ruasVerticais4[4].release();
        Semaforos.plus7.release();
        irEsquerda(262);
        Semaforos.ruasVerticais3[4].acquire();
        irEsquerda(234);
        //DESCIDA
        carro.setRotate(0);
        irDescida(503);
        Semaforos.ruasHorizontais5[2].release();
        irDescida(569);
        Semaforos.ruasHorizontais6[1].acquire();
        irDescida(595);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(210);
        Semaforos.ruasVerticais3[4].release();
        irEsquerda(146);
        Semaforos.ruasHorizontais6[0].acquire();
        irEsquerda(94);
        Semaforos.ruasHorizontais6[1].release();
        irEsquerda(26);
        Semaforos.ruasVerticais1[4].acquire();
        irEsquerda(0);
        //SUBIDA
        carro.setRotate(180);
        irSubida(548);
        Semaforos.ruasHorizontais6[0].release();
        irSubida(484);
        Semaforos.vermelhoVerde.acquire();
        Semaforos.ruasVerticais1[3].acquire();
        irSubida(433);
        Semaforos.ruasVerticais1[4].release();
        irSubida(369);
        Semaforos.ruasVerticais1[2].acquire();
        irSubida(318);
        Semaforos.ruasVerticais1[3].release();
        irSubida(252);
        Semaforos.ruasVerticais1[1].acquire();
        irSubida(202);
        Semaforos.vermelhoVerde.release();
        Semaforos.ruasVerticais1[2].release();
        irSubida(137);
        Semaforos.ruasVerticais1[0].acquire();
        irSubida(87);
        Semaforos.ruasVerticais1[1].release();
        irSubida(17);
        Semaforos.ruasHorizontais1[0].acquire();
        irSubida(-7);
        //DIREITA
        carro.setRotate(-90);
        irDireita(46);
        Semaforos.ruasVerticais1[0].release();
      } catch (InterruptedException e) {
      } 
    }
  }  
}