import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Bodega {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Empresa bodega = new Empresa();
    Bebida beb = new Bebida();
    Clientes client = new Clientes();

    ArrayList<Bebida> bebida = new ArrayList<Bebida>();
    ArrayList<Clientes> cachaceiros = new ArrayList<Clientes>();
    File bebidas = new File("/home/bianca/Desktop/Bodega/arquivobebida.db");
    File clientes = new File("/home/bianca/Desktop/Bodega/arquivoclientes.db");
    boolean verify = true;
    try {

      ObjectInputStream test = new ObjectInputStream(new FileInputStream(bebidas));
      while (verify) {
        Bebida b = (Bebida) test.readObject();
        if (b != null) {
          bebida.add(b);
          b = null;
        } else {
          verify = false;
        }
      }
      test.close();
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado/não existe");
    } catch (IOException e) {
      System.out.println("Erro ao inicializar stream");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    try {
      FileInputStream file = new FileInputStream(clientes);
      ObjectInputStream test = new ObjectInputStream(file);
      while (verify) {
        Clientes c = (Clientes) test.readObject();
        if (c != null) {
          cachaceiros.add(c);
          c = null;
        } else {
          verify = false;
        }
      }
      file.close();
      test.close();
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("Erro ao inicializar stream");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    int x;
    do {
      clrscr();
      System.out.println("|-------------------------------|");
      System.out.println("|\tBodega do seu ze\t|");
      System.out.println("|-------------------------------|");
      System.out.println("|1 - Cadastrar bebida \t\t|");
      System.out.println("|2 - Mostrar bebidas \t\t|");
      System.out.println("|3 - Comprar bebida \t\t|");
      System.out.println("|4 - Vender bebida \t\t|");
      System.out.println("|5 - Cadastrar cliente \t\t|");
      System.out.println("|6 - Mostrar clientes \t\t|");
      System.out.println("|7 - Sair do sistema \t\t|");
      System.out.println("|-------------------------------|");

      System.out.print("|Digite a opcao desejada: ");
      x = scan.nextInt();

      switch (x) {
        case 1:
        clrscr();
          bebida.add(beb.cadastraBebida(bebida.size()));
          break;
        case 2:
          clrscr();
          beb.mostraBebida(bebida);
          break;
        case 3:
        clrscr();
          beb.compraBebida(bebida);
          break;
        case 4:
        clrscr();
          beb.vendeBebida(bebida);
          break;
        case 5:
        clrscr();
          cachaceiros.add(client.cadastraCliente());
        case 6:
        clrscr();
          client.mostraCliente(cachaceiros);
          break;
        case 7:
        clrscr();
          break;
      }
      try {
        FileOutputStream arq = new FileOutputStream(bebidas);
        ObjectOutputStream o = new ObjectOutputStream(arq);

        for (int i = 0; i < bebida.size(); i++) {
          o.writeObject(bebida.get(i));
        }
        o.close();
        arq.close();
      } catch (FileNotFoundException e) {
        System.out.println("Arquivo não existe");
      } catch (IOException e) {
        System.out.println("Erro ao inicializar stream");
      }

      try {
        FileOutputStream arq = new FileOutputStream(clientes);
        ObjectOutputStream o = new ObjectOutputStream(arq);

        for (int i = 0; i < cachaceiros.size(); i++) {
          o.writeObject(cachaceiros.get(i));
        }
        o.close();
        arq.close();
      } catch (FileNotFoundException e) {
        System.out.println("Arquivo não existe");
      } catch (IOException e) {
        System.out.println("Erro ao inicializar stream");
      }

    } while (x != 7);
  }

  public static void clrscr() {
    // Clears Screen in java
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}