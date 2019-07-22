# JavaConcurrentCollectionBenchmark

Multithreaded performance test of 10000 insertions into a collection per thread, for 4 concurrent threads. The manually synchronized collections are only synchronized for writes.

## Benchmarking results - concurrent WRITES

```bash
Running Concurrent Test for 4 cores

========== Sequential collections ==========

Running test for class java.util.ArrayList
Thread-0: 3.609 µs
Thread-1: 1.825 µs
Thread-2: 1.836 µs
Thread-3: 1.969 µs
Average: 2.31 µs

Running test for class java.util.concurrent.ConcurrentLinkedQueue
Thread-4: 10.246 µs
Thread-5: 2.772 µs
Thread-6: 3.606 µs
Thread-7: 2.303 µs
Average: 4.732 µs

Running test for class java.util.Collections$SynchronizedRandomAccessList
Thread-8: 1.39 µs
Thread-9: 1.272 µs
Thread-10: 1.206 µs
Thread-11: 0.881 µs
Average: 1.187 µs

Running test for class ConcurrentTest$ConcurrentArray
Thread-12: 2.857 µs
Thread-13: 6.339 µs
Thread-14: 1.582 µs
Thread-15: 1.535 µs
Average: 3.078 µs

Running test for class java.util.concurrent.CopyOnWriteArrayList
Thread-16: 100.928 µs
Thread-17: 258.428 µs
Thread-18: 378.966 µs
Thread-19: 467.414 µs
Average: 301.434 µs

Running test for class java.util.concurrent.CopyOnWriteArraySet
Thread-20: 240.928 µs
Thread-21: 652.527 µs
Thread-22: 839.479 µs
Thread-23: 1238.049 µs
Average: 742.746 µs

========== Set/Map collections ==========

Running test for class java.util.HashMap
Thread-24: 5.091 µs
Thread-25: 5.082 µs
Thread-26: 6.6 µs
Thread-27: 3.284 µs
Average: 5.014 µs

Running test for class java.util.concurrent.ConcurrentHashMap
Thread-28: 16.358 µs
Thread-29: 10.816 µs
Thread-30: 34.767 µs
Thread-31: 3.14 µs
Average: 16.27 µs

Running test for class java.util.LinkedHashMap
Thread-32: 9.312 µs
Thread-33: 7.741 µs
Thread-34: 7.702 µs
Thread-35: 6.307 µs
Average: 7.766 µs

Running test for class java.util.Hashtable
Thread-36: 7.231 µs
Thread-37: 6.779 µs
Thread-38: 5.314 µs
Thread-39: 7.556 µs
Average: 6.72 µs

Running test for class java.util.Collections$SynchronizedMap
Thread-40: 2.927 µs
Thread-41: 3.056 µs
Thread-42: 3.859 µs
Thread-43: 3.085 µs
Average: 3.232 µs
```
