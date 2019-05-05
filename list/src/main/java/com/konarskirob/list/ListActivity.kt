package com.konarskirob.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.konarskirob.navigation.DetailHandle
import com.konarskirob.navigation.InfoHandle
import kotlinx.android.synthetic.main.activity_list.*

internal class ListActivity : AppCompatActivity() {

    private val detailHandle: DetailHandle by lazy {
        DetailHandle(this)
    }

    private val infoHandle: InfoHandle by lazy {
        InfoHandle {
            supportFragmentManager.beginTransaction()
                .remove(infoFragment)
                .commit()
        }
    }

    private val infoFragment: Fragment by lazy {
        infoHandle.getFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        list.setOnClickListener {
            startActivityForResult(detailHandle.getIntent(DetailHandle.Input("fake_id")), DetailRequestCode)
        }

        infoButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.infoFrame, infoFragment)
                .commit()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == DetailRequestCode) {
            detailHandle.getResult(resultCode, data)?.let { result ->
                Toast.makeText(this, "Result: ${result.status}", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {

        private const val DetailRequestCode = 1

        fun newIntent(context: Context) = Intent(context, ListActivity::class.java)
    }
}