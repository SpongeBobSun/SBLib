# SBLib
Some Base Libraries for Android developers. Or for myself's convenience.
Contains CustomView template and some enhanced Base Views.
Component may and will be used in my further projects.
Every time I finished a component, below index will be updated.
## Index of Content
### SBView
Provide a Base View for customize widgets. SBView can calculate View's width & height.
You can use getWidth() & getHeight() directly in onDraw() function.

### VolumeUtil
Raise or reduce a specific volume.

### VibrateUtil
Make device vibrate for a specific duration.

### View Injection.
This utility provide a view injection like the `butterknife` library.

This utility located in package sblib.bobsun.sblib.views.
####Usage
#####Initialize in activity
`new Injection(this);`

If you use any injection tools in this lib, you only need initialize once per class.
#####Inject a view

         @InjectView(R.id.id_textview)
         public TextView textView;

         @Override
         protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main);
             new Injection(this);
             textView.setText("Gooooood news everyone!");
         }

### ClickListener Injection
This utility provide a click listener injection like the `butterknife` library.

This utility located in package sblib.bobsun.sblib.views.
####Usage
#####Initialize in activity
`new Injection(this);`
If you use any injection tools in this lib, you only need initialize once per class.
#####Method declaration
`public void OnClickListenerFunctionName(View v)`
#####Inject a listener to view
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
        new Injection(this);
        textView.setText("Gooooood news everyone!");
    }
##About the name:
SB means 'Some Base', 'Sun.Bob' or 'Dumbass' in Chinese.
