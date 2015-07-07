package sblib.bobsun.sblib.net;

/**
 * Created by bobsun on 15-7-7.
 */
public class OperationResult {
    private boolean mSuccess;
    private String mErrText;
    private int mResultCode;
    private Exception mException;

    public boolean isSuccess() {
        return mSuccess;
    }

    public void setSuccess(boolean mSuccess) {
        this.mSuccess = mSuccess;
    }

    public String getErrText() {
        return mErrText;
    }

    public void setErrText(String mErrText) {
        this.mErrText = mErrText;
    }

    public Exception getException() {
        return mException;
    }

    public void setException(Exception mException) {
        this.mException = mException;
    }

    public int getResultCode() {
        return mResultCode;
    }

    public void setResultCode(int mResultCode) {
        this.mResultCode = mResultCode;
    }
}
