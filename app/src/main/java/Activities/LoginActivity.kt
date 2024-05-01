package Activities

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.my_project.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val textInputEditText: TextInputEditText = findViewById(R.id.text_input_edit_text)
        val checkBoxLogin: CheckBox = findViewById(R.id.check_box)
        val toast = Toast.makeText(applicationContext, "введен короткий пин", Toast.LENGTH_LONG)
        val sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val materialButton: com.google.android.material.button.MaterialButton = findViewById(R.id.material_button)
        val exitButton: Button = findViewById(R.id.exit_button)
        val intent = Intent(this, MainActivity::class.java)

        val isLoggedIn = intent.getBooleanExtra("isLoggedIn", false)
        if (isLoggedIn) {
            startActivity(intent)
            finish()
        }

        textInputEditText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                val text = textInputEditText.text?.toString()
                if (text == "Введите номер телефона") {
                    textInputEditText.text?.clear()
                }
            }
        }

        textInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val newText = s.toString()
                if (newText.length == 9) {
                    checkBoxLogin.isClickable = true
                    val numericValue = newText.toIntOrNull()
                    if (numericValue != null) {
                        editor.putInt("key", numericValue)
                    } else {
                        editor.putString("key", newText)
                    }
                    editor.apply()
                } else {
                    toast.show()
                }
            }
        })

        checkBoxLogin.setOnCheckedChangeListener { checkBoxLogin: CompoundButton?, isChecked: Boolean ->
            val materialButtonColor: Int
            materialButtonColor = if (isChecked) {
                ContextCompat.getColor(this, R.color.material_button_color)
            } else {
                materialButton.isClickable = false
                Color.parseColor("#E0E0E0")
            }
            materialButton.backgroundTintList = ColorStateList.valueOf(materialButtonColor)
        }

        materialButton.setOnClickListener {
            startActivity(intent)
            finish()
        }

        exitButton.setOnClickListener {
            finish()
        }

        val savedText = sharedPreferences.getString("key", "")
        if (savedText != "") {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("isLoggedIn", true)
            }
            startActivity(intent)
            finish()
        }

    }
}

