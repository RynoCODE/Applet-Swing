public class ThreadInfo {

    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.getThreadGroup());

        t.setName("My Thread");
        System.out.println(t);
    }
}
