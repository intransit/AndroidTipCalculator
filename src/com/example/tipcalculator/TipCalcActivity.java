package com.example.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalcActivity extends Activity {
	
	private double amount;
	private String itemText;
	private EditText etNewAmount;
	private EditText etFinalTipValue;
	private EditText etCustomTipValue;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calc);
		
		etNewAmount = (EditText)findViewById(R.id.etNewAmount);
		etFinalTipValue = (EditText)findViewById(R.id.etFinalTipValue);
		etCustomTipValue = (EditText)findViewById(R.id.etCustomTipValue);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calc, menu);
		return true;
	}

	//TODO:
	//tip change automatically on changing the total -- without hitting any tip % button -- textChangeist
	//moving the stuff around in the layout --- its relative, so everything change if I change one thing?
	//round off to 2 digits
	//using adaptor? -- not using any view, so dont need adaptor, ryt?
	//different functions for different tip %...other way??
	
	public void onCalcTip_10(View v){
		itemText = etNewAmount.getText().toString();
		
		if(itemText.equals("") || !isNumeric(itemText))
			Toast.makeText(this, "Enter a valid total!", Toast.LENGTH_SHORT).show();
		else{
			amount = Double.parseDouble(itemText);
			double tip = amount*0.1;
			etFinalTipValue.setText("$"+tip);
		}
	}
	
	public void onCalcTip_15(View v){
		itemText = etNewAmount.getText().toString();
		
		if(itemText.equals("") || !isNumeric(itemText))
			Toast.makeText(this, "Enter a valid total!", Toast.LENGTH_SHORT).show();
		else{
			amount = Double.parseDouble(itemText);
			double tip = amount*0.15;
			etFinalTipValue.setText("$"+tip);
		}
	}
	
	public void onCalcTip_20(View v){
		itemText = etNewAmount.getText().toString();
		
		if(itemText.equals("") || !isNumeric(itemText))
			Toast.makeText(this, "Enter a valid total!", Toast.LENGTH_SHORT).show();
		else{
			amount = Double.parseDouble(itemText);
			double tip = amount*0.2;
			etFinalTipValue.setText("$"+tip);
		}
	}
	
	public void onCalcTip_custom(View v){
		itemText = etNewAmount.getText().toString();
		
		if(itemText.equals("") || !isNumeric(itemText))
			Toast.makeText(this, "Enter a valid total!", Toast.LENGTH_SHORT).show();
		else{
			amount = Double.parseDouble(itemText);		
			String custTipText = etCustomTipValue.getText().toString();
			
			if(custTipText.equals("") || !isNumeric(custTipText))
				Toast.makeText(this, "Enter a valid tip!", Toast.LENGTH_SHORT).show();
			else{
				double custTip = Double.parseDouble(custTipText);
				double tip = amount*(custTip/100);
				etFinalTipValue.setText("$"+tip);
			}
		}
	}
	
	private boolean isNumeric(String str){  
		try{  
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe){  
			return false;  
		}  
	  
		return true;  
	}
}
