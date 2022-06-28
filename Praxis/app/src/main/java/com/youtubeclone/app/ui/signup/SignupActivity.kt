package com.youtubeclone.app.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.youtubeclone.app.R

class SignupActivity : AppCompatActivity(), SignupPresenter.View {

    private lateinit var presenter: SignupPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        init()
    }

    fun init() {
        presenter = SignupPresenter(this)
        val button: Button = findViewById(R.id.signUp)
        button.setOnClickListener {
            val name: TextView = findViewById(R.id.name)
            val username: TextView = findViewById(R.id.username)
            val surname: TextView = findViewById(R.id.surname)
            val password: TextView = findViewById(R.id.password)
            presenter.valideInputs(
                name.text.toString(),
                username.text.toString(),
                surname.text.toString(),
                password.text.toString(), this
            )

        }
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToHome() {
        finish()
    }
}