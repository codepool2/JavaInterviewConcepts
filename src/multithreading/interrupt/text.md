Wheneve we call interrupt on any thread using another thread, then the effcted threads
interrupted status is set to true. But it wont cause any harm.
Now its upon the developer, how he is going to handle it, he can check for id whether thread is interrupted, if it is he can stop executing the thread manually.

And the same way, If a thread interrupts a thread which is sleeping or in wait stage, then the thread will throw interuupted exception
