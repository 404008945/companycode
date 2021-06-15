package overload;


import static java.lang.Thread.sleep;

public class Chair {
    static boolean gcrun = false;
    static boolean f = false;
    static int created = 0;
    static int finalized = 0;
    private int x = get();
    private  int b = 0;
    int i;

    int get(){
        return b;
    }

    Chair() {
        i = ++created;
        if (created == 47)
            System.out.println("Created 47");
    }

    protected void finalize() {
        if (!gcrun) {
            gcrun = true;
            System.out.println(
                    "Beginning to finalize after " +
                            created + " Chairs have been created");
        }
        if (i == 47) {
            System.out.println(
                    "Finalizing Chair #47, " +
                            "Setting flag to stop Chair creation");
            f = true;
        }
        finalized++;
        if (finalized >= created)
            System.out.println(
                    "All " + finalized + " finalized");
    }
}

class Garbage {
    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0) {
            System.err.println("Usage: \n" +
                    "java Garbage before\n or:\n" +
                    "java Garbage after");
            return;
        }
        while (!Chair.f) {
            new Chair();
            new String("To take up space");
        }
        System.out.println(
                "After all Chairs have been created:\n" +
                        "total created = " + Chair.created +
                        ", total finalized = " + Chair.finalized);
        if (args[0].equals("before")) {
            System.out.println("gc():");
            System.gc();
            System.out.println("runFinalization():");
            System.runFinalization();
        }
        System.out.println(
                "gc after all Chairs have been created:\n" +
                        "total created = " + Chair.created +
                        ", total finalized = " + Chair.finalized);
        System.gc();
        sleep(200000);

        System.out.println("bye!");
        if (args[0].equals("after"))
            System.runFinalizersOnExit(true);
    }
}