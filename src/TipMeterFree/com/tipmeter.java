package TipMeterFree.com;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class tipmeter extends Activity {
	private static long startTime = 0;
	private static long stopTime = 0;
	private static boolean running = false;
    int minutes;
    int seconds;
    double tip = 20;
    int attitude = 0;
    int food = 0;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button button1 = (Button) findViewById(R.id.Button01);
        final TextView times = (TextView) findViewById(R.id.TextView01);
        final TextView tips = (TextView) findViewById(R.id.Tips);
        final Button button2 = (Button) findViewById(R.id.Button02);
        final EditText tipamt = (EditText) findViewById(R.id.tip);
       
        final FrameLayout fl = new FrameLayout(this);
        final EditText input = new EditText(this);
        final TextView tv5 = (TextView)findViewById(R.id.TextView05);
    	
        input.setGravity(30);
        
        fl.addView(input, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT));

        input.setText("");
       
        final AlertDialog.Builder dl = new AlertDialog.Builder(this);

        dl.setView(fl);

        dl.setTitle("Please Enter Overall Experience. 1 - 10");

/*        new AlertDialog.Builder(this)
                .setView(fl)
                .setTitle("How Was The Server's Attitude")
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface d, int which) {

                                d.dismiss();                                
                        }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface d, int which) {
                                d.dismiss();
                                satisfaction = Integer.parseInt(input.getText().toString());
                        }
                }).create().show();

*/        
        new CountDownTimer(2147483647, 1000) {
        
            public void onTick(long millisUntilFinished) {
            	times.setText(Long.toString(getElapsedTimeSecs()));
            }

            public void onFinish() {
                
            }
         }.start();

         
         	
        	button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(button1.getText() == "Calculate Tip Below")
				{
					button1.setText("Click When Seated");
					return;
				}
				
				if(button1.getText().toString().indexOf("Seated") > 0)
				{
					button1.setText("Click When Greeted");
					tip = 20.00;
					times.setText("0");
					start();
					return;
				}
				
				if(button1.getText() == "Click When Greeted")
				{
					button1.setText("Drink Ordered");
					stop();
					times.setText(Long.toString(getElapsedTimeSecs()));
					
					if(getElapsedTimeSecs() >= 600)
						tip = tip - 2.25;
					else if(getElapsedTimeSecs() >= 540)
						tip = tip - 2;
					else if(getElapsedTimeSecs() >= 480)
						tip = tip - 1.75;
					else if(getElapsedTimeSecs() >= 420)
						tip = tip - 1.50;
					else if(getElapsedTimeSecs() >= 360)
						tip = tip - 1.25;
					else if(getElapsedTimeSecs() >= 300)
						tip = tip - 1;
					else if(getElapsedTimeSecs() >= 240)
						tip = tip - .75;
					else if(getElapsedTimeSecs() >= 180)
						tip = tip - .50;
					else if(getElapsedTimeSecs() >= 120)
						tip = tip - .25;
					//tips.setText(Double.toString(tip));
					return;
				}
				
				if(button1.getText() == "Drink Ordered")
				{
					button1.setText("Drink Received");
					times.setText("0");
					start();	
					return;
				}
				
				if(button1.getText() == "Drink Received")
				{
					button1.setText("Food Ordered");
					stop();
					times.setText(Long.toString(getElapsedTimeSecs()));
					if(getElapsedTimeSecs() >= 780)
						tip = tip - 2.25;
					else if(getElapsedTimeSecs() >= 720)
						tip = tip - 2;
					else if(getElapsedTimeSecs() >= 660)
						tip = tip - 1.75;
					else if(getElapsedTimeSecs() >= 600)
						tip = tip - 1.5;
					else if(getElapsedTimeSecs() >= 540)
						tip = tip - 1.25;
					else if(getElapsedTimeSecs() >= 480)
						tip = tip - 1;
					else if(getElapsedTimeSecs() >= 420)
						tip = tip - .75;
					else if(getElapsedTimeSecs() >= 360)
						tip = tip - .50;
					else if(getElapsedTimeSecs() >= 300)
						tip = tip - .25;
					//tips.setText(Double.toString(tip));
					return;
				}
				
				if(button1.getText() == "Food Ordered")
				{
					button1.setText("Food Received");
					times.setText("0");
					start();
					return;
				}
				
				if(button1.getText() == "Food Received")
				{
					button1.setText("Check Requested");
					stop();
					times.setText(Long.toString(getElapsedTimeSecs()));
					
					if(getElapsedTimeSecs() >= 1700)
						tip = tip - 2.25;
					else if(getElapsedTimeSecs() >= 1640)
						tip = tip - 2;
					else if(getElapsedTimeSecs() >= 1580)
						tip = tip - 1.75;
					else if(getElapsedTimeSecs() >= 1520)
						tip = tip - 1.50;
					else if(getElapsedTimeSecs() >= 1460)
						tip = tip - 1.25;
					else if(getElapsedTimeSecs() >= 1380)
						tip = tip - 1;
					else if(getElapsedTimeSecs() >= 1320)
						tip = tip - .75;
					else if(getElapsedTimeSecs() >= 1260)
						tip = tip - .50;
					else if(getElapsedTimeSecs() >= 1200)
						tip = tip - .25;
					//tips.setText(Double.toString(tip));
					return;
				}
				
				if(button1.getText() == "Check Requested")
				{
					button1.setText("Check Received");
					times.setText("0");
					start();	
					return;
				}
				
				if(button1.getText() == "Check Received")
				{
					button1.setText("Calculate Tip Below");
					stop();
					times.setText(Long.toString(getElapsedTimeSecs()));
					if(getElapsedTimeSecs() >= 780)
						tip = tip - 2.25;
					else if(getElapsedTimeSecs() >= 720)
						tip = tip - 2;
					else if(getElapsedTimeSecs() >= 660)
						tip = tip - 1.75;
					else if(getElapsedTimeSecs() >= 600)
						tip = tip - 1.5;
					else if(getElapsedTimeSecs() >= 540)
						tip = tip - 1.25;
					else if(getElapsedTimeSecs() >= 480)
						tip = tip - 1;
					else if(getElapsedTimeSecs() >= 420)
						tip = tip - .75;
					else if(getElapsedTimeSecs() >= 360)
						tip = tip - .50;
					else if(getElapsedTimeSecs() >= 300)
						tip = tip - .25;
					
					
				       dl.setPositiveButton("OK", new DialogInterface.OnClickListener(){
				            @Override
				            public void onClick(DialogInterface d, int which) {
				            	tv5.setText(input.getText().toString());    
				            	attitude = Integer.parseInt(tv5.getText().toString());    
					            
				            	if(attitude <= 1)
									tip = tip - 2.25;
								else if(attitude <= 2)
									tip = tip - 2;
								else if(attitude <= 3)
									tip = tip - 1.75;
								else if(attitude <= 4)
									tip = tip - 1.5;
								else if(attitude <= 5)
									tip = tip - 1.25;
								else if(attitude <= 6)
									tip = tip - 1;
								else if(attitude <= 7)
									tip = tip - .75;
								else if(attitude <= 8)
									tip = tip - .50;
								else if(attitude <= 9)
									tip = tip - .25;
								
								tips.setText(Double.toString(tip));
								tipamt.setText(Double.toString(tip));
								
				            	
				            	d.dismiss(); 
				            	
				            }
				    })
				    .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
				            @Override
				            public void onClick(DialogInterface d, int which) {
				            	d.dismiss();
				            }
				    }).create().show();
				       
				       
				   return;
				}
			}
			}
		);
        	button2.setOnClickListener(new View.OnClickListener() {
    			@Override
    			public void onClick(View v) {   
    				
    				  final EditText tipper = (EditText) findViewById(R.id.tip);
    				  final EditText bill = (EditText) findViewById(R.id.bill);
    				  final EditText people = (EditText) findViewById(R.id.people);
    			      final TextView tipamt = (TextView) findViewById(R.id.tipamt);
    			      final TextView totalperperson = (TextView) findViewById(R.id.total);
    			      double billamt = 0.0;
    			      double tippercent = 0.0;
    			      int peoplenum = 0;
    			      double tperperson = 0.0;
    			      double totaltip = 0.0;
    			      double totalper = 0.0;
    			      
    			      //stores the bill amt into variable
    			      billamt = Double.parseDouble(bill.getText().toString());
    			      tippercent = Double.parseDouble(tipper.getText().toString());
    			      peoplenum = Integer.parseInt(people.getText().toString());
    			      tippercent = tippercent / 100;
    			      totaltip = (billamt * tippercent);
    			      
    			      tperperson = totaltip / peoplenum;
    			      tipamt.setText(Double.toString(tperperson));
    			      totalper = (totaltip + billamt) / peoplenum;
    			      totalperperson.setText(Double.toString(totalper));
    			}});
    }

    public static void start() {
        startTime = System.currentTimeMillis();
        running = true;
    }

    
    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
    }

    
    //elaspsed time in milliseconds
    public long getElapsedTime() {
        long elapsed;
        if (running) {
             elapsed = (System.currentTimeMillis() - startTime);
        }
        else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }
    
    
    //elaspsed time in seconds
    public long getElapsedTimeSecs() {
        long elapsed;
        if (running) {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        }
        else {
            elapsed = ((stopTime - startTime) / 1000);
        }
        return elapsed;
    }


    }
