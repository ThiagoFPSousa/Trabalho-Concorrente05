/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 23/11/2023 (23 de Novembro de 2023).
* Ultima alteracao.: 03/12/2023 (03 de Dezembro de 2023).
* Nome.............: CarroLaranja.java
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

public class CarroLaranja extends Percursos{

/* ***************************************************************
* Metodo: CarroLaranja.
* Funcao: Controlador.
* Parametros: ImageView carro, Slider sliderVelocidade, Label labelVelocidade.
* Retorno: nenhum.
*************************************************************** */
  public CarroLaranja(ImageView carro, Slider sliderVelocidade, Label labelVelocidade){
    super(carro, sliderVelocidade, labelVelocidade, 350, 18, 0);
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
      Semaforos.ruasVerticais4[0].acquire();
    }catch(InterruptedException e){}
    while (true) {
      try {
        //DESCIDA
        irDescida(107);
        irDescida(157);
        Semaforos.ruasVerticais4[0].release();
        irDescida(222);
        Semaforos.ruasVerticais4[2].acquire();
        Semaforos.laranjaRoxoCruzamento.acquire();
        Semaforos.verdeLaranjaCruzamento3.acquire();
        irDescida(273);
        Semaforos.laranjaRoxoCruzamento.release();
        Semaforos.verdeLaranjaCruzamento3.release();
        irDescida(337);
        Semaforos.ruasVerticais4[3].acquire();
        Semaforos.azulLaranjaCruzamento.acquire();
        irDescida(389);
        Semaforos.ruasVerticais4[2].release();
        Semaforos.azulLaranjaCruzamento.release();
        irDescida(453);
        Semaforos.plus7.acquire();
        Semaforos.ruasVerticais4[4].acquire();
        Semaforos.verdeLaranjaCruzamento2.acquire();
        irDescida(504);
        Semaforos.ruasVerticais4[3].release();
        Semaforos.verdeLaranjaCruzamento2.release();
        irDescida(568);
        Semaforos.ruasHorizontais6[2].acquire();
        irDescida(595);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(324);
        Semaforos.ruasVerticais4[4].release();
        Semaforos.plus7.release();
        irEsquerda(260);
        Semaforos.ruasHorizontais6[1].acquire();
        irEsquerda(208);
        Semaforos.ruasHorizontais6[2].release();
        irEsquerda(146);
        Semaforos.ruasVerticais2[4].acquire();
        irEsquerda(119);
        //SUBIDA
        carro.setRotate(180);
        irSubida(549);
        Semaforos.ruasHorizontais6[1].release();
        irSubida(484);
        Semaforos.ruasVerticais2[3].acquire();
        Semaforos.verdeLaranjaCruzamento1.acquire();
        irSubida(433);
        Semaforos.ruasVerticais2[4].release();
        Semaforos.verdeLaranjaCruzamento1.release();
        irSubida(368);
        Semaforos.ruasVerticais2[2].acquire();
        irSubida(318);
        Semaforos.ruasVerticais2[3].release();
        irSubida(254);
        Semaforos.ruasVerticais2[1].acquire();
        Semaforos.verdeLaranjaCruzamento4.acquire();
        irSubida(202);
        Semaforos.ruasVerticais2[2].release();
        Semaforos.verdeLaranjaCruzamento4.release();
        irSubida(136);
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
        irDireita(230);
        Semaforos.ruasHorizontais1[2].acquire();
        irDireita(280);
        Semaforos.ruasHorizontais1[1].release();
        irDireita(344);
        Semaforos.ruasVerticais4[0].acquire();
        irDireita(370);
        //DESCIDA
        carro.setRotate(0);
        irDescida(38);
        Semaforos.ruasHorizontais1[2].release();
      } catch (InterruptedException e) {
      } 
    }
  }
}