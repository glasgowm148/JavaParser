package detectors;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;


public class UselessControlFlowDetector extends VoidVisitorAdapter <List <String>> {

    @Override
    public void visit(FieldDeclaration fd, Void arg) {
        super.visit( fd, arg ); //Do not delete
    }

    @Override
    public void visit(MethodDeclaration md, Void arg) {
        super.visit( md, arg );//Do not delete
    }


