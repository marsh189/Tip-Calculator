package edu.chapman.cpsc356.tipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText cost;
    private EditText rating;
    private TextView bill;
    private TextView service;
    private TextView rateText;
    private TextView description;
    private TextView tipCost;
    private TextView tipText;
    private float finalCost;
    private float tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.cost = (EditText)findViewById(R.id.editTextCost);
        this.rating = (EditText)findViewById(R.id.editTextRating);
        this.bill = (TextView)findViewById(R.id.billText);
        this.service = (TextView)findViewById(R.id.serviceText);
        this.rateText = (TextView)findViewById(R.id.rateText);
        this.description = (TextView)findViewById(R.id.descriptionText);
        this.tipCost = (TextView)findViewById(R.id.finalCost);
        this.tipText = (TextView)findViewById(R.id.tipText);
    }

    public void Submit(View v)
    {
        if(bill.getVisibility() == View.VISIBLE)
        {
            if(cost.getText().toString().equals("") || rating.getText().toString().equals("")) {
                Toast.makeText(this, "PLEASE FILL BOTH FIELDS", Toast.LENGTH_SHORT).show();
            }
            else {
                GetCalculations(Float.parseFloat(cost.getText().toString()), Integer.parseInt(rating.getText().toString()));
            }
        }
        else
        {
            description.setVisibility(View.GONE);
            tipCost.setVisibility(View.GONE);
            tipText.setVisibility(View.GONE);
            bill.setVisibility(View.VISIBLE);
            cost.setVisibility(View.VISIBLE);
            service.setVisibility(View.VISIBLE);
            rateText.setVisibility(View.VISIBLE);
            rating.setVisibility(View.VISIBLE);
        }
    }

    public void GetCalculations(float c, int r)
    {
        if(r > 0 && r < 11) {
            if (r >= 1 && r <= 3) {
                tip = (c * 0.1f);
                finalCost = tip + c;
                finalCost = (float) (Math.round(finalCost * 100.0) / 100.0);
                tip = (float) (Math.round(tip * 100.0) / 100.0);
                tipCost.setText("$" + finalCost);
                tipText.setText("Tip Amount: $" + tip);
                description.setText("Rating of 1-3 = 10%");
            }
            else if (r >= 4 && r <= 5) {
                tip = (c * 0.13f);
                finalCost = tip + c;
                finalCost = (float) (Math.round(finalCost * 100.0) / 100.0);
                tip = (float) (Math.round(tip * 100.0) / 100.0);
                tipCost.setText("$" + finalCost);
                tipText.setText("Tip Amount: $" + tip);
                description.setText("Rating of 4-5 = 13%");
            }
            else if (r >= 6 && r <= 7) {
                tip = (c * 0.15f);
                finalCost = tip + c;
                finalCost = (float) (Math.round(finalCost * 100.0) / 100.0);
                tip = (float) (Math.round(tip * 100.0) / 100.0);
                tipCost.setText("$" + finalCost);
                tipText.setText("Tip Amount: $" + tip);
                description.setText("Rating of 6-7 = 15%");
            }
            else if (r >= 8 && r <= 9) {
                tip = (c * 0.2f);
                finalCost = tip + c;
                finalCost = (float) (Math.round(finalCost * 100.0) / 100.0);
                tip = (float) (Math.round(tip * 100.0) / 100.0);
                tipCost.setText("$" + finalCost);
                tipText.setText("Tip Amount: $" + tip);
                description.setText("Rating of 8-9 = 20%");
            }
            else if (r == 10) {
                tip = (c * 0.25f);
                finalCost = tip + c;
                finalCost = (float) (Math.round(finalCost * 100.0) / 100.0);
                tip = (float) (Math.round(tip * 100.0) / 100.0);
                tipCost.setText("$" + finalCost);
                tipText.setText("Tip Amount: $" + tip);
                description.setText("Rating of 10 = 25%");
            }

            bill.setVisibility(View.GONE);
            cost.setVisibility(View.GONE);
            service.setVisibility(View.GONE);
            rateText.setVisibility(View.GONE);
            rating.setVisibility(View.GONE);
            description.setVisibility(View.VISIBLE);
            tipCost.setVisibility(View.VISIBLE);
            tipText.setVisibility(View.VISIBLE);
        }
        else
        {
            finalCost = 0;
            tipCost.setText("");
            Toast.makeText(this, "RATING MUST BE BETWEEN 1 AND 10", Toast.LENGTH_SHORT).show();
        }
    }
}
