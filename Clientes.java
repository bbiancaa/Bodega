public class Clientes {
  int codigo;
  String nome, CPF;
  boolean maiorIdade;
  boolean vendeFiado;

  public Clientes(int codigo, String nome, String CPF, boolean maiorIdade, boolean vendeFiado){
    this.codigo = codigo;
    this.nome = nome;
    this.CPF = CPF;
    this.maiorIdade = maiorIdade;
    this.vendeFiado = vendeFiado;
  }
}
