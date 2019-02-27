package detectors;

import com.github.javaparser.ast.stmt.Statement;

import java.util.ArrayList;

/*
BreakPoints is a class which has an ArrayList of strings
when you dp breakpoint.add(node) it will parse the node into the required string format and add it to to the list of "breakpoint" strings
then when breakpoint.getOutput() is executed, it prints each string in the arraylist
 */

public class BreakPoints {

    StringBuilder sb = new StringBuilder();
    private ArrayList <Statement> breakpoints;


    public BreakPoints() {
        this.breakpoints = new ArrayList <Statement>();
    }

    void addNode(Statement n) {
        breakpoints.add( n );

        // sb.append( "className = 'Calculator'" + " methodName = " + "'" + "methodname" + "'" + " startline = " + "'" + start + "'" + " endline = " + "'" + end + "'" );

        System.out.println( sb.toString() );
    }

}


