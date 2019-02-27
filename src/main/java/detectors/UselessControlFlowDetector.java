package detectors;


import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class UselessControlFlowDetector extends VoidVisitorAdapter <BreakPoints> {


    void checkEmpty(Statement n, BreakPoints b) {
        boolean noKids = n.getChildNodes().size() == 0;
        boolean emptyStatement = n.isEmptyStmt();
        boolean onlyComments = n.getOrphanComments().size() == n.getChildNodes().size();


        if (noKids || emptyStatement || onlyComments) {
            b.addNode( n );
        }
    }

    @Override
    public void visit(IfStmt n, BreakPoints b) {
        super.visit( n, b );
        checkEmpty( n.getThenStmt(), b );

        if (n.hasElseBranch()) {
            checkEmpty( n.getElseStmt().get(), b );
        }
    }
}


/*
        public List<Breakpoints> analyze(File source) throws IOException, ParseException {
            List<Breakpoints> List = new ArrayList<>();
            CompilationUnit cu = JavaParser.parse(source);
            VoidVisitorAdapter visitor = new VoidVisitorAdapter(){
                cu.accept(new visitor<List<Breakpoints>>(), null);
            }



        @Override
        public void accept(List v) {
            v.visit(this);
        }
            }

       n.getCondition().accept(this., n);
        n.getElseStmt().ifPresent((l) -> {
            l.accept(this, arg);

        });
        n.getThenStmt().accept(this, arg);
        n.getComment().ifPresent((l) -> {
            l.accept(this, arg);

        });
 */