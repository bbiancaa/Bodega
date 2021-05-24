import java.util.*;

public class Clientes {
  int codigo;
  String nome, CPF;
  boolean maiorIdade;
  boolean vendeFiado;
  Scanner scan = new Scanner(System.in);

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
    System.out.println("Digite o código: ");
    int codigo = scan.nextInt();
    System.out.println("Digite o nome: ");
    String nome = scan.nextLine();
    System.out.println("CPF: ");
    String CPF = scan.nextLine();
    System.out.println("Você é maior de idade?: S/N");
    Boolean maiorIdade = scan.nextBoolean();

    System.out.println("Você quer fiado?: S/N");
    Boolean vendeFiado = scan.nextBoolean();

    Clientes cliente = new Clientes(codigo, nome, CPF, maiorIdade, vendeFiado);
    return cliente;
  }

  public void mostraCliente(ArrayList<Clientes> cliente) {
    for (int i = 0; i < cliente.size(); i++) {
      Clientes c = cliente.get(i);
      System.out.println("Dados do Cliente [" + (i + 1) + "]" + c);
    }
  }

}
