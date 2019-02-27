package detectors;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.Statement;

import java.util.ArrayList;

/*
BreakPoints is a class which has an ArrayList of strings
when you dp breakpoint.add(node) it will parse the node into the required string format and add it to to the list of "breakpoint" strings
then when breakpoint.getOutput() is executed, it prints each string in the arraylist
 */

public class BreakPoints {

    ArrayList breakpoints = new ArrayList<BreakPoints>();


    void addNode(Statement n) {
        StringBuilder sb = new StringBuilder();

        int start = n.getRange().get().begin.line;
        int end = n.getRange().get().end.line;
        String methodName = String.valueOf( n.getClass() );



        sb.append( "className = 'Calculator'" + " methodName = " + "'" + methodName + "'" + " startline = " + "'" + start + "'" + " endline = " + "'" + end + "'" );



        System.out.println(sb.toString());
    }


    //@Override
  /*  public void visit(MethodDeclaration md, BreakPoints b) {
        b.visit( md, b );
        StringBuilder sb = new StringBuilder();

        int start = md.getRange().get().begin.line;
        int end = md.getRange().get().end.line;
        String methodName = md.getName().asString();


        if (!md.getBody().get().getStatements().isNonEmpty()) {
            sb.append( "className = 'Calculator'" + " methodName = " + "'" + methodName + "'" + " startline = " + "'" + start + "'" + " endline = " + "'" + end + "'" );

        }

        breakpoints.addNode( md );

    } */

    public String getOutput() {
        String result = "";
        for (Object item : breakpoints) {
            result += item.toString();
        }

        return result;
    }
}

  /*  public void printNode(String prefix) {
        if (this.left != null)
            System.out.println(left.getAccessibleContext());
        System.out.println(prefix + this);
        if (this.right != null)
            System.out.println(left.getAccessibleContext());
    }
}




/*

     sb.append( "className = 'Calculator'" + " methodName = " + "'" + methodName + "'" + " startline = " + "'" + start + "'" + " endline = " + "'" + end + "'" );
            stringPrinter( sb );

  System.out.println(st.getParentNode());
        System.out.println(st.getMetaModel());
        System.out.println(st.getChildNodes());

    int start = st.getRange().get().begin.line;
    int end = st.getRange().get().end.line;
    ExplicitConstructorInvocationStmt methodName = st.asExplicitConstructorInvocationStmt();
    StringBuilder sb = new StringBuilder();

    static void stringPrinter(StringBuilder sb) {
        if (i == 0) System.out.println( "Useless Control Flow:" );
        System.out.println( sb );
        ++i;
    }
StringBuilder sb = new StringBuilder();
        String start = String.valueOf( n.getRange().get().begin.line );
        String end = String.valueOf( n.getRange().get().end.line );
        String methodName = String.valueOf( n.getMetaModel() );
}

      //  this.visit( n, breakpoints );

      //  b.visit( md, b );
*/
