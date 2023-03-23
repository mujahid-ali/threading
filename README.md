# threading

threading1:-> Creation of thread
If we call run method directly then new thread will not be started, and run will execute in main thread.
extends Thread
implements Runnable
Annonymous Runnable implementation 
Executor(Thread pool)

threading2:-> synchronization, volatile
It might be possible that one thread is using a data and cached it and it might not get the latest data from io/file/memory,
it might cause inconsistency if volatile is used then this problem can be avoided.

threading3:-> synchronized keyword