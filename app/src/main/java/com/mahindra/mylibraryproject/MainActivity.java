package com.mahindra.mylibraryproject;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.mahindra.mylibrary.validation.AwesomeValidation;
import com.mahindra.mylibrary.validation.CustomErrorReset;
import com.mahindra.mylibrary.validation.CustomValidation;
import com.mahindra.mylibrary.validation.CustomValidationCallback;
import com.mahindra.mylibrary.validation.LengthChecker;
import com.mahindra.mylibrary.validation.RegexpValidator;
import com.mahindra.mylibrary.validation.validators.MaterialEditText;
import com.mahindra.mylibrary.validation.validators.SpinnerSelection;
import com.mahindra.mylibrary.validation.validators.ValidationHolder;


public class MainActivity extends AppCompatActivity {

    LengthChecker metLengthChecker;
    Context context;
    ValidationHolder validationHolder;
    AwesomeValidation mAwesomeValidation;
    RegexpValidator regexpValidator = new RegexpValidator(this);
    private String[] mStyles;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    EditText input_password, input_email, input_name, input_mobile, input_pincode, input_dateofbirth, input_city, input_country, input_pancard, input_aadharcard, input_accno;
    MaterialEditText materialEditText;
    SpinnerSelection spinner_tech_stacks;
    SpinnerSelection spinnerSelection;
    Button btn_sign;
    private DrawerItemClickListener mDrawerItemClickListener = new DrawerItemClickListener();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStyles = getResources().getStringArray(R.array.styles);
        input_password = findViewById(R.id.input_password);
        input_email = findViewById(R.id.input_email);

        input_name = findViewById(R.id.input_name);
        input_mobile = findViewById(R.id.input_mobile);
        input_dateofbirth = findViewById(R.id.input_dateofbirth);
        input_city = findViewById(R.id.input_city);
        btn_sign = findViewById(R.id.btn_sign);

        Button btn_sign = findViewById(R.id.btn_sign);
        // intitmaxet();


//        SpinnerSelection spinner_tech_stacks = findViewById(R.id.spinner_tech_stacks);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tech_stacks, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_tech_stacks.setAdapter(adapter);


//        mAwesomeValidation.addValidation(this, R.id.spinner_tech_stacks, new CustomValidation() {
//            @Override
//            public boolean compare(ValidationHolder validationHolder) {
//                if (((Spinner) validationHolder.getView()).getSelectedItem().toString().equals("< Please select one >")) {
//                    return false;
//                } else {
//                    return true;
//                }
//            }
//        }, new CustomValidationCallback() {
//            @Override
//            public void execute(ValidationHolder validationHolder) {
//                TextView textViewError = (TextView) ((Spinner) validationHolder.getView()).getSelectedView();
//                textViewError.setError(validationHolder.getErrMsg());
//                textViewError.setTextColor(Color.RED);
//            }
//        }, new CustomErrorReset() {
//            @Override
//            public void reset(ValidationHolder validationHolder) {
//                TextView textViewError = (TextView) ((Spinner) validationHolder.getView()).getSelectedView();
//                textViewError.setError(null);
//                textViewError.setTextColor(Color.GREEN);
//            }
//        }, R.string.err_tech_stacks);
//
//        btn_sign.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//           mAwesomeValidation.validate();
//            }
//
//        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            selectItem(position);
        }

        private void selectItem(int position) {
            mDrawerList.setItemChecked(position, true);

        }
    }
}


  /*  private void intitmaxet() {
        final MaterialEditText input_name = findViewById(R.id.input_name);
        final MaterialEditText input_password = findViewById(R.id.input_password);
        final MaterialEditText input_email = findViewById(R.id.input_email);
        final MaterialEditText input_mobile = findViewById(R.id.input_mobile);
        final MaterialEditText input_pincode = findViewById(R.id.input_pincode);
        final MaterialEditText input_dateofbirth = findViewById(R.id.input_dateofbirth);
        final MaterialEditText input_city = findViewById(R.id.input_city);
        final MaterialEditText input_country = findViewById(R.id.input_country);
        final MaterialEditText input_pancard = findViewById(R.id.input_pancard);
        final MaterialEditText input_aadharcard = findViewById(R.id.input_aadharcard);
        final MaterialEditText input_accno = findViewById(R.id.input_accno);



        input_name.addValidator(new RegexpValidator("Name should be 8 characters long", "^[a-zA-Z0-9]{8}$"));
        input_password.addValidator(new RegexpValidator("Only Integer Valid!", "\\d+"));
        input_email.addValidator(new RegexpValidator("Email InValid!", "[\\w-]+@([\\w-]+\\.)+[\\w-]+"));
        input_mobile.addValidator(new RegexpValidator("Only 10numbers", "^[0][1-9]\\d{9}$|^[1-9]\\d{9}$"));
        input_pincode.addValidator(new RegexpValidator("Only 6 numbers", "^[1-9][0-9]{5}$"));
        input_dateofbirth.addValidator(new RegexpValidator("Invalid Date", "^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}$"));
        input_city.addValidator(new RegexpValidator("Invalid city", "^[a-zA-Z0-9]{8}$"));
        input_country.addValidator(new RegexpValidator("Invalid country", "^[a-zA-Z0-9]{8}$"));
        input_pancard.addValidator(new RegexpValidator("Invalid No", "[A-Z]{5}[0-9]{4}[A-Z]{1}"));
        input_aadharcard.addValidator(new RegexpValidator("Invalid No", "^\\d{4}\\s\\d{4}\\s\\d{4}$"));
        input_accno.addValidator(new RegexpValidator("The bank should have 9-18 digits", "[0-9]{9,18}"));

        final Button btn_sign = findViewById(R.id.btn_sign);
        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               input_name.validate();
                input_password.validate();
                input_email.validate();
                input_mobile.validate();
                input_pincode.validate();
                input_dateofbirth.validate();
                input_city.validate();
            }
        });
    }*/





