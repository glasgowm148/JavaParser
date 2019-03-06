package detectors;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

class UselessControlFlowDetector extends VoidVisitorAdapter<BreakPoints> {

    // Get the method name
    @Override
    public void visit(MethodDeclaration n, BreakPoints b) {
        b.addMethod( n.getNameAsString() );
        super.visit( n, b );

    }

    // Get the class name
    @Override
    public void visit(ClassOrInterfaceDeclaration n, BreakPoints b) {
        b.addClass( n.getNameAsString() );
        super.visit( n, b );
    }

    @Override
    public void visit(IfStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n )) b.addNode( n.getRange().get().begin.line, n.getRange().get().end.line );
    }

    @Override
    public void visit(ForStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n )) b.addNode( n.getRange().get().begin.line, n.getRange().get().end.line );
    }

    @Override
    public void visit(WhileStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n )) b.addNode( n.getRange().orElse( null ).begin.line, n.getRange().get().end.line );
    }

    @Override
    public void visit(SwitchStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n )) b.addNode( n.getRange().get().begin.line, n.getRange().get().end.line );
    }


    @Override
    public void visit(DoStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n )) b.addNode( n.getRange().get().begin.line, n.getRange().get().end.line );
    }


    @Override
    public void visit(TryStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n )) b.addNode( n.getRange().get().begin.line, n.getRange().get().end.line );
    }


    // Do Analysis
    private boolean codeAnalysis(Statement arg) {
        List <BlockStmt> node = null;
        node = arg.findAll( BlockStmt.class );

        for (BlockStmt n : node) if (n.isEmpty()) return true;

        return false;
    }


}

