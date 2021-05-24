import java.util.*;

public class Bebida implements java.io.Serializable {
  String codigo;
  String nomeBebida;
  int ml;
  double preco;
  int quant;
  boolean verifica = false;
  Scanner scan = new Scanner(System.in);

  public Bebida(String codigo, String nomeBebida, double preco, int ml, int quant) {
    this.codigo = codigo;
    this.nomeBebida = nomeBebida;
    this.ml = ml;
    this.preco = preco;
    this.quant = quant;
  }

  public Bebida() {

  }

  public void lista(ArrayList<Bebida> bebida) {
    System.out.println("Digite o codigo da Bebida desejada:\n\n");
    for (int i = 0; i < bebida.size(); i++) {
      Bebida prod = bebida.get(i);
      System.out.println("Nome: " + prod.nomeBebida + " Cod: [" + (i + 1) + "]\n\n");
    }
  }

  public Bebida cadastraBebida() {
    if (verifica) {
      scan.nextLine();
    } else {
      verifica = true;
    }
    System.out.print("Digite o código da bebida: ");
    String codigo = scan.nextLine();
    System.out.print("Digite o nome da bebida: ");
    String nomeBebida = scan.nextLine();
    System.out.print("\nPreço: ");
    double preco = scan.nextDouble();
    System.out.print("\nQuantidade de ml: ");
    int ml = scan.nextInt();
    System.out.print("\nQuantidade de bebidas: ");
    int quant = scan.nextInt();
    Bebida bebida = new Bebida(codigo, nomeBebida, preco, ml, quant);
    return bebida;
  }

  public void mostraBebida(ArrayList<Bebida> bebida) {
    for (int i = 0; i < bebida.size(); i++) {
      Bebida b = bebida.get(i);
      System.out.println("Dados da Bebida [" + (i + 1) + "]" + b);
    }
  }

  public void compraBebida(ArrayList<Bebida> bebida) {
    lista(bebida);
    int i;
    int n = scan.nextInt();
    n--;
    for (i = 0; i < bebida.size(); i++) {
      Bebida prod = bebida.get(i);
      if (i == n) {
        break;
      }
    }
    Bebida prod = bebida.get(i);
    if (i == bebida.size()) {
      System.out.println("Codigo invalido ou bebida não cadastrada");
    } else {
      System.out.print("Digite a quantidade de bebidas compradas: ");
      int comp = scan.nextInt();
      prod.quant += comp;
      System.out.println("Quantidade de bebidas atualizada: " + prod.quant);
    }

  }

  public void vendeBebida(ArrayList<Bebida> bebida) {
    lista(bebida);
    int i;
    int n = scan.nextInt();
    n--;
    for (i = 0; i < bebida.size(); i++) {
      Bebida prod = bebida.get(i);
      if (i == n) {
        break;
      }
    }
    Bebida prod = bebida.get(i);
    if (i == bebida.size()) {
      System.out.println("Codigo invalido ou bebida não cadastrada");
    } else if (n > 0) {
      System.out.print("Digite a quantidade de bebidas para vender: ");
      int a = scan.nextInt();
      while (a > prod.quant) {
        System.out.println("Valor maior do que o estoque, Digite novamente: ");
        a = scan.nextInt();
      }
      prod.quant -= a;
      System.out.println("Quantidade de bebidas atualizada: " + prod.quant);
    } else {
      System.out.println("Estoque Vazio! Abasteça");
    }
  }

}