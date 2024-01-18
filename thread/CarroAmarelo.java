/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 23/11/2023 (23 de Novembro de 2023).
* Ultima alteracao.: 03/12/2023 (03 de Dezembro de 2023).
* Nome.............: CarroAmarelo.java
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

public class CarroAmarelo extends Percursos{

/* ***************************************************************
* Metodo: CarroAmarelo.
* Funcao: Controlador.
* Parametros: ImageView carro, Slider sliderVelocidade, Label labelVelocidade.
* Retorno: nenhum.
*************************************************************** */
  public CarroAmarelo(ImageView carro, Slider sliderVelocidade, Label labelVelocidade){
    super(carro, sliderVelocidade, labelVelocidade, 465, 549, 180);
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
      Semaforos.brancoAmarelo2.acquire();
      Semaforos.plus6.acquire();
    }catch(InterruptedException e){}
    while (true) {
      try {
        //SUBIDA
        irSubida(484);
        Semaforos.ruasVerticais5[3].acquire();
        Semaforos.verdeAmareloCruzamento2.acquire();
        irSubida(433);
        Semaforos.verdeAmareloCruzamento2.release();
        irSubida(368);
        Semaforos.plus1.acquire();
        Semaforos.ruasVerticais5[2].acquire();
        Semaforos.azulAmareloCruzamento.acquire();
        irSubida(318);
        Semaforos.brancoAmarelo2.release();
        Semaforos.ruasVerticais5[3].release();
        Semaforos.azulAmareloCruzamento.release();
        Semaforos.plus6.release();
        irSubida(254);
        Semaforos.brancoAmarelo1.acquire();
        Semaforos.amareloRoxoCruzamento.acquire();
        Semaforos.verdeAmareloCruzamento3.acquire();
        Semaforos.vermelhoAmareloCruzamento.acquire();
        irSubida(202);
        Semaforos.ruasVerticais5[2].release();
        Semaforos.amareloRoxoCruzamento.release();
        Semaforos.verdeAmareloCruzamento3.release();
        Semaforos.vermelhoAmareloCruzamento.release();
        irSubida(136);
        Semaforos.plus1.release();
        irSubida(87);
        irSubida(19);
        Semaforos.vermelhoAmarelo.acquire();
        Semaforos.ruasHorizontais1[3].acquire();
        irSubida(-6);
        //ESQUERDA
        carro.setRotate(90);
        irEsquerda(439);
        irEsquerda(375);
        Semaforos.ruasHorizontais1[2].acquire();
        irEsquerda(324);
        Semaforos.ruasHorizontais1[3].release();
        irEsquerda(261);
        Semaforos.ruasVerticais3[0].acquire();
        irEsquerda(234);
        //DESCIDA
        carro.setRotate(0);
        irDescida(40);
        Semaforos.brancoAmarelo1.release();
        Semaforos.vermelhoAmarelo.release();
        Semaforos.ruasHorizontais1[2].release();
        irDescida(107);
        Semaforos.plus3.acquire();
        Semaforos.ruasVerticais3[1].acquire();
        irDescida(158);
        Semaforos.ruasVerticais3[0].release();
        irDescida(222);
        Semaforos.amareloRoxo.acquire();
        Semaforos.ruasVerticais3[2].acquire();
        Semaforos.verdeAmareloCruzamento4.acquire();
        irDescida(274);
        Semaforos.ruasVerticais3[1].release();
        Semaforos.verdeAmareloCruzamento4.release();
        Semaforos.plus3.release();
        irDescida(337);
        irDescida(390);
        Semaforos.ruasVerticais3[2].release();
        irDescida(453);
        Semaforos.ruasVerticais3[4].acquire();
        Semaforos.verdeAmareloCruzamento1.acquire();
        irDescida(505);
        Semaforos.verdeAmareloCruzamento1.release();
        irDescida(568);
        Semaforos.plus6.acquire();
        Semaforos.brancoAmarelo2.acquire();
        Semaforos.azulAmarelo.acquire();
        Semaforos.ruasHorizontais6[2].acquire();
        irDescida(595);
        //DIREITA
        carro.setRotate(-90);
        irDireita(282);
        Semaforos.ruasVerticais3[4].release();
        irDireita(346);
        Semaforos.ruasHorizontais6[3].acquire();
        irDireita(397);
        Semaforos.ruasHorizontais6[2].release();
        irDireita(460);
        irDireita(485);
        //SUBIDA
        carro.setRotate(180);
        irSubida(549);
        Semaforos.amareloRoxo.release();
        Semaforos.azulAmarelo.release();
        Semaforos.ruasHorizontais6[3].release();
      } catch (InterruptedException e) {
      } 
    }
  }  
}