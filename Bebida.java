import java.util.*;
import java.io.Serializable;

public class Bebida implements Serializable {
  public String codigo;
  public String nomeBebida;
  public int ml;
  public double preco;
  public int quant;
  public boolean verifica = false;
  static public Scanner scan = new Scanner(System.in);

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
      System.out.println("|-------------------------------|");
      Bebida prod = bebida.get(i);
      System.out.println("|Nome: " + prod.nomeBebida + " Cod: [" + prod.codigo + "]\t\t|");
    }
    System.out.println("|-------------------------------|");
  }

  public Bebida cadastraBebida(int tam) {
    if (verifica) {
      scan.nextLine();
    } else {
      verifica = true;
    }
    codigo = String.valueOf(tam);
    System.out.print("Digite o nome da bebida: ");
    String nomeBebida = scan.next();
    System.out.print("Preço: ");
    double preco = scan.nextDouble();
    System.out.print("Quantidade de ml: ");
    int ml = scan.nextInt();
    System.out.print("Quantidade de bebidas: ");
    int quant = scan.nextInt();
    Bebida bebida = new Bebida(codigo, nomeBebida, preco, ml, quant);
    return bebida;
  }

  public void mostraBebida(ArrayList<Bebida> bebida) {
    for (int i = 0; i < bebida.size(); i++) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      Bebida b = bebida.get(i);
      System.out.println("|-------------------------------|");
      System.out.println("|Dados da Bebida [" + (i + 1) + "]\t\t|");
      System.out.println("|-------------------------------|");
      System.out.println("|Codigo: " + b.codigo + "\t\t\t|");
      System.out.println("|Nome: " + b.nomeBebida + "\t\t\t|");
      System.out.println("|Valor: " + b.preco + "\t\t\t|");
      System.out.println("|Quantidade: " + b.quant + "\t\t\t|");
      System.out.println("|Ml: " + b.ml + "\t\t\t\t|");
      System.out.println("|-------------------------------|");
      System.out.println("|Pressione qualquer tecla para ver o prox");
      scan.nextLine();
      scan.nextLine();
    }
    System.out.println("Pressione qualquer tecla para continuar");
    scan.nextLine();
    scan.nextLine();
  }

  public void compraBebida(ArrayList<Bebida> bebida) {
    lista(bebida);
    int i;

    System.out.print("Vai kere qual chefia? ");
    int n = scan.nextInt();
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
      System.out.println("\nPressione qualquer tecla para continuar");
      scan.nextLine();
      scan.nextLine();
    }

  }

  public void vendeBebida(ArrayList<Bebida> bebida) {
    lista(bebida);
    int i;
    System.out.print("Fala meu rei, quer qual? ");
    int n = scan.nextInt();
    for (i = 0; i < bebida.size(); i++) {
      Bebida prod = bebida.get(i);
      if (i == n) {
        break;
      }
    }
    Bebida prod = bebida.get(i);
    if (i == bebida.size()) {
      System.out.println("Codigo invalido ou bebida não cadastrada");
    } else if (n >= 0) {
      System.out.print("Digite a quantidade de bebidas para vender: ");
      int a = scan.nextInt();
      while (a > prod.quant) {
        System.out.println("Valor maior do que o estoque, Digite novamente: ");
        a = scan.nextInt();
      }
      prod.quant -= a;
      System.out.println("Quantidade de bebidas atualizada: " + prod.quant);

      System.out.println("\nPressione qualquer tecla para continuar");
      scan.nextLine();
      scan.nextLine();
    } else {
      System.out.println("Estoque Vazio! Abasteça");
    }
  }

}