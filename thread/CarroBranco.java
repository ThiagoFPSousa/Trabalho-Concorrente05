/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 23/11/2023 (23 de Novembro de 2023).
* Ultima alteracao.: 03/12/2023 (03 de Dezembro de 2023).
* Nome.............: CarroBranco.java
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

public class CarroBranco extends Percursos{

/* ***************************************************************
* Metodo: CarroBranco.
* Funcao: Controlador.
* Parametros: ImageView carro, Slider sliderVelocidade, Label labelVelocidade.
* Retorno: nenhum.
*************************************************************** */
  public CarroBranco(ImageView carro, Slider sliderVelocidade, Label labelVelocidade){
    super(carro, sliderVelocidade, labelVelocidade, 145, -6, -90);
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
        Semaforos.ruasHorizontais1[1].acquire();
    }catch(InterruptedException e){}
    while (true) {
      try {
        //DIREITA
        irDireita(229);
        Semaforos.brancoAmarelo1.acquire();
        Semaforos.ruasHorizontais1[2].acquire();
        irDireita(281);
        Semaforos.ruasHorizontais1[1].release();
        irDireita(345);
        Semaforos.ruasHorizontais1[3].acquire();
        irDireita(396);
        Semaforos.ruasHorizontais1[2].release();
        irDireita(460);
        irDireita(485);
        //DESCIDA
        carro.setRotate(0);
        irDescida(38);
        Semaforos.ruasHorizontais1[3].release();
        irDescida(108);
        irDescida(157);
        irDescida(222);
        Semaforos.plus5.acquire();
        Semaforos.verdeBranco1.acquire();
        Semaforos.ruasHorizontais3[4].acquire();
        irDescida(248);
        //DIREITA
        carro.setRotate(-90);
        irDireita(511);
        Semaforos.brancoAmarelo1.release();
        irDireita(582);
        Semaforos.ruasVerticais6[2].acquire();
        irDireita(608);
        //DESCIDA
        carro.setRotate(0);
        irDescida(273);
        Semaforos.ruasHorizontais3[4].release();
        irDescida(339);
        Semaforos.plus6.acquire();
        Semaforos.ruasHorizontais4[4].acquire();
        irDescida(364);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(563);
        Semaforos.verdeBranco1.release();
        Semaforos.ruasVerticais6[2].release();
        Semaforos.plus5.release();
        irEsquerda(492);
        Semaforos.brancoAmarelo2.acquire();
        Semaforos.ruasVerticais5[3].acquire();
        Semaforos.brancoMarromCruzamento1.acquire();
        irEsquerda(465);
        //DESCIDA
        carro.setRotate(0);
        irDescida(388);
        Semaforos.ruasHorizontais4[4].release();
        Semaforos.brancoMarromCruzamento1.release();
        irDescida(454);
        Semaforos.verdeBrancoCruzamento2.acquire();
        irDescida(505);
        Semaforos.ruasVerticais5[3].release();
        Semaforos.verdeBrancoCruzamento2.release();
        irDescida(570);
        Semaforos.ruasHorizontais6[3].acquire();
        irDescida(595);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(440);
        irEsquerda(375);
        Semaforos.ruasHorizontais6[2].acquire();
        irEsquerda(325);
        Semaforos.ruasHorizontais6[3].release();
        irEsquerda(261);
        Semaforos.ruasHorizontais6[1].acquire();
        irEsquerda(209);
        Semaforos.brancoAmarelo2.release();
        Semaforos.ruasHorizontais6[2].release();
        Semaforos.plus6.release();
        irEsquerda(145);
        Semaforos.ruasVerticais2[4].acquire();
        irEsquerda(119);
        //SUBIDA
        carro.setRotate(180);
        irSubida(550);
        Semaforos.ruasHorizontais6[1].release();
        irSubida(484);
        Semaforos.ruasVerticais2[3].acquire();
        Semaforos.verdeBrancoCruzamento1.acquire();
        irSubida(434);
        Semaforos.ruasVerticais2[4].release();
        Semaforos.verdeBrancoCruzamento1.release();
        irSubida(368);
        Semaforos.plus8.acquire();
        Semaforos.ruasHorizontais4[0].acquire();
        irSubida(344);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(93);
        Semaforos.ruasVerticais2[3].release();
        irEsquerda(27);
        Semaforos.verdeBranco2.acquire();
        Semaforos.ruasVerticais1[2].acquire();
        irEsquerda(0);
        //SUBIDA
        carro.setRotate(180);
        irSubida(318);
        Semaforos.ruasHorizontais4[0].release();
        Semaforos.plus8.release();
        irSubida(253);
        irSubida(228);
        //DIREITA
        carro.setRotate(-90);
        irDireita(46);
        Semaforos.ruasVerticais1[2].release();
        irDireita(113);
        Semaforos.ruasVerticais2[1].acquire();
        Semaforos.brancoMarromCruzamento2.acquire();
        irDireita(139);
        //SUBIDA
        carro.setRotate(180);
        irSubida(203);
        Semaforos.verdeBranco2.release();
        Semaforos.brancoMarromCruzamento2.release();
        irSubida(137);
        Semaforos.ruasVerticais2[0].acquire();
        irSubida(88);
        Semaforos.ruasVerticais2[1].release();
        irSubida(19);
        Semaforos.ruasHorizontais1[1].acquire();
        irSubida(-6);
        //DIREITA
        carro.setRotate(-90);
        irDireita(165);
        Semaforos.ruasVerticais2[0].release();
      } catch (InterruptedException e) {
      } 
    }
  }
}