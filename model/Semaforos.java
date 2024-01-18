/* ***************************************************************
* Autor............: Thiago Fernandes Pereira de Sousa
* Matricula........: 202210546
* Inicio...........: 23/11/2023 (23 de Novembro de 2023).
* Ultima alteracao.: 03/12/2023 (03 de Dezembro de 2023).
* Nome.............: Semaforos.java
* Funcao...........: Define a configuracao dos semaforos que
controlam os acessos das vias em diferentes sentidos e cruzamentos
na simulacao do sistema de trafego de "Carros Automatos". Esta classe
utiliza a classe `Semaphore` do Java para criar e gerenciar semaforos
que controlam a passagem de carros em diversas ruas horizontais e
verticais, bem como nos cruzamentos e sentidos opostos, visando simular
o fluxo de trafego.
*************************************************************** */

package model;

import java.util.concurrent.Semaphore;// Importacao da classe Semaphore para lidar com semaforos.

public abstract class Semaforos{
  //RUAS HORIZONTAIS
  public static Semaphore[] ruasHorizontais1 = new Semaphore[5];
  public static Semaphore[] ruasHorizontais2 = new Semaphore[5];
  public static Semaphore[] ruasHorizontais3 = new Semaphore[5];
  public static Semaphore[] ruasHorizontais4 = new Semaphore[5];
  public static Semaphore[] ruasHorizontais5 = new Semaphore[5];
  public static Semaphore[] ruasHorizontais6 = new Semaphore[5];
  //RUAS VERTICAIS
  public static Semaphore[] ruasVerticais1 = new Semaphore[5];
  public static Semaphore[] ruasVerticais2 = new Semaphore[5];
  public static Semaphore[] ruasVerticais3 = new Semaphore[5];
  public static Semaphore[] ruasVerticais4 = new Semaphore[5];
  public static Semaphore[] ruasVerticais5 = new Semaphore[5];
  public static Semaphore[] ruasVerticais6 = new Semaphore[5];
  //INSTANCIANDO RUAS HORIZONTAIS E VERTICAIS
  static{
    for(int i = 0; i < 5; i++) {
      ruasVerticais1[i] = new Semaphore(1);
      ruasVerticais2[i] = new Semaphore(1);
      ruasVerticais3[i] = new Semaphore(1);
      ruasVerticais4[i] = new Semaphore(1);
      ruasVerticais5[i] = new Semaphore(1);
      ruasVerticais6[i] = new Semaphore(1);
      ruasHorizontais1[i] = new Semaphore(1);
      ruasHorizontais2[i] = new Semaphore(1);
      ruasHorizontais3[i] = new Semaphore(1);
      ruasHorizontais4[i] = new Semaphore(1);
      ruasHorizontais5[i] = new Semaphore(1);
      ruasHorizontais6[i] = new Semaphore(1);
    }
  }
  //SENTIDOS OPOSTOS
  public static Semaphore vermelhoVerde = new Semaphore(1);
  public static Semaphore vermelhoAmarelo = new Semaphore(1);
  public static Semaphore vermelhoRoxo = new Semaphore(1);
  public static Semaphore azulVerde = new Semaphore(1);
  public static Semaphore azulAmarelo = new Semaphore(1);
  public static Semaphore verdeBranco1 = new Semaphore(1);
  public static Semaphore verdeBranco2 = new Semaphore(1);
  public static Semaphore verdeRoxo = new Semaphore(1);
  public static Semaphore brancoAmarelo1 = new Semaphore(1);
  public static Semaphore brancoAmarelo2 = new Semaphore(1);
  public static Semaphore amareloRoxo = new Semaphore(1);
  //CRUZAMENTOS
  public static Semaphore vermelhoAmareloCruzamento = new Semaphore(1);
  public static Semaphore azulVerdeCruzamento = new Semaphore(1);
  public static Semaphore azulLaranjaCruzamento = new Semaphore(1);
  public static Semaphore azulAmareloCruzamento = new Semaphore(1);
  public static Semaphore verdeLaranjaCruzamento1 = new Semaphore(1);
  public static Semaphore verdeLaranjaCruzamento2 = new Semaphore(1);
  public static Semaphore verdeLaranjaCruzamento3 = new Semaphore(1);
  public static Semaphore verdeLaranjaCruzamento4 = new Semaphore(1);
  public static Semaphore verdeBrancoCruzamento1 = new Semaphore(1);
  public static Semaphore verdeBrancoCruzamento2 = new Semaphore(1);
  public static Semaphore verdeAmareloCruzamento1 = new Semaphore(1);
  public static Semaphore verdeAmareloCruzamento2 = new Semaphore(1);
  public static Semaphore verdeAmareloCruzamento3 = new Semaphore(1);
  public static Semaphore verdeAmareloCruzamento4 = new Semaphore(1);
  public static Semaphore verdeRoxoCruzamento = new Semaphore(1);
  public static Semaphore laranjaRoxoCruzamento = new Semaphore(1);
  public static Semaphore brancoMarromCruzamento1 = new Semaphore(1);
  public static Semaphore brancoMarromCruzamento2 = new Semaphore(1);
  public static Semaphore marromRoxoCruzamento = new Semaphore(1);
  public static Semaphore amareloRoxoCruzamento = new Semaphore(1);
  //PLUS (SEMAFOROS CRIADOS NA TENTATIVA DE RESOLVER ALGUMAS DEADLOCKS)
  public static Semaphore plus1 = new Semaphore(1);
  public static Semaphore plus2 = new Semaphore(1);
  public static Semaphore plus3 = new Semaphore(1);
  public static Semaphore plus4 = new Semaphore(1);
  public static Semaphore plus5 = new Semaphore(1);
  public static Semaphore plus6 = new Semaphore(1);
  public static Semaphore plus7 = new Semaphore(1);
  public static Semaphore plus8 = new Semaphore(1);

/* ***************************************************************
* Metodo: instanciarSemaforo.
* Funcao: Instancia todos os semaforos.
* Parametros: Nenhum.
* Retorno: Nenhum(void).
*************************************************************** */
  public static void instanciarSemaforos(){
    //INSTANCIANDO RUAS HORIZONTAIS E VERTICAIS
    for(int i = 0; i < 5; i++) {
      ruasVerticais1[i] = new Semaphore(1);
      ruasVerticais2[i] = new Semaphore(1);
      ruasVerticais3[i] = new Semaphore(1);
      ruasVerticais4[i] = new Semaphore(1);
      ruasVerticais5[i] = new Semaphore(1);
      ruasVerticais6[i] = new Semaphore(1);

      ruasHorizontais1[i] = new Semaphore(1);
      ruasHorizontais2[i] = new Semaphore(1);
      ruasHorizontais3[i] = new Semaphore(1);
      ruasHorizontais4[i] = new Semaphore(1);
      ruasHorizontais5[i] = new Semaphore(1);
      ruasHorizontais6[i] = new Semaphore(1);
    }
    //SENTIDOS OPOSTOS
    vermelhoVerde = new Semaphore(1);
    vermelhoAmarelo = new Semaphore(1);
    vermelhoRoxo = new Semaphore(1);
    azulVerde = new Semaphore(1);
    azulAmarelo = new Semaphore(1);
    verdeBranco1 = new Semaphore(1);
    verdeBranco2 = new Semaphore(1);
    verdeRoxo = new Semaphore(1);
    brancoAmarelo1 = new Semaphore(1);
    brancoAmarelo2 = new Semaphore(1);
    amareloRoxo = new Semaphore(1);
    //CRUZAMENTOS
    vermelhoAmareloCruzamento = new Semaphore(1);
    azulVerdeCruzamento = new Semaphore(1);
    azulLaranjaCruzamento = new Semaphore(1);
    azulAmareloCruzamento = new Semaphore(1);
    verdeLaranjaCruzamento1 = new Semaphore(1);
    verdeLaranjaCruzamento2 = new Semaphore(1);
    verdeLaranjaCruzamento3 = new Semaphore(1);
    verdeLaranjaCruzamento4 = new Semaphore(1);
    verdeBrancoCruzamento1 = new Semaphore(1);
    verdeBrancoCruzamento2 = new Semaphore(1);
    verdeAmareloCruzamento1 = new Semaphore(1);
    verdeAmareloCruzamento2 = new Semaphore(1);
    verdeAmareloCruzamento3 = new Semaphore(1);
    verdeAmareloCruzamento4 = new Semaphore(1);
    verdeRoxoCruzamento = new Semaphore(1);
    laranjaRoxoCruzamento = new Semaphore(1);
    brancoMarromCruzamento1 = new Semaphore(1);
    brancoMarromCruzamento2 = new Semaphore(1);
    marromRoxoCruzamento = new Semaphore(1);
    amareloRoxoCruzamento = new Semaphore(1);
    //PLUS (SEMAFOROS CRIADOS NA TENTATIVA DE RESOLVER ALGUMAS DEADLOCKS)
    plus1 = new Semaphore(1);
    plus2 = new Semaphore(1);
    plus3 = new Semaphore(1);
    plus4 = new Semaphore(1);
    plus5 = new Semaphore(1);
    plus6 = new Semaphore(1);
    plus7 = new Semaphore(1);
    plus8 = new Semaphore(1);
  }
}