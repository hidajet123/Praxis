package com.youtubeclone.app.ui.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.youtubeclone.app.R
import com.youtubeclone.app.data.model.User
import com.youtubeclone.app.ui.AppSharedPreferences

class AccountActivity : AppCompatActivity(), AccountPresenter.View {
    private lateinit var presenter: AccountPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        init()

    }

    fun init() {
        presenter = AccountPresenter(this)
        presenter.userInfo(this)
        val signOut: Button = findViewById(R.id.sign_out)
        signOut.setOnClickListener({
            AppSharedPreferences(this).clear()
            finish()
        })

    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showUserInfo(body: User?) {
        val username: TextView = findViewById(R.id.account_username)
        val name: TextView = findViewById(R.id.account_name)
        val surname: TextView = findViewById(R.id.account_surname)
        username.setText(body?.username)
        name.setText(body?.name)
        surname.setText(body?.surname)
    }
}