package sblib.bobsun.sblib.net;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.lang.reflect.Method;
import java.util.Objects;

import sblib.bobsun.sblib.net.annotations.NetworkResult;

/**
 * Created by bobsun on 15-7-7.
 */
public abstract class NetworkOperation {

    private String mTag;
    private Object mObject;
    private OnFinishHandler mHandler;
    public NetworkOperation(Object object, String operationTag){
        this.mTag = operationTag;
        this.mObject = object;
    }

    public NetworkOperation(OnFinishHandler handler){
        this.mHandler = handler;
    }

    public abstract OperationResult doNetworkOperation();



    public void run(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OperationResult result = doNetworkOperation();
                if (result == null)
                    throw new NullPointerException("Function doNetworkOperation can not return null!");
                mHandler.returnResult(result);
            }
        }).start();
    }

//    private void findHandlerAndRun(){
//        for (Method method : mObject.getClass().getDeclaredMethods()){
//            if (method.isAnnotationPresent(NetworkResult.class)){
//
//            }
//        }
//    }
}
