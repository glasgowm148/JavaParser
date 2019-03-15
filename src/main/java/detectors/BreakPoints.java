package detectors;

import com.github.javaparser.ast.expr.MethodCallExpr;

import java.util.ArrayList;

class BreakPoints {

    private static ArrayList <BreakPoints> breakpoints = new ArrayList <>();
    private String className;
    private String methodName;
    private int start;
    private int end;
    private long skipVal;

    public BreakPoints(String className, String methodName, int start, int end) {
        this.className = className;
        this.methodName = methodName;
        this.start = start;
        this.end = end;
    }

    public BreakPoints() {

    }


    void addNode(String currClass, String currMethod, int start, int end) {
        this.className = currClass;
        this.methodName = currMethod;
        this.start = start;
        this.end = end;
        BreakPoints p1 = new BreakPoints( className, methodName, start, end );
        breakpoints.add( p1 );
    }

    void addRecursive(String methodName, MethodCallExpr m) {
        this.className = className;
        this.methodName = methodName;
        this.start = m.getRange().get().begin.line;
        ;
        this.end = m.getRange().get().end.line;
        ;
        System.out.println( String.format( "Class Name=%s, Method Name =%s, Starting Line =%s, Ending Line=%s",
                className, methodName, start, end ) );

    }

    void clear() {
        breakpoints = new ArrayList <>();
    }

    @Override
    public String toString() {
        for (BreakPoints b : breakpoints) {
            return String.format( "Class Name=%s, Method Name =%s, Starting Line =%s, Ending Line=%s",
                    className, methodName, start, end );
        }
        clear();
        return "";
    }
}


