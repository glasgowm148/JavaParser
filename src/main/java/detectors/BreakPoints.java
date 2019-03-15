package detectors;

import com.github.javaparser.ast.expr.MethodCallExpr;

import java.util.ArrayList;

class BreakPoints {

    private String className;
    private String methodName;
    private int start;
    private int end;
    ArrayList breakp = new ArrayList <BreakPoints>();


    void addNode(String currClass, String currMethod, int start, int end) {
        this.className = currClass;
        this.methodName = currMethod;
        this.start = start;
        this.end = end;
        BreakPoints bp = new BreakPoints();
        bp.setMethod( methodName );
        breakp.add( bp );
    }

    void addRecursive(String methodName, MethodCallExpr m) {

        System.out.println( "Recursive : " + methodName );

        this.methodName = methodName;
        this.start = m.getRange().get().begin.line;
        this.end = m.getRange().get().end.line;
        BreakPoints bp = new BreakPoints();
        bp.setMethod( methodName );
        breakp.add( bp );
    }

    private void setMethod(String methodName) {
        this.methodName = methodName;
    }

    void clear() {
        breakp = new ArrayList();

    }

    @Override
    public String toString() {
        for (Object b : breakp) {
            return String.format( "Class Name=%s, Method Name =%s, Starting Line =%s, Ending Line=%s",
                    className, methodName, start, end );
        }
        clear();
        return "";
    }
}


