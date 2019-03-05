package detectors;

class BreakPoints {

    String className;
    String methodName;
    int start;
    int end;

    void addNode(String currClass, String currMethod, int start, int end) {
        this.className = currClass;
        this.methodName = currMethod;
        this.start = start;
        this.end = end;

        this.toString();
    }

    @Override
    public String toString() {
        return "Breakpoints = \n" + "Class : " + this.className + "\nMethod : " + this.methodName + " \nFrom line : " + start + " To : "  + end ;
    }

}


