package repo;

import java.io.InputStream;
import java.io.PrintStream;

public abstract class BaseProblem {

    protected InputStream in;
    protected PrintStream out;

    public BaseProblem(InputStream in, PrintStream out) {
            this.in = in;
            this.out = out;
    }

    public BaseProblem() {
        this.in = System.in;
        this.out = System.out;
    }

    public void setInputStream(InputStream in) {
        this.in = in;
    }

    public void setPrintStream(PrintStream out) {
        this.out = out;
    }

    public abstract void solve();
}
