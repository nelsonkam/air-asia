package io.airasia.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.airasia.R;


public class FlightFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener, View.OnTouchListener {
    EditText departureEditText;
    EditText arrivalEditText;
    DatePickerDialog datepicker;
    EditText willReceiveDate;
    ConstraintLayout firstView;
    ConstraintLayout secondView;
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
//        CardView fab = (CardView) getView().findViewById(R.id.timeline_fab);
//        fab.setOnClickListener(this);
        firstView = (ConstraintLayout) view.findViewById(R.id.first_view);
        secondView = (ConstraintLayout) view.findViewById(R.id.second_view);

    }

    @Override
    public void onClick(View view) {
        int index = view.getId();
        if (index == R.id.timeline_fab) {
            firstView.setVisibility(View.GONE);
            secondView.setVisibility(View.VISIBLE);
        }
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
