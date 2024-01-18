/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 23/11/2023 (23 de Novembro de 2023).
* Ultima alteracao.: 03/12/2023 (03 de Dezembro de 2023).
* Nome.............: CarroVerde.java 
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
* Metodo: CarroVerde.
* Funcao: Controlador.
* Parametros: ImageView carro, Slider sliderVelocidade, Label labelVelocidade.
* Retorno: nenhum.
*************************************************************** */
public class CarroVerde extends Percursos{

  public CarroVerde(ImageView carro, Slider sliderVelocidade, Label labelVelocidade){
    super(carro, sliderVelocidade, labelVelocidade, 26, 459, -90);
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
    while (true) {
      try {
        //DIREITA
        irDireita(113);
        Semaforos.verdeBrancoCruzamento1.acquire();
        Semaforos.verdeLaranjaCruzamento1.acquire();
        irDireita(164);
        Semaforos.verdeBrancoCruzamento1.release();
        Semaforos.verdeLaranjaCruzamento1.release();
        irDireita(229);
        Semaforos.ruasHorizontais5[2].acquire();
        Semaforos.verdeRoxoCruzamento.acquire();
        Semaforos.verdeAmareloCruzamento1.acquire();
        irDireita(281);
        Semaforos.verdeRoxoCruzamento.release();
        Semaforos.verdeAmareloCruzamento1.release();
        irDireita(345);
        Semaforos.verdeLaranjaCruzamento2.acquire();
        irDireita(394);
        Semaforos.ruasHorizontais5[2].release();
        Semaforos.verdeLaranjaCruzamento2.release();
        irDireita(460);
        Semaforos.plus5.acquire();
        Semaforos.ruasHorizontais5[4].acquire();
        Semaforos.verdeAmareloCruzamento2.acquire();
        Semaforos.verdeBrancoCruzamento2.acquire();
        irDireita(511);
        Semaforos.verdeAmareloCruzamento2.release();
        Semaforos.verdeBrancoCruzamento2.release();
        irDireita(583);
        Semaforos.plus2.acquire();
        Semaforos.verdeRoxo.acquire();
        Semaforos.ruasVerticais6[3].acquire();
        irDireita(608);
        //SUBIDA
        carro.setRotate(180);
        irSubida(434);
        Semaforos.ruasHorizontais5[4].release();
        irSubida(368);
        Semaforos.verdeBranco1.acquire();
        irSubida(319);
        Semaforos.ruasVerticais6[3].release();
        Semaforos.plus2.release();
        irSubida(253);
        Semaforos.ruasHorizontais3[4].acquire();
        irSubida(228);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(563);
        irEsquerda(492);
        Semaforos.ruasHorizontais3[3].acquire();
        Semaforos.verdeAmareloCruzamento3.acquire();
        irEsquerda(440);
        Semaforos.verdeBranco1.release();
        Semaforos.ruasHorizontais3[4].release();
        Semaforos.verdeAmareloCruzamento3.release();
        Semaforos.plus5.release();
        irEsquerda(376);
        Semaforos.verdeLaranjaCruzamento3.acquire();
        irEsquerda(325);
        Semaforos.ruasHorizontais3[3].release();
        Semaforos.verdeLaranjaCruzamento3.release();
        irEsquerda(261);
        Semaforos.ruasHorizontais3[1].acquire();
        Semaforos.verdeAmareloCruzamento4.acquire();
        Semaforos.azulVerdeCruzamento.acquire();
        irEsquerda(209);
        Semaforos.verdeRoxo.release();
        Semaforos.verdeAmareloCruzamento4.release();
        Semaforos.azulVerdeCruzamento.release();
        irEsquerda(145);
        Semaforos.verdeBranco2.acquire();
        Semaforos.verdeLaranjaCruzamento4.acquire();
        irEsquerda(93);
        Semaforos.ruasHorizontais3[1].release();
        Semaforos.verdeLaranjaCruzamento4.release();
        irEsquerda(27);
        Semaforos.azulVerde.acquire();
        Semaforos.vermelhoVerde.acquire();
        irEsquerda(0);
        //DESCIDA
        carro.setRotate(0);
        irDescida(273);
        irDescida(338);
        Semaforos.ruasVerticais1[3].acquire();
        irDescida(388);
        Semaforos.verdeBranco2.release();
        irDescida(454);
        irDescida(479);
        //DIREITA
        carro.setRotate(-90);
        irDireita(46);
        Semaforos.azulVerde.release();
        Semaforos.vermelhoVerde.release();
        Semaforos.ruasVerticais1[3].release();
      } catch (InterruptedException e) {
      }
    }
  }
}