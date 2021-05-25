import java.util.*;
import java.io.Serializable;

public class Clientes implements Serializable {
  int codigo;
  String nome, CPF;
  boolean maiorIdade;
  boolean vendeFiado;
  static Scanner scan = new Scanner(System.in);

  public Clientes(int codigo, String nome, String CPF, boolean maiorIdade, boolean vendeFiado) {
    this.codigo = codigo;
    this.nome = nome;
    this.CPF = CPF;
    this.maiorIdade = maiorIdade;
    this.vendeFiado = vendeFiado;

  }

  public Clientes() {

  }

  public Clientes cadastraCliente() {
    Boolean maiorIdade = false;
    Boolean vendeFiado = false;
    System.out.println("Digite o código: ");
    int codigo = scan.nextInt();
    System.out.println("Digite o nome: ");
    String nome = scan.next();
    System.out.println("CPF: ");
    String CPF = scan.next();
    System.out.println("Você é maior de idade?: S/N");
    String idade = scan.next();
    if (idade == "S") {
      maiorIdade = true;
    }
    System.out.println("Você quer fiado?: S/N");
    String fiado = scan.next();
    if (fiado == "S") {
      vendeFiado = true;
    }

    Clientes cliente = new Clientes(codigo, nome, CPF, maiorIdade, vendeFiado);
    return cliente;
  }

  public void mostraCliente(ArrayList<Clientes> cliente) {
    for (int i = 0; i < cliente.size(); i++) {
      Clientes c = cliente.get(i);
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println("|-------------------------------|");
      System.out.println("|Dados do Cliente [" + (i + 1) + "]\t\t|");
      System.out.println("|-------------------------------|");
      System.out.println("|Codigo: " + c.codigo + "\t\t\t|");
      System.out.println("|CPF: " + c.CPF + "\t\t\t|");
      System.out.println("|Nome: " + c.nome + "\t\t\t|");
      System.out.println("|Maior idade?: " + c.maiorIdade + "\t\t|");
      System.out.println("|Vende Fiado?: " + c.vendeFiado + "\t\t|");
      System.out.println("|-------------------------------|");
      System.out.println("|Pressione qualquer tecla para ver o prox");
      scan.nextLine();
    }

    System.out.println("Pressione qualquer tecla para continuar");
    scan.nextLine();
  }

}