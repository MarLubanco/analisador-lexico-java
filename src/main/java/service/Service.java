package service;

import model.TabelaDeSimbolo;
import model.Token;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Service {

    Logger logger = Logger.getLogger(Service.class.getName());
    List<String> palavrasPrivadas = Arrays.asList("int", "if", "switch", "main", "while", "Integer", "static", "Double", "double", "char", "String", "public", "void",
            "throws", "private", "class", "System.out.println", "for", "List", "ArrayList", "return", "else", "if", "forEach", "new", "try", "catch", "null", "List");
    List<String> simbolos = Arrays.asList("(", ")", "+", "-", "/", "*", "^", "{", "}", ";", "?", "||", "&&", "=", "=>", "->", "!", "<>", "[", "]",
            "<=", "<", ">", "!=", "==", "--", "++", "=!", "?");
    List<Token> tokens = new ArrayList<>();
    List<String> tabelaDeSimbolos = new ArrayList<>();
    Pattern isNumero = Pattern.compile("(^[0-9])");
  Pattern pt = Pattern.compile("^[//]{0,}.*", Pattern.MULTILINE);

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
        TabelaDeSimbolo tabelaDeSimbolo = new TabelaDeSimbolo();
        AtomicReference<Integer> contador = new AtomicReference<>(1);
        dados.stream()
                .filter(c -> !c.isEmpty())
                .forEach(dado -> {
//                    if(pt.matcher(dado).matches()) {
//                        System.out.println(dado);
//                    } else
                    if (Pattern.matches("[_|a-z|A-Z][a-z|A-Z|0-9|_]*", dado)
                           && !palavrasPrivadas.contains(dado)
                           && !tabelaDeSimbolo.getTabelaSimbolo().contains(dado)) {
                        tokens.add(new Token(contador.get(), "ID", dado));
                        contador.getAndSet(contador.get() + 1);
                        tabelaDeSimbolo.getTabelaSimbolo().add(dado);
                    }  if (palavrasPrivadas.contains(dado)) {
                        tokens.add(new Token(contador.get(), "PR", dado));
                        contador.getAndSet(contador.get() + 1);
                    }  else if (simbolos.contains(dado)) {
                        tokens.add(new Token(contador.get(), "SS", dado));
                        contador.getAndSet(contador.get() + 1);
                    } else if (isNumero.matcher(dado).matches()) {
                        tokens.add(new Token(contador.get(), "LIT", dado));
                        contador.getAndSet(contador.get() + 1);
                    }
                });
        tokens.forEach(c -> System.out.println(c.toString()));
        logger.info("Finalização de analise léxica");
    }


    public void isDigitOrString(String dado) {
        for (int i = 0; i < dado.length(); i++) {
            if (Character.isDigit(dado.charAt(i)) == true) {
                System.out.println("Possui numeros");
                break;
            }
        }
    }
}
