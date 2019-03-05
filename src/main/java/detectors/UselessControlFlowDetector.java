package detectors;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;


class UselessControlFlowDetector extends VoidVisitorAdapter<BreakPoints> {

    private String currMethod, currClass;

    @Override
    public void visit(MethodDeclaration n, BreakPoints b) {
        setCurrMethod( n.getName().toString() );
        super.visit( n, b );
        if(n.getBody().isPresent()) b.addNode(currClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line ); 
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, BreakPoints b) {
        setCurrClass( n.getName().toString() );
        super.visit( n, b );

    }

    @Override
    public void visit(IfStmt n, BreakPoints b) {
        super.visit( n, b ); 
        if (codeAnalysis( n )) b.addNode(currClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line ); }

    @Override
    public void visit(ForStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n )) b.addNode(currClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line ); }

    @Override
    public void visit(WhileStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n )) b.addNode(currClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line ); }

    @Override
    public void visit(SwitchStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n )) b.addNode(currClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line ); }

    @Override
    public void visit(DoStmt n, BreakPoints b) {
        super.visit( n, b );
        if (codeAnalysis( n )) b.addNode(currClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line ); }


    private boolean codeAnalysis(Statement arg) {
        List <BlockStmt> node;
        node = arg.findAll( BlockStmt.class );
        for (BlockStmt n : node) {
            if (isEmptyBlock( n ))
                return true;
        }
        return false;
    }

    // Setters, Getters, Utilities.
    private void setCurrMethod (String currMethod) { this.currMethod = currMethod; }
    private void setCurrClass (String currClass){ this.currClass = currClass; }
    public String getCurrMethod () { return currMethod; }
    public String getCurrClass () { return currClass; }
    private boolean isEmptyBlock (BlockStmt n){ return n.getChildNodes().isEmpty(); }

}

