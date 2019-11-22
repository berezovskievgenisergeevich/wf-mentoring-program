package com.epam.introdactionToJVM.homework.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * java.lang.StackOverflowError. Do not use recursive methods. Don’t tune stack size.
 */
public class Stackoverflow {
    public static void generateStackOverflow(){
        Handler.Chain chain = new Handler.Chain();
        chain.setHandlers(10000);
        chain.process();
    }
    static class Handler {
        void handle(Chain chain) {
            chain.process();
            System.out.println("yeah");
        }


        static class Chain {

            private List<Handler> handlers = new ArrayList<>();
            private int n = 0;

            public void setHandlers(int count) {
                int i = 0;
                while (i++ < count) {
                    handlers.add(new Handler());
                }
            }

            public void process() {
                if (n < handlers.size()) {
                    Handler handler = handlers.get(n++);
                    handler.handle(this);
                }
            }
        }

    }
}