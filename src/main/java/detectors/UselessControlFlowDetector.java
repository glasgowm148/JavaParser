package detectors;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

class UselessControlFlowDetector extends VoidVisitorAdapter<BreakPoints> {

    private String currMethod;
    private String curClass;


    // Get the method name
    @Override
    public void visit(MethodDeclaration n, BreakPoints b) {
        setCurrMethod( n.getName().toString() );
        super.visit( n, b );

    }

    // Get the class name
    @Override
    public void visit(ClassOrInterfaceDeclaration n, BreakPoints b) {
        setCurrClass( n.getNameAsString() );
        super.visit( n, b );
    }

    @Override
    public void visit(IfStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n ))
            b.addNode( curClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line );
    }

    @Override
    public void visit(ForStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n ))
            b.addNode( curClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line );
    }

    @Override
    public void visit(WhileStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n ))
            b.addNode( curClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line );
    }

    @Override
    public void visit(SwitchStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n ))
            b.addNode( curClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line );
    }


    @Override
    public void visit(DoStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n ))
            b.addNode( curClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line );
    }


    @Override
    public void visit(TryStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n ))
            b.addNode( curClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line );
    }


    // Do Analysis
    private boolean codeAnalysis(Statement arg) {
        List <BlockStmt> node = null;
        node = arg.findAll( BlockStmt.class );

        for (BlockStmt n : node) if (n.isEmpty()) return true;

        return false;
    }

    public void setCurrMethod(String currMethod) {
        this.currMethod = currMethod;
    }

    public void setCurrClass(String currClass) {
        this.curClass = currClass;
    }


}

