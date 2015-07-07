package sblib.bobsun.sblib.net;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by bobsun on 15-7-7.
 */

/**
 * A OnFinishHandler allows you to send a message after the network operation is done.
 * <b>OnFinishHandler must be instanced in your main thread. Or in a thread WITH a Looper, more precisely.</b>
 * This is an abstract class and has only one method to be implement, you can process result from network operation.
 */
public abstract class OnFinishHandler extends Handler {
    public OnFinishHandler() {
        super();
    }

    @Override
    public abstract void handleMessage(Message msg);

    /**
     * Parse operation result into an object and send message to Handler.
     * @param result OperationResult passed from NetworkOperation class.
     */
    public void returnResult(OperationResult result){
        Message message = new Message();
        Bundle bundle = new Bundle();
        message.what = result.getResultCode();
        bundle.putString("ErrText",result.getErrText());
        bundle.putBoolean("Success",result.isSuccess());
        message.setData(bundle);
        this.sendMessage(message);
    }
}
