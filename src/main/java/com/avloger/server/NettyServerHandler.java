package com.avloger.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author : avloger
 * @date : 2021/11/25 15:20
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<String> {
    /*
    通道读取就绪事件-接受客户端请求
     */
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("服务消息："+s);

    }

    /**
     * 通道读取完毕事件
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("我是Netty服务端");
    }
}
