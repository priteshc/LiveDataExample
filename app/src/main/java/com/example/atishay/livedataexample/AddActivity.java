package com.example.atishay.livedataexample;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.atishay.livedataexample.model.BorrowModel;
import com.example.atishay.livedataexample.model.BorrowedListViewModel;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Atishay on 19-03-2018.
 */

public class AddActivity  extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private Date date;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;

    private EditText itemEditText;
    private EditText nameEditText;

    private Button dat,ok;
    private BorrowedListViewModel addBorrowViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add);

        dat = findViewById(R.id.dateButton);

        ok = findViewById(R.id.ok);


        itemEditText = findViewById(R.id.itemName);
        nameEditText = findViewById(R.id.personName);

        calendar = Calendar.getInstance();
        addBorrowViewModel = ViewModelProviders.of(this).get(BorrowedListViewModel.class);

        datePickerDialog = new DatePickerDialog(this, AddActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));


        dat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datePickerDialog.show();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (itemEditText.getText() == null || nameEditText.getText() == null || date == null)
                    Toast.makeText(AddActivity.this, "Missing fields", Toast.LENGTH_SHORT).show();
                else {
                    addBorrowViewModel.addBorrow(new BorrowModel(
                            itemEditText.getText().toString(),
                            nameEditText.getText().toString(),
                            date
                    ));
                    finish();
                }
            }
        });


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date = calendar.getTime();
    }
}
