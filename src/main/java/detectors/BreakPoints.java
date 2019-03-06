package detectors;

import com.github.javaparser.ast.expr.MethodCallExpr;

class BreakPoints {

    private String className;
    private String methodName;
    private int start;
    private int end;

    void addClass(String currClass) {
        this.className = currClass;
    }

    void addMethod(String methodName) {
        this.methodName = methodName;
    }

    void addNode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    void addRecursive(String methodName, MethodCallExpr m) {
        System.out.println( "Recursive : " + methodName );
        this.methodName = methodName;
        this.start = m.getRange().get().begin.line;
        this.end = m.getRange().get().end.line;

    }

    @Override
    public String toString() {
        return String.format( "Class Name=%s, Method Name =%s, Starting Line =%s, Ending Line=%s",
                this.className, this.methodName, this.start, this.end );
    }
}


