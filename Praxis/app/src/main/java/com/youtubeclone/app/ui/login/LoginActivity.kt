package com.youtubeclone.app.ui.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.youtubeclone.app.R
import com.youtubeclone.app.ui.signup.SignupActivity
import com.youtubeclone.app.utils.withClickableSpan

class LoginActivity : AppCompatActivity(), LoginPresenter.View {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        span()
    }

    fun init() {
        presenter = LoginPresenter(this)
        val button: Button = findViewById(R.id.signin)
        button.setOnClickListener {
            val name: TextView = this.findViewById(R.id.name)
            val passw: TextView = this.findViewById(R.id.password)
            presenter.validateInputs(name.text.toString(), passw.text.toString(), this)
        }
        val singUp_button: Button = findViewById(R.id.signUp)
        singUp_button.setOnClickListener {
            val intent: Intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun span() {
        val text1 = findViewById<TextView>(R.id.textView2)
        val ss = SpannableString(this.getString(R.string.description))
        ss.withClickableSpan(this.getString(R.string.link)) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(intent)
        }
        text1.text = ss
        text1.movementMethod = LinkMovementMethod.getInstance()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToHome() {
        finish()
    }
}