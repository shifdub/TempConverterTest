package edu.cnm.deepdive.tempconvertertest;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.tempconvertertest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  {

  private ActivityMainBinding binding;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    final Button button = findViewById(R.id.button);
    button.setOnClickListener(v -> {
      // Code here executes on main thread after user presses button
      //fahrenheit = celsius * 9 / 5 + 32;
      //kelvin = celsius + 273.15;
      //fahrenheit = kelvin * 1.8 - 459.67;

     /* double fahrenheit = ((celsius * 9) / 5) + 32;
     e doubl celsius = ((fahrenheit - 32) * 5 / 9);
      double kelvin =
      double kelvin =*/
    oneTemperatureScaleToTheOtherTwoTempScales();


    });


  }


  public void oneTemperatureScaleToTheOtherTwoTempScales() {

    //get kelvin input
    String input1 = binding.input1.getText().toString().trim();
    //get fahrenheit input
    String input2 = binding.input2.getText().toString().trim();
    //get celsius input
    String input3 = binding.input3.getText().toString().trim();

    double fahrenheit;
    double celsius;
    double kelvin;

    if (input1.isEmpty()) {
      binding.input1.setText("0");
      kelvin = 0;
    } else {
      kelvin = Double.parseDouble(input1);
    }

    if (input1.isEmpty()) {
      binding.input2.setText("0");
      fahrenheit = 0;
    } else {
      fahrenheit = Double.parseDouble(input2);
    }

    if (input1.isEmpty()) {
      binding.input3.setText("0");
      celsius = 0;
    } else {
      celsius = Double.parseDouble(input3);
    }

    //binding.input1.setText(getString(R.string.kelvin,sum));
    if(kelvin == 0 && fahrenheit == 0) {
      kelvin = celsius + 273.15;
      fahrenheit =  celsius * 9 / 5 + 32;

      binding.input1.setText(getString(R.string.kelvin, kelvin));
      binding.input2.setText(getString(R.string.fahrenheit,fahrenheit));


    } else if (fahrenheit == 0 && celsius == 0) {
      fahrenheit = kelvin * 1.8 - 459.67;
      celsius = kelvin - 273.15;

      binding.input2.setText(getString(R.string.fahrenheit, fahrenheit));
      binding.input3.setText(getString(R.string.celsius, celsius));

    } else if (celsius == 0 && kelvin == 0) {
      celsius = fahrenheit / 9 * 5 - 32;
      kelvin = fahrenheit / 1.8 + 459.67;

      binding.input1.setText(getString(R.string.kelvin, kelvin));
      binding.input3.setText(getString(R.string.celsius, celsius));
    }

  }

}
/*
  @Override
  public void beforeTextChanged(CharSequence s, int start, int count, int after) {

  }

  @Override
  public void onTextChanged(CharSequence s, int start, int before, int count) {

  }

  @Override
  public void afterTextChanged(Editable s) {
    oneTemperatureScaleToTheOtherTwoTempScales();
  }
}

 */