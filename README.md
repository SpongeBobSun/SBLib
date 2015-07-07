# SBLib
Some Base Libraries for Android developers. Or for myself's convenience.
Contains CustomView template and some enhanced Base Views.
Component may and will be used in my further projects.
Every time I finished a component, below index will be updated.
## Index of Content
### View Injection.
This utility provide a view injection like the `butterknife` library.

This utility located in package sblib.bobsun.sblib.views.
####Usage
If the view variable is defined in an activity or view group, use `Injection.init(parent)` to initialize the injection.

If you use view injection in a fragment, you may need call `Injection.init(containerFragment, parentView)` to initialize the injection.

If you use any injection tools in this lib, you only need initialize once per class.
#####Sample - Inject a view in an activity

    public class MainActivity extends AppCompatActivity {
         @InjectView(R.id.id_textview)
         public TextView textView;

         @Override
         protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main);
             new Injection(this);
             textView.setText("Gooooood news everyone!");
         }

         ...
         blah blah blah
         ...
    }

#####Sample - Inject a view in a fragment

    public class TextFragment extends Fragment {
        @InjectView(R.id.id_textview_fragment_test)
        public TextView textView;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstantSate){
            View ret = inflater.inflate(R.layout.fragment_test,parent,false);
            Injection.init(this,ret);
            textView.setText("Need a friend?");
            return ret;
        }
    }

### ClickListener Injection
This utility provide a click listener injection like the `butterknife` library.

This utility located in package sblib.bobsun.sblib.views.
####Usage
#####Initialize in activity
Same strategy as ViewInjection

If you use any injection tools in this lib, you only need initialize once per class.
#####Method declaration
`public void OnClickListenerFunctionName(View v)`
#####Sample - Inject a listener to view in an activity
    public class MainActivity extends AppCompatActivity {

        @InjectView(R.id.id_textview)
        public TextView textView;

        @InjectClickListener(R.id.id_button)
        public void OnClick(View v){
            textView.setText("Fry is an idiot!");
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Injection.init(this, findViewById(R.id.id_linearlayout));
            textView.setText("Gooooood news everyone!");
        }

#####Sample - Inject a listener to view in a fragment
    public class TextFragment extends Fragment {
        @InjectView(R.id.id_textview_fragment_test)
        public TextView textView;
        @InjectClickListener(R.id.id_textview_fragment_test)
        public void onClick(View view){
            textView.setText("Why not Zoidberg?");
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstantSate){
            View ret = inflater.inflate(R.layout.fragment_test,parent,false);
            Injection.init(this,ret);
            textView.setText("Need a friend?");
            return ret;
        }
    }

###Network operation utility set
This utility set is located in sblib.bobsun.sblib.net

This utility set contains four part.
#####ConnectionBuilder
ConnectionBuilder wrapped HttpURLConnection, contains url address, request method, timeout, etc. You can get a HttpURLConnection from this builder. Also, you can write & read data from connection via this utility.

#####NetworkOperation
NetworkOperation contains async network operation. This is an abstract class and you only need to implement function `doNetworkOperation()`, which do the actual network job.

When network operation is complete, the `OnFinishHandler` will receive a message contains the result.
#####OnFinishHandler
A wrapped Handler class, has an abstract method `handleMessage()`, which recieve the network operation result.

This class is required when you initialize the NetworkOperation class.
#####OperationResult
Wrapped network result class.

####Sample - request JSON data when clicking a button
    @InjectClickListener(R.id.id_button)
    public void OnClick(View v){
        new NetworkOperation(new OnFinishHandler() {
            @Override
            public void handleMessage(Message msg) {
                Toast.makeText(MainActivity.this,""+msg.what,Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            public OperationResult doNetworkOperation() {
                OperationResult ret = new OperationResult();
                try {
                    String result = new ConnectionBuilder().setUrl("http://it-ebooks-api.info/v1/search/android/")
                            .getResponseFromConnection();
                    Log.e("result",result);
                    ret.setSuccess(true);
                    ret.setResultCode(1);
                } catch (IOException e) {
                    e.printStackTrace();
                    ret.setSuccess(false);
                    ret.setResultCode(-1);
                }
                return ret;
            }
        }.run();
    }

### SBView
Provide a Base View for customize widgets. SBView can calculate View's width & height.
You can use getWidth() & getHeight() directly in onDraw() function.
### Applications
####BaseApplication
Save Applications context and provide static setter & getter.

### VolumeUtil
Raise or reduce a specific volume.

### VibrateUtil
Make device vibrate for a specific duration.

##About the name:
SB means 'Some Base', 'Sun.Bob' or 'Dumbass' in Chinese.
