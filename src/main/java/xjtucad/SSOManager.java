package xjtucad;

import xjtucad.manager.ITokenManager;

import xjtucad.manager.imp.StandTokenManger;
import xjtucad.manager.imp.nio.ClientTokenManager;
import xjtucad.manager.imp.nio.ServerTokenManager;
import xjtucad.model.SSOConf;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

public class SSOManager {

    static int mode = 0;
    public final static int SERVER_MODE = 2;
    public final static int CLIENT_MODE = 1;
    public final static int STAND_MODE=0;
    ITokenManager tokenManager = null;
    static SSOManager ssoManager = new SSOManager();
    private String ssoLoginUrl = "";
    //单例模式 公有实例获取方法
    public static SSOManager getInstance(){
        return ssoManager;
    }
    //单例模式 私有构造方法
    private SSOManager() {
        SSOConf serverConf = null;
        SSOConf clientConf = null;
        Context initCtx = null;
        Context ctx = null;
        boolean is = false;
        try {
            //尝试建立服务端TokenManager
            initCtx = new InitialContext();
            ctx = (Context) initCtx.lookup("java:comp/env");
            serverConf = (SSOConf)ctx.lookup("sso/server");  //项目名要与context.xml里面的对应
            tokenManager = new ServerTokenManager(serverConf);
            mode = SERVER_MODE;
            is=true;
        } catch (NamingException e) {
            System.out.println("没有找到Server配置");
            try {
                //尝试建立客户端TokenManager
                initCtx = new InitialContext();
                ctx = (Context) initCtx.lookup("java:comp/env");
                clientConf = (SSOConf)ctx.lookup("sso/client");
                tokenManager = new ClientTokenManager(clientConf);
                is=true;
                mode = CLIENT_MODE;
                ssoLoginUrl = "http://"+clientConf.getRemoteHost()+':'+clientConf.getRemoteTomcatPort();
            } catch (NamingException e1) {
                System.out.println("没有找到Client配置");
            }catch (IOException e1){
                System.out.println("连接服务器失败");
            }
        }
        if(!is){
            //建立标准的TokenManager
            System.out.println("进入单机模式");
            tokenManager = new StandTokenManger();
            mode = STAND_MODE;
        }
    }

    public ITokenManager getTokenManager() {
        return tokenManager;
    }

    public int getMode() {
        return mode;
    }

    public String getSsoLoginUrl() {
        return ssoLoginUrl;
    }


}
