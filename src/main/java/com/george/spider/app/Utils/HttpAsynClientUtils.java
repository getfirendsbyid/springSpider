package com.george.spider.app.Utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

public class HttpAsynClientUtils {
    private static DefaultConnectingIOReactor IOReactor;
    private static PoolingNHttpClientConnectionManager PoolNManger;
    private static String EMPTY_STR = "";
    /**
     * 定义一个连接池
     * @throws IOReactorException
     */
    public static void poolInit() throws IOReactorException {
        try{
            if (IOReactor == null && PoolNManger == null){
                //定义reactor IO复用模式
                IOReactor = new DefaultConnectingIOReactor();
                //asyncHttpClient使用PoolingNHttpClientConnectionManager管理我们客户端连接
                PoolNManger = new PoolingNHttpClientConnectionManager(IOReactor);
                //设置总共的连接的最大数量
                PoolNManger.setMaxTotal(2000);
                //设置每个路由的连接的最大数量
                PoolNManger.setDefaultMaxPerRoute(1000);
            }
        }catch (IOReactorException e){
            throw new IOReactorException("异步连接池创建失败，请检查");
        }
    }
    /**
     *
     * @return
     * 创建一个异步客户端，并设置异步连接池
     */
    private static CloseableHttpAsyncClient getHttpAsynClient(){
        //创建一个异步客户端，并设置异步连接池
        CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.custom().setConnectionManager(PoolNManger).build();
        //启动异步客户端
        httpAsyncClient.start();
        //返回当前对象的异步客户端
        return httpAsyncClient;
    }
    /**
     * @param url
     * @return
     */
    public static String httpGetRequest(String[] url) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        //创建一个定时器
        final CountDownLatch latch = new CountDownLatch(url.length);
        System.out.println("all:" + latch.getCount());
        CloseableHttpAsyncClient httpAsyncClient = getHttpAsynClient();
        for (final  String uri:url){
            final HttpGet httpGet = new HttpGet(uri);
            httpAsyncClient.execute(httpGet, new FutureCallback<HttpResponse>() {
                @Override
                public void completed(HttpResponse httpResponse) {
                    latch.countDown();
                    System.out.println("success:" + latch.getCount());
                }

                @Override
                public void failed(Exception e) {
                    latch.countDown();
                    System.out.println("failed:" + latch.getCount());
                }

                @Override
                public void cancelled() {
                    latch.countDown();
                    System.out.println("cancelled:" + latch.getCount());
                }
            });
        }
        latch.await();
        System.out.println("用时:"+(System.currentTimeMillis()-start));
        httpAsyncClient.close();
        return "请求结束";
    }
}
