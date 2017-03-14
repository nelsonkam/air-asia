package io.airasia;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class FlightFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener, View.OnTouchListener {
    EditText departureEditText;
    EditText arrivalEditText;
    DatePickerDialog datepicker;
    EditText willReceiveDate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flight, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Calendar now = Calendar.getInstance();
        datepicker = new DatePickerDialog(getContext(), this,
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        departureEditText = (EditText) view.findViewById(R.id.departure_edit_text);
        departureEditText.setOnTouchListener(this);
        arrivalEditText = (EditText) view.findViewById(R.id.arrival_edit_text);
        arrivalEditText.setOnTouchListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar date = Calendar.getInstance();
        date.set(year, month, dayOfMonth);
        String format = SimpleDateFormat.getDateInstance().format(date.getTime());
        willReceiveDate.setText(format);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        datepicker.show();
        if (id == R.id.departure_edit_text) {
            willReceiveDate = departureEditText;
            return true;
        } else if (id == R.id.arrival_edit_text) {
            willReceiveDate = arrivalEditText;
            return true;
        }
        return false;
    }
}
