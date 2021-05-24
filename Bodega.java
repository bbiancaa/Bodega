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
    File bebidas = new File("C:\\Users\\bianca\\Desktop\\Bodega\\arquivobebida.txt");
    File clientes = new File("C:\\Users\\bianca\\Desktop\\Bodega\\arquivoclientes.txt");
    boolean verify = true;
    try {
      FileInputStream file = new FileInputStream(bebidas);
      ObjectInputStream test = new ObjectInputStream(file);
      while (verify) {
        Bebida b = (Bebida) test.readObject();
        if (b != null) {
          bebida.add(b);
          b = null;
        } else {
          verify = false;
        }
      }
      file.close();
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
    } catch (IOException e) {
      System.out.println("Erro ao inicializar stream");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    int x;
    do {
      System.out.println("Digite a opção desejeada: \n");
      System.out.println("1 - Cadastrar bebida ");
      System.out.println("2 - Mostrar bebidas ");
      System.out.println("3 - Comprar bebida ");
      System.out.println("4 - Vender bebida ");
      System.out.println("5 - Cadastrar cliente ");
      System.out.println("6 - Mostrar clientes ");
      System.out.println("7 - Sair do sistema ");

      x = scan.nextInt();

      switch (x) {
        case 1:
          bebida.add(beb.cadastraBebida());
          break;
        case 2:
          beb.mostraBebida(bebida);
          break;
        case 3:
          beb.compraBebida(bebida);
          break;
        case 4:
          beb.vendeBebida(bebida);
          break;
        case 5:
          cachaceiros.add(client.cadastraCliente());
        case 6:
          client.mostraCliente(cachaceiros);
          break;
        case 7:
          break;
          try {
            FileOutputStream arq = new FileOutputStream(bebidas);
            ObjectOutputStream o = new ObjectOutputStream(arq);

            for (int i = 0; i < bebida.size(); i++){
                o.writeObject(bebida.get(i));
            }
            o.close();
            arq.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não existe");
        } catch (IOException e) {
            System.out.println("Erro ao inicializar stream");
        } 
      }
       
        try {
            FileOutputStream arq = new FileOutputStream(clientes);
            ObjectOutputStream o = new ObjectOutputStream(arq);

            for (int i = 0; i < cachaceiros.size(); i++){
                o.writeObject(cachaceiros.get(i));
            }
            o.close();
            arq.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não existe");
        } catch (IOException e) {
            System.out.println("Erro ao inicializar stream");
        } 

        System.exit(0);
    }


    } while (x != 0);
  }
}