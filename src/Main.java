import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            // crear un analizador léxico que se alimenta a partir de la entrada (archivo  o consola)
            KotlinLexer lexer1;
            KotlinLexer lexer2;

            lexer1 = new KotlinLexer(CharStreams.fromFileName("./input/entrada.kt"));
            lexer2 = new KotlinLexer(CharStreams.fromFileName("./input/entrada2.kt"));

            // Identificar al analizador léxico como fuente de tokens para el sintactico
            //CommonTokenStream tokens = new CommonTokenStream(lexer1);
            // Crear el objeto correspondiente al analizador sintáctico que se alimenta a partir del buffer de tokens

            List<Integer> listaTokens1 = new ArrayList<>();
            for (Token token = lexer1.nextToken(); token.getType() != Token.EOF; token=lexer1.nextToken()){
                if (token.getType() != 3 && token.getType() != 5){
                    listaTokens1.add(token.getType());
                }
                //System.out.println(token.getType() + "--" + token.getText());
            }

            List<Integer> listaTokens2 = new ArrayList<>();
            for (Token token = lexer2.nextToken(); token.getType() != Token.EOF; token=lexer2.nextToken()){
                if (token.getType() != 3 && token.getType() != 5){
                    listaTokens2.add(token.getType());
                }
                //System.out.println(token.getType() + "--" + token.getText());
            }

            int rigurosidad = 5;

            List<Integer> listaAux = new ArrayList<>();
            int contador = 0;

            for (Integer token : listaTokens2) {
                if(contador<rigurosidad){
                    listaAux.add(token);
                    contador++;
                }else{
                    contador = 0;
                    listaAux.clear();
                }

                if (contador == rigurosidad){
                    System.out.println(Collections.indexOfSubList(listaTokens1 , listaAux));
                }
            }

            /*
            List list = new ArrayList();
            List sublist = new ArrayList();

            list.add("a");
            list.add("b");
            list.add("c");
            list.add("d");
            list.add("e");
            list.add("a");
            list.add("q");

            sublist.add("a");
            sublist.add("q");

            System.out.println(list.toString());
            System.out.println(sublist.toString());
            System.out.println(Collections.indexOfSubList(list , sublist));

             */



/*
            BCCParser parser = new BCCParser(tokens);
            ParseTree tree = parser.prog(); // Iniciar el analisis sintáctico en la regla inicial: r

            //------------------
            // Create a generic parse tree walker that can trigger callbacks
            ParseTreeWalker walker = new ParseTreeWalker();
            // Walk the tree created during the parse, trigger callbacks
            walker.walk(new Traductor(), tree);
            System.out.println(); // print a \n after translation
            //-------------------
*/
            //System.out.println(tree.toStringTree(parser)); // imprime el arbol al estilo LISP
        } catch (
                Exception e) {
            System.err.println("Error (Test): " + e);
        }
    }
}
