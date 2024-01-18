/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 23/11/2023 (23 de Novembro de 2023).
* Ultima alteracao.: 03/12/2023 (03 de Dezembro de 2023).
* Nome.............: CarroRoxo.java
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

/* ***************************************************************
* Metodo: CarroRoxo.
* Funcao: Controlador.
* Parametros: ImageView carro, Slider sliderVelocidade, Label labelVelocidade.
* Retorno: nenhum.
*************************************************************** */
public class CarroRoxo extends Percursos{

  public CarroRoxo(ImageView carro, Slider sliderVelocidade, Label labelVelocidade){
    super(carro, sliderVelocidade, labelVelocidade, 261, 228, -90);
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
      Semaforos.verdeRoxo.acquire();
    }catch(InterruptedException e){}
    while (true) {
      try {
        //DIREITA
        irDireita(344);
        Semaforos.vermelhoRoxo.acquire();
        Semaforos.laranjaRoxoCruzamento.acquire();
        irDireita(395);
        Semaforos.laranjaRoxoCruzamento.release();
        irDireita(459);
        Semaforos.ruasHorizontais3[4].acquire();
        Semaforos.amareloRoxoCruzamento.acquire();
        irDireita(512);
        Semaforos.amareloRoxoCruzamento.release();
        irDireita(583);
        Semaforos.ruasVerticais6[2].acquire();
        irDireita(608);
        //DESCIDA
        carro.setRotate(0);
        irDescida(273);
        Semaforos.vermelhoRoxo.release();
        Semaforos.ruasHorizontais3[4].release();
        irDescida(339);
        Semaforos.ruasVerticais6[3].acquire();
        irDescida(388);
        Semaforos.ruasVerticais6[2].release();
        irDescida(454);
        Semaforos.ruasVerticais6[4].acquire();
        irDescida(504);
        Semaforos.verdeRoxo.release();
        Semaforos.ruasVerticais6[3].release();
        irDescida(569);
        Semaforos.ruasHorizontais6[4].acquire();
        irDescida(595);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(562);
        Semaforos.ruasVerticais6[4].release();
        irEsquerda(492);
        Semaforos.amareloRoxo.acquire();
        Semaforos.ruasHorizontais6[3].acquire();
        irEsquerda(439);
        Semaforos.ruasHorizontais6[4].release();
        irEsquerda(376);
        Semaforos.ruasHorizontais6[2].acquire();
        irEsquerda(324);
        Semaforos.ruasHorizontais6[3].release();
        irEsquerda(261);
        Semaforos.ruasVerticais3[4].acquire();
        irEsquerda(235);
        //SUBIDA
        carro.setRotate(180);
        irSubida(549);
        Semaforos.ruasHorizontais6[2].release();
        irSubida(485);
        Semaforos.verdeRoxoCruzamento.acquire();
        irSubida(433);
        Semaforos.ruasVerticais3[4].release();
        Semaforos.verdeRoxoCruzamento.release();
        irSubida(368);
        Semaforos.ruasVerticais3[2].acquire();
        irSubida(318);
        irSubida(253);
        Semaforos.verdeRoxo.acquire();
        Semaforos.marromRoxoCruzamento.acquire();
        irSubida(228);
        //DIREITA
        carro.setRotate(-90);
        irDireita(281);
        Semaforos.amareloRoxo.release();
        Semaforos.ruasVerticais3[2].release();
        Semaforos.marromRoxoCruzamento.release();
      } catch (InterruptedException e) {
      } 
    }
  }
}