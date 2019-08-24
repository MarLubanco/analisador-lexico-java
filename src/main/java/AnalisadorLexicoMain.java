import service.Service;

import java.io.IOException;

public class AnalisadorLexicoMain {

  public static void main(String[] args) throws IOException {
    Service service = new Service();

    service.leituraBufferedReader("arquivo-java.txt");
  }
}
