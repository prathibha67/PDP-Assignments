package com.example.ThreadService;

public class LoggerService {
    private static LoggerService instance;
    private static final Object single=new Object(); // A single object for synchronization

    // Private constructor to prevent external instantiation
    private LoggerService(){

    }

    // Method will double check the locking
    public static LoggerService getInstance(){
        if(instance==null){
            synchronized(single){
                if(instance==null)
                {
                    instance=new LoggerService();
                }
            }
        }
        return instance;
    }

    // Prints the message
    public void log(String message){
        System.out.println("Log:"+message);
    }

}
