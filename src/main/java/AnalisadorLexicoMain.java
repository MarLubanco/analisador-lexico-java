import service.Service;

import java.io.IOException;
import java.util.logging.Logger;

public class AnalisadorLexicoMain {

  public static void main(String[] args) throws IOException {
    Service service = new Service();
    Logger logger = Logger.getLogger(AnalisadorLexicoMain.class.getName());
    logger.info("Iniciando Analisador Léxico");
    service.leituraBufferedReader("C:\\Users\\marcel_cb\\Documents\\analisador-lexico-java\\src\\main\\java\\BubbleSort.java");
  }
}
