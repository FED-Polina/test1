package fedulova.polina303.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import java.security.Key;

import fedulova.polina303.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding = null; //инициализируем объект привязки C Sharp в файле build.gradleModule

    //getText - получить текст; setText - поставить текст

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());//создание объекта привязки
        //setContentView(R.layout.activity_main); было
        setContentView(binding.getRoot()); //стало
        metodOtslejivaniaNajatia();//метод в код добавляем слушатели на кнопки
    }

    private void metodOtslejivaniaNajatia() {
        binding.buttonPlus.setOnClickListener(new View.OnClickListener() /*установить слушатель нажатий на buttonPlus*/ {
            @Override
            public void onClick(View view) /*что происходит по нажатию кнопки*/{
                if (!binding.editTextA.getText().toString().isEmpty() && !binding.editTextB.getText().toString().isEmpty()) {
                    metodPlus(Double.parseDouble(binding.editTextA.getText().toString()), Double.parseDouble(binding.editTextB.getText().toString()));
                }
            }
        });

        binding.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.editTextA.getText().toString().isEmpty() && !binding.editTextB.getText().toString().isEmpty()) {
                    metodMinus(Double.parseDouble(binding.editTextA.getText().toString()), Double.parseDouble(binding.editTextB.getText().toString()));
                }
            }
        });

        binding.buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.editTextA.getText().toString().isEmpty() && !binding.editTextB.getText().toString().isEmpty()) {
                    metodMulti(Double.parseDouble(binding.editTextA.getText().toString()), Double.parseDouble(binding.editTextB.getText().toString()));
                }
            }
        });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.editTextA.getText().toString().isEmpty() && !binding.editTextB.getText().toString().isEmpty()) {
                    metodDivide(Double.parseDouble(binding.editTextA.getText().toString()), Double.parseDouble(binding.editTextB.getText().toString()));
                }
            }
        });

        binding.buttonSIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.editTextCountMath.getText().toString().isEmpty())
                    metodSIN(Double.parseDouble(binding.editTextCountMath.getText().toString()));
            }
        });

        binding.buttonCOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.editTextCountMath.getText().toString().isEmpty())
                    metodCOS(Double.parseDouble(binding.editTextCountMath.getText().toString()));
            }
        });

        binding.buttonTAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.editTextCountMath.getText().toString().isEmpty())
                    metodTAN(Double.parseDouble(binding.editTextCountMath.getText().toString()));
            }
        });

        binding.buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.editTextCountMath.getText().toString().isEmpty())
                    metodSqrt(Double.parseDouble(binding.editTextCountMath.getText().toString()));
            }
        });

        binding.buttonPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.editTextCountPow.getText().toString().isEmpty() && !binding.editTextPowIn.getText().toString().isEmpty()) {
                    metodPow(Double.parseDouble(binding.editTextCountPow.getText().toString()), Double.parseDouble(binding.editTextPowIn.getText().toString()));
                }
            }
        });
    }



    private void metodPlus(double a, double b) {
        Double result = a + b;
        binding.textViewAnswer.setText(getString(R.string.text_answer, result.toString()/*взяли строку из файла ресурсов strings.xml в values*/));
    }

    private void metodMinus(double a, double b) {
        Double result = a - b;
        binding.textViewAnswer.setText(getString(R.string.text_answer, result.toString()/*взяли строку из файла ресурсов strings.xml в values*/));
    }

    private void metodMulti(double a, double b) {
        Double result = a * b;
        binding.textViewAnswer.setText(getString(R.string.text_answer, result.toString()/*взяли строку из файла ресурсов strings.xml в values*/));
    }

    private void metodDivide(double a, double b) {
        if (b != 0) { //на 0 делить нельзя
            Double result = a / b;
            binding.textViewAnswer.setText(getString(R.string.text_answer, result.toString()/*взяли строку из файла ресурсов strings.xml в values*/));
        }
        else {
            binding.textViewAnswer.setText(getString(R.string.divide_by_zero));
        }
    }

    private void metodSIN(double a) {
        Double result = Math.sin(a);
        binding.textViewAnswer.setText(getString(R.string.text_answer, result.toString()/*взяли строку из файла ресурсов strings.xml в values*/));
    }

    private void metodCOS(double a) {
        Double result = Math.cos(a);
        binding.textViewAnswer.setText(getString(R.string.text_answer, result.toString()/*взяли строку из файла ресурсов strings.xml в values*/));
    }

    private void metodTAN(double a) {
        Double result = Math.tan(a);
        binding.textViewAnswer.setText(getString(R.string.text_answer, result.toString()/*взяли строку из файла ресурсов strings.xml в values*/));
    }

    private void metodSqrt(double a) {
        if(a >= 0){ //корень не отрицательный
            Double result = Math.sqrt(a);
            binding.textViewAnswer.setText(getString(R.string.text_answer, result.toString()/*взяли строку из файла ресурсов strings.xml в values*/));
        }
        else{
            binding.textViewAnswer.setText(getString(R.string.minus_sqrt));
        }

    }

    private void metodPow(double a, double b) {
        Double result = Math.pow(a, b);
        binding.textViewAnswer.setText(getString(R.string.text_answer, result.toString()/*взяли строку из файла ресурсов strings.xml в values*/));
    }

}
