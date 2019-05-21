package com.konarskirob.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.konarskirob.navigation.Navigation
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private val infoFragment: Fragment? by lazy {
        Navigation.Info.fragment { result ->
            infoFragment?.let {
                supportFragmentManager.beginTransaction()
                    .remove(it)
                    .commit()

                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        list.setOnClickListener {
            startActivityForResult(Navigation.Detail.activity(this, "fake_id"), DetailRequestCode)
        }

        infoButton.setOnClickListener {
            infoFragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.infoFrame, it)
                    .commit()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == DetailRequestCode) {
            Navigation.Detail.result(resultCode, data)?.let { result ->
                Toast.makeText(this, "Result: $result", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {

        private const val DetailRequestCode = 1

        fun newIntent(context: Context) = Intent(context, ListActivity::class.java)
    }
}