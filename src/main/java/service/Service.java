package service;

import com.sun.corba.se.impl.oa.toa.TOA;
import com.sun.deploy.util.StringUtils;
import model.Token;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Service {

  Logger logger = Logger.getLogger(Service.class.getName());
  List<String> palavrasPrivadas = Arrays.asList("int", "if", "switch", "while", "Integer", "Double", "double", "char", "String", "public", "void",
          "throws", "private", "class", "List", "ArrayList", "forEach", "new", "try", "catch", "null", "List");
  List<String> simbolos = Arrays.asList("(", ")", "+", "-", "/", "*", "^", "{", "}", ";", "?", "||", "&&", "=", "=>", "->", "!", "<>", "[", "]",
          "<=", "<", ">", "!=", "==", "--", "++", "=!");
  List<Token> tokens = new ArrayList<>();
  List<String> tabelaDeSimbolos = new ArrayList<>();
  Pattern isNumero = Pattern.compile("(^[0-9])");

  public void leituraBufferedReader(String caminhoEntrada) throws IOException {
    BufferedReader buffer = null;
    String linha = null;
    List<String> dadosParaAnalise = new ArrayList<String>();
    try {
      buffer = new BufferedReader(new FileReader(caminhoEntrada));
      while ((linha = buffer.readLine()) != null) {
        String[] splitLinha = linha.split(" ");
        dadosParaAnalise.addAll(Arrays.asList(splitLinha));
      }
      analisarEstrutura(dadosParaAnalise);
    } finally {
      if (buffer != null) {
        buffer.close();
      }
    }
  }

  public void analisarEstrutura(List<String> dados) {
    dados.stream()
            .filter(c -> !c.isEmpty())
            .forEach( dado -> {
      if(palavrasPrivadas.contains(dado)) {
        tokens.add(new Token("PR", dado));
      } else if (simbolos.contains(dado)) {
        tokens.add(new Token("SIMBOLO", dado));
//        tabelaDeSimbolos.add(dado);
      } else if (isNumero.matcher(dado).matches()) {
        tokens.add(new Token("LITERAL", dado));
      } else {
//            if (dado.contains("(")) {
//              tokens.add(new Token("SIMBOLO", dado));
//              int indice = dado.indexOf("s");
//              dado.replace("(", "");
//            } else {
              tokens.add(new Token("ID", dado));
//            }
      }
    });
    tokens.forEach(c -> System.out.println(c.toString()));
    logger.info("Finalização de analise léxica");
  }


  public void isDigitOrString(String dado) {
    for (int i = 0; i < dado.length(); i++) {
      if (Character.isDigit(dado.charAt(i))==true) {
        System.out.println("Possui numeros");
        break;
      }
    }
  }
}
