package detectors;

import com.github.javaparser.ast.Node;

class BreakPoints {

    private String className;
    private String methodName;
    private int start;
    private int end;

    void addNode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    void addClass(String currClass) {
        this.className = currClass;
    }

    void addMethod(String currClass) {
        this.methodName = currClass;
    }

    @Override
    public String toString() {
        return String.format( "Class Name=%s, Method Name =%s, Starting Line =%s, Ending Line=%s",
                this.className, this.methodName, this.start, this.end );
    }

    public void addDNode(Node node) {
        System.out.println( node.getRange() );
    }
}


