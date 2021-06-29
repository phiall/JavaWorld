package cn.phil.core.io.bio;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author px
 * @date 2021/3/8 16:51
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(1008);
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maxPoolSize = Runtime.getRuntime().availableProcessors() * 2;
        long keepAliveTime = 5;
        TimeUnit keepAliveTimeUnit = TimeUnit.MINUTES;
        int queSize = 100_000;
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("ThreadPoolUtils")
                .build();

        ExecutorService es = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
                keepAliveTime, keepAliveTimeUnit, new ArrayBlockingQueue<>(queSize)
                , threadFactory);
        while (true) {
            Socket accept = socket.accept();
            es.submit(new SocketHandler(accept));
        }
    }
    static class SocketHandler implements Runnable {
        private Socket socket;
        public SocketHandler(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            byte[] cache = new byte[1024];
            try {
                int len = -1;
                while ((len = socket.getInputStream().read(cache)) > 0) {
                    System.out.println(new String(cache, 0, len));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
