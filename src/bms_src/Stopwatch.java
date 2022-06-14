package bms_src;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Stopwatch<T> {
    public final TimeUnit timeUnit;
    public final long time;
    public final T[] returned;

    public Stopwatch(Supplier<T> supplier) {
        this(supplier, System::currentTimeMillis, TimeUnit.MILLISECONDS);
    }

    @SuppressWarnings("unchecked")
    public Stopwatch(Supplier<T> supplier, Supplier<Long> timer, TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        long st = timer.get();
        returned = (T[]) new Object[]{supplier.get()};
        time = timer.get() - st;
    }

    public Stopwatch(Supplier<T> supplier, int size) {
        this(supplier, size, System::currentTimeMillis, TimeUnit.MILLISECONDS);
    }

    @SuppressWarnings("unchecked")
    public Stopwatch(Supplier<T> supplier, int size, Supplier<Long> timer, TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        long totalTime = 0;
        returned = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            long st = timer.get();
            returned[i] = supplier.get();
            totalTime += timer.get() - st;
        }
        time = totalTime;
    }

    public static long timeOf(Runnable runnable) {
        return timeOf(runnable, System::currentTimeMillis);
    }

    public static long timeOf(Runnable runnable, Supplier<Long> timer) {
        long st = timer.get();
        runnable.run();
        return timer.get() - st;
    }

    public static long timeOf(Runnable runnable, int size) {
        return timeOf(runnable, size, System::currentTimeMillis);
    }

    public static long timeOf(Runnable runnable, int size, Supplier<Long> timer) {
        long totalTime = 0;
        for (int i = 0; i < size; i++) {
            long st = timer.get();
            runnable.run();
            totalTime += timer.get() - st;
        }
        return totalTime;
    }

    public static<E> E printDirectly(Supplier<E> supplier, String supplierName) {
        return printDirectly(supplier, System::currentTimeMillis, TimeUnit.MILLISECONDS, supplierName);
    }

    public static<E> E printDirectly(Supplier<E> supplier, Supplier<Long> timer, TimeUnit timeUnit, String supplierName) {
        long st = timer.get();
        E result = supplier.get();
        System.out.println(supplierName + " took " + (timer.get() - st) + " " + timeUnit);
        return result;
    }

    public static<E> E[] printDirectly(Supplier<E> supplier, int size, String runnableName) {
        return printDirectly(supplier, size, System::currentTimeMillis, TimeUnit.MILLISECONDS, runnableName);
    }

    @SuppressWarnings("unchecked")
    public static<E> E[] printDirectly(Supplier<E> supplier, int size, Supplier<Long> timer, TimeUnit timeUnit, String runnableName) {
        long totalTime = 0;
        E[] results = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            long st = timer.get();
            results[i] = supplier.get();
            totalTime += timer.get() - st;
        }
        System.out.println(size + " consecutive executions of " + runnableName + " took " + ((double) totalTime / size) + " " + timeUnit + " on average");
        return results;
    }

    public static void printDirectly(Runnable runnable, String runnableName) {
        printDirectly(runnable, System::currentTimeMillis, TimeUnit.MILLISECONDS, runnableName);
    }

    public static void printDirectly(Runnable runnable, Supplier<Long> timer, TimeUnit timeUnit, String runnableName) {
        long st = timer.get();
        runnable.run();
        System.out.println(runnableName + " took " + (timer.get() - st) + " " + timeUnit);
    }

    public static void printDirectly(Runnable runnable, int size, String runnableName) {
        printDirectly(runnable, size, System::currentTimeMillis, TimeUnit.MILLISECONDS, runnableName);
    }

    public static void printDirectly(Runnable runnable, int size, Supplier<Long> timer, TimeUnit timeUnit, String runnableName) {
        long totalTime = 0;
        for (int i = 0; i < size; i++) {
            long st = timer.get();
            runnable.run();
            totalTime += timer.get() - st;
        }
        System.out.println(size + " consecutive executions of " + runnableName + " took " + ((double) totalTime / size) + " " + timeUnit + " on average");
    }
}
