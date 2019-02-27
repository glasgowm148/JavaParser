VoidVisitorAdapter<A>
* extends Object
* implements VoidVisitor<A>


IfStmt
* extends Statement



```java
    ``` taken from .class file```
    @Override
    public void visit (IfStmt n, Breakpoints arg) {
        n.getCondition().accept(this, arg);
        n.getElseStmt().ifPresent((l) -> {
            l.accept(this, arg);
        });
        n.getThenStmt().accept(this, arg);
        n.getComment().ifPresent((l) -> {
            l.accept(this, arg);
        });
    }
```

Accepts the given void visitor ? 

```java
accept
`accept` in class `Node`

public abstract <A> void accept(VoidVisitor<A> v,
                                A arg)
Accept method for visitor support.
Accept method for visitor support is specified 
by the following type parameters

A - the type the argument passed for the visitor
v - the visitor implementation
arg - any value relevant for the visitor

The description is copied from class: `Node`


```